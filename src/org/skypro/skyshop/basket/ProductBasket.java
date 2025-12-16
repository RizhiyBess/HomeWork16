package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;

public class ProductBasket {
    Map<String, List<Product>> products = new LinkedHashMap<>();

    public void addingProduct(Product product) {
        List<Product> productList = products.getOrDefault(product.getNameProduct(), new ArrayList<>());
        productList.add(product);
        products.put(product.getNameProduct(), productList);
        System.out.println(product);
        System.out.println("Специальных товаров: " + countSpecialProducts());
    }

    int countSpecialProducts() {
        return products.values()
                .stream()
                .flatMap(Collection::stream)
                .filter(Product::isSpecial)
                .mapToInt(i -> 1)
                .sum();
    }

    public int totalCost() {
        return products.values()
                .stream()
                .flatMap(Collection::stream)
                .mapToInt(Product::getPriceProduct)
                .sum();
    }

    public void printProduct() {
        boolean isEmpty = products.values()
                .stream()
                .flatMap(Collection::stream)
                .findAny()
                .isEmpty();
        if (!isEmpty) {
            products.values()
                    .stream()
                    .flatMap(Collection::stream)
                    .forEach(product -> System.out.println(
                            product.getNameProduct() + ": " + product.getPriceProduct()));
        } else {
            System.out.println("В корзине пусто");
        }
    }

    public boolean checkingProductAvailability(String name) {
        return products.containsKey(name);
    }

    public void clearBasket() {
        products.clear();
    }

    public List<Product> productRemoval(String name) {
        List<Product> removedProducts = products.remove(name);
        return removedProducts != null ? removedProducts : Collections.emptyList();
    }

    public void printBasket() {
        System.out.println("Содержимое корзины");
        products.forEach((key, value) -> value.forEach(product -> System.out.println(product.getNameProduct() + " " + product.getPriceProduct())));
    }
}