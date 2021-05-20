package models.services;

import java.util.Calendar;
import java.util.Date;

import models.entities.Contract;
import models.entities.Installments;

public class OnlineTax {
	
	
	private TaxService tax;
	
	
	public OnlineTax(TaxService tax) {
		this.tax = tax;
	}
	
	
	// M�todo para calcular o valor total dividido pelo total de m�ses, aplicando juros
	public void processContract(Contract contract, int months) {
		
		// Pega o valor inicial e divide pelo total de meses
		double initialValue = contract.getTotalValue() / months;
		
		for(int i = 1; i <= months; i++) {
			// Para cada m�s chama o m�todo addMonths recebendo a data do contrato n�mero "i"
			Date date = addMonths(contract.getContractDate(), i);
			
			// Atribui a finalValue o valor inicial + o n�todo monthTax, recebendo o valor inicial das parcelas "i"
			double finalValue = initialValue + tax.monthTax(initialValue, i);
			
			// Chama o m�todo addInstallment, instanciando um novo Installment recebendo o valor final e a data
			contract.addInstallment(new Installments(finalValue,date));
		}
	}
	// M�todo addMonths recebendo uma data e um n�mero inteiro como padr�o
	private Date addMonths(Date date, int n) {
		
		// Instanciando um novo calend�rio 
		Calendar cal = Calendar.getInstance();
		
		// Informando a data
		cal.setTime(date);
		
		// Adicionando a cada mes do calend�rio um valor n 
		cal.add(Calendar.MONTH, n);
		
		// Retorna o valor em Milleseconds
		return cal.getTime();
	}
	
	

}
