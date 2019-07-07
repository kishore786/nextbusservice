package com.nextbus.nextbusservice.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.nextbus.nextbusservice.util.NextBusContants;
/**
 * @author Kishore Kar
 */
@Service
public class NextBusService {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	public String getNextBusGo(String routeName, String stopName, String directionKey) {

		logger.info("Inside NextBusService routeName::  " + routeName);		
		logger.info("Inside NextBusService direction code ::  " + getDirection().get(directionKey));		
		String route=getBusRoute(routeName);
		if("".equals(route)) {
			return NextBusContants.NO_BUS_AVAILABLE;
		}
		logger.info("Inside NextBusService route code ::  " + route);
		String stop=getBusStopCode(route, directionKey, stopName);
		if("".equals(stop)) {
			return NextBusContants.NO_BUS_AVAILABLE;
		}
		logger.info("Inside NextBusService bus stop code ::  " + stop);
		Map<String, String> params = new HashMap<String, String>();
		params.put("ROUTE", route);
		params.put("DIRECTION", getDirection().get(directionKey));
		params.put("STOP", stop);
		List<Map> clientRes = get(NextBusContants.NEXTBUS_URL, params, List.class);

		for (int i = 0; i < clientRes.size(); i++) {
			logger.info("Actual :" + clientRes.get(i).get("Actual"));
			if ("true".equalsIgnoreCase(clientRes.get(0).get("Actual").toString())) {
				return clientRes.get(0).get("DepartureText").toString();
			}
			break;
		}
		return NextBusContants.NO_BUS_AVAILABLE;

	}

	public String getBusRoute(String routeName) {

		logger.info("Inside getBusRoute routeName::  " + routeName);
		Map<String, String> params = new HashMap<String, String>();
		List<Map> clientRes = get(NextBusContants.ROUTE_URL, params, List.class);

		for (int i = 0; i < clientRes.size(); i++) {
			logger.info("Route name :" + clientRes.get(i).get("Description"));
			if (null!=clientRes.get(i).get("Description") && clientRes.get(i).get("Description").toString().endsWith(routeName)) {
				return clientRes.get(i).get("Route").toString();
			}
		}

		return "";

	}
	
	

	public String getBusStopCode(String route, String direction, String stopName) {

		logger.info("Inside getBusStopCode route::  " + route);
		logger.info("Inside getBusStopCode direction::  " + getDirection().get(direction));
		logger.info("Inside getBusStopCode stop name::  " + stopName);
		Map<String, String> params = new HashMap<String, String>();
		params.put("ROUTE", route);
		params.put("DIRECTION", getDirection().get(direction));

		List<Map> clientRes = get(NextBusContants.STOP_URL, params, List.class);

		for (int i = 0; i < clientRes.size(); i++) {
			logger.info("Stop name :" + clientRes.get(i).get("Text"));
			if (stopName.equalsIgnoreCase(clientRes.get(i).get("Text").toString())) {
				return clientRes.get(i).get("Value").toString();
			}
		}

		return "";

	}
	
		
	private <T> T get(String url, Map<String, String> params, Class<T> responseType) {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
		restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
		T responseObject = restTemplate.getForObject(url, responseType, params);
		return responseObject;
	}
	
	private Map<String,String> getDirection(){
		Map<String, String> directionMap=new HashMap<String,String>();
		 directionMap.put("south", "1");
		 directionMap.put("east", "2");
		 directionMap.put("west", "3");
		 directionMap.put("north", "4");
		 return directionMap;
	}

}
