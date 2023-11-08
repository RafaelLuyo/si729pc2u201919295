package io.newschool.platform.u201919295.profiles.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

    @Embeddable
    public record Dni(Long dni) {
        public Dni() {
            this(null);
        }

        public Dni {
            if (dni == null) {
                throw new IllegalArgumentException("DNI cannot be null");
            }


        }
    }
