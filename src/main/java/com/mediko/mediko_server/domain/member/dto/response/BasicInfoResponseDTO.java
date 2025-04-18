package com.mediko.mediko_server.domain.member.dto.response;

import com.mediko.mediko_server.domain.member.domain.BasicInfo;
import com.mediko.mediko_server.domain.member.domain.infoType.Gender;
import com.mediko.mediko_server.domain.member.domain.infoType.Language;
import com.mediko.mediko_server.domain.member.domain.Member;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BasicInfoResponseDTO {

    private Language language;

    private String number;

    private String address;

    private Gender gender;

    private Integer age;

    private Integer height;

    private Integer weight;


    public static BasicInfoResponseDTO fromEntity(BasicInfo basicInfo) {
        return new BasicInfoResponseDTO(
                basicInfo.getLanguage(),
                basicInfo.getNumber(),
                basicInfo.getAddress(),
                basicInfo.getGender(),
                basicInfo.getAge(),
                basicInfo.getHeight(),
                basicInfo.getWeight()
        );
    }
}
