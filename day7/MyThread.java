import dto.Person;

public class MyThread extends Thread{
    private int time;
    private int id;
    private Person person;
    //private static int count;

    public MyThread(int time, int id, Person person) {
        this.time = time;
        this.id = id;
        this.person=person;
        //count++;
    }
    @Override
    public void run(){


            person.setNow_state(0);
            try {
                Thread.sleep(time);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            person.setNow_state(1);
            if(person.getName()=="scv")
            {
                Main.scv_is_availble=true;
            }
            //여기서 getname==scv일때 또다른 thread를 실
//        person.getName()==scv

    }
}
