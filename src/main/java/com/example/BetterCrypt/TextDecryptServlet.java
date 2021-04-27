package com.example.BetterCrypt;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "TextDecryptServlet", value = "/TextDecryptServlet")
public class TextDecryptServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // read form fields
        String inputText = request.getParameter("text-decrypt");
        String secretKey = request.getParameter("floatingKey");

        // do some processing here...

        request.setAttribute("decrypted_text", inputText);
        RequestDispatcher rd = request.getRequestDispatcher("/text-decrypt.jsp");
        rd.forward(request, response);
    }
}
