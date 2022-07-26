package org.kings.project;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Store {
    private ArrayList<Products> productArrayList = new ArrayList<>();
    private double accountBalance;
    private Cashier cashier;
    private Queue<Customer> customerQueue = new LinkedList<>();
    private Map<String, PriorityQueue<CustomerDTO>> productQueueMap = new HashMap<>();


    public static void main(String[] args) {
        Store store = new Store();
        Customer obi = new Customer("Obi");
        Customer david = new Customer("Dave");
        Cashier cashier = new Cashier("Chika");

        String source = "src/main/FoodSales.csv";
        store.reStock(source);

        for (Products x : store.getProductArrayList()) {
            System.out.println(x);
        }
        ;

        david.addToCart("Carrot", 40, store);
        obi.addToCart("banana", 15, store);
        obi.addToCart("carrot", 5, store);
//        obi.addToCart("banana", 1, store);

        store.joinQueue(obi);
        store.joinQueue(david);

        cashier.sellByFifo(store);
//        cashier.sellProductsToCustomers(store, "Carrot");
//        cashier.issueReceipt(obi);
//        cashier.sellProductsToCustomers(store, "Banana");


    }


    //
    public void reStock(String source) {
        String fileContent = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader(source));
            br.readLine();
            while ((fileContent = br.readLine()) != null) {
                String[] data = fileContent.split(",");
                if (productFinder(data[4]) < 0) {//if the product is not in the arrayListofProduct of the store, create Product
                    Products products = new Products(data[4], Double.parseDouble(data[6]), Integer.parseInt(data[5]), data[3]);
                    this.productArrayList.add(products);
//                System.out.println(data[4]);

                } else {
                    int productIndex = productFinder(data[4]); //get the product index
                    Products product = this.productArrayList.get(productIndex);
                    product.setProductQuantity(product.getProductQuantity() + Integer.parseInt(data[5]));
                }

            }


        } catch (
                FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch
        (IOException e) {
            e.printStackTrace();
        }
    }

    public void performTransaction(Customer customer, Cashier cashier) {
        // Money deducted from customer
        //Money added to store account balance
        double balance = cashier.sellProduct(customer);
        System.out.println("Sales from transaction is N" + balance);
        this.accountBalance += balance;
    }


    public int productFinder(String productName) {
        for (Products product : this.productArrayList) {
            if (productName.equalsIgnoreCase(product.getProductName())) {

                return productArrayList.indexOf(product);
            }
        }
        return -1;
    }

    // Map -> ProductName and ProductQueue.
    public void joinQueue(Customer customer) {
        this.customerQueue.add(customer);
        System.out.println(customer.getName() + " just joined queue");
        ArrayList<Products> customerCart = customer.getCustomerCart();
        for (Products product : customerCart) {
            if (productQueueMap.containsKey(product.getProductName())) {
                PriorityQueue<CustomerDTO> productQueue = productQueueMap.get(product.getProductName());
                CustomerDTO customerDTO = new CustomerDTO(customer.getName(), product.getProductQuantity(), product.getProductName());
                productQueue.add(customerDTO);
            } else {
                CustomerDTO customerDTO = new CustomerDTO(customer.getName(), product.getProductQuantity(), product.getProductName());
                PriorityQueue<CustomerDTO> productQueue = new PriorityQueue<>();
                productQueue.add(customerDTO);
                this.productQueueMap.put(product.getProductName(), productQueue);
            }
        }
    }


    public void assignOfficeToCashier(Cashier cashier) {
        this.cashier = cashier;
    }

    public ArrayList<Products> getProductArrayList() {
        return productArrayList;
    }

    public Queue<Customer> getCustomerQueue() {
        return customerQueue;
    }

    public Map<String, PriorityQueue<CustomerDTO>> getProductQueueMap() {
        return productQueueMap;
    }
}
