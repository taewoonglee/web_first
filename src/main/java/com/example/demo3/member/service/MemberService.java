package com.example.demo3.member.service;


import com.example.demo3.hobby.domain.entity.Hobby;
import com.example.demo3.hobby.domain.entity.Member;
import com.example.demo3.hobby.domain.entity.MemberHobby;
import com.example.demo3.hobby.domain.request.ConnectRequest;
import com.example.demo3.hobby.domain.request.MemberRequest;
import com.example.demo3.hobby.domain.request.WordRequest;
import com.example.demo3.hobby.response.MemberResponse;
import com.example.demo3.store.Store;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.demo3.store.Store.memberHobbyList;
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
//    @Transactional
//    public List<MemberResponse> findAll(){
//        return memberList.stream().map(m->new MemberResponse(m)).toList();
//    }
    @Transactional
    public List<MemberResponse> findAll(){
        return em.createQuery("select m from Member as m",Member.class).
                getResultList().stream().map(MemberResponse::new).toList();
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
                setParameter("id",id)
                .executeUpdate();
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
    @Transactional
    public List<Hobby> returnHobby(Member member)
    {

        String query = "select h from Hobby as h where id =:id";
        List<Hobby> memberHobbies = em.createQuery(query, Hobby.class)
                .setParameter("id",member.getId()).getResultList();
        return memberHobbies;
    }
    public List<MemberHobby> connectMemberHobby()
    {
        List<Member> members= findAllMember();
        for(int i=0;i<members.size();i++)
        {
            List<Hobby> hobby = returnHobby(members.get(i));
            for(int j=0;j<hobby.size();j++)
            {
                MemberHobby MH = new MemberHobby(members.get(i),hobby.get(j));
                Store.memberHobbyList.add(MH);
            }
        }
        return memberHobbyList;
    }
    public List<MemberHobby> allMemberHobby()
    {
        String query="select m from MemberHobby as m";
        List<MemberHobby> retList = em.createQuery(query, MemberHobby.class).getResultList();
        return retList;
    }

    public List<MemberResponse> findAll(String name){
        return em.createQuery
                        ("select m from Member m join fetch m.hobbies " +
                                "where m.name like :name",Member.class)
                .setParameter("name","%"+name+"%").
                getResultList().
                stream().
                map(MemberResponse::new).
                toList();
    }
}
