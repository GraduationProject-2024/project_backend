package com.mediko.mediko_server.domain.openai.dto.response;

import com.mediko.mediko_server.domain.openai.domain.SelectedSBP;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class SelectedSBPResponseDTO {
    private List<String> body;
    private List<Long> sbpIds;
    private Long mbpId;
    private Long memberId;

    public static SelectedSBPResponseDTO fromEntity(SelectedSBP selectedSBP) {
        return new SelectedSBPResponseDTO(
                selectedSBP.getBody(),
                selectedSBP.getSbpIds(),
                selectedSBP.getMbpId(),
                selectedSBP.getMember().getId()
        );
    }
}
