package lk.ijse.carrent.layerd.repository;

public interface CrudRepo<T,ID> extends SuperRepo {

    Integer add(T t) throws Exception;
    T get(ID id) throws Exception;
}
