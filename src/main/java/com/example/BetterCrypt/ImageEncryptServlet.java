package com.example.BetterCrypt;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ImageEncryptServlet", value = "/ImageEncryptServlet")
public class ImageEncryptServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // read form fields
        String secretKey = request.getParameter("floatingKey");

        // do some processing here...

        RequestDispatcher rd = request.getRequestDispatcher("/image-encrypt.jsp");
        rd.forward(request, response);
    }
}
