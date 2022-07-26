package org.kings.project;

public class Products {
    private String productName;
    private double productPrice;
    private int productQuantity;
    private String category;

    public void setCategory(String category) {
        this.category = category;
    }

    public Products(String productName, double productPrice, int productQuantity, String category) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
        this.category = category;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = Double.parseDouble(productPrice);
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return "Products{" +
                "productName='" + productName + '\'' +
                ", productPrice=" + productPrice +
                ", productQuantity=" + productQuantity +
                ", category='" + category + '\'' +
                '}';
    }
}
