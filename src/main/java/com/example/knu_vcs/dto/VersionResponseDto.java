package com.example.knu_vcs.dto;

import com.example.knu_vcs.domain.Version;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class VersionResponseDto {

    private String ver;
    private int updatetype;

    public VersionResponseDto(Version version) {
        this.ver = version.getVer();
        this.updatetype = version.getUpdatetype();
    }
}
