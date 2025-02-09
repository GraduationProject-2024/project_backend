package com.mediko.mediko_server.domain.recommend.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mediko.mediko_server.domain.member.domain.BasicInfo;
import com.mediko.mediko_server.domain.member.domain.HealthInfo;
import com.mediko.mediko_server.domain.recommend.domain.Hospital;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class HospitalRequestDTO {

    private Long basicInfoId;

    private Long healthInfoId;

    @JsonProperty("lat")
    private Double userLatitude;

    @JsonProperty("lon")
    private Double userLongitude;

    @JsonProperty("is_report")
    private boolean isReport;

    private Long reportId;

    @JsonProperty("department")
    private String userDepartment;

    @JsonProperty("suspected_disease")
    private List<String> suspectedDisease;

    @JsonProperty("secondary_hospital")
    private boolean secondaryHospital;

    @JsonProperty("tertiary_hospital")
    private boolean tertiaryHospital;

    public Hospital toEntity(BasicInfo basicInfo, HealthInfo healthInfo) {
        return Hospital.builder()
                .userLatitude(this.userLatitude)
                .userLongitude(this.userLongitude)
                .isReport(this.isReport)
                .userDepartment(this.userDepartment)
                .suspectedDisease(this.suspectedDisease)
                .secondaryHospital(this.secondaryHospital)
                .tertiaryHospital(this.tertiaryHospital)
                .basicInfo(basicInfo)
                .healthInfo(healthInfo)
                .build();
    }
}

