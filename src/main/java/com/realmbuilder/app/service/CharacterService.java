package com.realmbuilder.app.service;

import com.realmbuilder.app.domain.Character;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing {@link Character}.
 */
public interface CharacterService {
    /**
     * Save a character.
     *
     * @param character the entity to save.
     * @return the persisted entity.
     */
    Character save(Character character);

    /**
     * Updates a character.
     *
     * @param character the entity to update.
     * @return the persisted entity.
     */
    Character update(Character character);

    /**
     * Partially updates a character.
     *
     * @param character the entity to update partially.
     * @return the persisted entity.
     */
    Optional<Character> partialUpdate(Character character);

    /**
     * Get all the characters.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<Character> findAll(Pageable pageable);

    /**
     * Get the "id" character.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<Character> findOne(Long id);

    /**
     * Delete the "id" character.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
