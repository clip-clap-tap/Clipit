package com.clipit.clipitback.model.service;

import com.clipit.clipitback.model.dao.TagDao;
import com.clipit.clipitback.model.dto.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagServiceImpl implements TagService {
    private final TagDao tagDao;

    @Autowired
    TagServiceImpl(TagDao tagDao) {
        this.tagDao = tagDao;
    }

    @Override
    public List<Tag> getFavoriteTagsByUserId() {
        return null;
    }

    @Override
    public List<Tag> getTagsByName(String name) {
        List<Tag> tags = tagDao.selectTagsByName(name);
        return tags;
    }

    @Override
    public int addUserFavoriteTag() {
        return 0;
    }

    @Override
    public int removeUserFavoriteTag() {
        return 0;
    }

    @Override
    public int addTag(Tag tag) {
        return tagDao.insertTag(tag);
    }

    @Override
    public int removeTag() {
        return 0;
    }

    @Override
    public int addPostTag() {
        return 0;
    }

    @Override
    public int removePostTag() {
        return 0;
    }
}
