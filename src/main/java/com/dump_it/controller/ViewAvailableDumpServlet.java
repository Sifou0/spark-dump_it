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

  private ArrayList<String> availableDumpFilesList;



  private ArrayList<String> availableDumpDirList;

  public ViewAvailableDumpServlet() {
    AvailableDump tmp = new AvailableDump("\\\\Klee-file02\\spark archives\\Technique");
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
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
    throws ServletException, IOException {
    req.setAttribute("dumpFileslist", availableDumpFilesList);
    req.setAttribute("dumpDirList",availableDumpDirList);
    req.getRequestDispatcher("dump_list.jsp").forward(req, resp);
  }
}
