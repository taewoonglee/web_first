package com.example.demo3.hobby.domain.request;

import com.example.demo3.hobby.domain.entity.Hobby;
import com.example.demo3.hobby.domain.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public class ConnectRequest {
    private Member member;
    private Hobby hobby;

}
