package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.*;

import java.util.*;

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
//        basket.clearBasket();
        //8 Печать содержимого пустой корзины.
        basket.printProduct();
        //9 Получение стоимости пустой корзины.
        System.out.println("Стоимость пустой корзины: " + basket.totalCost());
        //10 Поиск товара по имени в пустой корзине.
        System.out.println("Есть ли в корзине сыр? " + basket.checkingProductAvailability(cheese.getNameProduct()));

        SearchEngine searchEngine = new SearchEngine();
        Article article1 = new Article("Молоко полезно для здоровья", "Стакан молока в день укрепляет здоровье");
        Article article2 = new Article("сезон Яблок", "В этом году огромный урожай яблок");
        Article article3 = new Article("Виды Сыров", "В нашем магазине огромное количество сыров разных видов");
        Article article4 = new Article("Скидки на Яблоки", "скидки по 75% на яблоки любых сортов");
        Article article5 = new Article("Весенние молодые Яблоки", "Ранний урожай яблок ");

        searchEngine.add(article1);
        searchEngine.add(article2);
        searchEngine.add(article3);
        searchEngine.add(article4);
        searchEngine.add(article5);

        System.out.println("Поиск по слову \"Яблок\" ");
        Set<Searchable> results = searchEngine.search("Яблок");
        for (Searchable result : results) {
            System.out.println(result);
        }

        System.out.println("Поиск по слову \"Сыр\" ");
        results = searchEngine.search("Сыр");
        for (Searchable result : results) {
            System.out.println(result);
        }

        try {
            SimpleProduct eggs = new SimpleProduct(null, 100);
        } catch (IllegalArgumentException e) {
            System.out.println("Название продукта не может быть пустым или null.");
        }

        try {
            SimpleProduct chocolate = new SimpleProduct("Шоколад", 0);
        } catch (IllegalArgumentException e) {
            System.out.println("Цена должна быть строго больше 0");
        }

        try {
            DiscountedProduct watermelon = new DiscountedProduct("Арбуз", 300, 105);
        } catch (IllegalArgumentException e) {
            System.out.println("Процент скидки может быть от 0 до 100 включительно");
        }

        try {
            searchEngine.findBestMatch("сырок глазированный");
        } catch (BestResultNotFound e) {
            System.out.println(e.getMessage());
        }

        //1 Удаляем существующий продукт из корзины
        List<Product> deletedApple = basket.productRemoval("Яблоки");
        //2 Выводим удаленный продукты
        System.out.println("Удалены продукты:");
        for (Product p : deletedApple)
            System.out.println("Удаленный продукт " + p.getNameProduct() + " " + p.getPriceProduct());
        //3 Состояние корзины
        basket.printBasket();
        //4 Удалить несуществующий продукт
        List<Product> deletedBanana = basket.productRemoval("Бананы");
        //5 Проверяем, что список удаленных продуктов пустой и выводим сообщение “Список пуст”
        if (deletedBanana.isEmpty())
            System.out.println("Список пуст");
        //6 Состояние корзины
        basket.printBasket();
    }
}