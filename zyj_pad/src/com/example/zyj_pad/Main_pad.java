package com.example.zyj_pad;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.adapter.FiterListAdapter;
import com.example.adapter.MainAdapter;

public class Main_pad extends Activity{
	
	public int mFiterType = 0;
	public TextView mOneRL = null;
	public TextView mTwoRL = null;
	public TextView mThreeRL = null;
	public TextView mFourRL = null;
	
	public RelativeLayout mRightRL = null;
	
	public ListView mPopupListView = null;
	public View mPopupView = null;

	public PopupWindow mPopupWindow = null;
	public FiterListAdapter mFiterAdapter = null;
	public FiterListAdapter mFiterAdapter_2 = null;
	
	public ListView mPopupLevel2ListView = null;
	
	public ListView MainListView = null;
	
	public List<Map<String, Object>> mMainList = new ArrayList<Map<String, Object>>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_pad);
		
		initControls();
	}
	
	public void initControls(){
		MainListView = (ListView)findViewById(R.id.ShopListView);
		
		mOneRL = (TextView) findViewById(R.id.Shoplist_title_textbtn1);
		mOneRL.setOnClickListener(new RL_ClickListener(1));
		
		mTwoRL = (TextView) findViewById(R.id.Shoplist_title_textbtn2);
		mTwoRL.setOnClickListener(new RL_ClickListener(2));
		
		mThreeRL = (TextView) findViewById(R.id.Shoplist_title_textbtn3);
		mThreeRL.setOnClickListener(new RL_ClickListener(3));
		
		mFourRL = (TextView) findViewById(R.id.Shoplist_title_textbtn4);
		mFourRL.setOnClickListener(new RL_ClickListener(4));
		
		
	}
	
	class RL_ClickListener implements View.OnClickListener{

		public int selfType;
		
		public RL_ClickListener(int type){
			this.selfType = type;
		}
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			initPopupWindow(this.selfType);
			mFiterAdapter = new FiterListAdapter(Main_pad.this,
					this.selfType, 0);
			mPopupListView
					.setOnItemClickListener(new FiterOnItemClickListener(selfType));

			mPopupListView.setAdapter(mFiterAdapter);
			mPopupWindow.showAsDropDown(mOneRL);
			mPopupWindow.setFocusable(true);
			mPopupWindow.update();
		}
		
	}
	
	public void initPopupWindow(int type) {
		mPopupView = LayoutInflater.from(this).inflate(
				R.layout.popupwindow_estate, null);
		mPopupWindow = new PopupWindow(mPopupView,
				ViewGroup.LayoutParams.MATCH_PARENT,
				ViewGroup.LayoutParams.WRAP_CONTENT);
		mPopupWindow.setBackgroundDrawable(new BitmapDrawable());
		mPopupWindow.setOutsideTouchable(true);

		mPopupListView = (ListView) mPopupView.findViewById(R.id.fiter_list_1);
		mPopupLevel2ListView = (ListView)mPopupView.findViewById(R.id.fiter_list_2);
		mRightRL = (RelativeLayout)mPopupView.findViewById(R.id.rl_right);
		if (type == 3 || type == 4){
			mRightRL.setVisibility(View.GONE);
		}
	}
	
	class FiterOnItemClickListener implements OnItemClickListener {

		public int index = 0;
		
		public FiterOnItemClickListener(int index){
			this.index = index;
		}
		
		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
				long arg3) {
			if (mRightRL.getVisibility() == View.GONE){
				MainAdapter mFiterAdapter_Main = new MainAdapter(Main_pad.this,
						MainListView);
				MainListView.setBackgroundResource(R.color.white);
				
				for (int i = 0; i < 10; i++){
					Map<String, Object> map = new HashMap<String, Object>();
					map.put("title", "这是标题");
					map.put("sub1", "这是第二行");
					map.put("sub2", "这是第三行");
					map.put("sub3", "这是第四行");
					mMainList.add(map);
				}
				
				mFiterAdapter_Main.setList(mMainList);
				MainListView.setAdapter(mFiterAdapter_Main);
				mPopupWindow.dismiss();
				
				MainListView.setOnItemClickListener(new OnItemClickListener() {

					@Override
					public void onItemClick(AdapterView<?> arg0, View arg1,
							int arg2, long arg3) {
						// TODO Auto-generated method stub
						Intent intent = new Intent(Main_pad.this, DetailActivity.class);
						startActivity(intent);
					}
				});
				return;
			}
			
			mFiterAdapter_2 = new FiterListAdapter(Main_pad.this,
					arg2+10, index);
			mPopupLevel2ListView.setAdapter(mFiterAdapter_2);
			
			mPopupLevel2ListView.setOnItemClickListener(new OnItemClickListener() {

				@Override
				public void onItemClick(AdapterView<?> arg0, View arg1,
						int arg2, long arg3) {
					// TODO Auto-generated method stub
//					MainListView = (ListView)findViewById(R.id.main_list);
					MainAdapter mFiterAdapter_Main = new MainAdapter(Main_pad.this,
							MainListView);
					MainListView.setBackgroundResource(R.color.white);
					
					for (int i = 0; i < 10; i++){
						Map<String, Object> map = new HashMap<String, Object>();
						map.put("title", "这是标题");
						map.put("sub1", "这是第二行");
						map.put("sub2", "这是第三行");
						map.put("sub3", "这是第四行");
						mMainList.add(map);
					}
					
					mFiterAdapter_Main.setList(mMainList);
					MainListView.setAdapter(mFiterAdapter_Main);
					mPopupWindow.dismiss();
					
					MainListView.setOnItemClickListener(new OnItemClickListener() {

						@Override
						public void onItemClick(AdapterView<?> arg0, View arg1,
								int arg2, long arg3) {
							// TODO Auto-generated method stub
							Intent intent = new Intent(Main_pad.this, DetailActivity.class);
							startActivity(intent);
						}
					});
				}
			});
		}

	}
	
}
