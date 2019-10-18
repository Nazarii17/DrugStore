package nararii.tkachuk.com.services;

import nararii.tkachuk.com.entities.Product;
import nararii.tkachuk.com.mappers.ProductMapper;
import nararii.tkachuk.com.utils.FileReaderUtil;
import nararii.tkachuk.com.utils.FileWriterUtil;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class ProductService {

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

    public Product createNewProduct(String filePath, String name, Double price, String info){

        FileWriterUtil.createFileIfNotExists(filePath);

        EntityIDService.createFileWithMaxID(filePath, new ProductMapper());

        return new Product(name, EntityIDService.generateID(EntityIDService.getIDFilePath(filePath)),new BigDecimal(price).setScale(2, RoundingMode.HALF_EVEN),info);

    }
}
