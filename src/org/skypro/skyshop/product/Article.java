package org.skypro.skyshop.product;

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
}

