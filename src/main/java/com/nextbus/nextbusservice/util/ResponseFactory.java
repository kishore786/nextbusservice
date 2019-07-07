package com.nextbus.nextbusservice.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * @author Kishore Kar
 */
public class ResponseFactory {
	
	private ResponseFactory() {
		
	}

    public static ResponseEntity<Object> getResponse(Integer code, String action,String... body){
        NextBusResponse response = new NextBusResponse();

        ResponseEntity<Object> result = null;
        switch (code){
            case 500:
                response.setAction(action);
                response.setErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
                response.setStatus(500);
                result = new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
                break;
            case 200:
                response.setAction(action);
                response.setActionResponse("success");
                response.setStatus(200);
                response.setMessage(body != null && body.length>0?body[0]:"");
                result = new ResponseEntity<>(response, HttpStatus.OK);
                break;
            case 404:
                response.setAction(action);
                response.setErrorMessage(HttpStatus.NOT_FOUND.getReasonPhrase());
                response.setStatus(401);
                result = new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
                break;
            default:
                response.setAction(action);
                if(null != body && body.length >0){
                    String msg = body[0];
                    response.setErrorMessage(msg);
                }else{
                    response.setErrorMessage(HttpStatus.BAD_REQUEST.getReasonPhrase()+", " + NextBusContants.INVALID_INPUT);
                }
                response.setStatus(400);
                result = new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
        }
        return result;
    }

}
