package com.example._test.memberlogin.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="memberlogins")
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class MemberLogin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer memberId;
    private String create_at;
    private String endAt;


    public MemberLogin(Integer memberId, String create_at, String endAt) {
        this.memberId = memberId;
        this.create_at = create_at;
        this.endAt = endAt;
    }
}


