package org.skypro.skyshop.product;

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
