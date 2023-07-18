package com.example._test.member.service;

import com.example._test.exception.Exception400;
import com.example._test.member.domain.entity.Member;
import com.example._test.member.domain.request.LoginRequest;
import com.example._test.member.domain.request.MemberRequest;
import com.example._test.member.memberreponse.MemberResponse;
import com.example._test.member.repository.MemberRepository;
//import com.example._test.member.repository.MemberTodoRepository;
import com.example._test.memberlogin.entity.MemberLogin;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;
import java.text.SimpleDateFormat;
import java.util.Date;


@Service
@RequiredArgsConstructor
@Transactional
public class MemberService {
    private final EntityManager em;
    private final MemberRepository memberRepository;
//    private final MemberTodoRepository memberTodoRepository;

//    public Page<Member> findAllTodos(PageRequest request)
//    {
//
//        Page<Member> members =memberRepository.findAll(request);
//        return members;
//    }
    public List<MemberResponse> findAll(PageRequest request)
    {

        Page<Member> members =memberRepository.findMemberFetchJoin(request);
        return members.stream().map(MemberResponse::new).toList();
    }
    public void signupMember(MemberRequest member)
    {
        String password = member.getPassword();
        String email = member.getEmail();
        LoginRequest request = new LoginRequest(email,password);
        if(checkSignUp(request)==null)
        {
            Member mem=new Member(member.getEmail(),member.getPassword(),member.getName(),member.getAge());
            em.persist(mem);
        }
        else {

            throw new Exception400("이미 있는 유저입니다. 가입 x");

            //회원가입 불가 이미있음
        }
    }
    public Optional<Member> checkSignUp(LoginRequest loginrequest)
    {
        String password = loginrequest.getPassword();
        String email = loginrequest.getEmail();
//        String query = "select h from Member as h where password = :password and email = :email";
//        Optional<Member> member = em.createQuery(query, Member.class).
//                setParameter("password", password).
//                setParameter("email", email).
//                getSingleResult();
        Optional<Member> member = Optional.ofNullable(memberRepository.findMemberByPasswordAndEmail(password, email));
        if(member.isEmpty())
        {

            return null;
        }
        return Optional.of(member.get());

    }
    public Boolean loginMember(LoginRequest loginrequest)
    {
        if(checkSignUp(loginrequest)==null)
        {
            //없음
            throw new Exception400("없는 회원입니다. 로그인 x");
        }
        else {
            String now_time = null;
            String last_time = null;
            Date date = new Date();
// 포맷변경 ( 년월일 시분초)
            SimpleDateFormat sdformat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            now_time = sdformat.format(cal.getTime());
            cal.add(Calendar.MINUTE, 10);
            last_time = sdformat.format(cal.getTime());
            Integer id = checkSignUp(loginrequest).get().getId();
            MemberLogin memberLogin =new MemberLogin(id,now_time,last_time);
            em.persist(memberLogin);
            return true;
        }
    }
//    public Page<MemberTodos> allMembers(PageRequest request)
//    {
//        Page<MemberTodos> members =memberTodoRepository.findAllToDo(request);
//        return members;
//
//    }
    public Boolean checkTimeLogin()
    {
        //1먼저 값이 있는지
        //있으면 10분이 지났는지
        //시간이 지났으니 다시 로그인 부탁드립니다.
        return false;
    }







}
