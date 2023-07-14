package com.example.demo.hobby.service;

import com.example.demo.hobby.domain.entity.Hobby;
import com.example.demo.hobby.domain.request.ConnectRequest;
import com.example.demo.hobby.domain.request.HobbyRequest;
import com.example.demo.hobby.domain.response.HobbyResponse;
import com.example.demo.hobby.repository.HobbyRepository;
import com.example.demo.member.domain.entity.Member;
import com.example.demo.member.domain.request.MemberRequest;
import com.example.demo.member.domain.response.MemberResponse;
import com.example.demo.store.MemberHobby;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class HobbyService {
    private final EntityManager em;
    private final HobbyRepository hobbyRepository;

    public void connect(ConnectRequest request){
        MemberHobby memberHobby = new MemberHobby(null,
                Member
                .builder()
                .id(request.getMemberId())
                .build(),
                Hobby
                .builder()
                .id(request.getHobbyId())
                .build());
        em.persist(memberHobby);
    }


    public void save(HobbyRequest request){
        Hobby hobby = new Hobby(null,
                request.getName(),
                null);
        em.persist(hobby);
        System.out.println(hobby.getId());
    }

    public HobbyResponse findById(Long id){
        Hobby hobby = em.find(Hobby.class, id);
        return new HobbyResponse(hobby);
    }

    public List<HobbyResponse> findAll(){
//        mysql, oracle, mssql ...
        return em
                .createQuery("select h from Hobby h " +
                        "left join fetch h.members m " +
                                "join fetch m.member"
                        , Hobby.class)
                .getResultStream()
                .map(HobbyResponse::new)
                .toList();
    }

    public void delete(Long id){
        Hobby hobby = em.find(Hobby.class, id);
        em.remove(hobby);
    }
    public Page<HobbyResponse> findAll(PageRequest request) {
//        return memberRepository.findAllFetchByNameContainingToResponse("%"+name+"%");
        Page<Hobby> all = hobbyRepository.findAll(request);
        return all.map(HobbyResponse::new);
    }
}
