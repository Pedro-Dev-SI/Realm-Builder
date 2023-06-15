package com.realmbuilder.app.service.impl;

import com.realmbuilder.app.domain.Attributes;
import com.realmbuilder.app.repository.AttributesRepository;
import com.realmbuilder.app.service.AttributesService;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link Attributes}.
 */
@Service
@Transactional
public class AttributesServiceImpl implements AttributesService {

    private final Logger log = LoggerFactory.getLogger(AttributesServiceImpl.class);

    private final AttributesRepository attributesRepository;

    public AttributesServiceImpl(AttributesRepository attributesRepository) {
        this.attributesRepository = attributesRepository;
    }

    @Override
    public Attributes save(Attributes attributes) {
        log.debug("Request to save Attributes : {}", attributes);
        return attributesRepository.save(attributes);
    }

    @Override
    public Attributes update(Attributes attributes) {
        log.debug("Request to update Attributes : {}", attributes);
        return attributesRepository.save(attributes);
    }

    @Override
    public Optional<Attributes> partialUpdate(Attributes attributes) {
        log.debug("Request to partially update Attributes : {}", attributes);

        return attributesRepository
            .findById(attributes.getId())
            .map(existingAttributes -> {
                if (attributes.getName() != null) {
                    existingAttributes.setName(attributes.getName());
                }
                if (attributes.getQtd() != null) {
                    existingAttributes.setQtd(attributes.getQtd());
                }

                return existingAttributes;
            })
            .map(attributesRepository::save);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Attributes> findAll() {
        log.debug("Request to get all Attributes");
        return attributesRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Attributes> findOne(Long id) {
        log.debug("Request to get Attributes : {}", id);
        return attributesRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete Attributes : {}", id);
        attributesRepository.deleteById(id);
    }
}
