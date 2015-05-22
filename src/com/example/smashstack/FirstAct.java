package com.example.smashstack;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import com.psiuol21.smashstack.R;

public class FirstAct extends ActionBarActivity {
TextView tv;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
	    getActionBar().hide();
		setContentView(R.layout.activity_first);
		 tv=(TextView)findViewById(R.id.textView1);
		    Typeface mFont = Typeface.createFromAsset(getAssets(), "fonts/FONTX.TTF");
		    tv.setTypeface(mFont);
		    tv.setTextColor(Color.parseColor("#FFF000"));
		    tv.setText("NINJASMACK");

		
	}
	
	public void enter(View v)
	{
		Intent intent=new Intent(FirstAct.this,MainActivity.class);
		startActivity(intent);
		finish();
		 
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.first, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	

}
