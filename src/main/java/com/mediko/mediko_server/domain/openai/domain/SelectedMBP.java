package com.mediko.mediko_server.domain.openai.domain;

import com.mediko.mediko_server.domain.member.domain.Member;
import com.mediko.mediko_server.domain.openai.dto.request.SelectedMBPRequestDTO;
import com.mediko.mediko_server.global.converter.LongListConverter;
import com.mediko.mediko_server.global.converter.StringListConvert;
import com.mediko.mediko_server.global.domain.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name= "selected_mbp")
public class SelectedMBP extends BaseEntity {
    @Convert(converter = StringListConvert.class)
    @Column(nullable = false)
    private List<String> body;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @Convert(converter = LongListConverter.class)
    @Column(name = "mbp_id", nullable = false)
    private List<Long> mbpIds;

    public void updateSelectedMBP(SelectedMBPRequestDTO requestDTO, List<Long> mbpIds) {
        if (requestDTO.getDescription() == null) {
            this.body = new ArrayList<>();
            this.mbpIds = new ArrayList<>();
        } else {
            this.body = new ArrayList<>(requestDTO.getDescription());
            this.mbpIds = new ArrayList<>(mbpIds);
        }
    }

}
