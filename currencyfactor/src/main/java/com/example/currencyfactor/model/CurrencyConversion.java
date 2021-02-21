package com.example.currencyfactor.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class CurrencyConversion {
	
	@Id
	@GeneratedValue
	private long id;
	private String countryCode;
	private Double conversionFactor;
	
	public CurrencyConversion() {

	}

	public CurrencyConversion(String countryCode, Double conversionFactor) {
		this.countryCode = countryCode;
		this.conversionFactor = conversionFactor;		
	}

	@Override
	public String toString() {
		return "CurrencyConversion [id=" + id + ", countryCode=" + countryCode + ", conversionFactor="
				+ conversionFactor + "]";
	}

}
