package com.nextbus.nextbusservice.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author Kishore Kar
 */
@Configuration
@PropertySource("classpath:testdata.properties")
@ConfigurationProperties("testdata")
public class TestDataConfiguration {

    private String routename;
    private String routeCode;
    private String stopname;
    private String stopcode;
    private String direction;
    private String invalid_stopcode;
    private String invalid_direction;
    private String invalid_routeCode;
    
	public String getRoutename() {
		return routename;
	}
	public void setRoutename(String routename) {
		this.routename = routename;
	}
	public String getRouteCode() {
		return routeCode;
	}
	public void setRouteCode(String routeCode) {
		this.routeCode = routeCode;
	}
	public String getStopname() {
		return stopname;
	}
	public void setStopname(String stopname) {
		this.stopname = stopname;
	}
	public String getStopcode() {
		return stopcode;
	}
	public void setStopcode(String stopcode) {
		this.stopcode = stopcode;
	}
	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}
	public String getInvalid_stopcode() {
		return invalid_stopcode;
	}
	public void setInvalid_stopcode(String invalid_stopcode) {
		this.invalid_stopcode = invalid_stopcode;
	}
	public String getInvalid_direction() {
		return invalid_direction;
	}
	public void setInvalid_direction(String invalid_direction) {
		this.invalid_direction = invalid_direction;
	}
	public String getInvalid_routeCode() {
		return invalid_routeCode;
	}
	public void setInvalid_routeCode(String invalid_routeCode) {
		this.invalid_routeCode = invalid_routeCode;
	}
    
	

}
