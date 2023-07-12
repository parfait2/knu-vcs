package com.example.knu_vcs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing // Version에서 등록 시간

@SpringBootApplication
public class KnuVcsApplication {

    public static void main(String[] args) {
        SpringApplication.run(KnuVcsApplication.class, args);
    }

}
