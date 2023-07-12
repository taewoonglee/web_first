package com.example.demo3.hobby.domain.request;

import jakarta.persistence.Table;
import lombok.*;

@Getter
@AllArgsConstructor
@Builder
@Table(name = "members")
@Setter
public class WordRequest {
    private String name;


    public WordRequest() {
    }

    public String getName() {
        return name;
    }
}
