package com.nextbus.nextbusservice;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.nextbus.nextbusservice.configuration.TestDataConfiguration;
import com.nextbus.nextbusservice.service.NextBusService;

/**
 * @author Kishore Kar
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class NextbusserviceApplicationTests {

	static Logger logger = LoggerFactory.getLogger(NextbusserviceApplicationTests.class);

	@Autowired
	NextBusService service;

	@Autowired
	private TestDataConfiguration testData;


	@Test
	public void findBusRouteCode() {
		String routeCode = service.getBusRoute(testData.getRoutename());
		logger.info("Bus route code: {}", routeCode);
		assertEquals("Bus Route matches: ", testData.getRouteCode(), routeCode);
	}
	
	@Test
	public void findBusStopCode() {
		String routeCode = service.getBusRoute(testData.getRoutename());
		String busStopCode = service.getBusStopCode(routeCode,
				testData.getDirection(),testData.getStopname());
		logger.info("Bus stop name: {}", busStopCode);
		assertEquals("Bus stop name matches: ", testData.getStopcode(), busStopCode);
	}
	
	@Test
	public void invalidBusRouteCode() {
		String routeCode = service.getBusRoute(testData.getRoutename());
		logger.info("Bus route code: {}", routeCode);
		assertNotSame(testData.getInvalid_routeCode(), routeCode);
	}
	
	@Test
	public void invalidBusStopCode() {
		String routeCode = service.getBusRoute(testData.getRoutename());
		String busStopCode = service.getBusStopCode(routeCode,
				testData.getDirection(),testData.getStopname());
		logger.info("Bus route code: {}", routeCode);
		assertNotSame( testData.getInvalid_stopcode(), busStopCode);
	}

}
