package com.example.rentalpropertyanalysis;

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
	
	
	public static double getMortgageAmount(){
		return PurchasePrice - DownPaymentAmount;
	}
	
	public static double getMortgagePayment(){
		double v = (1+(InterestRate/12));
		double t = (-(TermYears/12)*12);
		double result=(getMortgageAmount()*(InterestRate/12))/(1-Math.pow(v,t));
		 
		return result;
	}
	
	public static double getTotalInvested(){
		return DownPaymentAmount+Improvements+ClosingCosts+FurAndEquip; 
	}
	
	public static double getAnnualRents(){
		return MonthlyRental*12;
	}

	public static double getMinusVacancyDiscounts() {
		return (OnTimeDiscount*12) +(VacancyAllowance*getAnnualRents());
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
	

}
