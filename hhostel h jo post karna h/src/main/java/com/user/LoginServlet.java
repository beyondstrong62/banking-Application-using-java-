package com.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    Connection con = null;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        con = DBconnection.get();
        PrintWriter out = response.getWriter();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        try {
            String query = "SELECT * FROM register WHERE username = ? AND password = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                // Redirect to success page
                RequestDispatcher dispatcher = request.getRequestDispatcher("Success2.html");
                dispatcher.forward(request, response);
            } else {
                // Redirect to failure page
                RequestDispatcher dispatcher = request.getRequestDispatcher("Failed2.jsp");
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
