package com.devsuperior.dsmeta.services;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.repositories.SaleRepository;

@Service
public class SaleService {

	@Autowired
	private SaleRepository repo;
	
	public Page<Sale> findSales(String minDate, String maxDate, Pageable pageable) {
		
		LocalDate hoje = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());
		
		
		LocalDate min = minDate.equals("") ? hoje.minusDays(365) : LocalDate.parse(minDate);
		LocalDate max = maxDate.equals("") ? hoje : LocalDate.parse(maxDate);
		
		
		return repo.findSales(min, max, pageable);
		
	}


}
