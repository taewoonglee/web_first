package controller;
import service.Service;

import java.util.Scanner;
public class Controller {
    private final Scanner sc;
    private final Service service;

    public Controller(Scanner sc) {
        this.sc = sc;
        service = Service.getInstance();
    }

    /**
     * 기능 : 모드를 찾아 검색하다.
     * @param i : None
     * @return : None
     */
    public void selectMode(){
        int mode;
        try {
            mode=Integer.parseInt(sc.nextLine());
        }
        catch (Exception e){
            mode=0;

        }
        if(mode==1)
        {
            service.insert(sc.nextInt());
            //TO DO : insert 기능 만들기
        }
        else if(mode==2)
        {
            //TO DO : 전체찾기 기능
        }else if(mode==3)
        {
            //TO DO 인덱스를 입력받아 찾는거
        }
        else {
            //TO DO : select Mode 다시 실행
        }

    }

}
