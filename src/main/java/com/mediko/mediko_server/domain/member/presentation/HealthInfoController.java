package com.mediko.mediko_server.domain.member.presentation;

import com.mediko.mediko_server.domain.member.application.CustomUserDetails;
import com.mediko.mediko_server.domain.member.application.HealthInfoService;
import com.mediko.mediko_server.domain.member.dto.request.HealthInfoRequestDTO;
import com.mediko.mediko_server.domain.member.dto.response.HealthInfoResponseDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/healthInfo")
public class HealthInfoController {

    HealthInfoService healthInfoService;

    // HealthInfo 저장
    @PostMapping("/health-info")
    public ResponseEntity<String> saveHealthInfo(
            @AuthenticationPrincipal CustomUserDetails customUserDetails,
            @RequestBody HealthInfoRequestDTO healthInfoRequestDTO) {
        String loginId = customUserDetails.getUsername();
        String savedLoginId = healthInfoService.saveHealthInfo(loginId, healthInfoRequestDTO);
        return ResponseEntity.status(CREATED).body(savedLoginId);
    }

    // HealthInfo 조회
    @GetMapping("/health-info")
    public ResponseEntity<HealthInfoResponseDTO> getHealthInfo(
            @AuthenticationPrincipal CustomUserDetails customUserDetails) {
        String loginId = customUserDetails.getUsername();
        HealthInfoResponseDTO healthInfoResponseDTO = healthInfoService.getHealthInfo(loginId);
        return ResponseEntity.ok(healthInfoResponseDTO);
    }

    // HealthInfo 수정
    @PatchMapping("/health-info")
    public ResponseEntity<HealthInfoResponseDTO> updateHealthInfo(
            @AuthenticationPrincipal CustomUserDetails customUserDetails,
            @RequestBody HealthInfoRequestDTO healthInfoRequestDTO) {
        String loginId = customUserDetails.getUsername();
        HealthInfoResponseDTO updatedHealthInfo = healthInfoService.updateHealthInfo(loginId, healthInfoRequestDTO);
        return ResponseEntity.ok(updatedHealthInfo);
    }
}