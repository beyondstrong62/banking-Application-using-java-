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

@WebServlet("/CreateServlet")
public class CreateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    Connection con = null;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        con = DBconnection.get();
        PrintWriter out = response.getWriter();
        String num = request.getParameter("num");
        String name = request.getParameter("name");
        String balance = request.getParameter("balance");
        try {
            String query = "INSERT INTO account (num, name, balance) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, num);
            ps.setString(2, name);
            ps.setString(3, balance);
            int count = ps.executeUpdate();
            if (count > 0) {
                out.println("Record inserted successfully");
                // Redirect to success page
                RequestDispatcher dispatcher = request.getRequestDispatcher("sucs.html");
                dispatcher.forward(request, response);
            } else {
                out.println("Failed to insert record");
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
