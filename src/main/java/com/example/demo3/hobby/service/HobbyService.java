package com.example.demo3.hobby.service;


import com.example.demo3.hobby.domain.entity.Hobby;
import com.example.demo3.hobby.domain.entity.Member;
import com.example.demo3.hobby.domain.entity.MemberHobby;
import com.example.demo3.hobby.domain.request.ConnectRequest;
import com.example.demo3.hobby.domain.request.HobbyRequest;
import com.example.demo3.hobby.response.HobbyResponse;
import com.example.demo3.hobby.response.MemberResponse;
import com.example.demo3.store.Store;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HobbyService {
    private final EntityManager em;
    @Transactional
    public void save(HobbyRequest request){
        Hobby hobby =  new Hobby(null, request.getName(),null);
        em.persist(hobby);
    }
//    @Transactional
//    public void connect(ConnectRequest request){
//
//        MemberHobby memberHobby = new MemberHobby(null,Member.builder().id(request.getMemberId())).build(),Hobby.builder().id(request.getHobbyId()).build());
//        em.persist(memberHobby);
//    }
    @Transactional
    public Hobby find(Long id){
        Hobby hobby = em.find(Hobby.class,id);
        return hobby;
    }
    @Transactional
    public List<Hobby> findAllHobby()
    {
        return Store.hobbyList;
    }
//    public List<Hobby> findAll(){
//        List<Hobby> hobbies = em.createQuery("select h from Hobby h",Hobby.class).getResultList();
//        return hobbies;
//    }
    public List<HobbyResponse> findAll(){
        return em.createQuery("select h from Hobby h left join fetch h.members m join fetch m.member",Hobby.class).getResultStream().map(HobbyResponse::new).toList();
    }
    public void deleteHobby(Long id)
    {
        em.createQuery("delete from Hobby where id = :id").setParameter("id",id).executeUpdate();

    }
    public void updateHobby(Long id, HobbyRequest request)
    {
        em.createQuery("update Hobby set name = :name where id = :id").setParameter("name",request.getName()).executeUpdate();
    }
//    public void connect(ConnectRequest request)
//    {
//        Member member = em.find(Member.class, request.getMemberId());
//        Hobby hobby = em.find(Hobby.class, request.getHobbyId());
//        MemberHobby memberHobby = new MemberHobby(member,hobby);
//        em.persist(memberHobby);
//    }



}
