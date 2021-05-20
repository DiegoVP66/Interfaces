package models.entities;

import java.util.Date;

public class Installments {
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

}
