package com.api.marvel.interceptor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.api.marvel.util.ErrorMessage;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class RequestParamInterceptor implements HandlerInterceptor {

	@Value("${server.servlet.context-path}")
	private String applicationPath;
	
	/**
	 *  Valida os atributos passados através dos parametros
	 */
    @Override
    public boolean preHandle(HttpServletRequest request,HttpServletResponse response, Object handler) throws Exception {
    
    	String limit = request.getParameter("limit");
    	String orderBy = request.getParameter("orderBy");
    	
    	if(limit != null && !isNumeric(limit)) {
    		sendError(response, 409, ErrorMessage.LIMIT_GREATHER_THAN_0);
    		return false;
    	}
    	
    	if(limit != null && Integer.parseInt(limit) < 1) {
    		sendError(response, 409, ErrorMessage.LIMIT_GREATHER_THAN_0);
    		return false;
    	}
    	
		if(limit != null && Integer.parseInt(limit) > 100) {
			sendError(response, 409, ErrorMessage.MAY_NOT_REQUEST_MORE_THAN_100);
    		return false;
    	}
		
		if(orderBy != null) {
			
			if(!orderBy.equalsIgnoreCase("name") || !orderBy.equalsIgnoreCase("modified") ||
					!orderBy.equalsIgnoreCase("-name") || !orderBy.equalsIgnoreCase("-modified")) {
				sendError(response, 409, ErrorMessage.UNRECOGNIZED_ORDERING_PARAMETER);
	    		return false;
			}
		}
    	
        return true;
    }
    
    private void sendError(HttpServletResponse response, int errorCode, ErrorMessage errorMessage) throws Exception {
    	String errorParams = "error/validation?errorCode=" + errorCode + "&errorMessage=" + errorMessage;
    	response.sendRedirect(applicationPath.concat(errorParams));
    }

    public static boolean isNumeric(String str) { 
    	try {  
    		  Integer.parseInt(str);  
    		  return true;
    	} catch(NumberFormatException e){  
    		return false;  
    	}  
    }
	
}
