package ra.model.DaoImp;

import ra.model.Dao.ProductDao;
import ra.model.entity.Product;
import ra.model.util.ConnectionDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImp implements ProductDao<Product,String> {

    @Override
    public List<Product> searchProductByName(String name) {
        Connection conn = null;
        CallableStatement callst = null;
        List<Product>listProduct = null;
        try {
            conn = ConnectionDB.openConnection();
            callst = conn.prepareCall("{call proc_searchbyname(?)}");
            callst.setString(1,name);
            ResultSet rs = callst.executeQuery();
            listProduct = new ArrayList<>();
            while (rs.next()){
                Product pro = new Product();
                pro.setProductId(rs.getString("productid"));
                pro.setProductName(rs.getString("productname"));
                pro.setPrice(rs.getFloat("price"));
                pro.setDateCreated(rs.getDate("createdate"));
                pro.setDescriptions(rs.getString("descriptions"));
                pro.setProductStatus(rs.getBoolean("productstatus"));
                listProduct.add(pro);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn,callst);
        }
        return listProduct;
    }

    @Override
    public List<Product> getAll() {
        Connection conn = null;
        CallableStatement callst = null;
        List<Product>listProduct = null;
        try {
            conn = ConnectionDB.openConnection();
            callst= conn.prepareCall("{call proc_getallproduct()}");
            ResultSet resul = callst.executeQuery();
            listProduct = new ArrayList<>();
            while (resul.next()){
                Product pro= new Product();
                pro.setProductId(resul.getString("productId"));
                pro.setProductName(resul.getString("productName"));
                pro.setPrice(resul.getFloat("price"));
                pro.setDateCreated(resul.getDate("createdate"));
                pro.setDescriptions(resul.getString("descriptions"));
                pro.setProductStatus(resul.getBoolean("productstatus"));
                listProduct.add(pro);

            }
        }catch (Exception e){
            e.printStackTrace();

        }finally {
            ConnectionDB.closeConnection(conn,callst);
        }
        return listProduct;
    }

    @Override
    public boolean save(Product product) {
        Connection conn = null;
        CallableStatement callst = null;
        boolean result = true;
        try {
            conn = ConnectionDB.openConnection();
            callst = conn.prepareCall("{call proc_insertproduct(?,?,?,?,?,?)}");
            callst.setString(1,product.getProductId());
            callst.setString(2, product.getProductName());
            callst.setFloat(3,product.getPrice());
            callst.setDate(4,new Date(product.getDateCreated().getTime()));
            callst.setString(5, product.getDescriptions());
            callst.setBoolean(6, product.isProductStatus());
            callst.executeUpdate();
        }catch (Exception e){
            result = false;
            e.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn,callst);
        }
        return result;
    }

    @Override
    public boolean update(Product product) {
        Connection conn = null;
        CallableStatement callst = null;
        boolean result = true;
        try {
            conn = ConnectionDB.openConnection();
            callst = conn.prepareCall("{call proc_updateproduct(?,?,?,?,?,?)}");
            callst.setString(1,product.getProductId());
            callst.setString(2, product.getProductName());
            callst.setFloat(3,product.getPrice());
            callst.setDate(4,new Date(product.getDateCreated().getTime()));
            callst.setString(5, product.getDescriptions());
            callst.setBoolean(6, product.isProductStatus());
            callst.executeUpdate();
        }catch (Exception e){
            result = false;
            e.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn,callst);
        }
        return result;
    }

    @Override
    public boolean delete(String id) {
        Connection conn = null;
        CallableStatement callst = null;
        boolean result = true;
        try {
           conn= ConnectionDB.openConnection();
            callst = conn.prepareCall("{call proc_deleteproduct(?)}");
            callst.setString(1,id);
            callst.executeUpdate();
        }catch (Exception e){
            result = false;
            e.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn,callst);
        }
        return result;
    }

    @Override
    public Product getById(String id) {
        Connection conn = null;
        CallableStatement callst = null;
        Product productInfo = null;
        try {
            conn =ConnectionDB.openConnection();
            callst = conn.prepareCall("{call proc_getproductbyid(?)}");
            callst.setString(1,id);
            ResultSet rs = callst.executeQuery();
            productInfo = new Product();
            if (rs.next()){
                productInfo.setProductId(rs.getString("productId"));
                productInfo.setProductName(rs.getString("productName"));
                productInfo.setPrice(rs.getFloat("price"));
                productInfo.setDateCreated(rs.getDate("createdate"));
                productInfo.setDescriptions(rs.getString("descriptions"));
                productInfo.setProductStatus(rs.getBoolean("productstatus"));

            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn,callst);
        }
        return productInfo;
    }
}
