package com.example.BetterCrypt;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "TextEncryptServlet", value = "/TextEncryptServlet")
public class TextEncryptServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // read form fields
        String inputText = request.getParameter("text-encrypt");
        String secrectKey = request.getParameter("floatingKey");

        // do some processing here...

        request.setAttribute("encrypted_text", inputText);
        RequestDispatcher rd = request.getRequestDispatcher("/text-encrypt.jsp");
        rd.forward(request, response);
    }
}
