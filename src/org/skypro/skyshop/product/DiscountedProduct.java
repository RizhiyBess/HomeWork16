package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {

    private int bisePrice;
    private int discountWholePercentages;

    public DiscountedProduct(String nameProduct, int bisePrice, int discountWholePercentages) {
        super(nameProduct);
        this.bisePrice = bisePrice;
        this.discountWholePercentages = discountWholePercentages;
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