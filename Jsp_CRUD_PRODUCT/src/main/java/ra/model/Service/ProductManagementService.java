package ra.model.Service;

import java.util.List;

public interface ProductManagementService<T,V> {
    List<T> getAll();
    boolean save(T t);
    boolean update(T t);
    boolean delete(V id);
    T getById(V id);
}
