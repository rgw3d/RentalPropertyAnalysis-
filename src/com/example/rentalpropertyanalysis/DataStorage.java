package com.example.rentalpropertyanalysis;

import java.text.DecimalFormat;

public class DataStorage {
	//property location
	public static String StreetAddress = "305 Apache Trail";
	public static String City = "Miami Township";
	public static String State = "Ohio";
	public static String Zip = "45150";
	
	//Financing
	public static double PurchasePrice = 65000;
	public static double InterestRate = 8.25;
	public static double TermYears = 15;
	
	//Investment
	public static double DownPaymentAmount = 13000;
	public static double ClosingCosts = 1500;
	public static double FurAndEquip = 2500;
	public static double Improvements = 30000;
	
	//Income
	public static double MonthlyRental = 1000;
	public static double OnTimeDiscount = 0;
	public static double VacancyAllowance = 5.0;
	public static double OtherIncomeMonthly = 0;
	
	//Expenses
	public static double RealEstateTaxes = 1043;
	public static double HazardInsurance = 480;
	public static double RepairMaintenance = 900;
	public static double AnnualUtilities = 600;
	public static double Miscellaneous = 350;
	
	//Other Values
	public static double EstimatedValueAfterImprovements = 155000;
	public static double LandValuePercent = 20;
	public static double AppreciatedFutureValue = 175000;
	public static double NumberYearsHeld;
	
	
	
	
	public static double getMortgageAmount(){
		return PurchasePrice - DownPaymentAmount;
	}
	
	public static double getMortgagePayment(){//this is wrong
		//return (getMortgageAmount()*(InterestRate/12))/Math.pow((1-(1+(InterestRate/12))),-(12*TermYears));
		///P = L[c(1 + c)n]/[(1 + c)n - 1]
		/*
		L = Loan amount
				F = Points and all other lender fees
				P = Monthly payment
				n = Month when the balance is paid in full
				Bn = Balance in month n
		*/
		
		double monthlyRate = InterestRate/100/12;
		double termInMonths = TermYears*12;
		
		double monthlyPayment = 
	            (getMortgageAmount()*monthlyRate) / 
	               (1-Math.pow(1+monthlyRate, -termInMonths));
		
		return monthlyPayment;
	}
	
	public static double getTotalInvested(){
		return DownPaymentAmount+Improvements+ClosingCosts+FurAndEquip; 
	}
	
	public static double getAnnualRents(){
		return MonthlyRental*12;
	}

	public static double getMinusVacancyDiscounts() {
		return -((OnTimeDiscount*12) +(VacancyAllowance/100*getAnnualRents()));
	}

	public static double getGrossRentalIncome() {
		return getAnnualRents()+getMinusVacancyDiscounts()+(OtherIncomeMonthly*12);
	}

	public static double getMortgagePaymentsAnnual() {
		return getMortgagePayment()*12;
	}

	public static double getAnnualExpenses() {
		return getMortgagePaymentsAnnual()+RealEstateTaxes+HazardInsurance+RepairMaintenance+AnnualUtilities+Miscellaneous;
	}
	
	public static double getAnnualCashFlow(){
		return getGrossRentalIncome() - getAnnualExpenses();
	}

	public static double getAdjustedMortgage() {
		double rate = InterestRate/12;
		double paymentPeriods = TermYears*12;
		double amount = getMortgageAmount();
		double start = 1;
		double end = 12;
		double type = 1;
		
		return 1;
	}
	
	public static double getFirstYearReturnOnInvest(){
		return (EstimatedValueAfterImprovements - PurchasePrice + getAdjustedMortgage() + getAnnualCashFlow())/getTotalInvested();
	}

	public static double getBuildingDepreciation() {
		return PurchasePrice*(1-LandValuePercent/100)/27.5;
	}

	public static double getDepreciationOfStartupImprovements() {
		return FurAndEquip/5;
	}

	public static double getTotalDepreciation() {
		return getBuildingDepreciation()+getDepreciationOfStartupImprovements();
	}

	public static double getAnnualTaxableIncome() {
		return getAnnualCashFlow()-getTotalDepreciation();
	}

	public static double getIncomeRealized() {
		return (getAnnualCashFlow()*NumberYearsHeld) + (getAnnualCashFlow()*.05*(NumberYearsHeld-1));
	}

	public static double getDebtReduction() {
		// TODO Auto-generated method stub
		return 6000;
	}

	public static double getCapitalGainsTax() {
		
		return .2*(AppreciatedFutureValue-(PurchasePrice+Improvements));
		
	}

	public static double getAnnualReturnOnInvestment() {
		return (AppreciatedFutureValue - PurchasePrice + getIncomeRealized() + getDebtReduction() - getCapitalGainsTax())/getTotalInvested()/NumberYearsHeld;
	}
	
	

}
