package controller;

import dto.SignupDto;
import service.UserService;

import java.sql.SQLException;
import java.util.Scanner;

public class Controller {
    public void selectMode() throws SQLException {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("1. 로그인 2. 회원가입");
            String mode = sc.nextLine();
            switch (mode){
                case "1":
                    login(sc);
                    break;
                case "2":
                    signup(sc);
                    break;

            }
        }
    }

    private static void login(Scanner sc) throws SQLException {
        System.out.println("insert id : ");
        String id = sc.nextLine();
        System.out.println("insert pw : ");
        String pw = sc.nextLine();
        UserService service = UserService.getInstance();
        service.login(id, pw);
    }

    private static void signup(Scanner sc) throws SQLException {
        System.out.println("insert id : ");
        String id = sc.nextLine();
        System.out.println("insert pw : ");
        String pw = sc.nextLine();
        System.out.println("insert name : ");
        String name = sc.nextLine();
        UserService service = UserService.getInstance();
        SignupDto dto = new SignupDto(id,pw, name);
        service.signup(dto);
    }


}
