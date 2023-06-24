package com.realmbuilder.app.domain;

import static org.assertj.core.api.Assertions.assertThat;

import com.realmbuilder.app.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class AttributesTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Attributes.class);
        Attributes attributes1 = new Attributes();
        attributes1.setId(1L);
        Attributes attributes2 = new Attributes();
        attributes2.setId(attributes1.getId());
        assertThat(attributes1).isEqualTo(attributes2);
        attributes2.setId(2L);
        assertThat(attributes1).isNotEqualTo(attributes2);
        attributes1.setId(null);
        assertThat(attributes1).isNotEqualTo(attributes2);
    }
}
