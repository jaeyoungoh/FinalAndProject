package com.project.finalandproject.test;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.project.finalandproject.R;

import java.util.ArrayList;

public class Test_Menu_Activity extends Activity implements OnClickListener {

	/* slide menu */
	private DisplayMetrics metrics;
	private LinearLayout ll_mainLayout;
	private LinearLayout ll_menuLayout;
	private FrameLayout.LayoutParams leftMenuLayoutPrams;
	private int leftMenuWidth;
	private static boolean isLeftExpanded;
	private Button btn1, btn2, btn3, btn4;
	private ImageButton  bt_left;
	ArrayList<Listviewitem> data2;

	ListView menu_list1,menu_list2;
    LinearLayout container;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.test_menu_main);
		LinearLayout inter = (LinearLayout) findViewById(R.id.inter);


		LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		inflater.inflate(R.layout.testholdtitle, inter,true);

		initSildeMenu();
        container=(LinearLayout) findViewById(R.id.container);
        LinearLayout containerInflater = (LinearLayout) findViewById(R.id.containerInflater);

		inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		inflater.inflate(R.layout.test_top, containerInflater,true);
        container.removeAllViews();
        container.addView(new gathering_list(this));

        //메뉴1 버튼 추가.
		((Button) findViewById(R.id.bt1)).setOnClickListener(this);
		((Button) findViewById(R.id.bt2)).setOnClickListener(this);
		((Button) findViewById(R.id.bt3)).setOnClickListener(this);

        //리스트뷰 아이템추가

	}

	private void initSildeMenu() {
//왼쪽 메뉴 아이템 추가 및 애니메이션 효과
		// init left menu width
		metrics = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(metrics);
		leftMenuWidth = (int) ((metrics.widthPixels) * 0.75);

		// init main view
		ll_mainLayout = (LinearLayout) findViewById(R.id.ll_mainlayout);

		// init left menu
		ll_menuLayout = (LinearLayout) findViewById(R.id.ll_menuLayout);
		ll_menuLayout.setX(-leftMenuWidth);
        //메뉴 아이템 추가.
        //홈,만남검색, 그룹검색,나의그룹
        menu_list1=(ListView) findViewById(R.id.menu_list);
        data2=new ArrayList<Listviewitem>();
        data2.add(new Listviewitem(R.drawable.ic_home_black_48dp,"홈"));
        data2.add(new Listviewitem(R.drawable.ic_search_black_48dp,"검색"));
        data2.add(new Listviewitem(R.drawable.ic_event_black_48dp,"일정관리"));
        data2.add(new Listviewitem(R.drawable.ic_account_circle_black_48dp,"나의그룹"));
        ListviewAdapter adapter =new ListviewAdapter(this,R.layout.item1,data2);
        menu_list1.setAdapter(adapter);
        menu_list1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //리스트뷰 아이템선택시 작업.
                Log.i("msg1",adapterView.getCount()+"");
                for(int j=0;j<adapterView.getCount();j++){
                    LinearLayout ll=((LinearLayout)((ListView)view.getParent()).getChildAt(j));
                    TextView tv=(TextView)ll.getChildAt(1);
                    ImageView iv=(ImageView)ll.getChildAt(0);
                    ll.setBackgroundColor(Color.WHITE);
                    iv.setSelected(false);
                    tv.setTextColor(getResources().getColor(R.color.c9));
                }
                ((LinearLayout)view).setBackgroundColor(getResources().getColor(R.color.c7));
                ((TextView)((LinearLayout)view).getChildAt(1)).setTextColor(getResources().getColor(R.color.c5));
                ((ImageView)((LinearLayout)view).getChildAt(0)).setSelected(true);
                container.removeAllViews();
                if(i==0)
                    container.addView(new gathering_list(getApplication()));
                else if(i==1)
                    container.addView(new test_in(getApplication()));
                else if(i==2)
                    container.addView(new gathering_list(getApplication()));
                else if(i==3)
                    container.addView(new test_in(getApplication()));
                menuLeftSlideAnimationToggle();

            }

        });
        menu_list2=(ListView) findViewById(R.id.menu_list2);

		leftMenuLayoutPrams = (FrameLayout.LayoutParams) ll_menuLayout
				.getLayoutParams();
		leftMenuLayoutPrams.width = leftMenuWidth;
		ll_menuLayout.setLayoutParams(leftMenuLayoutPrams);

		// init ui
		bt_left = (ImageButton) findViewById(R.id.bt_left);
		bt_left.setOnClickListener(this);

	}

	/**
	 * left menu toggle
	 */
	private void menuLeftSlideAnimationToggle() {
//메뉴 애니메이션 toggle
		if (!isLeftExpanded) {

			isLeftExpanded = true;
			Log.i("msg",leftMenuWidth+"");
			// Expand
			new OpenAnimation(ll_menuLayout, leftMenuWidth,
					Animation.RELATIVE_TO_SELF, 0f,
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
							/*ll_menuLayout.setX(-leftMenuWidth);*/
							menuLeftSlideAnimationToggle();
							return true;
						}
					});

		} else {
			isLeftExpanded = false;

			// close
			new OpenAnimation(ll_menuLayout,0,
					Animation.RELATIVE_TO_SELF, 0f,
					Animation.RELATIVE_TO_SELF, -0.75f, 0, 0.0f, 0, 0.0f);
			//LinearLayout layout, int width, int fromXType,
			//float fromXValue, int toXType, float toXValue, int fromYType,
			//float fromYValue, int toYType, float toYValue
			//
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
        //뷰 사용 동작 제어/
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

			case R.id.bt1:
				Toast.makeText(getApplicationContext(), "실험1", Toast.LENGTH_SHORT)
						.show();
				break;
			case R.id.bt2:
				Toast.makeText(getApplicationContext(), "실험2", Toast.LENGTH_SHORT)
						.show();
				break;
			case R.id.bt3:
				Toast.makeText(getApplicationContext(), "실험3", Toast.LENGTH_SHORT)
						.show();
				break;
		}

	}
}
