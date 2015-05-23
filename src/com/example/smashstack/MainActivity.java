package com.example.smashstack;

import java.util.Random;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.psiuol21.smashstack.R;

public class MainActivity extends ActionBarActivity {

	private float x1,x2,y1,y2;
	RelativeLayout root;
	int count=0;
	int cuts[]=new int[] {0,0,0,0};
	ImageView down,up,left,right;
	MediaPlayer mediaPlayer;
	
	static final int MIN_DISTANCE = 150;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		 getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
		    getActionBar().hide();
		setContentView(R.layout.org);
		mediaPlayer = MediaPlayer.create(this, R.raw.music);
		mediaPlayer.start();
		
		down=(ImageView)findViewById(R.id.down);
		up=(ImageView)findViewById(R.id.up);
		left=(ImageView)findViewById(R.id.left);
		right=(ImageView)findViewById(R.id.right);
		Thread thread = new Thread() {
		    @Override
		    public void run() {
		        try {
		        	
		            while(true) {
		            	 Random rand = new Random();
		            	 int randomNum = rand.nextInt((4-0));    
		            	 while(cuts[0]==1 || cuts[1]==1 || cuts[2]==1 || cuts[3]==1);
		           if(cuts[0]==0 && cuts[1]==0 && cuts[2]==0 && cuts[3]==0)
		           {
		        	   cuts[randomNum]=1;
		        	   System.out.println(randomNum+"");
		           }
		           runOnUiThread(new Runnable() {
					     @Override
					     public void run() {
					    	  if(cuts[0]==1)
					    			 right.setVisibility(View.VISIBLE);
					    			  else if(cuts[1]==1)
					    				  left.setVisibility(View.VISIBLE);
					    			  else if(cuts[2]==1)
					    				  down.setVisibility(View.VISIBLE);
					    			  else if(cuts[3]==1)
					    				  up.setVisibility(View.VISIBLE);

					//stuff that updates ui

					    }
					});
		
		            }
		        } catch (Exception e) {
		            e.printStackTrace();
		        }
		      
		    }
		};
		 thread.start();
		
		
		 

		
		final Handler handler = new Handler();
		 handler.postDelayed(new Runnable() {
		     @Override
		     public void run() {
		         // Do something after 5s = 5000ms
		    	 mediaPlayer.release();
		    	 mediaPlayer=null;
		    	 Intent intent=new Intent(MainActivity.this,LastActivity.class);
		    	
		    	 intent.putExtra("score", count);
		 		startActivity(intent);
		 		finish();
		    //	 Toast.makeText(getApplicationContext(), count+"", Toast.LENGTH_LONG).show();
		     }
		 }, 10000);
		 
		
		
		

	
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
	        	   if(cuts[0]==1)
	        	   {
	        		  
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
	        			
	        			 right.setVisibility(View.INVISIBLE);
	        			 cuts[0]=0;
	        	   }
	        	   else
	        	   {
	               // consider as something else - a screen tap for example
	        	   }
	        	   }
	           }
	           else
	           {
	        	   float deltaX = x2 - x1;
	        	   if(cuts[1]==1)
	        	   {
	        		  
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
	        
	        left.setVisibility(View.INVISIBLE);
	        cuts[1]=0;
	        	   }
	        	   else
	        	   {
	               // consider as something else - a screen tap for example
	        	   }
	        	   } 
	           }
	           }
	           else
	           {
	        	      if(y2>y1)
	   	           {
	        	    	  if(cuts[2]==1)
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
	   	        			 down.setVisibility(View.INVISIBLE);
	   	        			 cuts[2]=0;
	   	        	   }
	   	        	   else
	   	        	   {
	   	               // consider as something else - a screen tap for example
	   	        	   }
	   	        	   }
	   	           }
	   	           else
	   	           {
	   	        	   float deltaX = y2 - y1;
	   	        	  if(cuts[3]==1)
	   	        	   {
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
	   	        			 up.setVisibility(View.INVISIBLE);
	   	        			 cuts[3]=0;
	   	        
	   	        	   }
	   	        	   else
	   	        	   {
	   	               // consider as something else - a screen tap for example
	   	        	   }
	   	        	   }
	   	        	   
	   	           }
	        	   
	           }
	       break;   
	     }           
	     return super.onTouchEvent(event);       
	 }
	

}
