package com.example.BetterCrypt;

import com.example.Email.EmailUtil;
import com.example.Security.Image.AESImage;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

@WebServlet(name = "EmailServlet", value = "/EmailServlet")
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024, // 1 MB
        maxFileSize = 1024 * 1024 * 10,      // 10 MB
        maxRequestSize = 1024 * 1024 * 100   // 100 MB
)
public class EmailServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String dir="", fileName = "", filePath="", email="";

        // read form fields
        String secretKey = request.getParameter("floatingKey");
        String bits = request.getParameter("bits");

        try{
            dir = getServletContext().getRealPath("/");
            Part part = request.getPart("file");
            fileName = part.getSubmittedFileName();

            filePath = dir+fileName;
            part.write(filePath);
        } catch (Exception e){
            e.printStackTrace();
            RequestDispatcher rd = request.getRequestDispatcher("/image-encrypt.jsp");
            request.setAttribute("error", "Please upload an image");
            rd.forward(request, response);
        }

        try {
            fileName = AESImage.encrypt(dir, filePath, secretKey, Integer.parseInt(bits) ,fileName);
        }catch (Exception e){
            e.printStackTrace();
            RequestDispatcher rd = request.getRequestDispatcher("/image-encrypt.jsp");
            request.setAttribute("error", e.getMessage());
            rd.forward(request, response);
        }

        String EncryptedfilePath = dir+fileName;

        // Delete original file
        File myObj = new File(filePath);
        if (myObj.delete()) {
            System.out.println("Deleted the file: " + myObj.getName());
        } else {
            System.out.println("Failed to delete the file.");
        }

        Cookie cookie = null;
        Cookie[] cookies = null;

        // Get an array of Cookies associated with the this domain
        cookies = request.getCookies();

        if( cookies != null ) {
            for (Cookie value : cookies) {
                cookie = value;
                System.out.println("Name : " + cookie.getName() + ",  ");
                System.out.println("Value: " + cookie.getValue());
                if((cookie.getName( )).compareTo("email") == 0 ) {
                    email = cookie.getValue();
                    cookie.setMaxAge(0);
                    response.addCookie(cookie);
                    System.out.println("Deleted cookie: " +
                            cookie.getName( ));
                }
            }

            System.out.println();

            for (Cookie value : cookies) {
                cookie = value;
                System.out.println("Name : " + cookie.getName() + ",  ");
                System.out.println("Value: " + cookie.getValue());
            }

        } else {
            System.out.println("No cookie");
        }

        try{
            EmailUtil.sendEmail(email, EncryptedfilePath, fileName);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Delete encrypted file
        myObj = new File(EncryptedfilePath);
        if (myObj.delete()) {
            System.out.println("Deleted the file: " + myObj.getName());
        } else {
            System.out.println("Failed to delete the file.");
        }

        request.setAttribute("success","Email Sent");
        RequestDispatcher rd = request.getRequestDispatcher("/image-encrypt.jsp");
        rd.forward(request, response);


    }
}
