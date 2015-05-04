package com.example.zyj_pad;

import android.content.Context;
import android.content.res.TypedArray;

public class ItemsHelper {
	
	public static String[] getStringItems(Context context, int resId){		
		return context.getResources().getStringArray(resId);
	}
	
	public static String[] getStringItems2(Context context, int resId){
		String[] items = getStringItems(context,resId);
		String[] returnItems = new String[items.length - 1];
		for (int i = 0; i < items.length - 1; i++){
			returnItems[i] = items[i+1]; 
		}
		return returnItems;
	}
	
	public static int[] getIntItems(Context context, int resId){
		return context.getResources().getIntArray(resId);
	}
	
	public static TypedArray getTypedArrayItems(Context context, int resId){
		return context.getResources().obtainTypedArray(resId);		
	}
	
//	public static int[] getDrawableItems(Context context, int resId){
//		return ;
//	}
	
	
	
}
