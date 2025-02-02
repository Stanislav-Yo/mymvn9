package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductTest {

    Product product1 = new Product(10, "Товар1", 100);
    Product product2 = new Product(20, "Товар2", 200);
    Product product3 = new Product(30, "Товар3", 300);


    @Test
    public void getTitle() {

        String expectedTitle1 = "Товар1";
        String expectedTitle2 = "Товар2";
        String expectedTitle3 = "Товар3";
        String actualTitle1 = product1.getTitle();
        String actualTitle2 = product2.getTitle();
        String actualTitle3 = product3.getTitle();

        Assertions.assertEquals(expectedTitle1, actualTitle1);
        Assertions.assertEquals(expectedTitle2, actualTitle2);
        Assertions.assertEquals(expectedTitle3, actualTitle3);
    }

    @Test
    public void GetPrice() {

        int expectedPrice1 = 100;
        int expectedPrice2 = 200;
        int actualPrice1 = product1.getPrice();
        int actualPrice2 = product2.getPrice();

        Assertions.assertEquals(expectedPrice1, actualPrice1);
        Assertions.assertEquals(expectedPrice2, actualPrice2);
    }

    @Test
    public void DifferentProductsWithSameInformation() {
        Product product1 = new Product(1, "Название товара", 100);
        Product product2 = new Product(1, "Название товара", 100);

        Assertions.assertTrue(product1.equals(product2));
    }

    @Test
    public void DifferentProductsWithDifferentInformation() {

        Assertions.assertFalse(product1.equals(product2));
    }

    @Test
    public void DifferentProductsWithDifferentTitles() {
        Product product1 = new Product(10, "Товар1", 100);
        Product product2 = new Product(10, "Товар2", 100);

        Assertions.assertFalse(product1.equals(product2));
    }

    @Test
    public void DifferentProductsWithDifferentId() {
        Product product1 = new Product(1, "Товар1", 100);
        Product product2 = new Product(2, "Товар1", 100);

        Assertions.assertFalse(product1.equals(product2));
    }

    @Test
    public void DifferentProductsWithDifferentPrices() {
        Product product1 = new Product(1, "Товар1", 100);
        Product product2 = new Product(1, "Товар1", 200);

        Assertions.assertFalse(product1.equals(product2));
    }

    @Test
    public void NullInequality() {

        Assertions.assertFalse(product3.equals(null));
    }

    @Test
    public void HashCodeForEqualProducts() {

        Product product1 = new Product(1, "Товар1", 100);
        Product product2 = new Product(1, "Товар1", 100);

        int hashCode1 = product1.hashCode();
        int hashCode2 = product2.hashCode();

        Assertions.assertEquals(hashCode1, hashCode2);
    }

    @Test
    public void HashCodeForDifferentProducts() {

        int hashCode1 = product1.hashCode();
        int hashCode2 = product2.hashCode();

        Assertions.assertEquals(false, hashCode1 == hashCode2);
    }

    @Test
    public void nonExistentProduct() {

        Object otherObject = new Object();

        Assertions.assertFalse(product1.equals(otherObject));
    }

}
