package com.dump_it.dao;

import com.dump_it.model.User;
import org.postgresql.Driver;

import java.sql.*;
import java.util.ArrayList;

public class UserDao {
    private final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
    private final String USER = "postgres";
    private final String PWD = "spark";
    public ArrayList<User> getAll() throws ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        ArrayList<User> users = new ArrayList<>();
        try (
                Connection con = DriverManager.getConnection(DB_URL,USER,PWD);
                Statement statement = con.createStatement();
                ResultSet rs = statement.executeQuery("select * from public.users");
        )
        {
            while(rs.next()) {
                users.add(new User(rs.getLong("id"),rs.getString("name"),rs.getString("pwd")));
            }
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return users;
    }

    public void insert(String name, String pwd) throws ClassNotFoundException {
        Class.forName("org.postgresql.Driver");

        try (Connection con = DriverManager.getConnection(DB_URL,USER,PWD))
        {
            PreparedStatement preparedStatement = con.prepareStatement("insert into public.users(name,pwd) values (?,?);");
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, pwd);
            preparedStatement.executeUpdate();
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(long id, String[] params) throws ClassNotFoundException {
        Class.forName("org.postgresql.Driver");

        try (Connection con = DriverManager.getConnection(DB_URL,USER,PWD))
        {
            PreparedStatement preparedStatement = con.prepareStatement("update users set name = ?, pwd = ? where id = ? ;");
            preparedStatement.setString(1,params[0]);
            preparedStatement.setString(2,params[1]);
            preparedStatement.setLong(3,id);
            preparedStatement.executeUpdate();
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(long id) throws ClassNotFoundException {
        Class.forName("org.postgresql.Driver");

        try (Connection con = DriverManager.getConnection(DB_URL,USER,PWD))
        {
            PreparedStatement preparedStatement = con.prepareStatement("delete from users where id = ?;");
            preparedStatement.setLong(1,id);
            preparedStatement.executeUpdate();
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
