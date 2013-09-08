package com.example.mdd2013;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ListView;
public class Search_Result extends Activity {

	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		double cheapest,buff ;
		//double price[3];
		double[] pricearray = new double[3];
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_search__result);
		// Show the Up button in the action bar.
		setupActionBar();
		
		 Bundle extras = getIntent().getExtras();
		 String category = (String) extras.get("cursor");
		 TextView text1 = (TextView) findViewById(R.id.textView1);
		 text1.setText(category);
		 
		 String category1 = (String) extras.get("cursor1");
		 TextView text2 = (TextView) findViewById(R.id.textView2);
		 text2.setText(category1);
		 
		 String category2 = (String) extras.get("cursor2");
		 TextView text3 = (TextView) findViewById(R.id.textView3);
		 text3.setText(category2);
		 
		 String category3 = (String) extras.get("cursor3");
		 TextView text4 = (TextView) findViewById(R.id.textView4);
		 text4.setText(category3);
		 
		 
		 pricearray[0]=Double.valueOf(category1).doubleValue();
	     pricearray[1]=Double.valueOf(category2).doubleValue();
	     pricearray[2]=Double.valueOf(category3).doubleValue();
	     buff=pricearray[0];
		 for(int i=0;i<3;i++)
		 {
			// buff=pricearray[i];
			 if(pricearray[i]<buff)
			 {
				 buff=pricearray[i];
			 }
		 }
		 cheapest=buff;
		 String c_price= Double.toString(cheapest);
		 //TextView text5 = (TextView) findViewById(R.id.textView6);
		 
		 if(buff==pricearray[0])
		 {
			 TextView text5 = (TextView) findViewById(R.id.textView6);
			 text5.setText("RM"+c_price+ " from "+ "Tesco");
		 }else 
			 if(buff==pricearray[1])
			 {
				 TextView text5 = (TextView) findViewById(R.id.textView6);
				 text5.setText("RM"+c_price+ " from "+ "Jusco");
			 }else
			 {
				 TextView text5 = (TextView) findViewById(R.id.textView6);
				 text5.setText("RM"+c_price+ " from "+ "Giant");
			 }
	}

	/**
	 * Set up the {@link android.app.ActionBar}, if the API is available.
	 */
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	private void setupActionBar() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			getActionBar().setDisplayHomeAsUpEnabled(true);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.search__result, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
