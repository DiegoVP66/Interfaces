package models.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Contract {
	private Integer contractNumber;
	private Date contractDate;
	private Double totalValue;
    
	// Nova arrayList do tipo Installments para adicionar e remover os contratos
	private List<Installments> installments = new ArrayList<>();

	public Contract() {
	}

	public Contract(Integer contractNumber, Date contractDate, Double totalValue) {
		this.contractNumber = contractNumber;
		this.contractDate = contractDate;
		this.totalValue = totalValue;
	}

	public Integer getContractNumber() {
		return contractNumber;
	}

	public Date getContractDate() {
		return contractDate;
	}

	public Double getTotalValue() {
		return totalValue;
	}
	
	public List<Installments> getInstallments() {
		return installments;
	}
	
    // Método para adicionar as parcelas na lista
	public void addInstallment(Installments installment) {
		installments.add(installment);

	}
    // Método para remover as parcelas da lista
	public void removeInstallment(Installments installment) {
		installments.remove(installment);
	}

}
