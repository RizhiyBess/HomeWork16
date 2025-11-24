package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;

public class ProductBasket {
    List<Product> products = new ArrayList<>();

    public void addingProduct(Product product) {
        products.add(product);
        System.out.println(product);
        System.out.println("Специальных товаров: " + countSpecialProducts());
    }

    int countSpecialProducts() {
        int specialCount = 0;
        for (Product i : products) {
            if (i != null && i.isSpecial()) {
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
        products.clear();
    }

    public List<Product> productRemoval(String name) {
        Iterator<Product> iterator = products.iterator();
        List<Product> removedProducts = new ArrayList<>();

        while (iterator.hasNext()) {
            Product currentProduct = iterator.next();

            if (currentProduct.getNameProduct().equals(name)) {
                removedProducts.add(currentProduct);
                iterator.remove();
            }
        }
        return removedProducts;
    }

    public void printBasket() {
        System.out.println("Содержимое корзины");
        for (Product p : products)
            System.out.println(p.getNameProduct() + " " + p.getPriceProduct());
    }
}