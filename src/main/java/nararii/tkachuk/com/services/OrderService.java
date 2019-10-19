package nararii.tkachuk.com.services;

import nararii.tkachuk.com.entities.Customer;
import nararii.tkachuk.com.entities.Order;
import nararii.tkachuk.com.entities.Product;
import nararii.tkachuk.com.mappers.OrderMapper;
import nararii.tkachuk.com.utils.FileReaderUtil;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.List;

public class OrderService {

    public static Order getOrdererById(String filePath, int id) {
        List<Order> orderList = FileReaderUtil.readObjects(filePath, new OrderMapper());
        Order correctOne = null;
        for (Order order : orderList) {
            if (order.getId() == id) {
                correctOne = order;
            }
        }
        return correctOne;
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


}
