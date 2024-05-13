package com.clipit.clipitback.controller;

import com.clipit.clipitback.model.dto.Video;
import com.clipit.clipitback.model.service.VideoService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RequestMapping("/videos")
@RestController
public class VideoController {

    VideoService videoService;


    public VideoController(VideoService videoService) {
        this.videoService = videoService;
    }

    @GetMapping("/id")
    public ResponseEntity<Video> getVideoById(@PathVariable("id") String id) {
        Video video = videoService.getVideoById(id);
        return new ResponseEntity<>(video, HttpStatus.OK);
    }


    @Operation(summary = "영상 마크")
    @PostMapping("/{id}")
    public ResponseEntity<?> addVideo(@PathVariable("id") String id, @SessionAttribute(name = "userId") String userId) {

        Map<String, String> map = new HashMap<>();
        map.put("id", id);
        map.put("userId", userId);

        int res = videoService.addMarkedVideo(map);
        return new ResponseEntity<>(res, res==1? HttpStatus.OK : HttpStatus.CREATED);
    }


}
