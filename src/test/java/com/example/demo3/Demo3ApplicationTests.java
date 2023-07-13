package com.example.demo3;

import com.example.demo3.hobby.domain.entity.Hobby;
import com.example.demo3.hobby.domain.entity.Member;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

@SpringBootTest
@Transactional
@Commit
class Demo3ApplicationTests {
	@Autowired
	EntityManager em;

	@Test
	void contextLoads() {




//		Hobby 축구 = new Hobby(1L,"축구");
//		em.persist(축구);
//		em.flush(); //쌓여있던 것을 빼줌
////*		em.clear(); //사라짐
//		축구.setName("농구");
//		Hobby 배구 = Hobby.builder().id(2L).name("배구").build();
//		em.persist(배구);
//		Hobby hobby = em.find(Hobby.class,2L);
//		System.out.println(hobby);
//		System.out.println(hobby==배구);
//		Hobby hobby2=em.find(Hobby.class,1L);
//		System.out.println("축구 == hobby2 " + (축구 == hobby2));
	}
//	@Test
//	void 데이터많이넣기() throws  Exception{
//		for (int i = 0; i < 100; i++) {
//
//			Hobby 축구 = new Hobby((long) i, "축구");
//			em.persist(축구);
//			if (i % 10 == 0) em.flush();
//			if (i == 50) em.clear();
//			if (1 == 7) throw new Exception();
//		}

//		em.persist(축구);
//		em.flush(); //쌓여있던 것을 빼줌
//		em.clear(); //사라짐
//		축구.setName("농구");
//		Hobby 배구 = Hobby.builder().id(2L).name("배구").build();
//		em.persist(배구);

//@Test
//	void 조인테스트(){
//		Member member = new Member(null,"김태경",2_000_000,null);
//		em.persist(member);
//		Hobby hobby = new Hobby(null,"축구",member);
//		em.persist(hobby);
//		Hobby hobby2 = new Hobby(null,"배구",member);
//		em.persist(hobby2);
//		em.flush();
//		em.clear();
//		Member member1 = em.find(Member.class, 1l);
//		Hobby hobby1 = em.find(Hobby.class,1l);
//		for(Hobby hobby3:member1.getHobbies()){
//			System.out.println(hobby3);
//		}
//		System.out.println(member1.getHobbies().get(0)==hobby1);
//		System.out.println(member1.getHobbies().get(1)==hobby1);
//		System.out.println(hobby1.getMember()==member1);
//		System.out.println(member1.getHobbies().get(1).getMember()==member1);
//}
//	@Test
//	void 조인테스트2(){
//		Member member = new Member(null,"김태경",2_000_000,null);
//		em.persist(member);
//		Hobby hobby = new Hobby(null,"축구",member);
//		em.persist(hobby);
//		Hobby hobby2 = new Hobby(null,"배구",member);
//		em.persist(hobby2);
//		em.flush();
//		em.clear();
//		Member member1 = em.find(Member.class, 1l);
//		System.out.println(member1.getHobbies().get(0));
//		System.out.println();
//		Hobby hobby1 = em.find(Hobby.class,1l);
//		for(Hobby hobby3:member1.getHobbies()){
//			System.out.println(hobby3);
//		}
//		System.out.println(member1.getHobbies().get(0)==hobby1);
//		System.out.println(member1.getHobbies().get(1)==hobby1);
//		System.out.println(hobby1.getMember()==member1);
//		System.out.println(member1.getHobbies().get(1).getMember()==member1);
//		System.out.println();
	}

}