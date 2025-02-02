package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {

    Product product1 = new Product(10, "Товар1", 100);
    Product product2 = new Product(20, "Товар2", 200);
    Product product3 = new Product(30, "Товар3", 300);

    ShopRepository repo = new ShopRepository();

    @Test
    public void findProductById() {

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        Product actualProduct1 = repo.findById(product1.getId());
        Product actualProduct2 = repo.findById(product2.getId());
        Product actualProduct3 = repo.findById(product3.getId());

        Assertions.assertEquals(product1, actualProduct1);
        Assertions.assertEquals(product2, actualProduct2);
        Assertions.assertEquals(product3, actualProduct3);

        Assertions.assertNotNull(actualProduct1);
        Assertions.assertNotNull(actualProduct2);
        Assertions.assertNotNull(actualProduct3);
    }

    @Test
    void FindNonExistingProduct() {
        Product actualProduct = repo.findById(5);

        Assertions.assertEquals(null, actualProduct);
    }

    @Test
    public void removeProductById() {

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        repo.removeById(product2.getId());

        Product[] expectedProducts = {product1, product3};
        Product[] actualProducts = repo.findAll();

        Assertions.assertArrayEquals(expectedProducts, actualProducts);
    }

    @Test
    void NotFoundExceptionGenerations() {

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.removeById(-100);});
    }

}
