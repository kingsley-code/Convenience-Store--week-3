package org.kings.project;

import java.util.Comparator;

public class CustomerDTO implements Comparable<CustomerDTO> {
    private String customerName;
    private double quantity;
    private String productName;

    public CustomerDTO(String customerName, double quantity, String productName) {
        this.customerName = customerName;
        this.quantity = quantity;
        this.productName = productName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public double getQuantity() {
        return quantity;
    }

    public String getProductName() {
        return productName;
    }

    @Override
    public int compareTo(CustomerDTO o) {
        return o.getQuantity() > this.getQuantity() ? 1 : -1;
    }
}
