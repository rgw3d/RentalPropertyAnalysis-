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

public class Expenses extends ActionBarActivity implements OnNavigationListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_expenses);
		
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
		if(tmpClass!=null&& tmpClass!=Expenses.class){
			Intent intent = new Intent(this,tmpClass);
			startActivity(intent);
			return true;
		}
		return false;
    
    }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.expenses, menu);
		
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
    	
		
		
    	Intent intent = new Intent(this, Summary.class);
    	
    	
    	startActivity(intent);
	}
	private void storeInput() {
		EditText editRealEstateTaxes = (EditText) findViewById(R.id.edit_real_estate_taxes);
    	EditText editHazardInsurance = (EditText) findViewById(R.id.edit_hazard_insurance);
    	EditText editRepairMaintenance = (EditText) findViewById(R.id.edit_repair_maintenance);
    	EditText editAnnualUtilities = (EditText) findViewById(R.id.edit_annual_utilities);
    	EditText editMisc = (EditText) findViewById(R.id.edit_misc);
    	
    	if(!editRealEstateTaxes.getText().toString().equals("")){//not equal nothing
    		DataStorage.RealEstateTaxes = Double.parseDouble(editRealEstateTaxes.getText().toString());
    	}
    	if(!editHazardInsurance.getText().toString().equals("")){//not equal nothing
    		DataStorage.HazardInsurance = Double.parseDouble(editHazardInsurance.getText().toString());
    	}
    	if(!editRepairMaintenance.getText().toString().equals("")){//not equal nothing
    		DataStorage.RepairMaintenance = Double.parseDouble(editRepairMaintenance.getText().toString());
    	}
    	if(!editAnnualUtilities.getText().toString().equals("")){//not equal nothing
    		DataStorage.AnnualUtilities = Double.parseDouble(editRepairMaintenance.getText().toString());
    	}
    	if(!editMisc.getText().toString().equals("")){//not equal nothing
    		DataStorage.Miscellaneous = Double.parseDouble(editRepairMaintenance.getText().toString());
    	}
	}
}
