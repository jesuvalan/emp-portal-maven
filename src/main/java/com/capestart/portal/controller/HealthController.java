package com.capestart.portal.controller;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capestart.App;
import com.capestart.portal.service.HealthService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@Api(tags = "Health Check Url of Portal API")
@RequestMapping(value = "/portal")
@RestController
@Slf4j
public class HealthController {

	@Autowired
	HealthService healthService;

	@ApiOperation(value = "Health URL", notes = "It shows the health of all dependencies (APIs and Database)")
	
	@GetMapping(value = "/health")
	public ResponseEntity<String> health() {
		log.debug("Health API called");
		String response = "{status: OK}";
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@GetMapping(value = "/health/info")
	public ResponseEntity<String> healthInfo() {
		log.debug("Health Info API called");
		boolean response = healthService.health();
		if (response) {
			String responseValue = "{status: OK}";
			return new ResponseEntity<>(String.valueOf(responseValue), HttpStatus.OK);
		}else {
			String responseValue = "{status: Down}";
			return new ResponseEntity<>(String.valueOf(responseValue), HttpStatus.GATEWAY_TIMEOUT);
		}
		
	}
}
