package com.example.knu_vcs.dto;

import com.example.knu_vcs.domain.Version;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class AddVersionRequestDto {

    private String os;
    private String ver;
    private int updatetype;
    private String message;
    private String packageInfo;



    public Version toEntity() {
        return Version.builder()
                .os(os)
                .ver(ver)
                .updatetype(updatetype)
                .message(message)
                .packageInfo(packageInfo)
                .build();
    }
}
