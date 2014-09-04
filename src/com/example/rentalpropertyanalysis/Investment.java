package com.example.rentalpropertyanalysis;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class Investment extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_investment);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.investment, menu);
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
		EditText editDownpaymentAmount = (EditText) findViewById(R.id.edit_downpayment_amount);
    	EditText editClosingCosts = (EditText) findViewById(R.id.edit_closing_costs);
    	EditText editFurnishingsEquipment = (EditText) findViewById(R.id.edit_furnishings_equipment);
    	EditText editImprovements = (EditText) findViewById(R.id.edit_improvements);
    	
    	if(!editDownpaymentAmount.getText().toString().equals("")){//not equal nothing
    		DataStorage.DownPaymentAmount = Double.parseDouble(editDownpaymentAmount.getText().toString());
    	}
    	if(!editClosingCosts.getText().toString().equals("")){//not equal nothing
    		DataStorage.ClosingCosts = Double.parseDouble(editClosingCosts.getText().toString());
    	}
    	if(!editFurnishingsEquipment.getText().toString().equals("")){//not equal nothing
    		DataStorage.FurAndEquip = Double.parseDouble(editFurnishingsEquipment.getText().toString());
    	}
    	if(!editImprovements.getText().toString().equals("")){//not equal nothing
    		DataStorage.Improvements = Double.parseDouble(editFurnishingsEquipment.getText().toString());
    	}
    	
    	Intent intent = new Intent(this, Income.class);
    	
    	
    	startActivity(intent);
	}
}
