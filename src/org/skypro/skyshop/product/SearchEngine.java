package org.skypro.skyshop.product;

import java.util.*;

public class SearchEngine {

    private final Set<Searchable> searchables;

    public SearchEngine() {
        this.searchables = new HashSet<>();
    }

    public Set<Searchable> search(String searchString) {
        Set<Searchable> resultSet = new TreeSet<>(new MyComporator());
        for (Searchable s : searchables) {
            if (s != null && s.getSearchTerm().contains(searchString)) {
                resultSet.add(s);
            }
        }
        return resultSet;
    }

    public class MyComporator implements Comparator<Searchable> {
        @Override
        public int compare(Searchable s1, Searchable s2) {
            int lengthComparison = Integer.compare(
                    s2.getSearchTerm().length(),
                    s1.getSearchTerm().length());
            if (lengthComparison != 0) {
                return lengthComparison;
            }
            return s1.getSearchTerm().compareTo(s2.getSearchTerm());
        }
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
