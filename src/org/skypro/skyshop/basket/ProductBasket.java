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
        int specialCount = 0;
        for (List<Product> list : products.values())
            for (Product i : list) {
                if (i.isSpecial()) {
                    specialCount++;
                }
            }
        return specialCount;
    }

    public int totalCost() {
        int sum = 0;
        for (List<Product> list : products.values())
            for (Product b : list) {
                sum += b.getPriceProduct();
            }
        return sum;
    }

    public void printProduct() {
        boolean empty = true;
        for (String key : products.keySet()){
            List<Product> list = products.get(key);
            for (Product b : list) {
                    System.out.println(b.getNameProduct() + ": " + b.getPriceProduct());
                    empty = false;
                }
            }
        if (empty) {
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
        for (String key : products.keySet()){
            List<Product> list = products.get(key);
            for (Product p : list){
                System.out.println(p.getNameProduct() + " " + p.getPriceProduct());
            }
        }
    }
}