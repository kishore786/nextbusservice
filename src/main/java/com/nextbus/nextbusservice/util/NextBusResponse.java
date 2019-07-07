package com.nextbus.nextbusservice.util;

import java.io.Serializable;
import java.util.HashMap;
/**
 * @author Kishore Kar
 */
public class NextBusResponse extends HashMap implements Serializable{

    public NextBusResponse(){
        put("actionResponse", "error");
    }

    public void setAction(String action) {
        put("action",action);
    }

    public void setActionResponse(String actionResponse) {
        put("actionResponse", actionResponse);
    }

    public void setStatus(Integer status) {
        put("status",status);
    }

    public void setMessage(Object message) {
        put("message", message);
    }
    public void setErrorMessage(String msg){
        put("errorMessage",msg);
    }
}
