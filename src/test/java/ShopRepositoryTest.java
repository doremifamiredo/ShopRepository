import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShopRepositoryTest {

    Product strings = new Product(1, "violin", 10_000);
    Product keyboard = new Product(2, "piano", 100_000);
    Product woodwind = new Product(3, "oboe", 8_000);

    @Test
    public void removeAnExistingProductById() {
        ShopRepository repo = new ShopRepository();

        repo.add(strings);
        repo.add(keyboard);
        repo.add(woodwind);
        repo.removeById(1);

        Product[] expected = {keyboard, woodwind};
        Assertions.assertArrayEquals(expected, repo.findAll());
    }

    @Test
    public void removeANonExistentProductById() {
        ShopRepository repo = new ShopRepository();

        repo.add(keyboard);
        repo.add(woodwind);

        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.removeById(1);
        });
    }

    @Test
    public void removeFromEmptyRepo() {
        ShopRepository repo = new ShopRepository();

        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.removeById(10);
        });
    }
}