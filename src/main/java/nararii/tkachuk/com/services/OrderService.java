package nararii.tkachuk.com.services;

import nararii.tkachuk.com.entities.Order;
import nararii.tkachuk.com.mappers.OrderMapper;
import nararii.tkachuk.com.utils.FileReaderUtil;

import java.time.LocalDate;
import java.util.List;

public final class OrderService {
    private OrderService() {
        throw new UnsupportedOperationException();
    }

    public static Order getOrdererById(String filePath, int ID) {
        List<Order> orderList = FileReaderUtil.readObjects(filePath, new OrderMapper());
        Order correctOne = null;
        for (Order order : orderList) {
            if (order.getId() == ID) {
                correctOne = order;
            }
        }
        return correctOne;
    }

    public static Order getOrdererByDate(String filePath, Integer Year, Integer Month, Integer Day) {

        List<Order> orderList = FileReaderUtil.readObjects(filePath, new OrderMapper());
        Order correctOne = null;
        for (Order order : orderList) {
            if (order.getDateOfOrder().equals(LocalDate.of(Year, Month, Day))) {
                correctOne = order;
            }
        }
        return correctOne;
    }
}
