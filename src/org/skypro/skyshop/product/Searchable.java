package org.skypro.skyshop.product;

import java.util.Comparator;

public interface Searchable {

    String getSearchTerm();

    String getContentType();

    default String getStringRepresentation() {
        return this.getSearchTerm() + " - " + this.getContentType();
    }
}
