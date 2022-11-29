package lk.ijse.dep9.dao.custom;

import lk.ijse.dep9.dao.CrudeDAO;
import lk.ijse.dep9.entity.Todo;

public interface TodoDAO extends CrudeDAO<Todo, Integer> {

    void deleteAll();
}
