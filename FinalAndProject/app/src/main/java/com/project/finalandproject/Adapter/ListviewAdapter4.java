package com.project.finalandproject.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.project.finalandproject.R;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016-08-03.
 */
public class ListviewAdapter4 extends BaseAdapter {
    private Context context;
    private ArrayList<Listviewitem4> data;

    public ListviewAdapter4(Context context, ArrayList<Listviewitem4> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Listviewitem4 getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
       // Log.i("layout",res+"=");
        int res = data.get(position).getType();//현재 위치의 Type을 조사해보고
        if (convertView == null) {
            //초기값설정
        }
            Log.i("position",position+"");

            // Log.i("layout",res+"+");

            Log.d("type", res+"");
            switch (res) {
                case 0://0이면 textedit
                    res = R.layout.mitem;
                    break;
                case 1://1이면 btnicon으로 R.layout값을 넣어주고
                    res = R.layout.mitem2;
                    break;
            }
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(res, parent, false);

        Listviewitem4 listviewitem = data.get(position);

        ImageView icon = (ImageView) convertView.findViewById(R.id.icon);
        icon.setImageResource(listviewitem.getIcon());
        TextView message = (TextView) convertView.findViewById(R.id.message);
        message.setText(listviewitem.getMessage());
        TextView date = (TextView) convertView.findViewById(R.id.date);
        date.setText(listviewitem.getDate() + "");
        TextView id = (TextView) convertView.findViewById(R.id.id);
        id.setText(listviewitem.getId() + "");

        //최초 호출이면 항목 뷰를 생성한다.
        //타입별로 뷰를 다르게 디자인 할 수 있으며 높이가 달라도 상관없다.




            //icon,message,GATHERING_NUM,date,id
            //채팅창 매개변수
            //출력 : 프로필, 메세지, 날짜
            //히든 : 그룹번호, 아이디


        return convertView;
    }
}