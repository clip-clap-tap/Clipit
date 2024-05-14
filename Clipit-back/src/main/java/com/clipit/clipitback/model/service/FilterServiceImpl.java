package com.clipit.clipitback.model.service;

import com.clipit.clipitback.model.dao.FilterDao;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilterServiceImpl implements FilterService {

    private final FilterDao filterDao;

    FilterServiceImpl(FilterDao filterDao) {
        this.filterDao = filterDao;
    }

    @Override
    public int addAgeRange(List<Integer> ageRange) {
        return filterDao.insertAgeRange(ageRange);
    }

    @Override
    public int addBodyPart(List<String> bodyPart) {
        return filterDao.insertBodyPart(bodyPart);
    }

    @Override
    public int addStrength(String strength) {
        return filterDao.insertStrength(strength);
    }
}
