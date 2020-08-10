package com.capestart.portal.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capestart.portal.dao.CompanyDao;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CompanyService {
	
	@Autowired
	private CompanyDao companyDao;
	
	
	@Transactional
	public List<Map<String, Object>> getDataFromQuery(String query) {
		log.debug("OrderService:: getDataFromQuery() query: {}", query);
		return companyDao.getDataFromQuery(query);
	}

}
