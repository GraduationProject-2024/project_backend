package com.mediko.mediko_server.domain.recommend.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mediko.mediko_server.domain.member.domain.BasicInfo;
import com.mediko.mediko_server.domain.member.domain.Location;
import com.mediko.mediko_server.domain.recommend.domain.Pharmacy;
import io.micrometer.common.lang.Nullable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PharmacyRequestDTO {

    @JsonProperty("lat")
    private Double userLatitude;

    @JsonProperty("lon")
    private Double userLongitude;

    public Pharmacy toEntity(BasicInfo basicInfo) {
        return Pharmacy.builder()
                .basicInfo(basicInfo)
                .userLatitude(this.userLatitude)
                .userLongitude(this.userLongitude)
                .build();
    }
}
