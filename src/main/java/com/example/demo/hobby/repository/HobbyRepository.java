package com.example.demo.hobby.repository;

import com.example.demo.hobby.domain.entity.Hobby;
import com.example.demo.member.domain.entity.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HobbyRepository  extends JpaRepository<Hobby, Long> {

    Page<Hobby> findAll(Pageable pageable);
}
