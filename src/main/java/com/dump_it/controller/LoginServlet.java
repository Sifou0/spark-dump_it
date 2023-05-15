package com.dump_it.controller;

import com.dump_it.dao.UserDao;
import com.dump_it.model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;
import java.io.*;

import static com.dump_it.controller.Authentification.sha256;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {

  private UserDao userDao;

  @Override
  public void init() throws ServletException {
    super.init();
    userDao = new UserDao();
  }

  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    HttpSession session = request.getSession();
    try {
      for(User u : userDao.getAll()) {
        if(u.getName().equals(request.getParameter("username")) && u.getPwd().equals(sha256(request.getParameter("password")))) {
          session.setAttribute("name",u.getName());
          response.sendRedirect("/available");
          return;
        }
      }
    } catch (ClassNotFoundException e) {
      throw new RuntimeException(e);
    }
    if(session.getAttribute("name") != null) response.sendRedirect("/available");
    request.getRequestDispatcher("login.jsp").forward(request, response);

  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    request.getRequestDispatcher("login.jsp").forward(request, response);
  }

  public void destroy() {}
}
