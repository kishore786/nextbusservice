package com.nextbus.nextbusservice.controller;

import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nextbus.nextbusservice.exception.NextBusServiceException;
import com.nextbus.nextbusservice.service.NextBusService;
import com.nextbus.nextbusservice.util.NextBusContants;
import com.nextbus.nextbusservice.util.ResponseFactory;
/**
 * @author Kishore Kar
 */
@RestController
@RequestMapping(value = "/nextbus")
public class NextBusController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private NextBusService nextBusService;

	/**
	 * get next bus go time
	 * @param routeName
	 * @param stopName
	 * @param direction
	 * @return {@code String value for next bus go}	
	 */
	@RequestMapping(value = "/{routeName}/{stopName}/{direction}",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON)
	
	public ResponseEntity<?> nextBusGo(@PathVariable("routeName") String routeName, 
			@PathVariable("stopName") String stopName, @PathVariable("direction") String direction) {

		try {
			logger.info("Inside NextBusController.....");
			logger.info("Inside controller routeName: "+routeName);
			logger.info("Inside controller stopName: "+stopName);
			logger.info("Inside controller direction: "+direction);
			//String route=nextBusService.getBusRoute(routeName);
			String result = nextBusService.getNextBusGo(routeName,stopName,direction);
			logger.info("Next bus available from : "+stopName+" is : "+result);
			return ResponseFactory.getResponse(200,NextBusContants.GO,result);
		}catch (NextBusServiceException ex) {
			logger.error("NextBus service api with not found exception : " + ex.getMessage());
			return ResponseFactory.getResponse(404, NextBusContants.GO);
		}
		catch (Exception ex) {
			logger.error("NextBus service api with internal server error : " + ex.getMessage());
			return ResponseFactory.getResponse(500, NextBusContants.GO);
		}
		
	}

}
