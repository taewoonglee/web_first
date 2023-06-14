import Mythread.MyRunnable;
import dto.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Main {
    static List<Person> list=new ArrayList<Person>();
    public static int Mineral=50;
    static Scanner sc=new Scanner(System.in);
    static int id=0;
    static boolean scv_is_availble=false;
    public static void main(String[] args){
        selectmode();


//        MyRunnable myRunnable = new MyRunnable(1);
//        MyRunnable myRunnable2 = new MyRunnable(2);
//        Thread thread = new Thread(myRunnable);
//        Thread thread2 = new Thread(myRunnable2);
//        thread.start();
////      thread2.start();
//        MyThread myThread = new MyThread(1000,1);
//        MyThread myThread2 = new MyThread(2000,2);
//        myThread.start();
//        myThread2.start();
//        Person person = new Person();
//        for (int i = 0; i <5 ; i++) {
//            MyThread myThread = new MyThread(1000, i, person);
//            myThread.start();
//        }

    }
    static public void makemarine()
    {
        System.out.println("유닛 이름을 입력하세요");
        String text=sc.nextLine();
        System.out.println("유닛을 생성하는데 필요한 미네랄을 입력하시오");
        String mine=sc.nextLine();
        int mineral=parseInt(mine);
        Mineral=Mineral-mineral;
        if(Mineral<0)
        {
            System.out.println("더 이상 유닛을 생성 할 수 없습니다.");
        }
        else {
            Person person = new Person();
            person.setName(text);
            list.add(person);
            id++;
            person.setId(id);
            MyThread myThread = new MyThread(10000,id,person);
            myThread.start();
        }
    }
    static public void now_state_print()
    {

            for (int i = 0; i < list.size() ; i++) {

                Person now_person=list.get(i);
                System.out.println(list.get(i));
                System.out.print("iD : "+" "+now_person.getId()+" ");
                System.out.print("Unit : "+" "+now_person.getName()+" ");
                System.out.print("State : "+" "+now_person.getNow_state()+" "+"\n");

            }
    }
    static public int now_mineral()
    {
        return Mineral;
    }
    static public void catch_mineral(Person List)
    {

    }

    static public void selectmode()
    {
        System.out.println("현재 상태를 입력하시요 1. 추가, 2. 상태 확인, 3.종료");
        System.out.println(now_mineral());
        String num=sc.nextLine();
        int mode= parseInt(num);
        if(mode==1)
        {
            if(scv_is_availble==true)
            {
                //catch_mineral();
            }
            makemarine();
        }
        else if(mode==2)
        {
            now_state_print();

        }
        else if(mode==3)
        {
            return;
        }
        else {

        }
        selectmode();

    }
}

