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
    private String classType;
    private String description;
    private String imageUrl;
    private long gameId;

    public CharacterDTO(Character character) {
        this.firstName = character.getFirstName();
        this.secondName = character.getSecondName();
        this.race = character.getRace();
        this.classType = character.getClassType();
        this.description = character.getDescription();
        this.imageUrl = character.getImageUrl();
        this.gameId = character.getGame().getId();
    }
}
