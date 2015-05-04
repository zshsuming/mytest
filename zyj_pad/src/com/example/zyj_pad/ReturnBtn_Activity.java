package com.example.zyj_pad;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

public class ReturnBtn_Activity extends Activity {
	public TextView btnReturn = null;
	public TextView tvTitle = null;
	
	public String title = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);	
	}

	public void InitReturnBtn(){
		btnReturn = (TextView)findViewById(R.id.back_btn);
		btnReturn.setOnClickListener(new View.OnClickListener() {			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});
	}
	
	public void InitTitle(){
		tvTitle = (TextView)findViewById(R.id.title);
		tvTitle.setText(title);		
	}
	
}
