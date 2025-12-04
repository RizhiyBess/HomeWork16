package org.skypro.skyshop.product;

import java.util.Objects;

public abstract class Product implements Searchable {

    private String nameProduct;

    public Product(String nameProduct) {
        this.nameProduct = nameProduct;
        if (nameProduct == null || nameProduct.isBlank()) {
            throw new IllegalArgumentException("Название продукта не может быть пустым или null.");
        }
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public abstract boolean isSpecial();

    public abstract int getPriceProduct();

    @Override
    public String toString() {
        return "Product{" +
                "nameProduct='" + nameProduct + '\'' +
                '}';
    }

    @Override
    public String getSearchTerm() {
        return nameProduct;
    }

    @Override
    public String getContentType() {
        return "PRODUCT";
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(nameProduct, product.nameProduct);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(nameProduct);
    }
}