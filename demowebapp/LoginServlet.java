package com.jetbrains.demowebapp;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String email = request.getParameter("email");
        String pwd = request.getParameter("password");

        if (email.equalsIgnoreCase("shiv@gmail.com") && pwd.equals("shiv@1234")) {
            RequestDispatcher rd = request.getRequestDispatcher("./WelcomeServlet");
            rd.forward(request, response);
        } else {
            out.println("<h1> Invalid Credential <span style='color:red'> Try Again </span></h1><br>");
            RequestDispatcher rd = request.getRequestDispatcher("./login.html");
            rd.include(request, response);
            //response.sendRedirect("login.html"); // external resources
        }

    }
}
