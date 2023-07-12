package com.example.demo3.hobby.service;


import com.example.demo3.hobby.domain.entity.Hobby;
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
    public void save(String name){
        Hobby hobby=new Hobby(null,name);
        em.persist(hobby);
        Store.hobbyList.add(hobby);
    }
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




}
