package com.example.demo.member.service;

import com.example.demo.member.domain.entity.Member;
import com.example.demo.member.domain.request.MemberRequest;
import com.example.demo.member.domain.response.MemberResponse;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberService {
    private final EntityManager em;

    public void delete(Long id){
        Member member = em.find(Member.class, id);
        em.remove(member);
    }

    public MemberResponse findById(Long id){
        Member member = em.find(Member.class, id);
        return new MemberResponse(member);
    }

    public List<MemberResponse> findAll(){
        return em
                .createQuery("select m from Member m", Member.class)
                .getResultList()
                .stream()
                .map(MemberResponse::new)
                .toList();
    }

    public void insert(MemberRequest request){
        em.persist(request.toEntity());
    }

    public MemberResponse update(Long id, MemberRequest request){
        Member member = em.find(Member.class, id);
        member.setAge(request.age());
        member.setName(request.name());
        return new MemberResponse(member);
    }
}
