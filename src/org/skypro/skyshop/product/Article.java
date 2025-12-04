package org.skypro.skyshop.product;

import java.util.Comparator;
import java.util.Objects;

public class Article implements Searchable {

    private String titleArticle;
    private String textArticle;

    public Article(String titleArticle, String textArticle) {
        this.titleArticle = titleArticle;
        this.textArticle = textArticle;
    }

    @Override
    public String toString() {
        return "Название статьи - " + titleArticle + "\nТекст статьи - " + textArticle;
    }

    @Override
    public String getSearchTerm() {
        return "Название статьи - " + titleArticle + "\nТекст статьи - " + textArticle;
    }

    @Override
    public String getContentType() {
        return "ARTICLE";
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Article article = (Article) o;
        return Objects.equals(titleArticle, article.titleArticle);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(titleArticle);
    }
}


