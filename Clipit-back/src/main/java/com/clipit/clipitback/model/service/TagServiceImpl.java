package com.clipit.clipitback.model.service;

import com.clipit.clipitback.model.dao.PostDao;
import com.clipit.clipitback.model.dao.TagDao;
import com.clipit.clipitback.model.dto.FavoriteTag;
import com.clipit.clipitback.model.dto.Post;
import com.clipit.clipitback.model.dto.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class TagServiceImpl implements TagService {
    private final TagDao tagDao;
    private final PostDao postDao;

    @Autowired
    TagServiceImpl(TagDao tagDao, PostDao postDao) {
        this.tagDao = tagDao;
        this.postDao = postDao;
    }

    @Override
    public Tag getTagByName(String name) {
        Tag tag = tagDao.selectTagByName(name);
        return tag;
    }

    @Override
    public int removeFavoriteTag(String userId, List<Tag> tags) {

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
    public List<FavoriteTag> getFavoriteTagsByUserId(String userId) {
        return tagDao.selectFavoriteTagsByUserId(userId);
    }

    @Override
    public int addUserFavoriteTag(String userId, List<Tag> tags) {

        int res = tagDao.insertUserFavoriteTag(Map.of("userId", userId, "tags", tags));
        return res;

    }

    @Override
    public int modifyFavoriteTag(String userId, List<Tag> tags) {

        List<FavoriteTag> currentFavoriteTags = tagDao.selectFavoriteTagsByUserId(userId);
        List<FavoriteTag> newFavoriteTags = new ArrayList<>();

        for(Tag tag : tags){
            newFavoriteTags.add(new FavoriteTag(userId, tagDao.selectTagByName(tag.getName()).getId()));
        }

        tagDao.deleteFavoriteTagByUserId(Map.of("userId", userId, "tags", compareFavoriteTags(currentFavoriteTags,newFavoriteTags)));
        int res = tagDao.insertExtraFavoriteTag(Map.of("userId", userId, "tags", compareFavoriteTags(newFavoriteTags,currentFavoriteTags)));

        return res;
    }

    static List<FavoriteTag> compareFavoriteTags(List<FavoriteTag> favTag1, List<FavoriteTag> favTag2) {

        List<FavoriteTag> tmp = new ArrayList<>();
        tmp.addAll(favTag1);
        for(FavoriteTag tag : favTag2){
            if(favTag1.contains(tag)){
                tmp.remove(tag);
            }
        }

        return tmp;

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
