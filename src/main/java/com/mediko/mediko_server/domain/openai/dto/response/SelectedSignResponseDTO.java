package com.mediko.mediko_server.domain.openai.dto.response;


import com.mediko.mediko_server.domain.openai.domain.SelectedSign;
import com.mediko.mediko_server.domain.openai.domain.SelectedSBP;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class SelectedSignResponseDTO {

    private List<String> sign;

    private Long signId;

    private List<Long> sbpId;

    public static SelectedSignResponseDTO fromEntity(
            SelectedSign selectedSign, SelectedSBP selectedSBP) {
        return new SelectedSignResponseDTO(
                selectedSign.getSign(),
                selectedSign.getId(),
                selectedSBP.getSbpIds()
        );
    }

}
