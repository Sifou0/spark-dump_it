package com.dump_it.dao;

import com.dump_it.model.DumpStatus;
import com.dump_it.model.Log;

import java.sql.*;
import java.util.ArrayList;

public class LogDao extends Dao {

    private static Connection connection;
    public LogDao() {
        super();
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(DB_URL,USER,PWD);
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("create table if not exists logs(id serial primary key, user_id bigint, datetime timestamp, status varchar(7), foreign key(user_id) references users(id) );");
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static ArrayList<Log> getAll(){
        ArrayList<Log> logs = new ArrayList<>();
        String query = "select * from logs";
        try {
           Statement statement = connection.createStatement();
           ResultSet resultSet = statement.executeQuery(query);
           while (resultSet.next()) {
               logs.add(extractLogFromQueryResult(resultSet));
           }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return logs;
    }

    public static void insert(Log log) {
        String query = "INSERT INTO logs (user_id, datetime, status) VALUES (?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setLong(1, log.getUserId());
            statement.setTimestamp(2, log.getDateTime());
            statement.setString(3, log.getStatus());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
        private static Log extractLogFromQueryResult(ResultSet resultSet) {
        try {
            DumpStatus dumpStatus = null;
            switch (resultSet.getString("status")) {
                case "PENDING":
                    dumpStatus = DumpStatus.PENDING;
                    break;
                case "SUCCESS":
                    dumpStatus = DumpStatus.SUCCESS;
                    break;
                case "FAILURE":
                    dumpStatus = DumpStatus.FAILURE;
                    break;
            }
            return new Log(resultSet.getInt("id"),resultSet.getInt("user_id"),dumpStatus);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
