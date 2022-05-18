package service;

import java.sql.Connection;

import dbexam.ProductDao;
import enitity.Product;
import util.DbUtil;

public class ProductService {

    public Product findByProductId(Integer productId) {
        try (Connection con = DbUtil.getConnection()) {
            ProductDao productDao = new ProductDao(con);
            return productDao.findByProductId(productId);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

}
