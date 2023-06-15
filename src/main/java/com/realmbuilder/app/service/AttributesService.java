package com.realmbuilder.app.service;

import com.realmbuilder.app.domain.Attributes;
import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link Attributes}.
 */
public interface AttributesService {
    /**
     * Save a attributes.
     *
     * @param attributes the entity to save.
     * @return the persisted entity.
     */
    Attributes save(Attributes attributes);

    /**
     * Updates a attributes.
     *
     * @param attributes the entity to update.
     * @return the persisted entity.
     */
    Attributes update(Attributes attributes);

    /**
     * Partially updates a attributes.
     *
     * @param attributes the entity to update partially.
     * @return the persisted entity.
     */
    Optional<Attributes> partialUpdate(Attributes attributes);

    /**
     * Get all the attributes.
     *
     * @return the list of entities.
     */
    List<Attributes> findAll();

    /**
     * Get the "id" attributes.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<Attributes> findOne(Long id);

    /**
     * Delete the "id" attributes.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
