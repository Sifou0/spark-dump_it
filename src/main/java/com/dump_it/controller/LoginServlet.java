package com.dump_it.controller;

import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;
import java.io.*;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {

  public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws IOException {
    response.setContentType("text/html");
    // Hello
    PrintWriter out = response.getWriter();
    //System.out.println(request.getParameter("username"))

  }

  public void destroy() {}
}
