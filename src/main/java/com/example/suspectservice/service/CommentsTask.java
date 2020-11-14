package com.example.suspectservice.service;
import java.util.concurrent.Callable;
import com.example.suspectservice.model.VideoComments;
import com.example.suspectservice.rest.client.YTClient;

import lombok.Data;

@Data
public class CommentsTask implements Callable<VideoComments>{
	
	
    private YTClient ytClient;
	private String part;
	private String id;
	private String nextPageToken;
	
	public CommentsTask() {
		
	}

	@Override
	public VideoComments call() throws Exception {
		System.out.println(Thread.currentThread().getName()+">>>>>"+nextPageToken);
		//System.out.println(ytClient);
		VideoComments videoComments = (VideoComments)ytClient.getVideoComments("commentThreads", VideoComments.class,new String[]{part,id,nextPageToken});
		//System.out.println(videoComments);
		return videoComments;
	}

}
