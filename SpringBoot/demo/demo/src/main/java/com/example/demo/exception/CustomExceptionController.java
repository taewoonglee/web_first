package com.example.demo.exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
@RestControllerAdvice
public class CustomExceptionController {
    @ExceptionHandler(NullPointerException.class)
    @ResponseStatus(HttpStatus.OK)
    public String notFound(MemberNotFound e){
        e.printStackTrace();
        System.out.println(e.getApi()+ "를 하는데 " + e.getMemberId()+ "이 놈이 없어서 사고가 났어요");
        return e.getMessage();
    }
}
