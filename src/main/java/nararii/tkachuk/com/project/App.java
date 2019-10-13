package main.java.nararii.tkachuk.com.project;

import project.io.FilesReader;
import project.io.FilesWriter;
import project.mainClasses.Customer;
import project.mainClasses.Order;
import project.mainClasses.Product;

import java.util.ArrayList;

public class App {

    public static void main(String[] args) {

        FilesWriter filesWriter = new FilesWriter();
        FilesReader filesReader = new FilesReader();

        ArrayList<Customer> customers = new ArrayList<>();
        ArrayList<Product> products = new ArrayList<>();
        ArrayList<Order> orders = new ArrayList<>();

        Customer customer1 = new Customer("Jack", "Bush", 1, "503730412");
        Customer customer2 = new Customer("Mary", "Bush", 2, "536546126");
        Customer customer3 = new Customer("Klara", "Kent", 3, "046322342");
        Customer customer4 = new Customer("Frank", "Marlboro", 4, "875743344");
        Customer customer5 = new Customer("Ivan", "Loft", 5, "987654323");
        customers.add(customer1);
        customers.add(customer2);
        customers.add(customer3);
        customers.add(customer4);
        customers.add(customer5);


//        ArrayList <String> temporary = filesReader.getLinesFromFile("customers.csv");
////        System.out.println(temporary);
//        String[] strings = temporary.get(2).split(",");
//        System.out.println(Arrays.toString(strings));
//        Customer cus = new Customer(strings[0].trim(),strings[1].trim(),Integer.parseInt(strings[2].trim()),strings[3].trim());
//        System.out.println(cus.toFileString());

        ArrayList<String[]> temporary = filesReader.getObjectsfromFile("customers.csv");
        ArrayList<Customer> customerArrayList =  App.returnlist(temporary);

        System.out.println(customerArrayList.get(0));

//        System.out.println(customerArrayList);


//        String s = "Jack,"+"Bush,"+ "1," +"503730412";
//
//        App.getCustomer(s);
//        System.out.println(s);


//        Product product1 = new Product("Critical+", 1, new BigDecimal("25"), "Упаковка: 3 насіння." +
//                "Виробник: Dinafem Seeds. Різновид: сатіва 50%; індика 50%. " + "Ефект: потужний; збалансований. " +
//                "Фем. / Рег. : фемінізовані. Цвітіння: 45-50 днів. " + "Розмір: 2.5 м. " +
//                "Урожай: 625 г / м2 (індаур); 1300 г / рослина (аутдор). Аромат: лимонний. " + "ТГК: 12-16%");
//        Product product2 = new Product("Amnesia Lemon", 2, new BigDecimal("16.30"), "Упаковка: 3 насіння." +
//                "Різновид: сатіва 60%; індика 40%" + "Ефект: потужний; знеболюючий" + "Фем. / Рег. : фемінізовані" +
//                "Цвітіння: 7-8 тижнів" + "Розмір: 100-120 см" + "Урожай: 500 г / рослина" + "ТГК: 20.5%");
//        Product product3 = new Product("Кубанський убивця", 3, new BigDecimal("18"), "Упаковка: 3 насіння." +
//                "Різновид: сатіва 60%; індика 40%" + "Ефект потужний; розслабляючий" + "Фем. / Рег. : фемінізовані" +
//                "Цвітіння: 50-60 днів" + "Розмір: 100-130 см" +
//                "Урожай: 500-600 г / м2 (приміщення); 900-1500 г / рослина (грунт)" + "ТГК: 22%");
//        Product product4 = new Product("Black Widow ", 4, new BigDecimal("12.20"), "Упаковка: 3 насіння." +
//                "Різновид: сатіва 25%; індика 75%" + "Ефект: потужний; розслабляючий" + "Фем. / Рег. : фемінізовані" +
//                "Цвітіння: 8-9 тижнів" + "Розмір: 100-120 см." + "Урожай: 400-500 г / м2" + "ТГК: 21%");
//        products.add(product1);
//        products.add(product2);
//        products.add(product3);
//        products.add(product4);
//
//        Order order1 = new Order(LocalDate.of(1945, 1, 13), 37, customer2, product3);
//        Order order2 = new Order(LocalDate.of(1913, Month.FEBRUARY, 11), 10, customer3, product1);
//        Order order3 = new Order(LocalDate.of(1913, Month.FEBRUARY, 11), 103, customer3, product2);
//        Order order4 = new Order(LocalDate.now(), 20, customer5, product1);
//        orders.add(order1);
//        orders.add(order2);
//        orders.add(order3);
//        orders.add(order4);
//
////      filesWriter.writeTextToFile("customers.csv", CSVFormatterUtil.toCSVString(customers));
////      filesWriter.writeTextToFile("products.csv", CSVFormatterUtil.toCSVString(products));
////      filesWriter.writeTextToFile("orders.csv", CSVFormatterUtil.toCSVString(orders));
////        filesReader.readFromFile("customers.csv");

//        filesWriter.writeTextToFile("customers.csv",cus.toFileString());

    }

    public static Object[] getCustomer(String s) {
        Object[] objects = s.split(",");
//        Customer customer;
//        String[] strings ;
//       customer = new Customer(strings[0],strings[1],Integer.parseInt(strings[2]),strings[3]);
//       objects = strings;
        return objects;

    }

    public static ArrayList<Customer> returnlist(ArrayList<String[]> list) {
        ArrayList<Customer> temporaryList = new ArrayList<>();
        ArrayList<String[]> fields = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {

            fields.add(list.get(i));
            String[] strings = list.get(i);

            temporaryList.add(new Customer(strings[0].trim(), strings[1].trim(), Integer.parseInt(strings[2].trim()), strings[3].trim()));

        }
        for (int i = 0; i < list.size(); i++) {

    }
        return temporaryList;
    }
}
