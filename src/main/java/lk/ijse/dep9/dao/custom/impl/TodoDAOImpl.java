package lk.ijse.dep9.dao.custom.impl;

import lk.ijse.dep9.dao.custom.TodoDAO;
import lk.ijse.dep9.dao.exception.ConstraintViolationException;
import lk.ijse.dep9.entity.Todo;
import lk.ijse.dep9.entity.util.Status;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TodoDAOImpl implements TodoDAO {
    private final Connection connection;

    public TodoDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public long count() {
        try {
            PreparedStatement stm = connection.prepareStatement("SELECT COUNT(`id`) FROM `todo_item`");
            ResultSet rst = stm.executeQuery();
            rst.next();
            return rst.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean existsById(Integer id) {
        try {
            PreparedStatement stm = connection.prepareStatement
                    ("SELECT * FROM todo_item WHERE id = ?");
            stm.setInt(1, id);
            ResultSet rst = stm.executeQuery();
            return rst.next();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Todo> findAll() {
        try {
            PreparedStatement stm = connection.prepareStatement
                    ("SELECT * FROM `todo_item`");
            ResultSet rst = stm.executeQuery();
            List<Todo> items = new ArrayList<>();
            while(rst.next()){
                int id = rst.getInt("id");
                String name = rst.getString("user_name");
                String description = rst.getString("description");
                Status status = Status.valueOf(rst.getString("status"));
                items.add(new Todo(id, name, description, status));
            }
            return items;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<Todo> findById(Integer PK) {
        return Optional.empty();
    }

    @Override
    public Todo save(Todo todo) {
        try {
            PreparedStatement stm = connection.prepareStatement("INSERT INTO `todo_item` (`user_name`, description, status) VALUES (?, ?, ?)");
            stm.setString(1, todo.getUsername());
            stm.setString(2, todo.getDescription());
            stm.setString(3, String.valueOf(todo.getStatus()));
            if (stm.executeUpdate() == 1) {
                return todo;
            } else {
                throw new SQLException("Failed to save the todo item");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Todo update(Todo todo) {
        try {
            PreparedStatement stm = connection.prepareStatement
                    ("UPDATE todo_item SET user_name=?, description=?, status=? WHERE id=?");
            stm.setString(1, todo.getUsername());
            stm.setString(2, todo.getDescription());
            stm.setString(3, String.valueOf(todo.getStatus()));
            stm.setInt(4, todo.getId());
            if (stm.executeUpdate() == 1) {
                return todo;
            } else {
                throw new SQLException("Failed to update the book");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteById(Integer id) {
        try {
            PreparedStatement stm = connection.prepareStatement("DELETE FROM book WHERE id = ?");
            stm.setInt(1, id);
            stm.executeUpdate();
        } catch (SQLException e) {
            if (existsById(id)) throw new ConstraintViolationException("Book ", e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteAll() {
        try {
            PreparedStatement stm = connection.prepareStatement
                    ("DELETE FROM `todo_item` WHERE true");
            stm.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
