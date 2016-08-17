package com.project.finalandproject.board;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.project.finalandproject.R;

import java.util.ArrayList;

public class MainActivity extends Activity implements OnClickListener{
	ListView comment_list;
	EditText comment_edit;
	Comment_Adapter ca;
	View footer;
	String gathering_num ="1";
	String id = "test";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		init();
	}

	public void init(){
		comment_list = (ListView)findViewById(R.id.jrv_comment_list);
		footer = getLayoutInflater().inflate(R.layout.footer, null, false);
		comment_list.addHeaderView(footer);
		setList();
		setFooter();
	}
	private void setFooter(){
		comment_edit = (EditText)footer.findViewById(R.id.jrv_comment_edit);
		Button commentinput_btn = (Button)footer.findViewById(R.id.jrv_commentinput_btn);

		commentinput_btn.setOnClickListener(this);
	}

	private void setList(){
		ArrayList<BoardDTO> c_arr = (ArrayList<BoardDTO>)BDConn.conn("refresh", gathering_num);
		ca = new Comment_Adapter(getApplicationContext(), MainActivity.this, MainActivity.this, c_arr);
		comment_list.setAdapter(ca);
		comment_list.setSelection(c_arr.size()-1);
		comment_list.setDivider(null);
		comment_list.setSelectionFromTop(0,0);
	}

	@Override
	public void onClick(View v) {
		switch(v.getId()){
			case R.id.jrv_commentinput_btn:
				String temp = comment_edit.getText().toString();
				if(temp.equals("")){
					Toast.makeText(MainActivity.this, "빈칸이 있습니다.", Toast.LENGTH_SHORT).show();
				}else{
					BoardDTO dto = new BoardDTO();
					dto.setMember_id(id); //static Member ID
					dto.setGathering_bd_content(temp);
					dto.setGathering_num(gathering_num);
					BDConn.conn("addBD", dto);
					comment_edit.setText("");
					setList();
				}
				break;
		}
	}
	public void deleteArr(String num){
		BDConn.conn("deleteBD", num);
		setList();
	}

}
