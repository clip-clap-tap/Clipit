package com.clipit.clipitback.model.service;

import com.clipit.clipitback.model.dto.MarkedVideo;
import com.clipit.clipitback.model.dto.Video;

import java.util.List;
import java.util.Map;

public interface VideoService {

    int addMarkedVideo(String userId, String id);

    List<MarkedVideo> getMarkedVideosByUserId(String id);


}
