package models.entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Installments {
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private Double amount;
	private Date dueDate;

	public Installments() {
	}

	public Installments(Double amount, Date dueDate) {
		this.amount = amount;
		this.dueDate = dueDate;
	}

	public Double getAmount() {
		return amount;
	}

	public Date getDueDate() {
		return dueDate;
	}
	
	
	// retorna uma String com a  data formatada e o valor das parcelas formatado
	public String toString() {
		return sdf.format(dueDate)+": "+String.format("%.2f", amount);
	}

}
