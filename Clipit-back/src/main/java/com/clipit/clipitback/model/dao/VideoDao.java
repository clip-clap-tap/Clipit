package com.clipit.clipitback.model.dao;

import com.clipit.clipitback.model.dto.MarkedVideo;
import com.clipit.clipitback.model.dto.Video;

import java.util.List;
import java.util.Map;

public interface VideoDao {

	int insertMarkedVideo(Map<String, String> markedVideoInfo);

	int insertVideo(Video video);

	List<MarkedVideo> selectMarkedVideosByUserId(String id);

	Video selectVideoById(String id);
}
