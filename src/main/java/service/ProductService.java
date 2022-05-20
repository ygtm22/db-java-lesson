package service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import dbexam.ProductDao;
import enitity.Product;
import util.DbUtil;

public class ProductService {
    public List<Product> find(Product p) {
    	List<Product> pdList = new ArrayList<Product>();
    	
        try (Connection con = DbUtil.getConnection()) {
            ProductDao productDao = new ProductDao(con);
            
            pdList = productDao.find(p);
            
        } catch (Exception e) {
            e.printStackTrace();
        }

        return pdList;
    }

}
