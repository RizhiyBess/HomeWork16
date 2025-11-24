package org.skypro.skyshop.product;

public class SimpleProduct extends Product {

    private int price;

    public SimpleProduct(String nameProduct, int price) {
        super(nameProduct);
        this.price = price;
        if (price <= 0){
            throw new IllegalArgumentException("Цена должна быть строго больше 0");
        }
    }

    @Override
    public int getPriceProduct() {
        return price;
    }

    @Override
    public String toString() {
        return "имя продукта " + getNameProduct() + ": стоимость " + getPriceProduct();
    }

    @Override
    public boolean isSpecial() {
        return false;
    }
}