package com.mediko.mediko_server.domain.openai.application;

import com.mediko.mediko_server.domain.openai.domain.SubBodyPart;
import com.mediko.mediko_server.domain.openai.domain.repository.SubBodyPartRepository;
import com.mediko.mediko_server.domain.openai.dto.response.SubBodyPartResponseDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class SubBodyPartService {
    private final SubBodyPartRepository subBodyPartRepository;

    // 세부 신체 전체 조회
    public List<SubBodyPartResponseDTO> findAll() {
        List<SubBodyPart> allSubBodyParts = subBodyPartRepository.findAll();
        return allSubBodyParts.stream()
                .map(SubBodyPartResponseDTO::fromEntity)
                .collect(Collectors.toList());
    }

    // 세부 신체 부분 조회
    public List<SubBodyPart> getSubBodyPartsByMainBodyPartBodies(List<String> bodies) {
        return subBodyPartRepository.findAllByMainBodyPartBodies(bodies);
    }
}
