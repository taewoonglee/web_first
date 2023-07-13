package com.example.demo3.hobby.domain.request;

import com.example.demo3.hobby.domain.entity.Hobby;
import com.example.demo3.hobby.domain.entity.Member;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor

public class HobbyRequest {
    private String name;
    private Integer id;
}
