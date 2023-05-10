package com.dump_it.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/availableServlet")
public class ViewAvailableDumpServlet extends HttpServlet {
  private String path;
  private final String initPath = "\\\\klee-storage01.klee.lan.net\\SPARK ARCHIVES\\";
  private ArrayList<String> availableDumpFilesList;
  private ArrayList<String> availableDumpDirList;

  public ViewAvailableDumpServlet() {
    this.path = initPath;
    loadAvailable();
  }

  public void loadAvailable() {
    AvailableDump tmp = new AvailableDump(path);
    availableDumpFilesList = tmp.getAvailableFiles();
    availableDumpDirList = tmp.getAvailableDirectories();
  }

  public ArrayList<String> getAvailableDumpList() {
    return availableDumpFilesList;
  }

  public ArrayList<String> getGetAvailableDumpDirList() {
    return availableDumpDirList;
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
    throws ServletException, IOException {
    if(req.getParameter("dirButton") != null) {
      path += "\\" + req.getParameter("dirButton");
    }
    else if(req.getParameter("backButton") != null && !path.equals(initPath)) {
      path = path.substring(0,path.lastIndexOf("\\"));
    }
    if(path.equals(initPath)) {
      req.setAttribute("canBack",false);
    }
    else {
      req.setAttribute("canBack",true);
    }
    loadAvailable();
    req.setAttribute("dumpFileslist", availableDumpFilesList);
    req.setAttribute("dumpDirList",availableDumpDirList);
    req.getRequestDispatcher("dump_list.jsp").forward(req, resp);
    //System.out.println(path);
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    this.path = initPath;
    loadAvailable();
    req.setAttribute("dumpFileslist", availableDumpFilesList);
    req.setAttribute("dumpDirList",availableDumpDirList);
    req.setAttribute("canBack", false);
    req.getRequestDispatcher("dump_list.jsp").forward(req, resp);
  }
}
