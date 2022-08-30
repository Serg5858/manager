package ru.netology.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductRepositoryTest {

    ProductRepository repo = new ProductRepository();
    Book book1 = new Book(10, "Terminator life", 100, "Nick");
    Book book2 = new Book(3, "Flowers", 50, "Maya");
    Book book3 = new Book(8, "Terminator returned", 75, "Rick");
    Smartphone smartphone1 = new Smartphone(12, "Nokia6300", 400, "Nokia");
    Smartphone smartphone2 = new Smartphone(2, "Sumsung", 300, "Sumsung Corporation");

    @Test
    public void shouldAddedProducts() {
        repo.add(book2);
        repo.add(smartphone1);
        repo.add(book3);
        Product[] expected = {book2, smartphone1, book3};
        Product[] actual = repo.getProducts();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveById() {
        repo.add(book3);
        repo.add(smartphone1);
        repo.add(book2);
        repo.removeById(3);
        Product[] expected = {book3, smartphone1};
        Product[] actual = repo.getProducts();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void saveProducts() {
        repo.save(book2);
        repo.save(smartphone1);
        repo.save(book3);
        Product[] expected = {book2, smartphone1, book3};
        Product[] actual = repo.getProducts();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldDeleteReallyId() {
        repo.add(book2);
        repo.add(book1);
        repo.add(smartphone1);
        repo.removeById(3);
        Product[] expected = {book1, smartphone1};
        Product[] actual = repo.getProducts();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotDeleteNoReallyId() {
        ProductRepository repo = new ProductRepository();
        repo.save(book2);
        repo.save(smartphone1);
        repo.save(book3);
        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.removeById(30);
        });
    }
}
