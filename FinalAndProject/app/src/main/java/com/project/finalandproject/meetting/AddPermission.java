package com.project.finalandproject.meetting;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;

/**
 * Created by 김희윤 on 2016-08-18.
 */
public class AddPermission {

    static public boolean add(String permission, Activity activity) {
        if (Build.VERSION.SDK_INT >= 23) {
            //사용 권한 체크(사용권한이 없을 경우)
            if (ContextCompat.checkSelfPermission(activity, permission) != PackageManager.PERMISSION_GRANTED) {
                Log.i("msg","if안 권한없음");
                //권한이 없을 경우
                //최초 권한 요청인지, 혹은 사용자에 의한 재요청인지 확인
                if (ActivityCompat.shouldShowRequestPermissionRationale(activity, permission)) { //사용자가임의로 권한을취소 시킨 경우
                    //권한 재요청
                    ActivityCompat.requestPermissions(activity, new String[]{permission}, 0);
                    ActivityCompat.shouldShowRequestPermissionRationale(activity, permission);
                } else {  //최초로 권한을 요청하는 경우(첫실행)
                    ActivityCompat.requestPermissions(activity, new String[]{permission}, 0);
                }
            }
        }
        Log.i("a permission", (ActivityCompat.checkSelfPermission(activity, permission) == PackageManager.PERMISSION_GRANTED)+"");
        Log.i("c permission", (ContextCompat.checkSelfPermission(activity, permission) == PackageManager.PERMISSION_GRANTED)+"");
        return ContextCompat.checkSelfPermission(activity, permission) == PackageManager.PERMISSION_GRANTED;
    }
}