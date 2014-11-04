package com.example.rentalpropertyanalysis;

import android.app.ActionBar;
import android.app.ActionBar.OnNavigationListener;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;

public class Financing extends ActionBarActivity implements OnNavigationListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_financing);
		
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
		if(tmpClass!=null&& tmpClass!=Financing.class){
			Intent intent = new Intent(this,tmpClass);
			startActivity(intent);
			return true;
		}
		return false;
    
    }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.financing, menu);
		
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
    	
    	Intent intent = new Intent(this, Investment.class);
    	
    	
    	startActivity(intent);
	}

	private void storeInput() {
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
	}
	
}
