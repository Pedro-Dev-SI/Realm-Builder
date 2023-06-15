package com.realmbuilder.app.service.impl;

import com.realmbuilder.app.domain.Game;
import com.realmbuilder.app.repository.GameRepository;
import com.realmbuilder.app.service.GameService;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link Game}.
 */
@Service
@Transactional
public class GameServiceImpl implements GameService {

    private final Logger log = LoggerFactory.getLogger(GameServiceImpl.class);

    private final GameRepository gameRepository;

    public GameServiceImpl(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @Override
    public Game save(Game game) {
        log.debug("Request to save Game : {}", game);
        return gameRepository.save(game);
    }

    @Override
    public Game update(Game game) {
        log.debug("Request to update Game : {}", game);
        return gameRepository.save(game);
    }

    @Override
    public Optional<Game> partialUpdate(Game game) {
        log.debug("Request to partially update Game : {}", game);

        return gameRepository
            .findById(game.getId())
            .map(existingGame -> {
                if (game.getName() != null) {
                    existingGame.setName(game.getName());
                }
                if (game.getSubName() != null) {
                    existingGame.setSubName(game.getSubName());
                }
                if (game.getDescription() != null) {
                    existingGame.setDescription(game.getDescription());
                }

                return existingGame;
            })
            .map(gameRepository::save);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Game> findAll(Pageable pageable) {
        log.debug("Request to get all Games");
        return gameRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Game> findOne(Long id) {
        log.debug("Request to get Game : {}", id);
        return gameRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete Game : {}", id);
        gameRepository.deleteById(id);
    }
}
