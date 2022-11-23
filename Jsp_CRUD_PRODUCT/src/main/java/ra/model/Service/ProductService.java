package ra.model.Service;

import java.util.List;

public interface ProductService<T,V> extends ProductManagementService<T,V> {
    List<T> searchProductByName(String name);
}
