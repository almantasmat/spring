package com.testdemo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

@WebServlet("/TestDbServlet" )
public class TestDbServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String user = "root";
        String pass = "admin";
        String jdbcUrl = "jdbc:mysql://localhost:3306/db?useSSL=false";
        String driver = "com.mysql.cj.jdbc.Driver";
        try{
            PrintWriter printWriter = resp.getWriter();
            printWriter.println("connecting to database: " + jdbcUrl);
            Class.forName(driver);  //nurodome kaip naudosim driveri
            Connection connection = DriverManager.getConnection(jdbcUrl, user, pass);
            printWriter.println("Success!");
            connection.close();
        }catch (Exception e){
            e.printStackTrace();
            throw new ServletException(e);
        }
    }
}
