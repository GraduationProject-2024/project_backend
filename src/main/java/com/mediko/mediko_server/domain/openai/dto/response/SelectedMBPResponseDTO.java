package com.mediko.mediko_server.domain.openai.dto.response;

import com.mediko.mediko_server.domain.openai.domain.SelectedMBP;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class SelectedMBPResponseDTO {

    private List<String> description;

    private Long selectedMBPId;

    public static SelectedMBPResponseDTO fromEntity(
            SelectedMBP selectedMBP,
            List<String> descriptions) {
        return new SelectedMBPResponseDTO(
                descriptions,
                selectedMBP.getId()
        );
    }
}
