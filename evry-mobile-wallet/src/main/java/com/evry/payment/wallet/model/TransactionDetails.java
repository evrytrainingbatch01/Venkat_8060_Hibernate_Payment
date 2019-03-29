package com.evry.payment.wallet.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "transaction")
@PrimaryKeyJoinColumn(name="id")
public class TransactionDetails {
	@Id
	private int id;
	private int process_amount;
	private int transferto;
	private int transfer_amount;
	private int loan_request;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getProcess_amount() {
		return process_amount;
	}

	public void setProcess_amount(int process_amount) {
		this.process_amount = process_amount;
	}

	public int getTransferto() {
		return transferto;
	}

	public void setTransferto(int transferto) {
		this.transferto = transferto;
	}

	public int getTransfer_amount() {
		return transfer_amount;
	}

	public void setTransfer_amount(int transfer_amount) {
		this.transfer_amount = transfer_amount;
	}

	public int getLoan_request() {
		return loan_request;
	}

	public void setLoan_request(int loan_request) {
		this.loan_request = loan_request;
	}

}
