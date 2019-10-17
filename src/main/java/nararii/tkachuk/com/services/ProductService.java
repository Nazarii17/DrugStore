package nararii.tkachuk.com.services;

import nararii.tkachuk.com.entities.Product;
import nararii.tkachuk.com.mappers.ProductMapper;
import nararii.tkachuk.com.utils.FileReaderUtil;

import java.util.List;

public final class ProductService {
    private ProductService() { throw new UnsupportedOperationException();
    }

    public static Product getProductById(String filePath, int ID){
        List<Product> customerList = FileReaderUtil.readObjects(filePath,new ProductMapper());
        Product correctOne = null;
        for (Product product : customerList) {
            if (product.getId() == ID) {
                correctOne = product;
            }
        }
        return correctOne ;
    }

    public static Product getProductByName(String filePath, String name){
        List<Product> customerList = FileReaderUtil.readObjects(filePath,new ProductMapper());
        Product correctOne = null;
        for (Product product : customerList) {
            if (product.getName().equals(name)) {
                correctOne = product;
            }
        }
        return correctOne ;
    }
}
