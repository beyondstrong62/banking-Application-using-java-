package com.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    Connection con = null;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        con = DBconnection.get();
        PrintWriter out = response.getWriter();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        try {
            String query = "INSERT INTO register (username, password) VALUES (?, ?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password);

            int count = ps.executeUpdate();
            if (count > 0) {
                // Redirect to success page
                RequestDispatcher dispatcher = request.getRequestDispatcher("login2.html");
                dispatcher.forward(request, response);
            } else {
                // Redirect to failure page
                RequestDispatcher dispatcher = request.getRequestDispatcher("Failed.jsp");
                dispatcher.forward(request, response);
            }
        } catch (SQLException e) {
            out.println("Exception: " + e);
        } finally {
            try {
                if (con != null) {
                    con.close(); // Close the connection
                }
            } catch (SQLException e) {
                out.println("Exception while closing connection: " + e);
            }
        }
    }
}
