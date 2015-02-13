package com.example.ariketa13listviewsql;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class CustomToast extends Toast{
	
	private Context context;

	public CustomToast(Context cont, int duration) {
		super(cont);
		context = cont;
		this.setDuration(duration);
	}

	public void show(CharSequence text) {
		LayoutInflater li = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View vi = (View) li.inflate(R.layout.toast_layout, null);
		
		TextView tv = (TextView) vi.findViewById(R.id.text_toast);
		this.setView(vi);
		tv.setText(text);
		
		super.show();
	}
	
	

}
