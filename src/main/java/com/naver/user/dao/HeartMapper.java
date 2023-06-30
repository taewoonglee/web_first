package com.naver.user.dao;

import com.naver.user.domain.heart.HeartSupport;
import org.springframework.stereotype.Repository;

@Repository
public interface HeartMapper {
    Integer findById(HeartSupport heartSupport);
    Integer updateHearts(HeartSupport heartSupport);
}
