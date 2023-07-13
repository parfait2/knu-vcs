package com.example.knu_vcs.dto;

import com.example.knu_vcs.domain.Version;
import lombok.Getter;

import javax.persistence.Column;

@Getter
public class VersionResponseDto {

    private String ver;
    private int updatetype;

    public VersionResponseDto(Version version) {
        this.ver = ver;
        this.updatetype = updatetype;
    }
}
