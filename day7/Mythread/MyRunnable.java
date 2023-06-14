package Mythread;

public class MyRunnable implements Runnable{
    private int param;
    public MyRunnable(int param){
        this.param=param;
    }

    @Override
    public void run() {
        for (int i = 0; i <10 ; i++) {
            System.out.println(param);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException("에러 발생");
            }

        }

    }
}
