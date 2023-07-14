package com.example.demo3.member.repository;

import com.example.demo3.hobby.domain.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {

}
