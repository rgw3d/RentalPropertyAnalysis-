package com.example.rentalpropertyanalysis;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class Financing extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_financing);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.financing, menu);
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
	
	public  void sendMessage(View view){
		EditText editPurchasePrice = (EditText) findViewById(R.id.edit_purchase_price);
    	EditText editInterestRate = (EditText) findViewById(R.id.edit_interest_rate);
    	EditText editTermYears = (EditText) findViewById(R.id.edit_term_years);
    	
    	if(!editPurchasePrice.getText().toString().equals("")){//not equal nothing
    		DataStorage.PurchasePrice = Double.parseDouble(editPurchasePrice.getText().toString());
    	}
    	if(!editInterestRate.getText().toString().equals("")){//not equal nothing
    		DataStorage.InterestRate = Double.parseDouble(editInterestRate.getText().toString());
    	}
    	if(!editTermYears.getText().toString().equals("")){//not equal nothing
    		DataStorage.TermYears = Double.parseDouble(editTermYears.getText().toString());
    	}
    	
    	Intent intent = new Intent(this, Investment.class);
    	
    	
    	startActivity(intent);
	}
	
}
