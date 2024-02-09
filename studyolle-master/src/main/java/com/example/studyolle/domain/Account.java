package com.example.studyolle.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
@Entity
@Getter @Setter
@EqualsAndHashCode(of = "id")
@Builder @AllArgsConstructor @NoArgsConstructor
public class Account {

    //로그인
    @Id @GeneratedValue
    private Long id;
    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private String nickname;
    private String password;
    private boolean emailVerified;
    private String emailCheckToken;
    private LocalDateTime joinedAt;

    //프로필
    private String bio;
    private String occupation;
    private String liveAround;
    @Lob @Basic(fetch = FetchType.EAGER)
    private String profileImage;

    //알림설정
    private String studyCreatedByEmail;
    private String studyCreatedByWeb;
    private String studyEnrollmentResultByEmail;
    private String StudyEnrollmentResultByWeb;
    private String StudyUpdateByEmail;
    private String studyUpdateByWeb;
}
