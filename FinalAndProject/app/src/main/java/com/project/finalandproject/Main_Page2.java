package com.project.finalandproject;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.nhn.android.naverlogin.OAuthLogin;
import com.nhn.android.naverlogin.OAuthLoginHandler;
import com.nhn.android.naverlogin.ui.view.OAuthLoginButton;
import com.project.finalandproject.conn.MemConn;
import com.project.finalandproject.dto.MemberDTO;
import com.project.finalandproject.member.MemInfo;
import com.project.finalandproject.member.category_list;
import com.project.finalandproject.test.Test_Menu_Activity;

import org.json.simple.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;


/**
 * Created by Administrator on 2016-08-02.
 */
public class Main_Page2 extends Activity {

    Intent intent;
    Button Logbt, naver_logout, naver_out;
    private static String TAG = "출력용";


    // 네이버 로그인 요소
    private OAuthLoginButton mOAuthLoginButton;
    private static OAuthLogin mOAuthLoginInstance;
    private static Context mContext;
    InputSource is;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        naver_logout = (Button)findViewById(R.id.naver_logout);
/*        naver_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mOAuthLoginInstance.logout(mContext);
            }
        });*/
        naver_out = (Button)findViewById(R.id.naver_out);
        naver_out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DeleteTokenTask().execute();
            }
        });

        Logbt = (Button) findViewById(R.id.Log);
        Logbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(getApplication(), Main_page3.class);
                startActivity(intent);

            }
        });


        Naverinit();

    }


    private void Naverinit() {

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
       //OAuthLoginDefine.DEVELOPER_VERSION = true;
        mContext = this;
        mOAuthLoginInstance = OAuthLogin.getInstance();
        mOAuthLoginInstance.init(mContext, "YvqElEzARe1B1zcoMktx",  "Trp4XEcdr4", "네이버 아이디로 로그인");
        // 네이버 인증키 부분


        mOAuthLoginButton  = (OAuthLoginButton) findViewById(R.id.Log_naver);
        mOAuthLoginButton.setOAuthLoginHandler(mOAuthLoginHandler);

    }

    private OAuthLoginHandler mOAuthLoginHandler = new OAuthLoginHandler() {
        @Override
        public void run(boolean success) {
            if (success) { // 사용자가 네이버에서 로그인 성공
                new RequestApiTask().execute(); // xml 받아옴

            } else { // 사용자가 네이버에서 로그인 실패
                String errorCode = mOAuthLoginInstance.getLastErrorCode(mContext).getCode();
                String errorDesc = mOAuthLoginInstance.getLastErrorDesc(mContext);
                Toast.makeText(mContext, "errorCode:" + errorCode + ", errorDesc:" + errorDesc, Toast.LENGTH_SHORT).show();
            }
        };
    };

    private class RequestApiTask extends AsyncTask<Void, Void, String> {
        @Override
        protected String doInBackground(Void... params) {
            String url = "https://openapi.naver.com/v1/nid/getUserProfile.xml";
            String at = mOAuthLoginInstance.getAccessToken(mContext);

            return mOAuthLoginInstance.requestApi(mContext, at, url);
        }
        protected void onPostExecute(String xml) {
            is = new InputSource(new StringReader(xml));
            try {
                getnaverinfo(xml);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return;
        }
    }

    private void getnaverinfo(String xml) throws Exception {
        Toast.makeText(getApplicationContext(), "네이버 가입완료", Toast.LENGTH_LONG).show();
        is = new InputSource(new StringReader(xml));
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

        Document doc = dBuilder.parse(is);
        doc.getDocumentElement().normalize();
        NodeList descNodes = doc.getElementsByTagName("response");
        String member_name =""; String member_id=""; String member_pwd=""; String member_email="";
        for (int i = 0; i < descNodes.getLength(); i++) {
            for (Node node = descNodes.item(i).getFirstChild(); node != null; node = node.getNextSibling()) {
                if (node.getNodeName().equals("email")) {
                    member_email =   node.getTextContent().toString();
                } else if (node.getNodeName().equals("name")) {
                    member_name = node.getTextContent().toString();
                } else if (node.getNodeName().equals("id")) {
                    member_pwd = node.getTextContent().toString();
                    member_id = node.getTextContent().toString();
                }
            }
        }

        MemberDTO m = new MemberDTO();
        m.setName(member_name);
        m.setId(member_id);
        m.setPwd(member_pwd);
        m.setEmail(member_email);
        Intent intent;

/*
        intent = new Intent(getApplication(),category_list.class);
        intent.putExtra("dto",m);
        intent.putExtra("type","mjoin");
        startActivity(intent);*/



        if (((JSONObject)MemConn.getJSONDatas("login", m)).get("msg").toString().equals("Success")){ // 네이버 아이디가 존재할 경우
            Log.d(TAG, "카테고리 조사가 필요하지 않음" );
            intent = new Intent(getApplication(), Test_Menu_Activity.class);
            startActivity(intent);

        }else{ // 현재 네이버 아이디로 최초 로그인한 경우 (카테고리를 조사한다)
            Log.d(TAG, "카테고리 조사가 필요함" );
            SubmitJoin(m);

            intent = new Intent(getApplication(),category_list.class);
            intent.putExtra("dto",m);
            intent.putExtra("type","mjoin");
            startActivity(intent);
        }


/*

        intent = new Intent(getApplication(),category_list.class);
        intent.putExtra("dto",m);
        intent.putExtra("type","mjoin");
        startActivity(intent);

        */

    }

    private void SubmitJoin(MemberDTO dto) { //조인 부분
//        String requestURL = "http://192.168.14.31:8805/finalproject/join.do";
//        HttpClient client = new DefaultHttpClient();
//        HttpPost post = new HttpPost(requestURL);
//        List<NameValuePair> paramList = new ArrayList<>();
//        paramList.add(new BasicNameValuePair("name", member_name));
//        paramList.add(new BasicNameValuePair("id", member_id));
//        paramList.add(new BasicNameValuePair("pwd", member_pwd));
//        paramList.add(new BasicNameValuePair("email", member_email));
//
//        try {
//            post.setEntity(new UrlEncodedFormEntity(paramList, "UTF-8"));
//            HttpResponse response = client.execute(post);
//        } catch (Exception e) {
//        }

        JSONObject Jobj =null;
        try {
            Jobj = (JSONObject) MemConn.getJSONDatas("join", dto);
            if (Jobj.get("msg").toString().equals("Success")) {
                Toast.makeText(getApplicationContext(), "가입완료", Toast.LENGTH_LONG).show();
                MemInfo.USER_ID = dto.getId();
                MemInfo.USER_NAME = dto.getName();
                intent = new Intent(getApplication(), category_list.class);
                startActivity(intent);
            } else {
                Toast.makeText(getApplicationContext(), "가입실패", Toast.LENGTH_LONG).show();
            }
        }catch (Exception e){
            Toast.makeText(getApplicationContext(), "가입실패", Toast.LENGTH_LONG).show();
        }

    }

    private class DeleteTokenTask extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... params) {
            boolean isSuccessDeleteToken = mOAuthLoginInstance.logoutAndDeleteToken(mContext);

            if (!isSuccessDeleteToken) {
                // 서버에서 token 삭제에 실패했어도 클라이언트에 있는 token 은 삭제되어 로그아웃된 상태이다
                // 실패했어도 클라이언트 상에 token 정보가 없기 때문에 추가적으로 해줄 수 있는 것은 없음
                Log.d(TAG, "errorCode:" + mOAuthLoginInstance.getLastErrorCode(mContext));
                Log.d(TAG, "errorDesc:" + mOAuthLoginInstance.getLastErrorDesc(mContext));
            }

            return null;
        }
    }


}
