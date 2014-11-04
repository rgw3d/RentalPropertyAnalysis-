package com.example.rentalpropertyanalysis;

import android.util.Log;

public class ActionBarListener{
    
    public static Class<?> getDestination(int position) {

    	switch(position){
	    case 0:
			return null;
		case 1:
			return MainActivity.class;
		case 2:
			return Financing.class;
		case 3:
			return Investment.class;
		case 4:
			return Income.class;
		case 5:
			return Expenses.class;
		case 6:
			return OtherValues.class;
		case 7:
			return Summary.class;
		default:
			Log.e("Unacounted Position in Spinner",""+position);
			return MainActivity.class;
			
    	}
    	
    	
    
    }
}
