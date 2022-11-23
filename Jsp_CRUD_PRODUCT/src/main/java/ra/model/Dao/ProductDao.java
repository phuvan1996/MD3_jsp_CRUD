package ra.model.Dao;

import java.util.List;

public interface ProductDao<T,V> extends ProductManagement<T,V> {
    List<T> searchProductByName(String name);
}
