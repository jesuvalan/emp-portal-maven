package com.capestart.portal.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.capestart.portal.controller.HealthController;
import com.capestart.portal.model.Company;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class CompanyDao {
	
	@Autowired
	private SequenceGeneratorDao sequenceGenerator;
	
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	ObjectMapper objectMapper;
	
	
	public List<Map<String, Object>> getDataFromQuery(String query) {
		return this.jdbcTemplate.queryForList(query);
	}

}
