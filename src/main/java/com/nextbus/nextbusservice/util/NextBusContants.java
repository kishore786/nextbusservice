package com.nextbus.nextbusservice.util;
/**
 * @author Kishore Kar
 */
public class NextBusContants {

	public static final String GO = "GO";
	public static final String INTERNAL_SERVER_ERROR = "Internal Server Error";
	public static final String INVALID_INPUT = "Invalid input.";
	public static final String NEXTBUS_URL="http://svc.metrotransit.org/NexTrip/{ROUTE}/{DIRECTION}/{STOP}";
	public static final String ROUTE_URL="http://svc.metrotransit.org/NexTrip/Routes";
	public static final String STOP_URL="http://svc.metrotransit.org/NexTrip/Stops/{ROUTE}/{DIRECTION}";
	public static final String DIRECTION_URL="http://svc.metrotransit.org/NexTrip/Directions/{ROUTE}";
	
	public static final String NO_BUS_AVAILABLE = "NO BUS AVAILABLE";
}
