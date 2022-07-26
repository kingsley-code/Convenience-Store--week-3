package org.kings.project;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Customer {
    private int id;
    private String name;
    private Products products;
    private String address;
    private ArrayList<Products> customerCart = new ArrayList<>();


    public Customer(String name) {
        this.name = name;
    }

    public Customer(String name, String address, int id) {
        this.id = id;
        this.name = name;
        this.address = address;

    }

    public ArrayList<Products> getCustomerCart() {
        return customerCart;
    }

    public String addToCart(String productName, int qty, Store store){
        String message = null;
        int productInStoreIndex = store.productFinder(productName);
        if ( productInStoreIndex >= 0){
            Products productInStore = store.getProductArrayList().get(productInStoreIndex);
            if (qty <= productInStore.getProductQuantity()){
                Products newProduct = new Products(productInStore.getProductName(), productInStore.getProductPrice(), qty, productInStore.getCategory());
                productInStore.setProductQuantity(productInStore.getProductQuantity() - qty);
                this.customerCart.add(newProduct);
                System.out.println("Added " + newProduct.getProductName() + " to your cartgit");
                message = "added";
            }
            else{
                message = "outofstock";
                System.out.println("OUT OF STOCK");
            }
        }
        else {
            message = "noproduct";
            System.out.println("Product Unavailable");
        }
        return message;
    }

    public String getName() {
        return name;
    }
}









////    public Customer(int id, String name, Products products, String address) {
////        this.id = id;
////        this.name = name;
////        this.products = products;
////        this.address = address;
//    }

//    public int getId() {
//        return id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public Products getProducts() {
//        return products;
//    }
//
//    public String getAddress() {
//        return address;
//    }
//}
