package com.dump_it.dao;

import com.dump_it.model.User;
import io.github.cdimascio.dotenv.Dotenv;
import org.postgresql.Driver;

import java.sql.*;
import java.util.ArrayList;

public class UserDao extends Dao {

    public UserDao() {
        super();
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
//        try {
//            Class.forName("org.postgresql.Driver");
//            Connection con = DriverManager.getConnection(DB_URL,USER,PWD);
//            Statement statement = con.createStatement();
//            ResultSet rs = statement.executeQuery("create table if not exists users(id serial not null , username varchar(20), pwd varchar(20))");
//        } catch (ClassNotFoundException | SQLException e) {
//            throw new RuntimeException(e);
//        }
    }

    public ArrayList<User> getAll() throws ClassNotFoundException {
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
            PreparedStatement preparedStatement = con.prepareStatement("insert into users(name,pwd) values (?,?);");
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
