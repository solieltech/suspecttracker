package com.example.suspectservice.rest.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class YTClient<T> {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private RestTemplate restTemplate;

    @Value("${api.key}")
    private String apiKey;

    @Value("${yt.api}")
    private String api;

    public T get(String uri,Class<T> clazz,String... args){
    String actualApi = api+uri+"?part="+args[0]+"&id="+args[1]+"&key="+apiKey;
        return  getApiCall(actualApi,clazz).getBody();
    }

    public T getChildComments(String uri,Class<T> clazz,String... args){
        String actualApi;
        actualApi = api + uri + "?part=" + args[0] + "&maxResults=100&parentId=" + args[1] + "&key=" + apiKey;
        /*if(args[2]==null) {
            actualApi = api + uri + "?part=" + args[0] + "&maxResults=100&parentId=" + args[1] + "&key=" + apiKey;
        }else{
            actualApi = api + uri + "?part=" + args[0] + "&maxResults=100&parentId=" + args[1] + "&pageToken="+args[2]+"&key=" + apiKey;
        }*/
        return  getApiCall(actualApi,clazz).getBody();
    }

    public T getVideoComments(String uri,Class<T> clazz,String... args){
        String actualApi;
        if(args[2]==null) {
            actualApi = api + uri + "?part=" + args[0] + "&maxResults=100&videoId=" + args[1] + "&key=" + apiKey;
        }else{
            actualApi = api + uri + "?part=" + args[0] + "&maxResults=100&videoId=" + args[1] + "&pageToken="+args[2]+"&key=" + apiKey;
        }
        return  getApiCall(actualApi,clazz).getBody();
    }
    protected ResponseEntity<T> getApiCall(String api,Class<T> clazz){
        logger.info("Api :: "+api);
        return restTemplate.exchange(api, HttpMethod.GET,null,clazz);
    }
    protected ResponseEntity<T> postApiCall(Class<T> clazz){
        return  null;
    }
}
