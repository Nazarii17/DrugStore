package main.java.nararii.tkachuk.com.project.mainClasses;

import project.csvFiles.CSVFormats;
import project.csvFiles.CSVSerializable;

import java.math.BigDecimal;

public class Product implements CSVSerializable {
    private String name;
    private int id;
    private BigDecimal price;
    private String info;

    public Product(String name, int id, BigDecimal price, String info) {
        this.name = name;
        this.id = id;
        this.price = price.setScale(2);
        this.info = info;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "Product{" +
                "Name = '" + name + '\'' +
                ", ID of the product = " + id +
                ", Price = " + price + "$" +
                ", \nInformation: \n'" + info + " '" +
                '}';
    }

    @Override
    public String toCSVString() {
        return String.format(CSVFormats.PRODUCT.getFormatValue(), name + ",", id + ",", price + ",", info);
    }

    public String[] getStringFields(Product product) {
        String[] o = new String[4];
        o[0] = product.getName() + ",";
        o[1] = product.getId() + ",";
        o[2] = product.getPrice() + ",";
        o[3] = product.getInfo() + ",";
        return o;
    }
}
