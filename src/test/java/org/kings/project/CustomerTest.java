package org.kings.project;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {

    Store storeTest;

    @BeforeEach
    void setUp() {
        this.storeTest = new Store();
    }

    @Test
    void addToCart_product_not_found() {
        //Given
        Customer customer = new Customer("Vin", "lagos", 1);

        //when
        var expected = "noproduct";
        var actual = customer.addToCart("Apple", 45, storeTest);
        assertEquals(expected, actual);
    }


    @Test
    void addToCart_product_out_of_stock() {
        //Given
        Customer customer = new Customer("Vin", "lagos", 1);

        Store store = new Store();
        store.getProductArrayList().add(new Products("Carrot", 67, 80, "Bars"));

        //when
        var expected = "outofstock";
        var actual = customer.addToCart("Carrot", 450000, store);
        assertEquals(expected, actual);
    }


    @Test
    void addToCart_product_added() {
        //Given
        Customer customer = new Customer("Vin", "lagos", 1);

        Store store = new Store();
        store.getProductArrayList().add(new Products("Carrot", 67, 80, "Bars"));

        //when
        var expected = "added";
        var actual = customer.addToCart("Carrot", 45, store);
        assertEquals(expected, actual);
    }


}