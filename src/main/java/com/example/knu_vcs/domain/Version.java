package com.example.knu_vcs.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
@Entity
public class Version {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idx", updatable = false)
    private Long idx;

    @Column(name = "os", nullable = false)
    private String os;

    @Column(name = "ver", nullable = false)
    private String ver;

    @Column(name = "updatetype", nullable = false)
    private int updatetype;

    @Column(name = "message")
    private String message;

    @Column(name = "package", nullable = false)
    private String packageInfo;

    @CreatedDate
    @Column(name = "regdate", nullable = false)
    private LocalDateTime regdate;

    @Builder
    public Version(String os, String ver, int updatetype, String message, String packageInfo) {
        this.os = os;
        this.ver = ver;
        this.updatetype = updatetype;
        this.message = message;
        this.packageInfo = packageInfo;
    }

}
