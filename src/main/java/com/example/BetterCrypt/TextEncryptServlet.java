package com.example.BetterCrypt;

import com.example.Security.Text.AESText;
import com.example.Security.Text.NinesComplimentText;
import com.example.Security.Image.AES_256;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet(name = "TextEncryptServlet", value = "/TextEncryptServlet")
public class TextEncryptServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        AES_256 AES = new AES_256();
        NinesComplimentText NinesComplimentText = new NinesComplimentText();
        // read form fields
        String inputText = request.getParameter("text-encrypt");
        String secretKey = request.getParameter("floatingKey");

        // do some processing here...

        String AESEncryptedText = null;
        try {
            AESEncryptedText = new String(AES.encrypt(secretKey.getBytes(StandardCharsets.UTF_8),inputText.getBytes(StandardCharsets.UTF_8)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(AESEncryptedText);
        String ASCII_ENC = NinesComplimentText.encrypt(AESEncryptedText);
        System.out.println(ASCII_ENC);
        request.setAttribute("encrypted_text", ASCII_ENC);
        RequestDispatcher rd = request.getRequestDispatcher("/text-encrypt.jsp");
        rd.forward(request, response);
    }
}
