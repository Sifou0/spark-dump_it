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
    private final ArrayList<String> availableDumpList;
    public ViewAvailableDumpServlet() {
         availableDumpList = (new AvailableDump("\\\\Klee-file02\\spark archives")).getAvailableFiles();
    }

    public ArrayList<String> getAvailableDumpList() {
        return availableDumpList;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("dump_list",availableDumpList);
        req.getRequestDispatcher("dump_list.jsp").forward(req,resp);
    }
}
