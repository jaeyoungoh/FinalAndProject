package com.project.finalandproject.board;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.project.finalandproject.R;

import java.util.ArrayList;


public class Comment_Adapter extends BaseAdapter implements OnClickListener{
	private Context mContext;
	private Activity mActivity;
	private ArrayList<BoardDTO> arr;
	private int pos;
	private MainActivity ma;
	private String id = "test"; //static Member ID
	public Comment_Adapter(Context mContext, Activity mActivity, MainActivity mc, ArrayList<BoardDTO> arr_item) {
		this.mContext = mContext;
		this.mActivity = mActivity;
		this.arr = arr_item;
		this.ma = mc;
	}
	@Override
	public int getCount() {
		return arr.size();
	}
	@Override
	public Object getItem(int position) {
		return arr.get(position);
	}
	public long getItemId(int position){
		return position;
	}
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if(convertView == null){
			int res = 0;
			res = R.layout.comment_item;
			LayoutInflater mInflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView = mInflater.inflate(res, parent, false);
		}
		pos = position;
		if(arr.size() != 0){
			TextView ci_nickname_text = (TextView)convertView.findViewById(R.id.ci_nickname_text);
			ci_nickname_text.setText(arr.get(pos).getMember_id());
			TextView ci_content_text = (TextView)convertView.findViewById(R.id.ci_content_text);
			ci_content_text.setText(arr.get(pos).getGathering_bd_content());
			TextView ci_wdate_text = (TextView)convertView.findViewById(R.id.ci_wdate_text);
			ci_wdate_text.setText(arr.get(pos).getGathering_bd_date());
			Button ci_delete_btn = (Button)convertView.findViewById(R.id.ci_delete_btn);
			if(id.equals(arr.get(pos).getMember_id())){
				ci_delete_btn.setVisibility(View.VISIBLE);
				ci_delete_btn.setOnClickListener(this);
				ci_delete_btn.setTag(arr.get(pos).getGathering_bd_num());
			} else{
				ci_delete_btn.setVisibility(View.INVISIBLE);
			}


		}
		return convertView;
	}
	public void onClick(View v){
		final String tag = v.getTag().toString();
		switch(v.getId()){
			case R.id.ci_delete_btn:
				AlertDialog.Builder alertDlg = new AlertDialog.Builder(mActivity);
				alertDlg.setPositiveButton("삭제", new DialogInterface.OnClickListener(){
					@Override
					public void onClick( DialogInterface dialog, int which ) {
						ma.deleteArr(tag);
						Toast.makeText(mContext, "댓글이 삭제되었습니다.", Toast.LENGTH_SHORT).show();
					}
				});
				alertDlg.setNegativeButton("취소", null);
				alertDlg.setTitle("댓글 삭제");
				alertDlg.setMessage("정말 삭제 하시겠습니까?");
				alertDlg.show();
				break;
		}
	}
}