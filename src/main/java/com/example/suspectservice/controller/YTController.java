package com.example.suspectservice.controller;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.suspectservice.service.YTService;

@RestController
@ComponentScan("com.example.suspectservice")
public class YTController {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private YTService ytService;
    @GetMapping(value = "/getChannelStats/{channelId}")
    public @ResponseBody
    String getChannelStats(@PathVariable String channelId) {
        logger.info("getChannelStats ::: >>>> ");
        return ytService.channelStatistics(channelId).toString();
    }
    @GetMapping(value = "/channelDetails/{channelId}")
    public @ResponseBody
    String getChanelDeatails(@PathVariable String channelId) {
        logger.info("channel details ::: >>>> ");
        return ytService.channelDetails(channelId).toString();
    }
    @GetMapping(value = "/getVideoComments/{videoId}")
    public @ResponseBody
    ResponseEntity<String>  getVideoComments(@PathVariable String videoId,HttpServletResponse res) {
    	 HttpHeaders responseHeaders = new HttpHeaders();
         responseHeaders.set("content-type", 
           "application/json; charset=utf-8");
      
         return ResponseEntity.ok()
           .headers(responseHeaders)
           .body(ytService.videoComments(videoId));
    	
    }

}
