package com.example.knu_vcs.service;

import com.example.knu_vcs.domain.Version;
import com.example.knu_vcs.dto.AddVersionRequestDto;
import com.example.knu_vcs.dto.VersionResponseDto;
import com.example.knu_vcs.repository.VersionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
@Service
public class VersionService {

    private final VersionRepository versionRepository;

    public List<Version> findAll() {
        return versionRepository.findAll();
    }

    /**
     * 버전 정보 번호 조회
     * */
//    public Page<Long> findAll(Long id, int size, Long lastArticleId) {
//        Pageable pageable = PageRequest.of(0, size);
//        Page<Long> articleSeqs;
//
//        if (lastArticleId == null) {
//            articleSeqs = versionRepository.findArticleSeqListInFeedFirst(id, pageable);
//            return articleSeqs;
//        }
//        else {
//            articleSeqs = versionRepository.findArticleSeqListInFeed(id, lastArticleId, pageable);
//            return articleSeqs;
//        }
//
//
//
//        return versionRepository.findAll();
//    }

    public Version findById(Long id) {
        return versionRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("version not exist! : " + id));
    }

    public Version save(AddVersionRequestDto requestDto) {
        return versionRepository.save(requestDto.toEntity()); // dto 형태로 저장할 수 없다.

    }

    /**
     * 삭제
     * update한 후 isDeleted flag 값을 Y로 변경.
     */
    @Transactional
    public Version delete(Long id) {

        Version version = versionRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("article not exist! : " + id));

        version.delete(true);

        return version;
    }
}
