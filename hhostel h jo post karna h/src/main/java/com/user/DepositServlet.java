package com.user;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/DepositServlet")
public class DepositServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    Connection con = null;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        con = DBconnection.get();

        String accountNumber = request.getParameter("accountNumber");
        String depositAmount = request.getParameter("amount");
        double amount = Double.parseDouble(depositAmount);

        try {
            String query = "UPDATE account SET balance = balance + ? WHERE num = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setDouble(1, amount);
            ps.setString(2, accountNumber);
            ps.executeUpdate();

            response.sendRedirect("ssuccess2.html"); // Redirect to success page after deposit
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect("error2.html"); // Redirect to error page if deposit fails
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
