package lk.ijse.dep9.dao.custom.impl;

import lk.ijse.dep9.dao.custom.TodoDAO;
import lk.ijse.dep9.entity.SuperEntity;
import lk.ijse.dep9.util.ConnectionUtil;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.sql.Connection;

public class TodoDAOImpl implements TodoDAO {
    private final Connection connection;

    public TodoDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public long count() {
        try {
            PreparedStatement stm = connection.prepareStatement("SELECT COUNT(id) FROM todo_item");
            ResultSet rst = stm.executeQuery();
            rst.next();
            return rst.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void deleteById(Serializable PK) {

    }

    @Override
    public boolean existsById(Serializable PK) {
        return false;
    }

    @Override
    public List findAll() {
        return null;
    }

    @Override
    public Optional findById(Serializable PK) {
        return Optional.empty();
    }

    @Override
    public SuperEntity save(SuperEntity entity) {
        return null;
    }

    @Override
    public SuperEntity update(SuperEntity entity) {
        return null;
    }

    @Override
    public void deleteAll() {

    }
}
