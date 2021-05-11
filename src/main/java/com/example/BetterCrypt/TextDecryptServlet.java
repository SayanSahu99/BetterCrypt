package com.example.BetterCrypt;

import com.example.Security.Text.AESText;
import com.example.Security.Text.NinesComplimentText;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "TextDecryptServlet", value = "/TextDecryptServlet")
public class TextDecryptServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        AESText AES = new AESText();
        // read form fields
        String inputText = request.getParameter("text-decrypt");
        String secretKey = request.getParameter("floatingKey");

        inputText = inputText.replaceAll(String.valueOf((char)194),"");


        // do some processing here...

        String nineDec = NinesComplimentText.decrypt(inputText);
        String AESDecryptedText = AES.decrypt(nineDec,secretKey);

        assert AESDecryptedText != null;
        request.setAttribute("decrypted_text", AESDecryptedText.replaceAll(String.valueOf((char)8218),"").replace(String.valueOf((char)194),"").replace(String.valueOf((char)195),""));
        RequestDispatcher rd = request.getRequestDispatcher("/text-decrypt.jsp");
        rd.forward(request, response);
    }
}
