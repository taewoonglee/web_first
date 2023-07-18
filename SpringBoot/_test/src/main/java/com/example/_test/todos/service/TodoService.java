package com.example._test.todos.service;


import com.example._test.exception.Exception401;
import com.example._test.exception.Exception404;
import com.example._test.like.domain.entity.Like;
import com.example._test.like.domain.request.LikeRequest;
//import com.example._test.like.repository.LikeRepository;
import com.example._test.like.repository.LikeRepository;
import com.example._test.member.domain.entity.Member;
import com.example._test.member.memberreponse.MemberResponse;
import com.example._test.member.repository.MemberRepository;
import com.example._test.todos.domain.entity.Todos;
import com.example._test.todos.domain.request.CheckRequest;
import com.example._test.todos.domain.request.TodosRequest;
import com.example._test.todos.repository.TodosRepository;
import com.example._test.todos.response.TodosResponse;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class TodoService {
    private final EntityManager em;
    private final TodosRepository todosRepository;
    private final MemberRepository memberRepository;
    private final LikeRepository likeRepository;


    public List<TodosResponse> findAllTodos(PageRequest request)
    {

        Page<Todos> todos =todosRepository.findAll(request);
        return todos.stream().map(TodosResponse::new).toList();
    }
    public void insertTodos(TodosRequest request)
    {
        Integer id = request.getMemberId();
        Optional<Member> member = Optional.ofNullable(memberRepository.findById(id));
        if(member.isEmpty())
        {
            throw new Exception404("맞는 아이디가 존재하지 않습니다. 연결 x");
        }

        else {
            todosRepository.save(request.toEntity());
        }
    }
    public Page<Todos> findByContent(String content, PageRequest request)
    {
        //없을 경우 예외처리
        //ok
        Page<Todos> todos = todosRepository.findAllByContentContaining(content,request);
        return todos;
    }
    public void deleteById(Integer id)
    {
        //없을 경우 예외처리
        //ok

        Optional<Todos> todos = Optional.ofNullable(todosRepository.findById(id));
        if(todos.isEmpty())
        {
            throw new Exception404("삭제할 id가 존재하지 않습니다. 삭제 x");
        }
        else
        {
//            String query = "delete from Todos where id =:id";
//            em.createQuery(query,Todos.class).setParameter("id",id).executeUpdate();
            todosRepository.deleteById(id);
        }

        //todosRepository.deleteById(id);
    }
    public void changeById(Integer id, TodosRequest request)
    {
        Optional<Todos> todos = Optional.ofNullable(todosRepository.findById(id));
        if(todos.isEmpty())
        {
            throw new Exception404("바꿀 id가 존재하지 않습니다. 변경 x");
        }
        //없을 경우 예외처리
        //ok
//        String query = "select t from Todos where id = :id";
//        em.createQuery(query,Todos.class).setParameter()
//        todos.setContent(request.getContent());
//        todos.setTitle(request.getTitle());
        else {
            Todos todos1 = todosRepository.findById(id);
            todos1.setTitle(request.getTitle());
            todos1.setContent(request.getContent());
        }
    }
    public Boolean checkById(LikeRequest request)
    {
        Integer memberId = request.getMemberId();
        Integer todoId = request.getTodoId();
        Optional<Like> like = Optional.ofNullable(likeRepository.findByMemberIdAndTodoId(memberId,todoId));
        if(like.isEmpty())
        {
            return false;
        }
//        String query = "select l from Like as l where memberId= :memberId and todoId= :todoId";
//        Integer memberId = request.getMemberId();
//        Integer todoId = request.getTodoId();
//        Optional<Like> like = Optional.ofNullable(em.createQuery(query, Like.class).
//                setParameter("memberId", memberId).
//                setParameter("todoId", todoId).
//                getSingleResult());

//        if(like.isEmpty())
//        {
//            throw new Exception404("안됨");
//        }
        else {
            return true;
        }
    }
    public Boolean likeById(LikeRequest request)
    {
        Optional<Todos> todos = Optional.ofNullable(todosRepository.findById(request.getTodoId()));
        if(todos.isEmpty())
        {
            throw new Exception404("좋아요를 할 아이디가 없습니다. 좋아요 x");
        }
        Todos todos2 =todosRepository.findById(request.getTodoId());
        Integer id=todos2.getMember().getId();
        if(request.getMemberId()==id)
        {

        }
        if(checkById(request))
        {
                throw new Exception404("이미 좋아요를 했습니다. 좋아요 x");
            //이미 존재하기 때문에 좋아요 불가능
        }
        else {
            Like like = new Like(request.getMemberId(),request.getTodoId());
            em.persist(like);
            Todos todos3=todosRepository.findById(request.getTodoId());
            todos3.setLikeCount(todos3.getLikeCount()+1);
            return true;
        }
    }
    public Boolean checkList(CheckRequest request)
    {
        Optional<Member> member = Optional.ofNullable(memberRepository.findById(request.getMemberId()));
        Optional<Todos> todos = Optional.ofNullable(todosRepository.findById(request.getId()));
        if(member.isEmpty()||todos.isEmpty())
        {
            throw new Exception404("체크를 할 아이디가 없어요");
        }
        Todos todos1 = todosRepository.findById(request.getId());
        if(todos1.getIsDone())
        {
            throw new Exception401("이미 한 작업입니다. 완료");
        }
        else
        {
            Todos todos2 =todosRepository.findById(request.getId());
            todos2.setIsDone(true);
            return true;
        }
    }
}
