package com.project.finalandproject.chat;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.project.finalandproject.R;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;
/**
 * Created by Administrator on 2016-08-10.
 */
public class gathering_chatting extends LinearLayout {
    //gathering_list
    Context context;
    ArrayList<Listviewitem4> data = new ArrayList<Listviewitem4>();;
    ListView listView;
    ListviewAdapter4 adapter;
    ChatDTO info = null;
    Activity activity;
    public gathering_chatting(Context context,Activity activity){
        super(context);
        excute(context);
        this.activity=activity;
    }

    public void excute(Context context) {
        
        this.context = context;
        this.setLayoutParams(new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.gathering_chatting, this, true);
        listView = (ListView) findViewById(R.id.listview);
        listView.setTranscriptMode(AbsListView.TRANSCRIPT_MODE_ALWAYS_SCROLL);
        itemInsert();
        serverStart();
        ImageButton msgSend = (ImageButton) findViewById(R.id.msgSend);
        msgSend.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                msgSend(view);
            }
        });
    }
   
      

        



    private void itemInsert() {

 /*       data.add(new Listviewitem4(R.drawable.ic_search_black_48dp, "안녕안녕안녕안녕안녕안녕녕안녕안녕안녕안녕", "1", new Date(2016, 8, 16), "1", 1));
        data.add(new Listviewitem4(R.drawable.ic_search_black_48dp, "뭐해", "1", new Date(2016, 8, 16), "1", 1));
        data.add(new Listviewitem4(R.drawable.ic_account_circle_black_48dp, "안녕안녕안녕안녕안녕안녕녕안녕안녕안녕안녕", "1", new Date(2016, 8, 16), "1", 0));
        data.add(new Listviewitem4(R.drawable.ic_account_circle_black_48dp, "뭐해", "1", new Date(2016, 8, 16), "1", 0));
        data.add(new Listviewitem4(R.drawable.ic_account_circle_black_48dp, "안녕안녕안녕안녕안녕안녕녕안녕안녕안녕안녕", "1", new Date(2016, 8, 16), "1", 0));
        data.add(new Listviewitem4(R.drawable.ic_account_circle_black_48dp, "뭐해", "1", new Date(2016, 8, 16), "1", 0));
        data.add(new Listviewitem4(R.drawable.ic_account_circle_black_48dp, "안녕안녕안녕안녕안녕안녕녕안녕안녕안녕안녕", "1", new Date(2016, 8, 16), "1", 0));
        data.add(new Listviewitem4(R.drawable.ic_account_circle_black_48dp, "뭐해", "1", new Date(2016, 8, 16), "1", 0));
        data.add(new Listviewitem4(R.drawable.ic_account_circle_black_48dp, "안녕안녕안녕안녕안녕안녕녕안녕안녕안녕안녕", "1", new Date(2016, 8, 16), "1", 0));
        data.add(new Listviewitem4(R.drawable.ic_search_black_48dp, "뭐해", "1", new Date(2016, 8, 16), "아이디", 1));
        data.add(new Listviewitem4(R.drawable.ic_account_circle_black_48dp, "안녕안녕안녕안녕안녕안녕녕안녕안녕안녕안녕", "1", new Date(2016, 8, 16), "1", 0));
        data.add(new Listviewitem4(R.drawable.ic_search_black_48dp, "뭐해", "1", new Date(2016, 8, 16), "아이디", 1));
        data.add(new Listviewitem4(R.drawable.ic_account_circle_black_48dp, "안녕안녕안녕안녕안녕안녕녕안녕안녕안녕안녕", "1", new Date(2016, 8, 16), "1", 0));
        data.add(new Listviewitem4(R.drawable.ic_search_black_48dp, "뭐해", "1", new Date(2016, 8, 16), "아이디", 1));
        data.add(new Listviewitem4(R.drawable.ic_account_circle_black_48dp, "안녕안녕안녕안녕안녕안녕녕안녕안녕안녕안녕", "1", new Date(2016, 8, 16), "1", 0));
        data.add(new Listviewitem4(R.drawable.ic_search_black_48dp, "뭐해", "1", new Date(2016, 8, 16), "아이디", 1));
        data.add(new Listviewitem4(R.drawable.ic_search_black_48dp, "잔다1", "1", new Date(2016, 8, 16), "2", 0));
        data.add(new Listviewitem4(R.drawable.ic_search_black_48dp, "분기점2", "1", new Date(2016, 8, 16), "2", 0));*/
        adapter = new ListviewAdapter4(context, data);
        listView.setAdapter(adapter);
        listView.setSelection(data.size()-1);
        listView.setDivider(null);

    }

    Socket socket = null;
    ObjectOutputStream os = null;
    ObjectInputStream is = null;
    public void serverStart() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    socket = new Socket();
                    InetSocketAddress addr = new InetSocketAddress("192.168.14.31", 5000);
                    socket.connect(addr, 5000);
                    if (socket.isConnected()) Log.d("서버", "연결 성공");
                    activity.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(context, "서버 연결에 성공했습니다.\n", Toast.LENGTH_SHORT).show();
                        }
                    });
                    os = new ObjectOutputStream(socket.getOutputStream());
                    is = new ObjectInputStream(socket.getInputStream());
                    ServerIn();
                }catch (Exception e) {
                    Log.d("서버","오류심각");
                    e.printStackTrace();
                }
            }

        }).start();
    }
    public void ServerIn() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        ChatDTO inC = (ChatDTO)is.readObject();
                        Log.d("ServerIn",inC.toString());
                        int type = 0;
                        if(inC.getId().equals(info.getId())){
                            type =1;
                        }
                        data.add(new Listviewitem4(R.drawable.ic_search_black_48dp, inC.getContent(), String.valueOf(inC.getGathering_num()), new Date(2016, 8, 16), inC.getId(), type));
                        activity.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                adapter.notifyDataSetChanged();
                                listView.setSelection(data.size()-1);
                            }
                        });
                    } catch (NullPointerException e) {
                        continue;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();


    }

    public void msgSend(View v){
        EditText msg = (EditText)findViewById(R.id.submit);
        info = new ChatDTO();
        info.setGathering_num(1);
        info.setId("AndroidTEST");
        info.setContent(msg.getText().toString());
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    os.writeObject(info);
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        }).start();
    }
}








