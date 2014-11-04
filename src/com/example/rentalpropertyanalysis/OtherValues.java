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

public class OtherValues extends ActionBarActivity implements OnNavigationListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_other_values);
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
		if(tmpClass!=null&& tmpClass!=OtherValues.class){
			Intent intent = new Intent(this,tmpClass);
			startActivity(intent);
	    	return true;
		}
		return false;
    
    }
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.other_values, menu);
		
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
		
		EditText editEstimatedValues = (EditText) findViewById(R.id.edit_estimated_values);
    	EditText editLandValue = (EditText) findViewById(R.id.edit_land_value);
    	EditText editAppreciatedFutureValue = (EditText) findViewById(R.id.edit_appreciated_future_value);
    	EditText editNumberYearsHeld = (EditText) findViewById(R.id.edit_number_years_held);
    	
    	if(!editEstimatedValues.getText().toString().equals("")){//not equal nothing
    		DataStorage.EstimatedValueAfterImprovements = Double.parseDouble(editEstimatedValues.getText().toString());
    	}
    	if(!editLandValue.getText().toString().equals("")){//not equal nothing
    		DataStorage.LandValuePercent = Double.parseDouble(editLandValue.getText().toString());
    	}
    	if(!editAppreciatedFutureValue.getText().toString().equals("")){//not equal nothing
    		DataStorage.AppreciatedFutureValue = Double.parseDouble(editAppreciatedFutureValue.getText().toString());
    	}
    	if(!editNumberYearsHeld.getText().toString().equals("")){//not equal nothing
    		DataStorage.NumberYearsHeld = Double.parseDouble(editNumberYearsHeld.getText().toString());
    	}
		
	}
}
