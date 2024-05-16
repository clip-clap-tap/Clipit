package com.clipit.clipitback.model.service;

import com.clipit.clipitback.model.dao.TagDao;
import com.clipit.clipitback.model.dto.Post;
import com.clipit.clipitback.model.dto.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

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
    public Tag getTagByName(String name) {
        Tag tag = tagDao.selectTagByName(name);
        return tag;
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
    public void checkTagInfo(List<Tag> tags) {
        for (Tag tag : tags) {

            if(tagDao.selectTagByName(tag.getName())==null){
                tagDao.insertTag(tag);
            }

        }
        ;
    }

    @Override
    public int addPostTag(Post post) {
        return tagDao.insertPostTag(Map.of("postId", post.getId(), "tags", post.getTags()));
    }

    @Override
    public int removePostTag() {
        return 0;
    }
}
