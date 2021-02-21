package com.example.currencyfactor.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.currencyfactor.model.CurrencyConversion;

public interface CurrencyConversionFactorRepository extends JpaRepository<CurrencyConversion, Long>{

	CurrencyConversion findByCountryCode(String code);
}
