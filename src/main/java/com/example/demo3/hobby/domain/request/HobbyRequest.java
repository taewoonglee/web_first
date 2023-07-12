package com.example.demo3.hobby.domain.request;

import jakarta.persistence.Table;
import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "hobbies")
@Setter

public class HobbyRequest {
    private String name;
}
