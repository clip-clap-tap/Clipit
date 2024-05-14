package com.clipit.clipitback.model.dao;

import java.util.List;

public interface FilterDao {

    int insertAgeRange(List<Integer> ageRange);

    int insertBodyPart(List<String> bodyPart);

    int insertStrength(String strength);
}
