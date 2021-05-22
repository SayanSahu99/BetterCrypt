package com.example.BetterCrypt;

import com.example.Security.Text.AESText;
import com.example.Security.Text.NinesComplimentText;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Base64;

@WebServlet(name = "TextEncryptServlet", value = "/TextEncryptServlet")
public class TextEncryptServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("text-encrypt.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        NinesComplimentText NinesComplimentText = new NinesComplimentText();
        // read form fields
        String inputText = request.getParameter("text-encrypt");
        String secretKey = request.getParameter("floatingKey");
        String bits = request.getParameter("bits");

        // do some processing here...

        String AESEncryptedText = null;

        try {
            AESEncryptedText = Base64.getEncoder().encodeToString(AESText.encrypt(inputText.getBytes(), secretKey, Integer.parseInt(bits)));
        } catch (Exception e) {
            e.printStackTrace();
        }


        System.out.println(AESEncryptedText);
        String ASCII_ENC = NinesComplimentText.encrypt(AESEncryptedText);
        System.out.println(ASCII_ENC);
        request.setAttribute("success", "Text Encrypted");
        request.setAttribute("encrypted_text", ASCII_ENC);
        RequestDispatcher rd = request.getRequestDispatcher("/text-encrypt.jsp");
        rd.forward(request, response);
    }
}
