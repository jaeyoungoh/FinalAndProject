package com.project.finalandproject.test;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.project.finalandproject.R;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Administrator on 2016-08-17.
 */
public class Image_trans extends Activity {
    ImageView img1, img2,img3,img4,img5,img6;

    String url;
    back task;
    Bitmap bmImg;
    int cnt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.image_trans);
        super.onCreate(savedInstanceState);

        img1 = (ImageView) findViewById(R.id.img1);
        img2 = (ImageView) findViewById(R.id.img2);
        img3 = (ImageView) findViewById(R.id.img3);
        img4 = (ImageView) findViewById(R.id.img4);
        img5 = (ImageView) findViewById(R.id.img5);
        img6 = (ImageView) findViewById(R.id.img6);

        url = "http://192.168.14.38:8805/finalproject/File_Download.do?filename=";





        cnt = 0;


        Button trans_bt = (Button) findViewById(R.id.trans_bt);
        trans_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                if (task.isCancelled()) == )

                task = new back();
                url = "";
                url = "http://192.168.14.38:8805/finalproject/File_Download.do?filename=";
                cnt  += 1;
                url += cnt+".jpg";

                task.execute(url);
                String output = String.valueOf(cnt);
                Log.d("출력용", output);

            }
        });
    }


    private class back extends AsyncTask<String, Integer,Bitmap>{



        @Override
        protected Bitmap doInBackground(String... urls) {
            // TODO Auto-generated method stub
            try{
                URL myFileUrl = new URL(urls[0]);
                HttpURLConnection conn = (HttpURLConnection)myFileUrl.openConnection();
                conn.setDoInput(true);
                conn.connect();

                InputStream is = conn.getInputStream();

                bmImg = BitmapFactory.decodeStream(is);


            }catch(IOException e){
                e.printStackTrace();
            }
            return bmImg;
        }

        protected void onPostExecute(Bitmap img){

            if (cnt == 1){
                img1.setImageBitmap(bmImg);
            }else if (cnt ==2){
                img2.setImageBitmap(bmImg);
            }else if (cnt ==3){
                img3.setImageBitmap(bmImg);
            }else if (cnt ==4){
                img4.setImageBitmap(bmImg);
            }else if (cnt ==5){
                img5.setImageBitmap(bmImg);
            }else if (cnt ==6){
                img6.setImageBitmap(bmImg);
            }

        }

    }
}




