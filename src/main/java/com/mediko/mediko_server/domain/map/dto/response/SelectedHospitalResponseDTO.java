package com.mediko.mediko_server.domain.map.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mediko.mediko_server.domain.map.domain.SelectedHospital;
import com.mediko.mediko_server.domain.recommend.domain.Hospital;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SelectedHospitalResponseDTO {
    @JsonProperty("id")
    private Long hpId;

    @JsonProperty("name")
    private String name;

    @JsonProperty("department")
    private String hpDepartment;

    @JsonProperty("telephone")
    private String telephone;

    @JsonProperty("address")
    private String hpAddress;

    @JsonProperty("phLatitude")
    private Double hpLatitude;

    @JsonProperty("longitude")
    private Double hpLongitude;

    @JsonProperty("location")
    private List<Double> latLon;

    @JsonProperty("sidocdnm")
    private String sidocdnm;

    @JsonProperty("sggucdnm")
    private String sggucdnm;

    @JsonProperty("emdongnm")
    private String emdongnm;

    @JsonProperty("clcdnm")
    private String clcdnm;

    @JsonProperty("es_distance_in_km")
    private Double esDistanceInKm;

    @JsonProperty("transit_travel_distance_km")
    private Double travelKm;

    @JsonProperty("transit_travel_time_h")
    private Integer travelH;

    @JsonProperty("transit_travel_time_m")
    private Integer travelM;

    @JsonProperty("transit_travel_time_s")
    private Integer travelS;

    @JsonProperty("sort_score")
    private Long sortScore;

    @JsonProperty("department_match")
    private Boolean departmentMatch;

    @JsonProperty("similarity")
    private Double similarity;

    @JsonProperty("url")
    private String url;


    public static SelectedHospitalResponseDTO fromEntity(
            Hospital hospital, SelectedHospital selectedHospital) {
        return new SelectedHospitalResponseDTO(
                hospital.getHpId(),
                hospital.getName(),
                hospital.getHpDepartment(),
                hospital.getTelephone(),
                hospital.getHpAddress(),
                hospital.getHpLatitude(),
                hospital.getHpLongitude(),
                hospital.getLatLon(),
                hospital.getSidocdnm(),
                hospital.getSggucdnm(),
                hospital.getEmdongnm(),
                hospital.getClcdnm(),
                hospital.getEsDistanceInKm(),
                hospital.getTravelKm(),
                hospital.getTravelH(),
                hospital.getTravelM(),
                hospital.getTravelS(),
                hospital.getSortScore(),
                hospital.isDepartmentMatch(),
                hospital.getSimilarity(),
                hospital.getUrl()
        );
    }
}
