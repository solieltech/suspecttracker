package com.example.suspectservice.controller;

import com.example.suspectservice.service.YTService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@ComponentScan("com.example.suspectservice")
public class YTController {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private YTService ytService;

    private static final String FILE_PATH = "E:\\Kiran_work\\Suspect-Tracker\\suspect-service\\suspect-service\\comments.xlsx";

    @GetMapping(value = "/getChannelStats/{channelId}")
    public @ResponseBody
    String getChannelStats(@PathVariable String channelId) {
        logger.info("getChannelStats ::: >>>> ");
        return ytService.channelStatistics(channelId).toString();
    }
    @GetMapping(value = "/getVideoComments/{videoId}")
    public @ResponseBody
    String getVideoComments(@PathVariable String videoId) {
        return ytService.videoComments(videoId);
    }


}
