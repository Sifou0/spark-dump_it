package com.dump_it.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

// Return to the view all the available dump in the directory
public class ViewAvailableDumpServlet {
    String path;
    File directoryFile;
    ArrayList<String> availableFiles;
    public ViewAvailableDumpServlet(String path) {
        this.path = path;
        loadDirectory();
    }

    private void loadDirectory() {
        try {
            if((directoryFile = new File(path)).isDirectory()) {
                availableFiles = new ArrayList<>(List.of(Objects.requireNonNull(directoryFile.list())));
            }
        }
        catch (NullPointerException e) {
            System.out.println("Directory not found or not directory path given");
        }
    }
}
