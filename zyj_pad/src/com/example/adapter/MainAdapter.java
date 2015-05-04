package com.example.adapter;




import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.zyj_pad.R;

public class MainAdapter extends Base_InfoListAdapter{

	public MainAdapter(Context context, AbsListView listView) {
		super(context, listView);
		// TODO Auto-generated constructor stub
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		
		convertView = LayoutInflater.from(context).inflate(
				R.layout.main_infolist, null);
		
		ImageView mCoverImageView = (ImageView) convertView
				.findViewById(R.id.image_cover);
		TextView mTitleTextView_1 = (TextView) convertView
				.findViewById(R.id.text_title);
		TextView mTitleTextView_2 = (TextView) convertView
				.findViewById(R.id.sub_title_1);
		TextView mTitleTextView_3 = (TextView) convertView
				.findViewById(R.id.sub_title_2);
		TextView mTitleTextView_4 = (TextView) convertView
				.findViewById(R.id.sub_title_3);
		
		mTitleTextView_1.setText(list.get(position).get("title").toString());
		mTitleTextView_2.setText(list.get(position).get("sub1").toString());
		mTitleTextView_3.setText(list.get(position).get("sub2").toString());
		mTitleTextView_4.setText(list.get(position).get("sub3").toString());
		
		return convertView;
	}


}
