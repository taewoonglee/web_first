package com.example.demo.member;

import com.example.demo.hobby.Hobby;
import com.example.demo.store.Store;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.demo.store.Store.memberIndex;
import static com.example.demo.store.Store.members;

@Service
public class MemberService {
    public List<Member> findAll(){
        return members;
    }
    public Member findById(int id)
    {
        Member mem = new Member();
        for(int i=0;i<members.size();i++)
        {
            if(members.get(i).getId()==id)
            {
                mem =members.get(i);
            }
        }
        return mem;
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
