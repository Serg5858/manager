package ru.netology.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ManagerTest {
    @Test
    public void searchOfProducts() {
        Book book1 = new Book(10, "Terminator life", 100, "Nick");
        Book book2 = new Book(3, "Flowers", 50, "Maya");
        Book book3 = new Book(8, "Terminator returned", 75, "Rick");
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);

        Product[] actual = manager.searchBy("Terminator");
        Product[] expected = {book1, book3};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchOfProductsNoMatches() {
        Book book1 = new Book(10, "Terminator life", 100, "Nick");
        Book book2 = new Book(3, "Flowers", 50, "Maya");
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);
        manager.add(book1);
        manager.add(book2);


        Product[] actual = manager.searchBy("War");
        Product[] expected = {};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchOfProductsEmptyManager() {
        Book book1 = new Book(10, "Flowers of Russia", 100, "Ivanov");
        Book book2 = new Book(3, "Flowers", 50, "Maya");
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);


        Product[] actual = manager.searchBy("Flowers");
        Product[] expected = {};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchOfDifferentProducts() {
        Book book1 = new Book(10, "Terminator life", 100, "Nick");
        Smartphone smartphone1 = new Smartphone(9, "LG", 500, "LgCorporation");
        Book book3 = new Book(8, "Terminator returned", 75, "Rick");
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);
        manager.add(book1);
        manager.add(smartphone1);
        manager.add(book3);

        Product[] actual = manager.searchBy("Terminator");
        Product[] expected = {book1, book3};

        Assertions.assertArrayEquals(expected, actual);
    }


}
