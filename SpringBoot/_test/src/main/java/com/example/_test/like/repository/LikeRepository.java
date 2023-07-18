package com.example._test.like.repository;

import com.example._test.like.domain.entity.Like;
import com.example._test.like.domain.request.LikeRequest;
import com.example._test.member.domain.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeRepository extends JpaRepository<Like, Long> {
    Like findByMemberIdAndTodoId(Integer memberid, Integer todoId);
}
