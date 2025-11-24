package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {

    private int bisePrice;
    private int discountWholePercentages;

    public DiscountedProduct(String nameProduct, int bisePrice, int discountWholePercentages) {
        super(nameProduct);
        this.bisePrice = bisePrice;
        this.discountWholePercentages = discountWholePercentages;
        if (bisePrice <= 0){
            throw new IllegalArgumentException("Базовая цена должна быть строго больше 0");
        }
        if (discountWholePercentages > 100 || discountWholePercentages < 0) {
            throw new IllegalArgumentException("Процент скидки может быть от 0 до 100 включительно");
        }
    }

    @Override
    public int getPriceProduct() {
        int discountAmount = (bisePrice * discountWholePercentages) / 100;
        return bisePrice - discountAmount;
    }

    @Override
    public String toString() {
        return "имя продукта со скидкой " + getNameProduct() + ": стоиомость " + getPriceProduct() + " (скидка " + discountWholePercentages + "%)";
    }

    @Override
    public boolean isSpecial() {
        return true;
    }
}