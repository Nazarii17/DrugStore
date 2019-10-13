package main.java.nararii.tkachuk.com.project.mainClasses;

import main.java.nararii.tkachuk.com.project.csvFiles.CSVFormats;
import main.java.nararii.tkachuk.com.project.csvFiles.CSVSerializable;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Order implements CSVSerializable {
    private LocalDate dateOfOrder;
    private Integer quantity;
    private Customer customer;
    private Product product;
    private int customerID;
    private int productID;
    private BigDecimal price;


    public Order(LocalDate dateOfOrder, Integer quantity, Customer customer, Product product) {
        this.dateOfOrder = dateOfOrder;
        this.quantity = quantity;
        this.customer = customer;
        this.product = product;
        this.customerID = customer.getId();
        this.productID = product.getId();
        this.price = BigDecimal.valueOf(quantity).multiply(product.getPrice());
    }

    public LocalDate getDateOfOrder() {
        return dateOfOrder;
    }

    public void setDateOfOrder(LocalDate dateTime) {
        this.dateOfOrder = dateTime;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "Order{" +
                "dateTime=" + dateOfOrder +
                ", quantity=" + quantity +
                ", customerID=" + customerID +
                ", productID=" + productID +
                '}';
    }

    @Override
    public String toCSVString() {
        return String.format(CSVFormats.ORDER.getFormatValue(), dateOfOrder + ",",
                quantity + ",", customerID + ",", productID  + ",", price);
    }



    public Object[] returnFields(Order order) {
        Object[] o = new Object[5];
        o[0] = order.getDateOfOrder() + ",";
        o[1] = order.getQuantity() + ",";
        o[2] = order.getCustomer().getId() + ",";
        o[3] = order.getProduct().getId() + ",";
        o[4] = BigDecimal.valueOf(order.getQuantity()).multiply(order.product.getPrice());
        return o;
    }

    private class DateofOrder {
        LocalDate localDate;
        DateTimeFormatter dateTimeFormatter;

        public DateofOrder(LocalDate localDate) {
            this.localDate = localDate;
            this.dateTimeFormatter = DateTimeFormatter.ofPattern("MM, dd, YYYY");
        }
    }
}