package com.mediko.mediko_server.domain.recommend.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mediko.mediko_server.domain.recommend.domain.Er;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ErResponseDTO {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("dutyName")
    private String name;

    @JsonProperty("dutyAddr")
    private String address;

    @JsonProperty("dutyTel3")
    private String tel;

    @JsonProperty("hvamyn")
    private String hvamyn;

    @JsonProperty("is_trauma")
    private Boolean isTrauma;

    @JsonProperty("transit_travel_distance_km")
    private Double travelKm;

    @JsonProperty("transit_travel_time_h")
    private Integer travelH;

    @JsonProperty("transit_travel_time_m")
    private Integer travelM;

    @JsonProperty("transit_travel_time_s")
    private Integer travelS;

    @JsonProperty("wgs84Lat")
    private Double erLatitude;

    @JsonProperty("wgs84Lon")
    private Double erLongitude;

    public static ErResponseDTO fromEntity(Er er) {
        return new ErResponseDTO(
                er.getId(),
                er.getName(),
                er.getAddress(),
                er.getTel(),
                er.getHvamyn(),
                er.getIsTrauma(),
                er.getTravelKm(),
                er.getTravelH(),
                er.getTravelM(),
                er.getTravelS(),
                er.getErLatitude(),
                er.getErLongitude()
        );
    }
}
