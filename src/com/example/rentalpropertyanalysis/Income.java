package com.example.rentalpropertyanalysis;

import android.support.v7.app.ActionBarActivity;
import android.app.ActionBar;
import android.app.ActionBar.OnNavigationListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;

public class Income extends ActionBarActivity implements OnNavigationListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_income);
		
		setUpActionBarSpinner();
	}
	
	public void setUpActionBarSpinner(){
    	final ActionBar actionBar = getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);
        ArrayAdapter<CharSequence> mSpinnerAdapter = ArrayAdapter.createFromResource(this,
                R.array.action_list, R.layout.actionbar_white_spinner);
         mSpinnerAdapter.setDropDownViewResource(R.layout.actionbar_white_spinner_dropdown);
         actionBar.setListNavigationCallbacks(mSpinnerAdapter, this);
    }
    
    @Override
    public boolean onNavigationItemSelected(int position, long id) {

		storeInput();
		Class<?> tmpClass = ActionBarListener.getDestination(position);
		if(tmpClass!=null&& tmpClass!=Income.class){
			Intent intent = new Intent(this,tmpClass);
			startActivity(intent);
	    	return true;
		}
		return false;
      // Our logic
    
    }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.income, menu);
		
		for (int i = 0; i < menu.size(); i++)
            menu.getItem(i).setVisible(false);
		
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
		storeInput();
    	
    	Intent intent = new Intent(this, Expenses.class);
    	
    	
    	startActivity(intent);
	}

	private void storeInput() {
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
	}
}
