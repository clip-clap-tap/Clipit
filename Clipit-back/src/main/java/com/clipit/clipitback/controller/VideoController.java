package com.clipit.clipitback.controller;

import com.clipit.clipitback.model.dto.MarkedVideo;
import com.clipit.clipitback.model.dto.Video;
import com.clipit.clipitback.model.service.VideoService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/videos")
@RestController
public class VideoController {

    VideoService videoService;


    public VideoController(VideoService videoService) {
        this.videoService = videoService;
    }

    @Operation(summary = "영상 마크 목록 확인")
    @GetMapping("/{id}/marked-videos")
    public ResponseEntity<?> getMarkedVideoById(@PathVariable("id") String id) {
        List<MarkedVideo> list = videoService.getMarkedVideosByUserId(id);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }


    @Operation(summary = "영상 마크")
    @PostMapping("/{id}")
    public ResponseEntity<?> addVideo(@PathVariable("id") String id, @SessionAttribute(name = "userId") String userId) {

        int res = videoService.addMarkedVideo(userId, id);
        return new ResponseEntity<>(res, res==1? HttpStatus.OK : HttpStatus.CREATED);
    }


}
