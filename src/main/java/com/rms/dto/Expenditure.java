package com.rms.dto;

public class Expenditure {
	
	private String allExpenditures;
	private Double total;
	
	public String getAllExpenditures() {
		return allExpenditures;
	}
	
	public void setAllExpenditures(String allExpenditures) {
		this.allExpenditures = allExpenditures;
	}
	
	public Double getTotal() {
		return total;
	}
	
	public void setTotal(Double total) {
		this.total = total;
	}

	public Expenditure() { }
	
	public Expenditure(String allExpenditures) { 
		this.allExpenditures = allExpenditures;
	}
	
	public Expenditure(Double total) { 
		this.total = total;
	}
	
	public Expenditure(String allExpenditures, Double total) { 
		this.allExpenditures = allExpenditures;
		this.total = total;
	}
	
	@Override
	public String toString() {
		return "Expenditure [allExpenditures=" + allExpenditures + ", total=" + total + "]";
	}
}
