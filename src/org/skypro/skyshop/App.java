package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.*;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        ProductBasket basket = new ProductBasket();

        SimpleProduct milk = new SimpleProduct("Молоко", 100);
        SimpleProduct bread = new SimpleProduct("Хлеб", 30);
        SimpleProduct cheese = new SimpleProduct("сыр", 200);
        SimpleProduct potato = new SimpleProduct("Картофель", 100);
        SimpleProduct apple = new SimpleProduct("Яблоки", 150);
        SimpleProduct lemon = new SimpleProduct("Лимон", 250);
        //1 Добавление продукта в корзину.
        basket.addingProduct(milk);
        basket.addingProduct(bread);
        basket.addingProduct(cheese);
        basket.addingProduct(potato);
        basket.addingProduct(apple);
        //2 Добавление продукта в заполненную корзину, в которой нет свободного места.
        basket.addingProduct(lemon);
        //3 Печать содержимого корзины с несколькими товарами.
        basket.printProduct();
        //4 Получение стоимости корзины с несколькими товарами.
        System.out.println("Стоимость корзины с товарами: " + basket.totalCost());
        //5 Поиск товара, который есть в корзине.
        System.out.println("Есть ли в корзине молоко? " + basket.checkingProductAvailability(milk.getNameProduct()));
        //6 Поиск товара, которого нет в корзине.
        System.out.println("Есть ли в корзине лимон? " + basket.checkingProductAvailability(lemon.getNameProduct()));
        //7 Очистка корзины.
        basket.clearBasket();
        //8 Печать содержимого пустой корзины.
        basket.printProduct();
        //9 Получение стоимости пустой корзины.
        System.out.println("Стоимость пустой корзины: " + basket.totalCost());
        //10 Поиск товара по имени в пустой корзине.
        System.out.println("Есть ли в корзине сыр? " + basket.checkingProductAvailability(cheese.getNameProduct()));

        basket.addingProduct(new SimpleProduct("Молоко", 100));
        basket.addingProduct(new DiscountedProduct("Яблоки", 150, 20));
        basket.addingProduct(new FixPriceProduct("Сыр"));


        SearchEngine searchEngine = new SearchEngine(10);
        Article article1 = new Article("Молоко полезно для здоровья", "Стакан молока в день укрепляет здоровье");
        Article article2 = new Article("Сезон Яблок", "В этом году огромный урожай яблок");
        Article article3 = new Article("Виды Сыров", "В нашем магазине огромное количество сыров разных видов");

        searchEngine.add(article1);
        searchEngine.add(article2);
        searchEngine.add(article3);

        System.out.println("Поиск по слову \"Яблок\" ");
        Searchable[] results = searchEngine.search("Яблок");
        for (Searchable result : results) {
            if (result != null) {
                System.out.println(result);
            }
        }

        System.out.println("Поиск по слову \"Сыр\" ");
        results = searchEngine.search("Сыр");
        for (Searchable result : results) {
            if (result != null) {
                System.out.println(result);
            }
        }

        System.out.println("Поиск по слову \" \" ");
        results = searchEngine.search(" ");
        for (Searchable result : results) {
            if (result != null) {
                System.out.println(result);
            }
        }

    }
}