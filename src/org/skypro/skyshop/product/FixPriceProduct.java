package org.skypro.skyshop.product;

public class FixPriceProduct extends Product {

    public static final int FIX_PRICE_PRODUCT = 165;

    public FixPriceProduct(String nameProduct) {
        super(nameProduct);
    }

    @Override
    public int getPriceProduct() {
        return FIX_PRICE_PRODUCT;
    }

    @Override
    public String toString() {
        return "имя продукта с фиксированной ценой " + getNameProduct() + ": Фиксированная цена " + FIX_PRICE_PRODUCT;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }
}
