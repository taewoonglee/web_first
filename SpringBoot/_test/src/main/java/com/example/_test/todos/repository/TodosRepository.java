package com.example._test.todos.repository;

import com.example._test.like.domain.entity.Like;
import com.example._test.member.domain.entity.Member;
import com.example._test.todos.domain.entity.Todos;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TodosRepository extends JpaRepository<Todos, Long> {
    Page<Todos> findAll(Pageable pageable);
    Page<Todos> findAllByContent(String content,Pageable pageable);
    Page<Todos> findAllByContentContaining(String content,Pageable pageable);
    Todos findById(Integer id);
    void deleteById(Integer id);

}
