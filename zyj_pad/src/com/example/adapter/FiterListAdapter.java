package com.example.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.zyj_pad.Data;
import com.example.zyj_pad.R;

public class FiterListAdapter extends BaseAdapter {

	public String[] mTitleItems = null;
	public int type = 0;
	public int main_type = 0;
	public TextView mTitleTextView = null;
	public Context context;

	public FiterListAdapter(Context context, int type, int main_type) {
		this.main_type = main_type;
		this.context = context;
		this.type = type;
		getItems();
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		convertView = LayoutInflater.from(context).inflate(
				R.layout.fiter_infolist, null);
		mTitleTextView = (TextView) convertView
				.findViewById(R.id.text_title);
		if (mTitleItems.length > 0) {
			mTitleTextView.setText(mTitleItems[position]);
		}
		return convertView;
	}

	public void getItems() {
		if (type >= 10){
			switch (main_type) {
			case 1:
				mTitleItems = Data.MORELISTTXT[type-10];
				break;
			case 2:
				mTitleItems = Data.SHOPLIST_PLACESTREET[type-10];
				break;
			case 3:
//				mTitleItems = Data.SHOPLIST_THREELIST;				
				break;
			case 4:
//				mTitleItems = Data.MORELISTTXT[type-10];
				break;
			default:
				break;
			}
			
			return;
		}
		
		
		switch (type) {
		case 1:
			mTitleItems = Data.LISTVIEWTXT;
			break;
		case 2:
			mTitleItems = Data.SHOPLIST_TOPLIST;
			break;
		case 3:
			mTitleItems = Data.SHOPLIST_THREELIST;
			break;
		case 4:
			mTitleItems = Data.PAIHANGBANG_TOPLIST;
			break;
		case 10:
			mTitleItems =  Data.MORELISTTXT[0];
			break;
		case 11:
			mTitleItems = Data.MORELISTTXT[1];
			break;
		case 12:
			mTitleItems = Data.MORELISTTXT[2];
			break;
		case 13:
			mTitleItems = Data.MORELISTTXT[3];		
			break;
		}
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mTitleItems.length;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

}
