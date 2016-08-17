package com.project.finalandproject.board;

import android.os.StrictMode;
import android.util.Log;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016-08-12.
 */
public class BDConn {
    public static Object conn(String type, Object obj) {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        String requestURL = "http://192.168.14.160:8805/a/";
        List<NameValuePair> paramList = new ArrayList<>();

        Log.d(":type",type);

        try {
            if (type.equals("refresh")) {
                requestURL += "listBoard.do?";
                paramList.add(new BasicNameValuePair("gathering_num", (String) obj));
            } else if (type.equals("deleteBD")) {
                requestURL += "delBoard.do?";
                paramList.add(new BasicNameValuePair("gathering_bd_num", (String) obj));
            } else if (type.equals("addBD")) {
                requestURL += "addBoard.do?";
                BoardDTO dto = (BoardDTO)obj;
                paramList.add(new BasicNameValuePair("gathering_bd_content", dto.getGathering_bd_content()));
                paramList.add(new BasicNameValuePair("member_id", dto.getMember_id()));
                paramList.add(new BasicNameValuePair("gathering_num", dto.getGathering_num()));
            }
            Log.d("URL: ",requestURL);
            HttpClient client   = new DefaultHttpClient();
            HttpPost post    = new HttpPost(requestURL);
            post.setEntity(new UrlEncodedFormEntity(paramList, "UTF-8")); // READY상태
            HttpResponse response = client.execute(post); // 데이터가 GOGO
            HttpEntity entity = response.getEntity();
            InputStream is = entity.getContent();
            return getXML(is);

        } catch (Exception e) {
            Log.d("sendPost===> ", e.toString());
        }

        return null;
    }
    private static List<BoardDTO> getXML(InputStream is) {
        List<BoardDTO> list = new ArrayList<>();

        try {
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            XmlPullParser parser = factory.newPullParser();
            parser.setInput(is, "EUC-KR");

            int eventType = parser.getEventType();

            BoardDTO dto = null;
            while (eventType != XmlPullParser.END_DOCUMENT) {

                switch (eventType) {
                    case XmlPullParser.START_TAG:

                        String startTag = parser.getName();
                        if (startTag.equals("member")) {
                            dto = new BoardDTO();
                        }
                        if (dto != null) {
                            if (startTag.equals("id")) {
                                dto.setMember_id(parser.nextText());
                            } else if (startTag.equals("content")) {
                                dto.setGathering_bd_content(parser.nextText());
                            } else if (startTag.equals("wdate")) {
                                dto.setGathering_bd_date(parser.nextText());
                            } else if (startTag.equals("num")) {
                                dto.setGathering_bd_num(parser.nextText());
                            }
                        }
                        break;

                    case XmlPullParser.END_TAG:
                        String endTag = parser.getName();
                        if (endTag.equals("member")) {
                            list.add(dto);
                        }
                        break;
                } // end
                eventType = parser.next();
            }
        }catch (XmlPullParserException e){

        }catch (IOException e){

        }
        return list;
    }
}
