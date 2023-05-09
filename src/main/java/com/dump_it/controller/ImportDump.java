package com.dump_it.controller;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ImportDump {

  File file;

  public ArrayList<String> getQueries() {
    return queries;
  }

  ArrayList<String> queries;

  public ImportDump() {
    file = null;
    queries = new ArrayList<>();
  }

  public ImportDump(String url) {
    this();
    load(url);
  }

  public void load(String url) {
    file = new File(url);
  }

  public void execCmds(String dbName, String dbPwd) {
    try {
      ArrayList<String> cmds = new ArrayList<>();
      if (System.getProperty("os.name").startsWith("Windows")) {
        cmds = new ArrayList<>(List.of("cmd.exe", "/c"));
      } else {
        cmds = new ArrayList<>(List.of("/bin/bash", "-c"));
      }
      cmds.add(getPgCmds(dbName));
      ProcessBuilder pb = new ProcessBuilder(cmds);
      pb.environment().put("PGPASSWORD", dbPwd);
      pb.redirectOutput(generateLogs(dbName));
      pb.redirectErrorStream(true);
      Process process = pb.start();
      if (process.waitFor() == 0) System.out.println("Dump succes");
      process.destroy();
    } catch (IOException ex) {
      System.out.println("Exception: " + ex);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }

  public File generateLogs(String dbname) {
    File file = new File(dbname + "_logs");
    if (!file.exists()) file.mkdirs();
    return new File(
      dbname +
      "_logs/" +
      dbname +
      "_" +
      LocalDateTime
        .now()
        .format(DateTimeFormatter.ofPattern("dd-MM-yyyy_H-m")) +
      ".log"
    );
  }

  private String getPgCmds(String dbName) {
    /*
        -v "ON_ERROR_STOP=1" -> Stops on error, error findable in the log file
        */
    return (
      "psql -h bdd-pg-test -d ismail_test_param -U ismail_test_param -f " +
      file.getAbsolutePath()
    );
  }
}
