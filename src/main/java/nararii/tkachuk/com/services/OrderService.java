package nararii.tkachuk.com.services;

import nararii.tkachuk.com.entities.Customer;
import nararii.tkachuk.com.entities.Order;
import nararii.tkachuk.com.entities.Product;
import nararii.tkachuk.com.mappers.OrderMapper;
import nararii.tkachuk.com.utils.CSVFormatterUtil;
import nararii.tkachuk.com.utils.FileReaderUtil;
import nararii.tkachuk.com.utils.FileWriterUtil;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class OrderService {

    public static Order getOrderById(String filePath, int id) {
        List<Order> orderList = FileReaderUtil.readObjects(filePath, new OrderMapper());
        Order correctOne = null;
        for (Order order : orderList) {
            if (order.getId() == id) {
                correctOne = order;
            }
        }
        return correctOne;
    }

    public static int getIndexById(List<Order> list, int id){

        Integer correctOne = null;
        for (Order order : list) {
            if (order.getId() == id) {
                correctOne = list.indexOf(order);

            }
        }
        return correctOne ;
    }

    public static Order getOrdererByDate(String filePath, Integer year, Integer month, Integer day) {

        List<Order> orderList = FileReaderUtil.readObjects(filePath, new OrderMapper());
        Order correctOne = null;
        for (Order order : orderList) {
            if (order.getDateOfOrder().equals(LocalDate.of(year, month, day))) {
                correctOne = order;
            }
        }
        return correctOne;
    }

    public static boolean isOrderExist(String filePath, Order newOrder){

        List<Order> list = FileReaderUtil.readObjects(filePath, new OrderMapper());

        for (Order order : list){
            if (order.equals(newOrder)){
                return true;
            }
        }

        return false;
    }

    public static Order createNewOrder(String filePath,  Integer year, Integer month, Integer day,
                                       Integer quantity, Integer customersID, Integer productsID){

        EntityIDService.createFileWithMaxID(filePath, new OrderMapper());

        Order newOrder =  new Order(EntityIDService.generateIDFromFile(EntityIDService.getIDFilePath(filePath)),
                LocalDate.of(year, month, day),
                quantity,
                new Customer(customersID),
                new Product(productsID),
                BigDecimal.valueOf(quantity).multiply(ProductService.getProductById("products.csv",productsID).getPrice()));


        if (isOrderExist(filePath,newOrder)){
            throw new RuntimeException("This order already exist");

        }

        return newOrder;
    }

    public static void deleteOrderByID(String filePath, int id){
        List<Order> orderList = FileReaderUtil.readObjects(filePath, new OrderMapper());
        System.out.println(orderList.size());
        orderList.remove(getIndexById(orderList,id));
        System.out.println(orderList.size());
        FileWriterUtil.overwriteTextToFile(filePath, CSVFormatterUtil.toCSVStringNoFormat(orderList));
    }
}
