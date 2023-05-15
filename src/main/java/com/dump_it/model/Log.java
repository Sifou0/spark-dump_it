package com.dump_it.model;

import java.sql.Timestamp;
import java.time.LocalDateTime;


public class Log {
    private int id;
    private int userId;
    private Timestamp dateTime;
    private DumpStatus status;

    //Par défaut une exécution de DUMP est au statut PENDING, la date-heure renseigné est celle au moment du lancement de l'exécution
    public Log(int id, int userId, DumpStatus status) {
        this.userId = userId;
        this.dateTime = new Timestamp(System.currentTimeMillis());
        this.status = status;
    }

    public String getStatus() {
        switch (status) {
            case SUCCESS:
                return "SUCCESS";
            case FAILURE:
                return "FAILURE";
            case PENDING:
                return "PENDING";
            default:
                return "UNKNOWN STATUS";
        }
    }

    public void reportSuccess() {
        this.status = DumpStatus.SUCCESS;
    }

    public void reportFailure() {
        this.status = DumpStatus.FAILURE;
    }

    public int getId() {
        return id;
    }

    public int getUserId() {
        return userId;
    }

    public Timestamp getDateTime() {
        return dateTime;
    }
}
