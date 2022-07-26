package org.kings.project;

import java.util.*;

public class Cashier extends Staff {
    private int id;

    private String name;
    private Customer customer;
    private Products[] products;


    public Cashier(String name) {
        this.name = name;
    }

    public Cashier(int id, String name) {
        super();
        this.id = id;
        this.name = name;

    }

    Scanner input = new Scanner(System.in);

    public Cashier(int id, String Name, Customer customer, Products[] product) {
        super();
        this.id = id;
        this.name = name;
        this.customer = customer;
        this.products = product;
    }


    public int getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void issueReceipt(Customer customer) {
        double totalAmt = 0;
        double amount = 0;
        System.out.println("Receipt" + "\n-----------------------------------------------");
        System.out.println("ProductName | Product Qty | Product Amount");
        for (Products x : customer.getCustomerCart()) {
            amount = x.getProductPrice() * x.getProductQuantity();
            totalAmt += amount;
            System.out.println(x.getProductName() + "  " + x.getProductQuantity() + " " + amount);
        }
        System.out.println("total Amount = " + totalAmt);
        System.out.println("Thank you for shopping with XYZ Store!");
        System.out.println(customer.getName());

    }

    @Override
    public String toString() {
        return "Cashier{" +
                "id=" + id +
                ", Name=' " + "Name =" + name +
                '}';

    }

    public void sellProductsToCustomers(Store store, String productName) {
        Map<String, PriorityQueue<CustomerDTO>> productQueueMap = store.getProductQueueMap();
        PriorityQueue<CustomerDTO> priorityQueue = productQueueMap.get(productName);

        while (!priorityQueue.isEmpty()) {
            CustomerDTO customerDTO = priorityQueue.peek();
            System.out.println(customerDTO.getQuantity() + customerDTO.getProductName() + " has been sold to " + customerDTO.getCustomerName());
            priorityQueue.poll();

            System.out.println("------------------------------------------------");
        }

    }

    public void sellByFifo(Store store){
        Queue<Customer> customerQueue = store.getCustomerQueue();

        while (!customerQueue.isEmpty()){
            Customer customer = customerQueue.peek();
            issueReceipt(customer);
            customerQueue.poll();
        }
    }
    public double sellProduct(Customer customer) {
        double totalAmt = 0;
        for (Products p : customer.getCustomerCart()) {
            totalAmt += p.getProductPrice() * p.getProductQuantity();
        }
        return totalAmt;
    }
}
