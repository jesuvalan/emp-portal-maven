package com.capestart.portal.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class HealthService {
	
	@Autowired
	private CompanyService companyService;
	
	private static final String HEALTHQUERY = "select 1";
	
	public boolean health() {
		log.debug("Health API called");

		try {
			boolean isDBUp = isDataBaseUp();
			return isDBUp;
		}catch (Throwable e) {
			log.error("healthServiceCall() - Error while calling health service", e);
			return false;
		}
	}
	
	public boolean isDataBaseUp() {
		boolean isDBUp = false;
		try {
			companyService.getDataFromQuery(HEALTHQUERY);
			isDBUp = true;
		} catch (Throwable e) {
			log.error("isDataBaseUp() - Error while checking DB connection", e);
		}
		return isDBUp;
	}

}
