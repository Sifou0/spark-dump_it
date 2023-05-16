package com.dump_it.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/importServlet")
public class ImportServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String file = req.getSession().getAttribute("filePath") + "\\" + req.getParameter("fileName");
        ImportDump importDump = new ImportDump(file);
        boolean res = importDump.execCmds("ismail_test_param","ismail_test_param");
        req.setAttribute("isSuccess",res);
        req.getRequestDispatcher("import.jsp").forward(req, resp);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("available");
    }
}
