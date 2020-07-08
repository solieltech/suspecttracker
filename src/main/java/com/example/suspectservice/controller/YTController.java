package com.example.suspectservice.controller;

import com.example.suspectservice.service.YTService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//@CrossOrigin(origins = "*", maxAge = 3600)
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

    @GetMapping(value = "/getVideoStatistics/{videoId}")
    public @ResponseBody
    String videoStatistics(@PathVariable String videoId) {
        logger.info("getChannelStats ::: >>>> ");
        return ytService.videoStatistics(videoId);
    }

    @GetMapping(value = "/getVideoComments/{videoId}")
    public @ResponseBody
    ResponseEntity<InputStreamResource> getVideoComments(@PathVariable String videoId) {
        /*HttpHeaders httpHeaders =new HttpHeaders();
        httpHeaders.set("Content-Disposition",
                "attachment; filename=new-excel-file.xls");
        httpHeaders.setContentType(new MediaType("application/octet-stream"));
        new ResponseEntity().set
        logger.info("get video comments ::: >>>> ");*/
        return ytService.videoComments(videoId);
    }


}
