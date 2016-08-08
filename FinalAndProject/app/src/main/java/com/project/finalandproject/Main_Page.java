package com.project.finalandproject;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.nhn.android.naverlogin.OAuthLogin;
import com.nhn.android.naverlogin.OAuthLoginDefine;
import com.nhn.android.naverlogin.OAuthLoginHandler;
import com.nhn.android.naverlogin.ui.view.OAuthLoginButton;
import com.project.finalandproject.dto.MemberDTO;
import com.project.finalandproject.member.Info;
import com.project.finalandproject.member.Mem_Join_Page;
import com.project.finalandproject.naver.OAuthSampleActivity;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

/**
 * Created by Administrator on 2016-08-02.
 */
public class Main_Page extends Activity {

    Intent intent;
    Button Joinbt;

    EditText member_id;
    EditText member_pwd;


    // 네이버 로그인
    String member_email1 = "";    String member_name1 ="";    String member_pwd1 = "";
    InputSource is;
    Button naver_logout, naversample;
    private static final String TAG = "OAuthSampleActivity";

    private OAuthLoginButton mOAuthLoginButton;
    private static OAuthLogin mOAuthLoginInstance;
    private static Context mContext;
    private TextView mApiResultText;
    private static TextView mOauthAT;
    private static TextView mOauthRT;
    private static TextView mOauthExpires;
    private static TextView mOauthTokenType;
    private static TextView mOAuthState;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_page);
        Joinbt = (Button)findViewById(R.id.joinbt);
        member_id = (EditText)findViewById(R.id.num1);
        member_pwd = (EditText)findViewById(R.id.num2);
<<<<<<< Updated upstream
    /*    naverbt = (Button) findViewById(R.id.naverbt);
        daumbt = (Button) findViewById(R.id.daumbt);*/
