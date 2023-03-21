package com.rms.dto;

public class RecordDTO {
	
	private String id;
	private Integer number;
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public Integer getNumber() {
		return number;
	}
	
	public void setNumber(Integer number) {
		this.number = number;
	}
	
	public RecordDTO() { }
	
	public RecordDTO(String id, Integer number) { 
		this.id = id;
		this.number = number;
	}

	@Override
	public String toString() {
		return "RecordDTO [id=" + id + ", number=" + number + "]";
	}
	
}
