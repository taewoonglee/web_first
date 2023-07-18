package com.example.demo.member;

import com.example.demo.exception.MemberNotFound;
import com.example.demo.hobby.Hobby;
import com.example.demo.store.Store;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.example.demo.store.Store.memberIndex;
import static com.example.demo.store.Store.members;

@Service
public class MemberService {
    public List<MemberResponse> findAll(){
        return members.stream().map(m->new MemberResponse(m)).toList();
    }
    public Member findById(Integer id)
    {
        Member mem = new Member();
        for(int i=0;i<members.size();i++)
        {
            if(members.get(i).getId()==id)
            {
                return members.get(i);
            }
        }
        Optional<Member> first = members.stream().filter(m->m.getId().equals(id)).findFirst();
//        String i2=String.valueOf(id);
//        first.orElse(new Member());
//        Member member;
////        if(first.isPresent()) member = first.get() ;
//        first.orElseThrow(throw new Exception("ff"));
//        Member member = first.orElseThrow(()->new MemberNotFound("사람을 못찾았어요","api",i2));
        return null;
    }

    public void save(Member member){
        //여기서 post를 할 때 insert를 할 때 먼저 hobby를 찾아보고 없으면 그냥 add
        members.add(member);
    }
    public List<Member> delete(int id)
    {
       members.remove(findById(id));
        return members;
    }
    public Member put(Integer id, MemberRequest member)
    {
        Member byId=findById(id);
        byId.setAge(member.age());
        byId.setName(member.name());
        return byId;
    }
    public Integer checkHobbyList(List<Hobby> hobbies)
    {
        if(hobbies.size()==0)
        {
            return 0;
        }
        else {
            return 1;
        }
    }
    public Integer checkSameHobbyAndMemberList (List<Hobby> hobbies)
    {



        return 0;
    }



    public void insertHobby(List<Hobby> hobbies)
    {

    }




}
