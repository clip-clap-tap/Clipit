package com.clipit.clipitback.model.service;

import com.clipit.clipitback.model.dao.VideoDao;
import com.clipit.clipitback.model.dto.MarkedVideo;
import com.clipit.clipitback.model.dto.Tag;
import com.clipit.clipitback.model.dto.Video;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class VideoServiceImpl implements VideoService{

    private VideoDao videoDao;

    @Autowired
    public VideoServiceImpl(VideoDao videoDao) {
        this.videoDao = videoDao;
    }

    @Override
    public int addMarkedVideo(String userId, String id) {
        return videoDao.insertMarkedVideo(Map.of("userId", userId, "id", id));
    }

    @Override
    public List<MarkedVideo> getMarkedVideosByUserId(String id) {
        return videoDao.selectMarkedVideosByUserId(id);
    }

    @Override
    public void checkVideoInfo(List<Video> videos) {
        for (Video video : videos) {
            if(videoDao.selectVideoById(video.getId())==null){
                videoDao.insertVideo(video);
            }

        }
    }

}
