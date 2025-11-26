package org.skypro.skyshop.product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SearchEngine {

    private final List<Searchable> searchables;

    public SearchEngine() {
        this.searchables = new ArrayList<>();
    }

    public Map<String, Searchable> search(String searchString){
        Map<String, Searchable> resultMap = new HashMap<>();
        for (Searchable s : searchables) {
            if (s != null && s.getSearchTerm().contains(searchString)) {
                resultMap.put(s.getStringRepresentation(), s);
            }
        }
        return resultMap;
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
