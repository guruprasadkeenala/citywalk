package com.citywalk.backend.filter;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.citywalk.backend.util.CitywalkUtil;

/**
 * Payment filter is implemented to avoid cross origin problem over the network
 * @author gurubrahma_p
 * response.addHeader("Access-Control-Allow-Origin", "*");
 * response.addHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE");
 * response.addHeader("Cache-Control", "no-cache");
 * response.addHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
 * response.addHeader("Access-Control-Max-Age", "1");
 * response.addHeader("Access-Control-Allow-Credentials", "false");*/
 
@Component
@WebFilter(urlPatterns="/restricted/*",filterName="citywalkFilter")
public class CitywalkFilter extends OncePerRequestFilter{
	
	@Autowired private CitywalkUtil citywalkUtil;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
    	String path = request.getRequestURI();
    	logger.info("###### security filter "+path);
		logger.info("Sending Header....");
    	Map<String,Object> headerMap = citywalkUtil.constructHeaders();
    	Iterator<Entry<String, Object>> iterator = headerMap.entrySet().iterator();
    	while (iterator.hasNext()) {
            Map.Entry<String, Object> entry = (Map.Entry<String, Object>)iterator.next();
            response.addHeader(entry.getKey(), entry.getValue().toString());
        }
        filterChain.doFilter(request, response);
    }
}