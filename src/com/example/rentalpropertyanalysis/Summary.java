package com.example.rentalpropertyanalysis;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class Summary extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_summary);
		setDisplay();
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.summary, menu);
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
	
	public void setDisplay(){
		//location
    	TextView streetName =  (TextView)findViewById(R.id.street_name);
    	streetName.setText("Street Address: "+DataStorage.StreetAddress);
    	
    	TextView cityName =  (TextView)findViewById(R.id.city_name);
    	cityName.setText("City: "+DataStorage.City);
    	
    	TextView stateName =  (TextView)findViewById(R.id.state_name);
    	stateName.setText("State: "+DataStorage.State);
    	
    	TextView zipCode =  (TextView)findViewById(R.id.zip_code);
    	zipCode.setText("Zip Code: "+DataStorage.Zip);
		
		//financing
		TextView purchasePrice =  (TextView)findViewById(R.id.purchase_price);
    	purchasePrice.setText("Purchase Price: $"+DataStorage.PurchasePrice);
    	
    	TextView mortgageAmount =  (TextView)findViewById(R.id.mortgage_amount);
    	mortgageAmount.setText("Mortgage Amount: $"+DataStorage.getMortgageAmount());
    	
    	TextView interestRate =  (TextView)findViewById(R.id.interest_rate);
    	interestRate.setText("Interest Rate: "+DataStorage.InterestRate+"%");
    	
    	TextView termYears =  (TextView)findViewById(R.id.term_years);
    	termYears.setText("Term (Years): "+DataStorage.TermYears);
    	
    	TextView mortgagePayment =  (TextView)findViewById(R.id.mortgage_payment);
    	mortgagePayment.setText("Mortgage Payment: $"+DataStorage.getMortgagePayment());
    	
    	//investment
    	TextView downpaymentAmount =  (TextView)findViewById(R.id.downpayment_amount);
    	downpaymentAmount.setText("Downpayment Amount: $"+DataStorage.DownPaymentAmount);
    	
    	TextView closingCosts =  (TextView)findViewById(R.id.closing_costs);
    	closingCosts.setText("Closing Costs: $"+DataStorage.ClosingCosts);
    	
    	TextView furnishingsEquipment =  (TextView)findViewById(R.id.fur_equip);
    	furnishingsEquipment.setText("Furnishings/Equipment: $"+DataStorage.FurAndEquip);
    	
    	TextView improvements =  (TextView)findViewById(R.id.improvements);
    	improvements.setText("Improvements: "+DataStorage.TermYears);
    	
    	TextView totalInvested =  (TextView)findViewById(R.id.total_invested);
    	totalInvested.setText("Total Invested: $"+DataStorage.getTotalInvested());
    	
    	//income
    	TextView monthlyRental =  (TextView)findViewById(R.id.monthly_rental);
    	monthlyRental.setText("Monthly Rental: $"+DataStorage.MonthlyRental);
    	
    	TextView onTimeDiscount =  (TextView)findViewById(R.id.on_time_discount);
    	onTimeDiscount.setText("On-Time Discount: $"+DataStorage.OnTimeDiscount);
    	
    	TextView vacancyAllowance =  (TextView)findViewById(R.id.vacancy_allowance);
    	vacancyAllowance.setText("Vacancy Allowance: "+DataStorage.VacancyAllowance+"%");
    	
    	TextView otherIncome =  (TextView)findViewById(R.id.other_income);
    	otherIncome.setText("Other Income: $"+DataStorage.OtherIncomeMonthly);
    	
    	TextView annualRents =  (TextView)findViewById(R.id.annual_rents);
    	annualRents.setText("Annual Rents: $"+DataStorage.getAnnualRents());
    	
    	TextView minusVacancyDiscounts =  (TextView)findViewById(R.id.minus_vacancy);
    	minusVacancyDiscounts.setText("Minus Vacancy & Discounts: $"+DataStorage.getMinusVacancyDiscounts());
    	
    	TextView grossRentalIncome =  (TextView)findViewById(R.id.gross_rental_income);
    	grossRentalIncome.setText("Gross Rental Income: $"+DataStorage.getGrossRentalIncome());
    	
    	
    	//expenses
    	TextView mortgagePaymentsAnnual =  (TextView)findViewById(R.id.mortgage_payments);
    	mortgagePaymentsAnnual.setText("Annual Mortgage Payments: $"+DataStorage.getMortgagePaymentsAnnual());
    	
    	TextView realEstateTaxes =  (TextView)findViewById(R.id.real_estate_taxes);
    	realEstateTaxes.setText("Real Estate Taxes: $"+DataStorage.RealEstateTaxes);
    	
    	TextView hazardInsurance =  (TextView)findViewById(R.id.hazard_insurance);
    	hazardInsurance.setText("Hazard Insurance: "+DataStorage.HazardInsurance);
    	
    	TextView repairMaintenance =  (TextView)findViewById(R.id.repair_maintenance);
    	repairMaintenance.setText("Repair/Maintenance: $"+DataStorage.RepairMaintenance);
    	
    	TextView annualUtilities =  (TextView)findViewById(R.id.annual_utilities);
    	annualUtilities.setText("Annual Utilities: $"+DataStorage.AnnualUtilities);
    	
    	TextView misc =  (TextView)findViewById(R.id.misc);
    	misc.setText("Miscellaneous: $"+DataStorage.Miscellaneous);
    	
    	TextView annualExpenses =  (TextView)findViewById(R.id.annual_expenses);
    	annualExpenses.setText("Annual Expenses: $"+DataStorage.getAnnualExpenses());
    	
		
	}
}
