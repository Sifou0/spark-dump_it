package com.dump_it.controller;

import com.dump_it.dao.UserDao;
import com.dump_it.model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import static com.dump_it.controller.Authentification.sha256;

@WebServlet("/registerServlet")
public class RegisterServlet extends HttpServlet {
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
                if(u.getName().equals(request.getParameter("username"))) { //User already exists to NOTIFY
                    response.sendRedirect("/register");
                    return;
                }
            }
            userDao.insert(request.getParameter("username"),sha256(request.getParameter("password")));

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        //request.getRequestDispatcher("register.jsp").forward(request, response);
        response.sendRedirect("/login");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("register.jsp").forward(request, response);
    }
}
