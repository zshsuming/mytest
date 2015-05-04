package com.example.adapter;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Map;

import org.xmlpull.v1.XmlPullParserException;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;

public abstract class Base_InfoListAdapter extends BaseAdapter {
	public Context context = null;
	public List<Map<String, Object>> list = null;
	// public String URL = null;

	public URL url = null;
	public HttpURLConnection urlConn = null;
	public InputStream inputStream = null;

	public AbsListView listView = null;

	public Base_InfoListAdapter(Context context, AbsListView listView) {
		this.context = context;
		// URL = MyApplication.getInstance().getPIC_URL();
		this.listView = listView;
	}

	public void setList(List<Map<String, Object>> list) {
		this.list = list;
		this.notifyDataSetChanged();
	}

	public List<Map<String, Object>> getList() {
		return list != null ? list : null;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		int count = 0;
		if (list != null) {
			count = list.size();
		}
		return count;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return list != null ? list.get(position) : null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public abstract View getView(int position, View convertView,
			ViewGroup parent);

	/*
	 * static abstract class ViewHolder{
	 * 
	 * }
	 */

	public InputStream downFile(String fileName) throws MalformedURLException,
			IOException, XmlPullParserException {
		url = new URL(fileName);
		urlConn = (HttpURLConnection) url.openConnection();
		urlConn.setConnectTimeout(3000);
		inputStream = urlConn.getInputStream();
		return inputStream;
	}

//	public static class AnimateFirstDisplayListener extends
//			SimpleImageLoadingListener {
//
//		static final List<String> displayedImages = Collections
//				.synchronizedList(new LinkedList<String>());
//
//		@Override
//		public void onLoadingComplete(String imageUri, View view,
//				Bitmap loadedImage) {
//			if (loadedImage != null) {
//				ImageView imageView = (ImageView) view;
//				boolean firstDisplay = !displayedImages.contains(imageUri);
//				if (firstDisplay) {
//					FadeInBitmapDisplayer.animate(imageView, 500);
//					displayedImages.add(imageUri);
//				}
//			}
//		}
//	}
}