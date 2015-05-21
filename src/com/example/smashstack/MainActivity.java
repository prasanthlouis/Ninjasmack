package com.example.smashstack;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

	private float x1,x2,y1,y2;
	RelativeLayout root;
	int count=0;
	
	static final int MIN_DISTANCE = 150;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.org);
		final Handler handler = new Handler();
		 handler.postDelayed(new Runnable() {
		     @Override
		     public void run() {
		         // Do something after 5s = 5000ms
		    	 Intent intent=new Intent(MainActivity.this,FirstAct.class);
		 		startActivity(intent);
		    	 Toast.makeText(getApplicationContext(), count+"", Toast.LENGTH_LONG).show();
		     }
		 }, 5000);
		
		

	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
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
	 */
	

		
	@Override
	 public boolean onTouchEvent(MotionEvent event)
	 {  
		  
	     switch(event.getAction())
	     {
	       case MotionEvent.ACTION_DOWN:
	           x1 = event.getX();  
	           y1 = event.getY();
	       break;         
	       case MotionEvent.ACTION_UP:
	           x2 = event.getX();
	           y2= event.getY();
	           if(Math.abs(x2-x1)>Math.abs(y2-y1))
	           {
	           if(x2>x1)
	           {
	        	   float deltaX = x2 - x1;
	        	   if (Math.abs(deltaX) > MIN_DISTANCE)
	        	   {
	        		//   Toast.makeText(this, "left2right swipe", Toast.LENGTH_SHORT).show ();
	        		   root=(RelativeLayout)findViewById(R.id.root);
	        			 root.setBackgroundResource(R.drawable.hor);
	        			 count++;
	        			 final Handler handler = new Handler();
	        			 handler.postDelayed(new Runnable() {
	        			     @Override
	        			     public void run() {
	        			         // Do something after 5s = 5000ms
	        			         root.setBackgroundResource(R.drawable.org);
	        			     }
	        			 }, 200);
	        	   }
	        	   else
	        	   {
	               // consider as something else - a screen tap for example
	        	   }
	           }
	           else
	           {
	        	   float deltaX = x2 - x1;
	        	   if (Math.abs(deltaX) > MIN_DISTANCE)
	        	   {
	      //  		   Toast.makeText(this, "right2left swipe", Toast.LENGTH_SHORT).show ();
	        		   root=(RelativeLayout)findViewById(R.id.root);
	        			 root.setBackgroundResource(R.drawable.hor);
	        			 count++;
	        			 final Handler handler = new Handler();
	        			 
	        			 handler.postDelayed(new Runnable() {
	        			     @Override
	        			     public void run() {
	        			         // Do something after 5s = 5000ms
	        			         root.setBackgroundResource(R.drawable.org);
	        			     }
	        			 }, 200);
	        
	        	   }
	        	   else
	        	   {
	               // consider as something else - a screen tap for example
	        	   }
	        	   
	           }
	           }
	           else
	           {
	        	      if(y2>y1)
	   	           {
	   	        	   float deltaX = y2 - y1;
	   	        	   if (Math.abs(deltaX) > MIN_DISTANCE)
	   	        	   {
	   	        	//	   Toast.makeText(this, "up2down swipe", Toast.LENGTH_SHORT).show ();
	   	        		   root=(RelativeLayout)findViewById(R.id.root);
	   	        			 root.setBackgroundResource(R.drawable.ver);
	   	        			 count++;
	   	        			 final Handler handler = new Handler();
	   	        			 handler.postDelayed(new Runnable() {
	   	        			     @Override
	   	        			     public void run() {
	   	        			         // Do something after 5s = 5000ms
	   	        			         root.setBackgroundResource(R.drawable.org);
	   	        			     }
	   	        			 }, 200);
	   	        	   }
	   	        	   else
	   	        	   {
	   	               // consider as something else - a screen tap for example
	   	        	   }
	   	           }
	   	           else
	   	           {
	   	        	   float deltaX = y2 - y1;
	   	        	   if (Math.abs(deltaX) > MIN_DISTANCE)
	   	        	   {
	   	        //		   Toast.makeText(this, "down2up swipe", Toast.LENGTH_SHORT).show ();
	   	        		   root=(RelativeLayout)findViewById(R.id.root);
	   	        			 root.setBackgroundResource(R.drawable.ver);
	   	        			 count++;
	   	        			 final Handler handler = new Handler();
	   	        			 handler.postDelayed(new Runnable() {
	   	        			     @Override
	   	        			     public void run() {
	   	        			         // Do something after 5s = 5000ms
	   	        			         root.setBackgroundResource(R.drawable.org);
	   	        			     }
	   	        			 }, 200);
	   	        
	   	        	   }
	   	        	   else
	   	        	   {
	   	               // consider as something else - a screen tap for example
	   	        	   }
	   	        	   
	   	           }
	        	   
	           }
	       break;   
	     }           
	     return super.onTouchEvent(event);       
	 }
	

}
