package com.project.finalandproject.test;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.project.finalandproject.R;

import java.util.ArrayList;

public class Test_Board_Write extends Activity implements OnClickListener {

	/* slide menu */
	private DisplayMetrics metrics;
	private LinearLayout ll_mainLayout;
	private LinearLayout ll_menuLayout;
	private FrameLayout.LayoutParams leftMenuLayoutPrams;
	private int leftMenuWidth;
	private static boolean isLeftExpanded;
	private Button btn1, btn2, btn3, btn4;
	private ImageButton  bt_left;
	ArrayList<Listviewitem> data;
	Listviewitem test1,test3,test2,test4;
	ListView listView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.test_board_list);
		LinearLayout inter = (LinearLayout) findViewById(R.id.inter);

		LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		inflater.inflate(R.layout.test_board_write_content, inter,true);  // 게시판 글 목록 틀

			initSildeMenu();
		LinearLayout container = (LinearLayout) findViewById(R.id.board_write_bottom_containerInflater); // 게시판 글 목록 구간

		inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		inflater.inflate(R.layout.test_board_write_bottom, container,true); // 게시판 기능버튼 구간 (글쓰기, 검색, 삭제)

		((Button) findViewById(R.id.board_write_bt1)).setOnClickListener(this);
		((Button) findViewById(R.id.board_write_bt2)).setOnClickListener(this);
		((Button) findViewById(R.id.board_write_bt3)).setOnClickListener(this);

		((TextView) findViewById(R.id.board_list_title)).setText("글쓰기");


	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		menu.add("계산기"); menu.add("이미지변경"); menu.add("타로");menu.add("로또");
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if (item.getTitle().equals("글쓰기")){
		Toast.makeText(getApplicationContext(), "글쓰기", Toast.LENGTH_SHORT).show();
		}
		return super.onOptionsItemSelected(item);
	}

	private void initSildeMenu() {

		// init left menu width
		metrics = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(metrics);
		leftMenuWidth = (int) ((metrics.widthPixels) * 0.75);

		// init main view
		ll_mainLayout = (LinearLayout) findViewById(R.id.ll_mainlayout);

		// init left menu
		ll_menuLayout = (LinearLayout) findViewById(R.id.ll_menuLayout);


		leftMenuLayoutPrams = (FrameLayout.LayoutParams) ll_menuLayout
				.getLayoutParams();
		leftMenuLayoutPrams.width = leftMenuWidth;
		ll_menuLayout.setLayoutParams(leftMenuLayoutPrams);

		// init ui
		bt_left = (ImageButton) findViewById(R.id.bt_left);
		bt_left.setOnClickListener(this);

/*		btn1 = (Button) findViewById(R.id.btn1);
		btn2 = (Button) findViewById(R.id.btn2);
		btn3 = (Button) findViewById(R.id.btn3);
		btn4 = (Button) findViewById(R.id.btn4);
		btn1.setOnClickListener(this);
		btn2.setOnClickListener(this);
		btn3.setOnClickListener(this);
		btn4.setOnClickListener(this);*/

	}

	/**
	 * left menu toggle
	 */
	private void menuLeftSlideAnimationToggle() {

		if (!isLeftExpanded) {

			isLeftExpanded = true;

			// Expand
			new OpenAnimation(ll_mainLayout, leftMenuWidth,
					Animation.RELATIVE_TO_SELF, 0.0f,
					Animation.RELATIVE_TO_SELF, 0.75f, 0, 0.0f, 0, 0.0f);

			// disable all of main view
			FrameLayout viewGroup = (FrameLayout) findViewById(R.id.ll_fragment)
					.getParent();
			enableDisableViewGroup(viewGroup, false);

			// enable empty view
			((LinearLayout) findViewById(R.id.ll_empty))
					.setVisibility(View.VISIBLE);

			findViewById(R.id.ll_empty).setEnabled(true);
			findViewById(R.id.ll_empty).setOnTouchListener(
					new OnTouchListener() {

						@Override
						public boolean onTouch(View arg0, MotionEvent arg1) {
							menuLeftSlideAnimationToggle();
							return true;
						}
					});

		} else {
			isLeftExpanded = false;

			// close
			new CloseAnimation(ll_mainLayout, leftMenuWidth,
					TranslateAnimation.RELATIVE_TO_SELF, 0.75f,
					TranslateAnimation.RELATIVE_TO_SELF, 0.0f, 0, 0.0f, 0, 0.0f);

			// enable all of main view
			FrameLayout viewGroup = (FrameLayout) findViewById(R.id.ll_fragment)
					.getParent();
			enableDisableViewGroup(viewGroup, true);

			// disable empty view
			((LinearLayout) findViewById(R.id.ll_empty))
					.setVisibility(View.GONE);
			findViewById(R.id.ll_empty).setEnabled(false);

		}
	}

	/**
	 * 뷰의 동작을 제어한다. 하위 모든 뷰들이 enable 값으로 설정된다.
	 * 
	 * @param viewGroup
	 * @param enabled
	 */
	public static void enableDisableViewGroup(ViewGroup viewGroup,
			boolean enabled) {
		int childCount = viewGroup.getChildCount();
		for (int i = 0; i < childCount; i++) {
			View view = viewGroup.getChildAt(i);
			if (!(view.getId() == R.id.ll_menuLayout || view.getId()==R.id.menu_bar)) {
				view.setEnabled(enabled);
				if (view instanceof ViewGroup) {
					enableDisableViewGroup((ViewGroup) view, enabled);
				}
			}
		}
	}

	@Override
	public void onClick(View v) {

		switch (v.getId()) {
		case R.id.bt_left:
			menuLeftSlideAnimationToggle();
			break;
/*		case R.id.btn1:
			Toast.makeText(getApplicationContext(), btn1.getText(), Toast.LENGTH_SHORT)
					.show();
			break;
		case R.id.btn2:
			Toast.makeText(getApplicationContext(), btn2.getText(), Toast.LENGTH_SHORT)
					.show();
			break;
		case R.id.btn3:
			Toast.makeText(getApplicationContext(), btn3.getText(), Toast.LENGTH_SHORT)
					.show();
			break;
		case R.id.btn4:
			Toast.makeText(getApplicationContext(), btn4.getText(), Toast.LENGTH_SHORT)
					.show();
			break;*/
			case R.id.board_write_bt1:
				Toast.makeText(getApplicationContext(), "board_write_bt1", Toast.LENGTH_SHORT)
						.show();
				data.add(test3);

				break;
			case R.id.board_write_bt2:
				Toast.makeText(getApplicationContext(), "board_write_bt2", Toast.LENGTH_SHORT)
						.show();
				break;
			case R.id.board_write_bt3:
				Toast.makeText(getApplicationContext(), "board_write_bt3", Toast.LENGTH_SHORT)
						.show();
				break;
		}

	}
}
