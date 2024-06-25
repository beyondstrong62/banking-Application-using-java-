package com.user;

import java.io.IOException;
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

@WebServlet("/DisplayServlet")
public class DisplayServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    Connection con = null;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        con = DBconnection.get();

        String accountNumber = request.getParameter("accountNumber");
        Account account = getAccountByNumber(accountNumber);

        if (account != null) {
            request.setAttribute("account", account);
            RequestDispatcher dispatcher = request.getRequestDispatcher("display2.jsp");
            dispatcher.forward(request, response);
        } else {
            // If account not found, you can redirect to an error page or display a message
            response.sendRedirect("error.jsp");
        }
    }

    private Account getAccountByNumber(String accountNumber) {
        try {
            String query = "SELECT * FROM account WHERE num = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, accountNumber);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Account account = new Account();
                account.setNum(rs.getString("num"));
                account.setName(rs.getString("name"));
                account.setBalance(rs.getString("balance"));
                return account;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
