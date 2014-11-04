package com.example.rentalpropertyanalysis;

import java.text.DecimalFormat;

import android.support.v7.app.ActionBarActivity;
import android.app.ActionBar;
import android.app.ActionBar.OnNavigationListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class Summary extends ActionBarActivity implements OnNavigationListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_summary);
		setDisplay();
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
		Class<?> tmpClass = ActionBarListener.getDestination(position);
		if(tmpClass!=null&& tmpClass!=Summary.class){
			Intent intent = new Intent(this,ActionBarListener.getDestination(position));
			startActivity(intent);
			
	    	return true;
		}
		return false;

    }
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.summary, menu);
		
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
	
	public void setDisplay(){
		
		DecimalFormat df = new DecimalFormat("#.##");
		
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
    	purchasePrice.setText("Purchase Price: $"+df.format(DataStorage.PurchasePrice));
    	
    	TextView mortgageAmount =  (TextView)findViewById(R.id.mortgage_amount);
    	mortgageAmount.setText("Mortgage Amount: $"+df.format(DataStorage.getMortgageAmount()));
    	
    	TextView interestRate =  (TextView)findViewById(R.id.interest_rate);
    	interestRate.setText("Interest Rate: "+df.format(DataStorage.InterestRate)+"%");
    	
    	TextView termYears =  (TextView)findViewById(R.id.term_years);
    	termYears.setText("Term (Years): "+DataStorage.TermYears);
    	
    	TextView mortgagePayment =  (TextView)findViewById(R.id.mortgage_payment);
    	mortgagePayment.setText("Mortgage Payment: $"+df.format(DataStorage.getMortgagePayment()));
    	
    	//investment
    	TextView downpaymentAmount =  (TextView)findViewById(R.id.downpayment_amount);
    	downpaymentAmount.setText("Downpayment Amount: $"+df.format(DataStorage.DownPaymentAmount));
    	
    	TextView closingCosts =  (TextView)findViewById(R.id.closing_costs);
    	closingCosts.setText("Closing Costs: $"+df.format(DataStorage.ClosingCosts));
    	
    	TextView furnishingsEquipment =  (TextView)findViewById(R.id.fur_equip);
    	furnishingsEquipment.setText("Furnishings/Equipment: $"+df.format(DataStorage.FurAndEquip));
    	
    	TextView improvements =  (TextView)findViewById(R.id.improvements);
    	improvements.setText("Improvements: $"+df.format(DataStorage.Improvements));
    	
    	TextView totalInvested =  (TextView)findViewById(R.id.total_invested);
    	totalInvested.setText("Total Invested: $"+df.format(DataStorage.getTotalInvested()));
    	
    	//income
    	TextView monthlyRental =  (TextView)findViewById(R.id.monthly_rental);
    	monthlyRental.setText("Monthly Rental: $"+df.format(DataStorage.MonthlyRental));
    	
    	TextView onTimeDiscount =  (TextView)findViewById(R.id.on_time_discount);
    	onTimeDiscount.setText("On-Time Discount: $"+df.format(DataStorage.OnTimeDiscount));
    	
    	TextView vacancyAllowance =  (TextView)findViewById(R.id.vacancy_allowance);
    	vacancyAllowance.setText("Vacancy Allowance: "+df.format(DataStorage.VacancyAllowance)+"%");
    	
    	TextView otherIncome =  (TextView)findViewById(R.id.other_income);
    	otherIncome.setText("Other Income: $"+df.format(DataStorage.OtherIncomeMonthly));
    	
    	TextView annualRents =  (TextView)findViewById(R.id.annual_rents);
    	annualRents.setText("Annual Rents: $"+df.format(DataStorage.getAnnualRents()));
    	
    	TextView minusVacancyDiscounts =  (TextView)findViewById(R.id.minus_vacancy);
    	minusVacancyDiscounts.setText("Minus Vacancy & Discounts: $"+df.format(DataStorage.getMinusVacancyDiscounts()));
    	
    	TextView grossRentalIncome =  (TextView)findViewById(R.id.gross_rental_income);
    	grossRentalIncome.setText("Gross Rental Income: $"+df.format(DataStorage.getGrossRentalIncome()));
    	
    	
    	//expenses
    	TextView mortgagePaymentsAnnual =  (TextView)findViewById(R.id.mortgage_payments);
    	mortgagePaymentsAnnual.setText("Annual Mortgage Payments: $"+df.format(DataStorage.getMortgagePaymentsAnnual()));
    	
    	TextView realEstateTaxes =  (TextView)findViewById(R.id.real_estate_taxes);
    	realEstateTaxes.setText("Real Estate Taxes: $"+df.format(DataStorage.RealEstateTaxes));
    	
    	TextView hazardInsurance =  (TextView)findViewById(R.id.hazard_insurance);
    	hazardInsurance.setText("Hazard Insurance: $"+df.format(DataStorage.HazardInsurance));
    	
    	TextView repairMaintenance =  (TextView)findViewById(R.id.repair_maintenance);
    	repairMaintenance.setText("Repair/Maintenance: $"+df.format(DataStorage.RepairMaintenance));
    	
    	TextView annualUtilities =  (TextView)findViewById(R.id.annual_utilities);
    	annualUtilities.setText("Annual Utilities: $"+df.format(DataStorage.AnnualUtilities));
    	
    	TextView misc =  (TextView)findViewById(R.id.misc);
    	misc.setText("Miscellaneous: $"+df.format(DataStorage.Miscellaneous));
    	
    	TextView annualExpenses =  (TextView)findViewById(R.id.annual_expenses);
    	annualExpenses.setText("Annual Expenses: $"+df.format(DataStorage.getAnnualExpenses()));
    	
    	//Other Expenses
    	TextView annualCashFlow =  (TextView)findViewById(R.id.annual_cash_flow);
    	annualCashFlow.setText("Annual Cash Flow (Before Depreciation): $"+df.format(DataStorage.getAnnualCashFlow()));
    	
    	TextView adjustedMortgageLoan =  (TextView)findViewById(R.id.adjusted_mortgage_loan);
    	adjustedMortgageLoan.setText("Adjustment for Mortgage Loan Principal Payments: $"+df.format(DataStorage.getAdjustedMortgage()));
    	
    	TextView estimatedValueAfterImprovments =  (TextView)findViewById(R.id.estimated_value_after_improvements);
    	estimatedValueAfterImprovments.setText("Estimated Value after startup Improvements: $"+df.format(DataStorage.EstimatedValueAfterImprovements));
    	
    	TextView firstYearReturnOnInvestment =  (TextView)findViewById(R.id.first_year_return_on_investment);
    	firstYearReturnOnInvestment.setText("First Year Return on Investment: "+df.format(DataStorage.getFirstYearReturnOnInvest())+"%");
    	
    	TextView landValuePercent =  (TextView)findViewById(R.id.land_value_percent);
    	landValuePercent.setText("Land Value: (Percent of Purchase Price): "+df.format(DataStorage.LandValuePercent)+"%");
    	
    	TextView buildingDep =  (TextView)findViewById(R.id.building_depreciation);
    	buildingDep.setText("Building Depreciation (excludes Land Value): $"+df.format(DataStorage.getBuildingDepreciation()));
    	
    	TextView depreciationOfStartupImprovements =  (TextView)findViewById(R.id.depreciation_of_startup_improvements);
    	depreciationOfStartupImprovements.setText("Depreciation of Startup Improvements: $"+df.format(DataStorage.getDepreciationOfStartupImprovements()));
    	
    	TextView totalAnnualDepreciation =  (TextView)findViewById(R.id.total_depreciation);
    	totalAnnualDepreciation.setText("Total Annual Depreciation: $"+df.format(DataStorage.getTotalDepreciation()));
    	
    	TextView annualTaxableIncome =  (TextView)findViewById(R.id.annual_taxable_income);
    	annualTaxableIncome.setText("Annual Taxable Income (After Depreciation): $"+df.format(DataStorage.getAnnualTaxableIncome()));
    	
    	TextView appreciatedFutureValue =  (TextView)findViewById(R.id.appreciated_future_value);
    	appreciatedFutureValue.setText("Appreciated Future Value of Investment: $"+df.format(DataStorage.AppreciatedFutureValue));
    	
    	TextView numberOfYearsPropertyHeld =  (TextView)findViewById(R.id.number_years_property_held);
    	numberOfYearsPropertyHeld.setText("Number of Years Held: "+DataStorage.NumberYearsHeld);
    	
    	TextView origPurchasePrice =  (TextView)findViewById(R.id.original_purchase_price);
    	origPurchasePrice.setText("Original Purchase Price: $"+df.format(DataStorage.PurchasePrice));
    	
    	TextView initCashInvested =  (TextView)findViewById(R.id.initial_cash_invested);
    	initCashInvested.setText("Initial Cash Invested to Obtain Property: $"+df.format(DataStorage.getTotalInvested()));
    	
    	TextView incomeRealized =  (TextView)findViewById(R.id.income_realized_over_years);
    	incomeRealized.setText("Income Realized Over Years: $"+df.format(DataStorage.getIncomeRealized()));
    	
    	TextView debtReductionFromPrincipalPayments =  (TextView)findViewById(R.id.debt_reduction);
    	debtReductionFromPrincipalPayments.setText("Debt Reduction from Principal Payments: $"+df.format(DataStorage.getDebtReduction()));
    	
    	TextView capitalGainsTax =  (TextView)findViewById(R.id.capital_gains_tax);
    	capitalGainsTax.setText("Capital Gains Tax (Reduction): $"+df.format(DataStorage.getCapitalGainsTax()));
    	
    	TextView annualReturnOnInvestment =  (TextView)findViewById(R.id.annual_return_on_investment);
    	annualReturnOnInvestment.setText("Annual Return On Investment: $"+df.format(DataStorage.getAnnualReturnOnInvestment()));
    	
		
	}
}
