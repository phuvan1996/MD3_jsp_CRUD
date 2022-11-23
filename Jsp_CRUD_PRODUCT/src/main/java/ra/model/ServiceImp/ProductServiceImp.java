package ra.model.ServiceImp;

import ra.model.Dao.ProductDao;
import ra.model.DaoImp.ProductDaoImp;
import ra.model.Service.ProductService;
import ra.model.entity.Product;

import java.util.List;

public class ProductServiceImp implements ProductService<Product,String> {
    private ProductDao<Product,String>productDao= new ProductDaoImp();
    @Override
    public List<Product> getAll() {
        return productDao.getAll();
    }

    @Override
    public boolean save(Product product) {
        return productDao.save(product);
    }

    @Override
    public boolean update(Product product) {
        return productDao.update(product);
    }

    @Override
    public boolean delete(String id) {
        return productDao.delete(id);
    }

    @Override
    public Product getById(String id) {
        return productDao.getById(id);
    }

    @Override
    public List<Product> searchProductByName(String name) {
        return productDao.searchProductByName(name);
    }
}
