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
	
	
	// Método para calcular o valor total dividido pelo total de mêses, aplicando juros
	public void processContract(Contract contract, int months) {
		
		// Pega o valor inicial e divide pelo total de meses
		double initialValue = contract.getTotalValue() / months;
		
		for(int i = 1; i <= months; i++) {
			// Para cada mês chama o método addMonths recebendo a data do contrato número "i"
			Date date = addMonths(contract.getContractDate(), i);
			
			// Atribui a finalValue o valor inicial + o nétodo monthTax, recebendo o valor inicial das parcelas "i"
			double finalValue = initialValue + tax.monthTax(initialValue, i);
			
			// Chama o método addInstallment, instanciando um novo Installment recebendo o valor final e a data
			contract.addInstallment(new Installments(finalValue,date));
		}
	}
	// Método addMonths recebendo uma data e um número inteiro como padrão
	private Date addMonths(Date date, int n) {
		
		// Instanciando um novo calendário 
		Calendar cal = Calendar.getInstance();
		
		// Informando a data
		cal.setTime(date);
		
		// Adicionando a cada mes do calendário um valor n 
		cal.add(Calendar.MONTH, n);
		
		// Retorna o valor em Milleseconds
		return cal.getTime();
	}
	
	

}
