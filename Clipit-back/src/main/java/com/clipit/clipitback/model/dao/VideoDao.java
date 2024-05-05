package com.clipit.clipitback.model.dao;

import com.clipit.clipitback.model.dto.MarkedVideo;

import java.util.List;

public interface VideoDao {
	List<MarkedVideo> getMarkedVideosByUserId();
}
