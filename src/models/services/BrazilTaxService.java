package models.services;

public class BrazilTaxService implements TaxService{
    
	//Sobrescrevendo o método da interface TaxService
	@Override
	public double monthTax(double amount, int month) {
		
		return amount * 0.01 * month;
	}

}
