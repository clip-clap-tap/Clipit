package com.clipit.clipitback.controller;

import com.clipit.clipitback.model.dto.Tag;
import com.clipit.clipitback.model.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tags")
public class TagController {
    private final TagService tagService;

    @Autowired
    TagController(TagService tagService) {
        this.tagService = tagService;
    }

    @GetMapping("/{name}")
    ResponseEntity<?> getTagsByName(@PathVariable("name") String name) {
        List<Tag> tags = tagService.getTagsByName(name);
        return new ResponseEntity<>(tags, !tags.isEmpty() ? HttpStatus.OK : HttpStatus.NO_CONTENT);
    }

    @PostMapping()
    ResponseEntity<?> addTag(Tag tag) {
        int result = tagService.addTag(tag);
        return new ResponseEntity<>(result, result == 1 ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }


}
