package com.realmbuilder.app.service.dto;

import com.realmbuilder.app.domain.Attributes;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AttributesDTO {

    private String name;
    private Integer strength;

    public AttributesDTO(Attributes attributes) {
        this.name = attributes.getName();
        this.strength = attributes.getStrength();
    }
}
