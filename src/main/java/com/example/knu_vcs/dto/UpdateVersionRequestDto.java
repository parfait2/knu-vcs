package com.example.knu_vcs.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class UpdateVersionRequestDto {

    private String os;
    private String ver;
    private int updatetype;
    private String message;
}
