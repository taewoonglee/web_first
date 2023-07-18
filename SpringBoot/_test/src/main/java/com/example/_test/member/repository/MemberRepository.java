package com.example._test.member.repository;

import com.example._test.member.domain.entity.Member;
import com.example._test.member.domain.request.LoginRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MemberRepository extends JpaRepository<Member, Long> {




    Page<Member> findAll(Pageable pageable);
    Member findMemberByPasswordAndEmail(String password, String email);
    Member findById(Integer id);

    @Query("select m from Member m join fetch m.todosList")
    Page<Member> findMemberFetchJoin(Pageable pageable);


}
