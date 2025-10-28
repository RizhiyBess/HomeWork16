package org.skypro.skyshop.product;

public abstract class Product {

    private String nameProduct;

    public Product(String nameProduct) {
        this.nameProduct = nameProduct;
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
}