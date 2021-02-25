package com.example.currencyfactor.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.currencyfactor.model.CurrencyConversion;
import com.example.currencyfactor.repository.CurrencyConversionFactorRepository;

@RestController
@RequestMapping("/currecyconversionfactor")
public class CurrencyConversionFactorController {
	
	Logger log = LoggerFactory.getLogger(CurrencyConversionFactorController.class);
	
	@Autowired
	private CurrencyConversionFactorRepository currecyFactoryRepository;
	
	
	@PostMapping("/create")
	public ResponseEntity<CurrencyConversion> addConversionFactor(@RequestBody CurrencyConversion currencyConversion) {
		log.info("Entered CurrencyConversioFactorController :: addConversionFactor",currencyConversion);
	    try {
	    	
	      CurrencyConversion currencyCreation = currecyFactoryRepository.save(
	    		  new CurrencyConversion(currencyConversion.getCountryCode(), currencyConversion.getConversionFactor()));
	      log.info("Ended CurrencyConversioFactorController :: addConversionFactor");
	      return new ResponseEntity<>(HttpStatus.OK);
	    } catch (Exception e) {
	      log.info("Ended CurrencyConversioFactorController :: addConversionFactor");	
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<CurrencyConversion> updateConversionFactor(@PathVariable("id") long id, @RequestBody CurrencyConversion currencyConversion) {
		log.info("Entered CurrencyConversioFactorController :: updateConversionFactor",id);
		Optional<CurrencyConversion> currencyConversionData = currecyFactoryRepository.findById(id);
         
	    if (currencyConversionData.isPresent()) {
	    	CurrencyConversion existingcurrencyData = currencyConversionData.get();
	    	existingcurrencyData.setCountryCode(currencyConversion.getCountryCode());
	    	existingcurrencyData.setConversionFactor(currencyConversion.getConversionFactor());
	    	log.info("Ended CurrencyConversioFactorController :: updateConversionFactor");
	    	return new ResponseEntity<>(currecyFactoryRepository.save(existingcurrencyData), HttpStatus.OK);
	    } else {
	      log.info("Ended CurrencyConversioFactorController :: updateConversionFactor");	
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}
	
	@GetMapping("/get/{code}")
	public Double getConversionFactor(@PathVariable("code") String code) {
		log.info("Entered CurrencyConversioFactorController :: getConversionFactor",code);
	    Optional<CurrencyConversion> currencyConversion = Optional.of(currecyFactoryRepository.findByCountryCode(code));

	    if (currencyConversion.isPresent()) {
	    log.info("Ended CurrencyConversioFactorController :: getConversionFactor",code);	
	      return currencyConversion.get().getConversionFactor();
	    } else {
	      return null;
	    }
	  }

}
