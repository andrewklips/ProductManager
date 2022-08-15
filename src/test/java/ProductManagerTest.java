import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductManagerTest {

    @Test
    public void addProd() {
        Book book1 = new Book(1, "Book", 500, "Rnd Title", "Rnd Author");
        Smartphone smartphone1 = new Smartphone(2, "Apple_iPhone", 100_000, "13ProMax", "PaloAlto");
        Repository repo = new Repository();
        ProductManager manager = new ProductManager(repo);
        manager.add(book1);
        manager.add(smartphone1);

        Product[] expected = {book1, smartphone1};
        Product[] actual = repo.getAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void findName() {
        Book book1 = new Book(1, "Book", 500, "Rnd Title", "Rnd Author");
        Smartphone smartphone1 = new Smartphone(2, "Apple_iPhone", 100_000, "13ProMax", "PaloAlto");
        Repository repo = new Repository();
        ProductManager manager = new ProductManager(repo);
        manager.add(book1);
        manager.add(smartphone1);

        Product[] expected = {smartphone1};
        Product[] actual = manager.searchBy("Apple_iPhone");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void notFindName() {
        Book book1 = new Book(1, "Book", 500, "Rnd Title", "Rnd Author");
        Smartphone smartphone1 = new Smartphone(2, "Apple_iPhone", 100_000, "13ProMax", "PaloAlto");
        Repository repo = new Repository();
        ProductManager manager = new ProductManager(repo);
        manager.add(book1);
        manager.add(smartphone1);

        Product[] expected = {};
        Product[] actual = manager.searchBy("Calendar");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void findProd() {
        Book book1 = new Book(1, "Book", 500, "Rnd Title", "Rnd Author");
        Smartphone smartphone1 = new Smartphone(2, "Apple_iPhone", 100_000, "13ProMax", "PaloAlto");
        Repository repo = new Repository();
        ProductManager manager = new ProductManager(repo);
        manager.add(book1);
        manager.add(smartphone1);

        Boolean expected = true;
        Boolean actual = manager.matches(book1, "Book");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void findTwoProd() {
        Book book1 = new Book(1, "Book", 500, "Rnd Title", "Rnd Author");
        Smartphone smartphone1 = new Smartphone(2, "Apple_iPhone", 100_000, "13ProMax", "PaloAlto");
        Book book2 = new Book(3, "Apple_iPhone", 1000, "Manual", "Apple inc");
        Repository repo = new Repository();
        ProductManager manager = new ProductManager(repo);
        manager.add(book1);
        manager.add(smartphone1);
        manager.add(book2);

        Product[] expected = {smartphone1, book2};
        Product[] actual = manager.searchBy("Apple_iPhone");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void notFindProd() {
        Book book1 = new Book(1, "Book", 500, "Rnd Title", "Rnd Author");
        Repository repo = new Repository();
        ProductManager manager = new ProductManager(repo);
        manager.add(book1);

        Boolean expected = false;
        Boolean actual = manager.matches(book1, "Horror");
        Assertions.assertEquals(expected, actual);
    }

}