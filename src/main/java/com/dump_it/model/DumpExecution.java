package com.dump_it.model;

import java.time.LocalDateTime;

public class DumpExecution {
    private User user;
    private LocalDateTime dateTime;
    private DumpStatus status;

    //Par défaut une exécution de DUMP est au statut PENDING, la date-heure renseigné est celle au moment du lancement de l'exécution
    public DumpExecution(User user) {
        this.user = user;
        this.dateTime = LocalDateTime.now();
        this.status = DumpStatus.PENDING;
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
}
