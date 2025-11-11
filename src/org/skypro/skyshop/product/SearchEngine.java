package org.skypro.skyshop.product;

import java.util.ArrayList;
import java.util.List;

public class SearchEngine {

    private final Searchable[] searchables;
    private int currentSize;

    public SearchEngine(int foundCount) {
        this.searchables = new Searchable[foundCount];
        this.currentSize = 0;
    }

    public Searchable[] search(String searchString) {
        Searchable[] results = new Searchable[5];
        int foundCount = 0;
        for (Searchable s : searchables) {
            if (s != null && s.getSearchTerm().contains(searchString)) {
                results[foundCount++] = s;
                if (foundCount == 5) break;
            }
        }
        return results;
    }

    public void add(Searchable searchable) {
        if (currentSize < searchables.length) {
            searchables[currentSize++] = searchable;
        } else {
            throw new IllegalStateException("Массив заполнен");
        }
    }
}
