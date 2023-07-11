package com.example.knu_vcs.dto;

import com.example.knu_vcs.domain.Version;

import javax.persistence.Column;

public class VersionResponseDto {

    private String os;
    private String ver;
    private int updatetype;
    private String message;
    private String packageInfo;

    public VersionResponseDto(Version version) {
        this.os = os;
        this.ver = ver;
        this.updatetype = updatetype;
        this.message = message;
        this.packageInfo = packageInfo;
    }
}
