package com.dump_it.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

// Return to the view all the available dump in the directory
public class AvailableDump {

  private String path;
  private File directoryFile;
  private ArrayList<String> availableFiles;
  private ArrayList<String> availableDirectories;

  public ArrayList<String> getAvailableFiles() {
    return availableFiles;
  }

  public ArrayList<String> getAvailableDirectories() {
    return availableDirectories;
  }

  public AvailableDump(String path) {
    this.path = path;
    loadDirectory();
  }

  private void loadDirectory() {
    this.availableFiles = new ArrayList<>();
    this.availableDirectories = new ArrayList<>();
    try {
      if ((directoryFile = new File(path)).isDirectory()) {
        for(File f : Objects.requireNonNull(directoryFile.listFiles())) {
          if(f.isDirectory()) availableDirectories.add(f.getName());
          else if(f.isFile()) availableFiles.add(f.getName());
        }
      }
    } catch (NullPointerException e) {
      System.out.println("Directory not found or not directory path given");
    }
  }
}
