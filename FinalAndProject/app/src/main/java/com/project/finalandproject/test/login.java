package com.project.finalandproject.test;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.nhn.android.naverlogin.OAuthLogin;
import com.nhn.android.naverlogin.OAuthLoginHandler;
import com.nhn.android.naverlogin.ui.view.OAuthLoginButton;
import com.project.finalandproject.Main_Page;
import com.project.finalandproject.R;

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
 * Created by 김희윤 on 2016-08-04.
 */
public class login extends Activity {


    Button Log;

// 네이버 로그인 요소
    private OAuthLoginButton mOAuthLoginButton;
    private static OAuthLogin mOAuthLoginInstance;
    private static Context mContext;
    InputSource is;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Log  =(Button) findViewById(R.id.Log);
        Log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),Main_Page.class);
                finish();
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


    public OAuthLoginHandler mOAuthLoginHandler = new OAuthLoginHandler() {
        @Override
        public void run(boolean success) {
            if (success) {
                String requestURL = "http://192.168.14.31:8805/finalproject/join.do";
                HttpClient client = new DefaultHttpClient();
                HttpPost post = new HttpPost(requestURL);
                List<NameValuePair> paramList = new ArrayList<>();
                new RequestApiTask().execute(); // xml 받아옴
            } else {
                String errorCode = mOAuthLoginInstance.getLastErrorCode(mContext).getCode();
                String errorDesc = mOAuthLoginInstance.getLastErrorDesc(mContext);
                Toast.makeText(mContext, "errorCode:" + errorCode + ", errorDesc:" + errorDesc, Toast.LENGTH_SHORT).show();
            }
        };
    };

    public class RequestApiTask extends AsyncTask<Void, Void, String> {
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

    public void getnaverinfo(String xml) throws Exception {


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
        SubmitJoin(member_name, member_id, member_pwd, member_email);

    }

    public void SubmitJoin(String member_name,String member_id, String member_pwd, String member_email) { //조인 부분


        String requestURL = "http://192.168.14.31:8805/finalproject/join.do";

        HttpClient client = new DefaultHttpClient();
        HttpPost post = new HttpPost(requestURL);
        List<NameValuePair> paramList = new ArrayList<>();
        paramList.add(new BasicNameValuePair("name", member_name));
        paramList.add(new BasicNameValuePair("id", member_id));
        paramList.add(new BasicNameValuePair("pwd", member_pwd));
        paramList.add(new BasicNameValuePair("email", member_email));


        try {
            post.setEntity(new UrlEncodedFormEntity(paramList, "UTF-8"));
            HttpResponse response = client.execute(post);
        } catch (Exception e) {
        }

        Toast.makeText(getApplicationContext(),"가입완료",Toast.LENGTH_LONG).show();

    }



}
