package com.example.rentalpropertyanalysis;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;


public class MainActivity extends ActionBarActivity {
	
	public final static String EXTRA_MESSAGE  ="com.example.rentalpropertyanalysis.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
    
    public void sendMessage(View view){
    	
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
    	
    	Intent intent = new Intent(this, Financing.class);
    	
    	
    	//intent.putExtra(EXTRA_MESSAGE, message);
    	
    	startActivity(intent);
    }
}
