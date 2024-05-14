package com.clipit.clipitback.model.service;

import java.util.List;

public interface FilterService {

    int addAgeRange(List<Integer> ageRange);

    int addBodyPart(List<String> bodyPart);

    int addStrength(String strength);

}
