package com.dump_it.dao;

import io.github.cdimascio.dotenv.Dotenv;

public abstract class Dao {

    protected String DB_URL;
    protected String USER;
    protected String PWD;

    public Dao() {
        try {
            Dotenv dotenv = Dotenv.configure().filename(".env").load();
            DB_URL = dotenv.get("DB_URL");
            USER = dotenv.get("USER");
            PWD = dotenv.get("PWD");
        }
        catch (NullPointerException e) {
            System.out.println("No environment variables");
        }
    }
}
