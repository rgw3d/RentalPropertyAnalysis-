package com.example.rentalpropertyanalysis;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class Income extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_income);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.income, menu);
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
		EditText editMonthlyRental = (EditText) findViewById(R.id.edit_monthy_rental);
    	EditText editOnTimeDiscount = (EditText) findViewById(R.id.edit_on_time_discount);
    	EditText editVacancyAllowance = (EditText) findViewById(R.id.edit_vacancy_allowance);
    	EditText editOtherIncome = (EditText) findViewById(R.id.edit_other_income);
    	
    	if(!editMonthlyRental.getText().toString().equals("")){//not equal nothing
    		DataStorage.MonthlyRental = Double.parseDouble(editMonthlyRental.getText().toString());
    	}
    	if(!editOnTimeDiscount.getText().toString().equals("")){//not equal nothing
    		DataStorage.OnTimeDiscount = Double.parseDouble(editOnTimeDiscount.getText().toString());
    	}
    	if(!editVacancyAllowance.getText().toString().equals("")){//not equal nothing
    		DataStorage.VacancyAllowance = Double.parseDouble(editVacancyAllowance.getText().toString());
    	}
    	if(!editOtherIncome.getText().toString().equals("")){//not equal nothing
    		DataStorage.OtherIncomeMonthly = Double.parseDouble(editVacancyAllowance.getText().toString());
    	}
    	
    	Intent intent = new Intent(this, Expenses.class);
    	
    	
    	startActivity(intent);
	}
}
