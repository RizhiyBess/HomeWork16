package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.Arrays;

public class ProductBasket {
    private final static int maxProducts = 5;
    private Product[] products = new Product[maxProducts];
    private int a = 0;

    public void addingProduct(Product product) {
        if (a >= maxProducts) {
            System.out.println("Невозможно добавить продукт");
            return;
        }
        products[a++] = product;
        System.out.println(product);
        System.out.println("Специальных товаров: " + countSpecialProducts());
    }

    int countSpecialProducts() {
        int specialCount = 0;
        for(Product i : products) {
            if(i != null && i.isSpecial()) {
                specialCount++;
            }
        }
        return specialCount;
    }

    public int totalCost() {
        int sum = 0;
        for (Product b : products) {
            if (b != null)
                sum += b.getPriceProduct();
        }
        return sum;
    }

    public void printProduct() {
        boolean empty = true;
        for (Product b : products) {
            if (b != null) {
                System.out.println(b.getNameProduct() + ": " + b.getPriceProduct());
                empty = false;
            }
        }
        if (empty) {
            System.out.println("В корзине пусто");
        }
    }

    public boolean checkingProductAvailability(String name) {
        for (Product b : products) {
            if (b != null && b.getNameProduct().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public void clearBasket() {
        for (int c = 0; c < maxProducts; c++) {
            products[c] = null;
        }
        a = 0;
    }
}