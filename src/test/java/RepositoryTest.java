import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RepositoryTest {

    @Test
    public void addFile() {
        Book book1 = new Book(1, "book", 500, "Rnd Title", "Rnd Author");
        Smartphone smartphone1 = new Smartphone(2, "Apple_iPhone", 100_000, "13ProMax", "PaloAlto");
        Repository repo = new Repository();
        repo.addProduct(book1);
        repo.addProduct(smartphone1);

        Product[] expected = {book1, smartphone1};
        Product[] actual = repo.getAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void deliteId() {
        Book book1 = new Book(1, "book", 500, "Rnd Title", "Rnd Author");
        Smartphone smartphone1 = new Smartphone(2, "Apple_iPhone", 100_000, "13ProMax", "PaloAlto");
        Repository repo = new Repository();
        repo.addProduct(book1);
        repo.addProduct(smartphone1);
        repo.deleteID(1);

        Product[] expected = {smartphone1};
        Product[] actual = repo.getAll();
        Assertions.assertArrayEquals(expected, actual);
    }
}