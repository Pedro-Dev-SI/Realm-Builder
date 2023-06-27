package com.realmbuilder.app.service.dto;

import com.realmbuilder.app.domain.Game;
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
public class GameDTO {

    private String title;
    private String subTitle;
    private String description;
    private String imageUrl;

    public GameDTO(Game game) {
        this.title = game.getTitle();
        this.subTitle = game.getSubtitle();
        this.description = game.getDescription();
        this.imageUrl = game.getImageUrl();
    }
}
