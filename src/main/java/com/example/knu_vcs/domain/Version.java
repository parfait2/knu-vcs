package com.example.knu_vcs.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@DynamicInsert
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
@Entity
public class Version {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "os", nullable = false)
    private String os;

    @Column(name = "ver", nullable = false)
    private String ver;

    @Column(name = "updatetype", nullable = false)
    private int updatetype;

    @Column(name = "message")
    private String message;

    @Column(name = "package_info", nullable = false)
    private String packageInfo;

    @ColumnDefault("false")
    @Column(name = "is_deleted")
    private boolean isDeleted;

    @CreatedDate
    @Column(name = "regdate")
    private LocalDateTime regdate;

    @Builder
    public Version(String os, String ver, int updatetype, String message, String packageInfo, boolean isDeleted) {
        this.os = os;
        this.ver = ver;
        this.updatetype = updatetype;
        this.message = message;
        this.packageInfo = packageInfo;
        this.isDeleted = isDeleted;

    }

    @Builder
    public Version(String os, String ver, int updatetype, String message, String packageInfo) {
        this.os = os;
        this.ver = ver;
        this.updatetype = updatetype;
        this.message = message;
        this.packageInfo = packageInfo;

    }

    public void delete(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }
    public void update(String os, String ver, int updatetype, String message) {
        this.os = os;
        this.ver = ver;
        this.updatetype = updatetype;
        this.message = message;
    }
}
