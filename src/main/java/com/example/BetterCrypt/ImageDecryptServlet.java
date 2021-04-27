package com.example.BetterCrypt;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ImageDecryptServlet", value = "/ImageDecryptServlet")
public class ImageDecryptServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // read form fields
        String secretKey = request.getParameter("floatingKey");

        Part part = request.getPart("image");
        String fileName = part.getSubmittedFileName();
        String filePath = "C:\\upload\\" + fileName;
        part.write(filePath);

        ImageDecryptAES.decrypt(filePath, secretKey);

        PrintWriter out = response.getWriter();
        String filepath = "C:\\upload\\";
        response.setContentType("APPLICATION/OCTET-STREAM");
        response.setHeader("Content-Disposition","attachment; filename=\"" + fileName + "\"");

        FileInputStream fileInputStream = new FileInputStream(filepath + fileName);

        int i;
        while ((i=fileInputStream.read()) != -1) {
            out.write(i);
        }
        fileInputStream.close();
        out.close();

        File myObj = new File(filePath);
        if (myObj.delete()) {
            System.out.println("Deleted the file: " + myObj.getName());
        } else {
            System.out.println("Failed to delete the file.");
        }

        RequestDispatcher rd = request.getRequestDispatcher("/image-decrypt.jsp");
        rd.forward(request, response);
    }
}
