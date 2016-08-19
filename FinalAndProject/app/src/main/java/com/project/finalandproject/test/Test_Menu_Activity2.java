package com.project.finalandproject.test;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.project.finalandproject.R;
import com.project.finalandproject.chat.gathering_chatting;

import java.util.ArrayList;

public class Test_Menu_Activity2 extends Activity implements OnClickListener {

	/* slide menu */
	private DisplayMetrics metrics;
	private LinearLayout ll_mainLayout;
	private LinearLayout ll_menuLayout;
	private FrameLayout.LayoutParams leftMenuLayoutPrams;
	private int leftMenuWidth;
	private static boolean isLeftExpanded;
	private Button btn1, btn2, btn3, btn4;
	private ImageButton bt_left;
	ArrayList<Listviewitem> data2;

	LinearLayout container;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.top_menu_layout);
		LinearLayout inter = (LinearLayout) findViewById(R.id.inter);


		LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		inflater.inflate(R.layout.testholdtitle, inter, true);


		container = (LinearLayout) findViewById(R.id.container);
		LinearLayout containerInflater = (LinearLayout) findViewById(R.id.containerInflater);

		inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		inflater.inflate(R.layout.test_top2, containerInflater, true);
		//메뉴1 버튼 추가.
		((LinearLayout) findViewById(R.id.bt_back)).setOnClickListener(this);

		((Button) findViewById(R.id.bt1)).setOnClickListener(this);
		((Button) findViewById(R.id.bt2)).setOnClickListener(this);
		((Button) findViewById(R.id.bt3)).setOnClickListener(this);
		((Button) findViewById(R.id.bt4)).setOnClickListener(this);

		/*container.addView(new gathering_view2(getApplication(),getIntent()));
		((Button) findViewById(R.id.bt1)).setTextColor(getResources().getColor(R.color.c1));
		((View) findViewById(R.id.select)).setX(((Button) findViewById(R.id.bt1)).getX());*/
		clickmenu(4);

		//리스트뷰 아이템추가
	}


	@Override
	public void onClick(View v) {

		switch (v.getId()) {
			case R.id.bt_back:
				finish();
				break;

			case R.id.bt1:
				clickmenu(0);
				break;
			case R.id.bt2:
				clickmenu(1);
				break;
			case R.id.bt3:
				clickmenu(2);
				break;
			case R.id.bt4:
				clickmenu(3);
				break;
		}

	}

	public void clickmenu(int i) {
		container.removeAllViews();
		((Button) findViewById(R.id.bt1)).setTextColor(Color.WHITE);
		((Button) findViewById(R.id.bt2)).setTextColor(Color.WHITE);
		((Button) findViewById(R.id.bt3)).setTextColor(Color.WHITE);
		((Button) findViewById(R.id.bt4)).setTextColor(Color.WHITE);

		if (i == 0) {
			((Button) findViewById(R.id.bt1)).setTextColor(getResources().getColor(R.color.c3));
			((View) findViewById(R.id.select)).setX(((Button) findViewById(R.id.bt1)).getX());
				container.addView(new gathering_view2(getApplication(),getIntent()));
			} else if (i == 1) {
			((Button) findViewById(R.id.bt2)).setTextColor(getResources().getColor(R.color.c3));
			((View) findViewById(R.id.select)).setX(((Button) findViewById(R.id.bt2)).getX());
				container.addView(new gathering_view2(getApplication(),getIntent()));
			/*container.addView(new Setting_page(getApplication()));*/
			} else if (i == 2) {
				//container.addView(new gathering_list(getApplication()));
				((View) findViewById(R.id.select)).setX(((Button) findViewById(R.id.bt3)).getX());
			((Button) findViewById(R.id.bt3)).setTextColor(getResources().getColor(R.color.c3));
			container.addView(new gathering_view2(getApplication(),getIntent()));
			} else if (i == 3) {
				((View) findViewById(R.id.select)).setX(((Button) findViewById(R.id.bt4)).getX());
			((Button) findViewById(R.id.bt4)).setTextColor(getResources().getColor(R.color.c3));
			container.addView(new gathering_chatting(getApplication(),this));
				//container.addView(new test_in(getApplication()));
			}

		}
}