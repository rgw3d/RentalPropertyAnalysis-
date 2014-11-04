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


public class MainActivity extends ActionBarActivity implements OnNavigationListener {
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        
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
		if(tmpClass!=null && tmpClass!=MainActivity.class){
			Intent intent = new Intent(this,ActionBarListener.getDestination(position));
			startActivity(intent);
			
	    	return true;
		}
		return false;
    
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        
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
    
    public void sendMessage(View view){
    	
    	storeInput();
    	
    	Intent intent = new Intent(this, Financing.class);
    	
    	startActivity(intent);
    }

	private void storeInput() {
		EditText editStreet = (EditText) findViewById(R.id.edit_street);
    	EditText editCity = (EditText) findViewById(R.id.edit_city);
    	EditText editState = (EditText) findViewById(R.id.edit_state);
    	EditText editZip = (EditText) findViewById(R.id.edit_zip);
    	
    	if(!editStreet.getText().toString().equals("")){//not equal nothing
    		DataStorage.StreetAddress = editStreet.getText().toString();
    	}
    	if(!editCity.getText().toString().equals("")){//not equal nothing
    		DataStorage.City = editCity.getText().toString();
    	}
    	if(!editState.getText().toString().equals("")){//not equal nothing
    		DataStorage.State = editState.getText().toString();
    	}
    	if(!editZip.getText().toString().equals("")){//not equal nothing
    		DataStorage.Zip = editZip.getText().toString();
    	}
	}
}
