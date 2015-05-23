package com.example.smashstack;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import android.widget.Toast;

import com.psiuol21.smashstack.R;

public class LastActivity extends ActionBarActivity {
TextView tv,tv2;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
	    getActionBar().hide();
		setContentView(R.layout.activity_last);
	    int score = getIntent().getIntExtra("score",0);
	   // Toast.makeText(getApplicationContext(), score, Toast.LENGTH_SHORT).show();
	    tv=(TextView)findViewById(R.id.textView1);
	    tv2=(TextView)findViewById(R.id.textView2);
	    Typeface mFont = Typeface.createFromAsset(getAssets(), "fonts/FONTX.TTF");
	    tv.setTypeface(mFont);
	    tv.setTextColor(Color.parseColor("#FFF000"));
	    tv.setText(score+"");
	
	    tv2.setTypeface(mFont);
	    tv2.setTextColor(Color.parseColor("#FFF000"));
	    if(score<5)
	    tv2.setText("WHITE BELT");
	    else if(score<10)
	    tv2.setText("YELLOW BELT");
	    else if(score<15)
		    tv2.setText("GREEN BELT");
	    else if(score<20)
		    tv2.setText("BLUE BELT");
	    else if(score<25)
		    tv2.setText("RED BELT");
	    else if(score<30)
		    tv2.setText("BLACK BELT");
	    
	
	}
	
	private boolean MyStartActivity(Intent aIntent) {
	    try
	    {
	        startActivity(aIntent);
	        return true;
	    }
	    catch (ActivityNotFoundException e)
	    {
	        return false;
	    }
	}

	
	public void rateus(View v)
	{
	Intent intent = new Intent(Intent.ACTION_VIEW);
    //Try Google play
    intent.setData(Uri.parse("market://details?id=com.psiuol21.smashstack"));
    if (!MyStartActivity(intent)) {
        //Market (Google play) app seems not installed, let's try to open a webbrowser
        intent.setData(Uri.parse("https://play.google.com/store/apps/details?id=com.psiuol21.smashstack"));
        if (!MyStartActivity(intent)) {
            //Well if this also fails, we have run out of options, inform the user.
            Toast.makeText(this, "Could not open Android market, please install the market app.", Toast.LENGTH_SHORT).show();
        }
    }}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.last, menu);
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

	/**
	 * A placeholder fragment containing a simple view.
	 * @return 
	 */
	public void goback(View v)
	{
		 Intent intent=new Intent(LastActivity.this,MainActivity.class);
	 		startActivity(intent);
	 		finish();
	}
	

}
