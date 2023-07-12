package com.example.demo3.member.service;


import com.example.demo3.hobby.domain.entity.Hobby;
import com.example.demo3.hobby.domain.entity.Member;
import com.example.demo3.hobby.domain.request.MemberRequest;
import com.example.demo3.hobby.domain.request.WordRequest;
import com.example.demo3.store.Store;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.demo3.store.Store.memberList;
//import static jdk.internal.icu.lang.UCharacter.getAge;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final EntityManager em;
    @Transactional
    public void save(MemberRequest request)
    {
        Member member = new Member(request.getName(), request.getAge());
        em.persist(member);
        Store.memberList.add(member);
}

    @Transactional
    public Member findById(Long id)
    {
        Member member=em.find(Member.class,id);
        return member;

    }
    @Transactional
    public List<Member> findAllMember()
    {
        String query="select m from Member as m";
        List<Member> retList = em.createQuery(query, Member.class).getResultList();
        return retList;
//        return memberList;
    }
    @Transactional
    public List<Member> deleteIdMember(Long id)
    {
        String query = "delete from Member where id = :id";
        em.createQuery(query).setParameter("id",id).executeUpdate();
//        Member member =findById(id);
        return memberList;
    }
    @Transactional
    public List<Member> updateMember(Long id,MemberRequest request)
    {

        Integer req_Age = request.getAge();
        String req_Name = request.getName();
        String query = "update Member set name=:name, age=:age where id =:id";
        em.createQuery(query).
                setParameter("name",req_Name).
                setParameter("age",req_Age).
                setParameter("id",id).executeUpdate();
        return memberList;

    }
    @Transactional
    public List<Member> selectNameByMember(WordRequest request)
    {
        String query = "select id,name,age from Member where name like '%:word%'";
        String word = request.getName();
        System.out.println(word);
        List<Member> memlist1 = em.createQuery(query, Member.class).setParameter("name",word).getResultList();
        return memlist1;
    }
}
