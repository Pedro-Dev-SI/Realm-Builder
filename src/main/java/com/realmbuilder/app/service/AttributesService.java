package com.realmbuilder.app.service;

import com.realmbuilder.app.domain.Attributes;
import com.realmbuilder.app.repository.AttributesRepository;
import java.util.List;
import java.util.Optional;
import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@Getter
@Setter
public class AttributesService {

    private final Logger log = LoggerFactory.getLogger(AttributesService.class);

    private final AttributesRepository attributesRepository;

    public AttributesService(AttributesRepository attributesRepository) {
        this.attributesRepository = attributesRepository;
    }

    public Attributes save(Attributes attributes) {
        log.debug("Request to save Attributes : {}", attributes);
        return attributesRepository.save(attributes);
    }

    public Attributes update(Attributes attributes) {
        log.debug("Request to update Attributes : {}", attributes);
        return attributesRepository.save(attributes);
    }

    public Optional<Attributes> partialUpdate(Attributes attributes) {
        log.debug("Request to partially update Attributes : {}", attributes);

        return attributesRepository
            .findById(attributes.getId())
            .map(existingAttributes -> {
                if (attributes.getName() != null) {
                    existingAttributes.setName(attributes.getName());
                }
                if (attributes.getStrength() != null) {
                    existingAttributes.setStrength(attributes.getStrength());
                }

                return existingAttributes;
            })
            .map(attributesRepository::save);
    }

    @Transactional(readOnly = true)
    public List<Attributes> findAll() {
        log.debug("Request to get all Attributes");
        return attributesRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Attributes> findOne(Long id) {
        log.debug("Request to get Attributes : {}", id);
        return attributesRepository.findById(id);
    }

    public void delete(Long id) {
        log.debug("Request to delete Attributes : {}", id);
        attributesRepository.deleteById(id);
    }
}
