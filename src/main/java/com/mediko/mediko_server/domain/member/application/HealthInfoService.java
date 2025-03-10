package com.mediko.mediko_server.domain.member.application;

import com.mediko.mediko_server.domain.member.domain.HealthInfo;
import com.mediko.mediko_server.domain.member.domain.Member;
import com.mediko.mediko_server.domain.member.domain.repository.HealthInfoRepository;
import com.mediko.mediko_server.domain.member.dto.request.HealthInfoRequestDTO;
import com.mediko.mediko_server.domain.member.dto.response.HealthInfoResponseDTO;
import com.mediko.mediko_server.global.exception.exceptionType.BadRequestException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.mediko.mediko_server.global.exception.ErrorCode.DATA_ALREADY_EXIST;
import static com.mediko.mediko_server.global.exception.ErrorCode.DATA_NOT_EXIST;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class HealthInfoService {

    private final HealthInfoRepository healthInfoRepository;

    //사용자 건강정보 저장
    @Transactional
    public HealthInfoResponseDTO createHealthInfo(Member member, HealthInfoRequestDTO healthInfoRequestDTO) {
        if (healthInfoRepository.existsByMember(member)) {
            throw new BadRequestException(DATA_ALREADY_EXIST, "사용자의 건강정보가 이미 저장되었습니다.");
        }

        HealthInfo healthInfo = HealthInfo.createHealthInfo(member);
        healthInfo.updateHealthInfo(healthInfoRequestDTO);

        return HealthInfoResponseDTO.fromEntity(healthInfo);
    }

    //사용자 건강정보 조회
    public HealthInfoResponseDTO getHealthInfo(Member member) {
        HealthInfo healthInfo = healthInfoRepository.findByMember(member)
                .orElseThrow(() -> new BadRequestException(DATA_NOT_EXIST, "사용자의 건강 정보가 설정되지 않았습니다."));

        return HealthInfoResponseDTO.fromEntity(healthInfo);
    }

    //사용자 건강정보 수정
    @Transactional
    public HealthInfoResponseDTO updateHealthInfo(Member member, HealthInfoRequestDTO healthInfoRequestDTO) {
        HealthInfo healthInfo = healthInfoRepository.findByMember(member)
                .orElseThrow(() -> new BadRequestException(DATA_NOT_EXIST, "사용자의 건강 정보가 설정되지 않았습니다."));

        healthInfo.updateHealthInfo(healthInfoRequestDTO);

        return HealthInfoResponseDTO.fromEntity(healthInfo);
    }
}

