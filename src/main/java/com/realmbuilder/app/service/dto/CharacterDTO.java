package com.realmbuilder.app.service.dto;

import com.realmbuilder.app.domain.Character;
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
public class CharacterDTO {

    private String firstName;
    private String secondName;
    private String race;
    private String classification;
    private String description;
    private String image;
    private long gameId;

    public CharacterDTO(Character character) {
        this.firstName = character.getFirstName();
        this.secondName = character.getSecondName();
        this.race = character.getRace();
        this.classification = character.getClassification();
        this.description = character.getDescription();
        this.image = character.getImage();
        this.gameId = character.getGame().getId();
    }
}
