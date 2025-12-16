package org.skypro.skyshop.product;

import java.util.*;
import java.util.stream.Collectors;

public class SearchEngine {

    private final Set<Searchable> searchables;

    public SearchEngine() {
        this.searchables = new HashSet<>();
    }

    public Set<Searchable> search(String searchString) {
        return searchables.stream()
                .filter(s -> s != null && s.getSearchTerm().contains(searchString)).collect(Collectors.toCollection(() -> new TreeSet<>(new MyComporator())));
    }

    public void add(Searchable searchable) {
        searchables.add(searchable);
    }

    public Searchable findBestMatch(String search) throws BestResultNotFound {
        int maxCount = 0;
        Searchable mostFrequentObject = null;

        for (Searchable s : searchables) {
            if (s != null) {
                String currentString = s.getSearchTerm();
                long count = currentString.split(search).length - 1;
                if (count > maxCount) {
                    maxCount = (int) count;
                    mostFrequentObject = s;
                }
            }
        }
        if (mostFrequentObject == null) {
            throw new BestResultNotFound("Не найдено подходящего результата для поиска: " + search);
        }
        return mostFrequentObject;
    }

}
