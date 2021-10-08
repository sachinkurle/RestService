package com.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path = "/time")
public class TimeController {
 
    @GetMapping(path="/greetings")
    public ResponseEntity getGreetings(@RequestParam(name = "name", required = false) String name) {
	  DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MMM/dd HH:mm:ss");
	  LocalDateTime now = LocalDateTime.now();
    	if(null != name && !name.trim().isEmpty()) {
    		return ResponseEntity.ok("Hello "+name+ " Greetings! Current Time is "+ dtf.format(now));
    	} else {
    		
    		return ResponseEntity.ok("Hello Guest Greetings! Current Time is "+ dtf.format(now));
    	}
    }
    
    
    @GetMapping(path="/currentTime", produces="text/html")
    public ResponseEntity getCurrentTime(
    		@RequestParam(name = "loopCount", required = false) String loopCount,
    		@RequestParam(name = "sleepCount", required = false) String sleepCount) throws Exception 
    {
    	
    	long startTime = System.currentTimeMillis();
        Integer loopCnt = 100;
        Integer sleepCnt = 500;
    	String res = "Nothing return..";

    	try {
	    	if(null != loopCount && Integer.parseInt(loopCount) != 0) {
	    		loopCnt = Integer.parseInt(loopCount) ;
	    	}
	    	
	    	if(null != sleepCount && Integer.parseInt(sleepCount) != 0) {
	    		sleepCnt = Integer.parseInt(sleepCount);
	    	}
    	} catch (Exception e) {
    		return new ResponseEntity(res+" Either loopCount:" +loopCount+ " Or sleepCount:"+sleepCount+
    				" had invalid values.. if you dont pass default values are - "
    				+ " loopCount:"+loopCnt+ " and sleepCount:"+sleepCnt, HttpStatus.OK);
    	}
    	
    	
    	Integer iteration =0;
    	while(true) {
    		System.out.println("I am in loop:"+iteration);
    		if(iteration == loopCnt) {
			  DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MMM/dd HH:mm:ss");
			  LocalDateTime now = LocalDateTime.now();
			  res = "<BR><H3> Service looped "+loopCnt+ " times & each loop iteration slept for "+sleepCnt+ " milliseconds </H3>"
    					+ "<BR><H1> Current Time :"+ dtf.format(now)+ "</H1> <BR> <H3>Service took almost "+(System.currentTimeMillis()-startTime)+ " ms time in total.</H3>";
			  break;
    		}
    		System.out.println("I will sleep..");
    		Thread.sleep(sleepCnt);
    		System.out.println("I woke up..");
    		iteration++;
    	}
    	
        return new ResponseEntity(res, HttpStatus.OK);
    	
    }
    
}
