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
        String bits = request.getParameter("bits");

        inputText = inputText.replaceAll(String.valueOf((char)194),"");


        // do some processing here...
        String nineDec = "";

        try {
            nineDec = NinesComplimentText.decrypt(inputText);
            System.out.println(nineDec);
        } catch (Exception e) {
            e.printStackTrace();
            RequestDispatcher rd = request.getRequestDispatcher("/text-decrypt.jsp");
            request.setAttribute("error", "Please enter encrypted text");
            rd.forward(request, response);
        }


        //String AESDecryptedText = AES.decrypt(nineDec,secretKey);

        String AESDecryptedText = null;
        try {
            AESDecryptedText = AESText.decrypt(nineDec, secretKey, Integer.parseInt(bits));
        } catch (Exception e) {
            e.printStackTrace();
            RequestDispatcher rd = request.getRequestDispatcher("/text-decrypt.jsp");
            request.setAttribute("error", e.getMessage());
            rd.forward(request, response);
        }

        System.out.println("Bits: "+bits);

        assert AESDecryptedText != null;
        request.setAttribute("success", "Text Decrypted");
        request.setAttribute("decrypted_text", AESDecryptedText.replaceAll(String.valueOf((char)8218),"").replace(String.valueOf((char)194),"").replace(String.valueOf((char)195),""));
        RequestDispatcher rd = request.getRequestDispatcher("/text-decrypt.jsp");
        rd.forward(request, response);
    }
}