=======
>>>>>>> Stashed changes


        mOAuthLoginButton = (OAuthLoginButton) findViewById(R.id.buttonOAuthLoginImg);

        OAuthLoginDefine.DEVELOPER_VERSION = true;
        mContext = this;
        NaverInit();

        naversample = (Button) findViewById(R.id.naversample);
        naver_logout = (Button) findViewById(R.id.naver_logout);
        mOAuthLoginButton.setOAuthLoginHandler(mOAuthLoginHandler);


        naversample.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(getApplication(), OAuthSampleActivity.class);
                startActivity(intent);
                finish();
            }
        });

        naver_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mOAuthLoginInstance.logout(mContext);
            }
        });


        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

    }

    private void NaverInit() {

        mOAuthLoginInstance = OAuthLogin.getInstance();

        mOAuthLoginInstance.init(mContext, "YvqElEzARe1B1zcoMktx",  "Trp4XEcdr4", "네이버 아이디로 로그인");
        // 네이버 인증키 부분
		/*
		 * 2015년 8월 이전에 등록하고 앱 정보 갱신을 안한 경우 기존에 설정해준 callback intent url 을 넣어줘야 로그인하는데 문제가 안생긴다.
		 * 2015년 8월 이후에 등록했거나 그 뒤에 앱 정보 갱신을 하면서 package name 을 넣어준 경우 callback intent url 을 생략해도 된다.
		 */
        //mOAuthLoginInstance.init(mContext, OAUTH_CLIENT_ID, OAUTH_CLIENT_SECRET, OAUTH_CLIENT_NAME, OAUTH_callback_intent_url);

        mApiResultText = (TextView) findViewById(R.id.api_result_text);

        mOauthAT = (TextView) findViewById(R.id.oauth_access_token);
        mOauthRT = (TextView) findViewById(R.id.oauth_refresh_token);
        mOauthExpires = (TextView) findViewById(R.id.oauth_expires);
        mOauthTokenType = (TextView) findViewById(R.id.oauth_type);
        mOAuthState = (TextView) findViewById(R.id.oauth_state);

        mOAuthLoginButton  = (OAuthLoginButton) findViewById(R.id.buttonOAuthLoginImg);
        mOAuthLoginButton.setOAuthLoginHandler(mOAuthLoginHandler);

        updateView();


    }

    public void Joinbt(View v){
        intent = new Intent(getApplication(), Mem_Join_Page.class);
        startActivity(intent);
    }

    public void Login(View v){

        Log.d("로그인","버튼누름");
        MemberDTO m = new MemberDTO();
        m.setId(member_id.getText().toString());
        m.setPwd(member_pwd.getText().toString());

        if(Info.connServer("login", m)){
            Toast.makeText(getApplicationContext(), "로그인 성공", Toast.LENGTH_SHORT).show();
        } else
            Toast.makeText(getApplicationContext(), "로그인 실패", Toast.LENGTH_SHORT).show();
    }






    // 임시 네이버 샘플코드

    public OAuthLoginHandler mOAuthLoginHandler = new OAuthLoginHandler() {
        @Override
        public void run(boolean success) {
            if (success) {
                String requestURL = "http://192.168.14.31:8805/finalproject/join.do";
                HttpClient client = new DefaultHttpClient();
                HttpPost post = new HttpPost(requestURL);
                List<NameValuePair> paramList = new ArrayList<>();


                Toast.makeText(mContext, "여기", Toast.LENGTH_SHORT).show();
                String accessToken = mOAuthLoginInstance.getAccessToken(mContext);
                String refreshToken = mOAuthLoginInstance.getRefreshToken(mContext);
                long expiresAt = mOAuthLoginInstance.getExpiresAt(mContext);
                String tokenType = mOAuthLoginInstance.getTokenType(mContext);

/*
                mOauthAT.setText(accessToken);
                mOauthRT.setText(refreshToken);
                mOauthExpires.setText(String.valueOf(expiresAt));
                mOauthTokenType.setText(tokenType);
                mOAuthState.setText(mOAuthLoginInstance.getState(mContext).toString());
*/

                new RequestApiTask().execute(); // xml 받아옴



            } else {
                String errorCode = mOAuthLoginInstance.getLastErrorCode(mContext).getCode();
                String errorDesc = mOAuthLoginInstance.getLastErrorDesc(mContext);
                Toast.makeText(mContext, "errorCode:" + errorCode + ", errorDesc:" + errorDesc, Toast.LENGTH_SHORT).show();
            }
        };
    };




    public class DeleteTokenTask extends AsyncTask<Void, Void, Void> {
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
        protected void onPostExecute(Void v) {
            updateView();
        }
    }

    public class RequestApiTask extends AsyncTask<Void, Void, String> {
        @Override
        protected void onPreExecute() {
            //      mApiResultText.setText((String) "");
        }
        public RequestApiTask(){};
        @Override
        protected String doInBackground(Void... params) {
            String url = "https://openapi.naver.com/v1/nid/getUserProfile.xml";
            String at = mOAuthLoginInstance.getAccessToken(mContext);

            return mOAuthLoginInstance.requestApi(mContext, at, url);
        }
        protected void onPostExecute(String xml) {
            Log.d(TAG, "XML:" + xml);
            is = new InputSource(new StringReader(xml));
            try {
                getnaverinfo(xml);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return;
        }
    }

    public class RefreshTokenTask extends AsyncTask<Void, Void, String> {
        @Override
        protected String doInBackground(Void... params) {
            return mOAuthLoginInstance.refreshAccessToken(mContext);
        }
        protected void onPostExecute(String res) {
            updateView();
        }
    }

    private void updateView() {
//        mOauthAT.setText(mOAuthLoginInstance.getAccessToken(mContext));
        //      mOauthRT.setText(mOAuthLoginInstance.getRefreshToken(mContext));
        //    mOauthExpires.setText(String.valueOf(mOAuthLoginInstance.getExpiresAt(mContext)));
        //  mOauthTokenType.setText(mOAuthLoginInstance.getTokenType(mContext));
        // mOAuthState.setText(mOAuthLoginInstance.getState(mContext).toString());
    }

    @Override
    protected void onResume() {
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        super.onResume();

    }


    public void getnaverinfo(String xml) throws Exception {
        Toast.makeText(mContext, "도착?" + xml, Toast.LENGTH_SHORT).show();


        is = new InputSource(new StringReader(xml));
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

        Document doc = dBuilder.parse(is);
        doc.getDocumentElement().normalize();
        NodeList descNodes = doc.getElementsByTagName("response");
        member_email1 = "";
        member_name1 ="";
        member_pwd1 = "";

        for (int i = 0; i < descNodes.getLength(); i++) {
            for (Node node = descNodes.item(i).getFirstChild(); node != null; node = node.getNextSibling()) {
                if (node.getNodeName().equals("email")) {
                    member_email1 =  node.getTextContent().toString();
                    Toast.makeText(mContext, node.getTextContent(), Toast.LENGTH_SHORT).show();
                } else if (node.getNodeName().equals("name")) {
                    member_name1 = node.getTextContent().toString();
                    Toast.makeText(mContext, node.getTextContent(), Toast.LENGTH_SHORT).show();
                } else if (node.getNodeName().equals("id")) {
                    member_pwd1 = node.getTextContent().toString();
                    Toast.makeText(mContext, node.getTextContent(), Toast.LENGTH_SHORT).show();
                }
            }
        }
        String member_id1 = "거지같음!!";
        SubmitJoin(member_name1, member_id1, member_pwd1, member_email1);
        Toast.makeText(mContext, member_email1+member_name1 + member_pwd1, Toast.LENGTH_SHORT).show();

    }




    public void SubmitJoin(String member_name1, String member_id1, String member_pwd1, String member_email1) { //조인 부분

        String requestURL = "http://192.168.14.31:8805/finalproject/join.do";

        HttpClient client = new DefaultHttpClient();
        HttpPost post = new HttpPost(requestURL);
        List<NameValuePair> paramList = new ArrayList<>();
        paramList.add(new BasicNameValuePair("name", member_name1));
        paramList.add(new BasicNameValuePair("id", member_id1));
        paramList.add(new BasicNameValuePair("pwd", member_pwd1));
        paramList.add(new BasicNameValuePair("email", member_email1));


        try {
            post.setEntity(new UrlEncodedFormEntity(paramList, "UTF-8"));
            HttpResponse response = client.execute(post);
        } catch (Exception e) {
            Log.d("sendPost===> ", e.toString());
        }

        Toast.makeText(getApplicationContext(),"가입완료",Toast.LENGTH_LONG).show();

    }
}
