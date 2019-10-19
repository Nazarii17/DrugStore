package nararii.tkachuk.com.services;

import nararii.tkachuk.com.entities.Product;
import nararii.tkachuk.com.mappers.ProductMapper;
import nararii.tkachuk.com.utils.FileReaderUtil;

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

    public static Product createNewProduct(String filePath, String name, Double price, String info){

       if (EntityIDService.isPriceNotZero(new BigDecimal(price))){
        throw new RuntimeException("Price can't be zero!!!");
       }
       if (EntityIDService.isNameExist(filePath, name, new ProductMapper())){
           throw new RuntimeException("The product \"" + name.toUpperCase() + "\" is exist!!!");
       }

        EntityIDService.createFileWithMaxID(filePath, new ProductMapper());

        return new Product(
                name,
                EntityIDService.generateIDFromFile(EntityIDService.getIDFilePath(filePath)),
                new BigDecimal(price).setScale(2, RoundingMode.HALF_EVEN),
                info);

    }
}
