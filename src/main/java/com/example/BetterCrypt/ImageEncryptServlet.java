package com.example.BetterCrypt;

import com.example.Security.Image.AESImage;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "ImageEncryptServlet", value = "/ImageEncryptServlet")
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024, // 1 MB
        maxFileSize = 1024 * 1024 * 10,      // 10 MB
        maxRequestSize = 1024 * 1024 * 100   // 100 MB
)
public class ImageEncryptServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // read form fields
        String secretKey = request.getParameter("floatingKey");

        String dir = getServletContext().getRealPath("/");
        Part part = request.getPart("file");
        String fileName = part.getSubmittedFileName();

        String filePath = dir+fileName;
        part.write(filePath);

        //ImageEncryptAES.encrypt(filePath, secretKey);

        fileName = AESImage.encrypt(dir, filePath, secretKey, fileName);
        String EncryptedfilePath = dir+fileName;

        PrintWriter out = response.getWriter();
        response.setContentType("APPLICATION/OCTET-STREAM");
        response.setHeader("Content-Disposition","attachment; filename=\"" + fileName + "\"");

        FileInputStream fileInputStream = new FileInputStream(dir + fileName);

        int i;
        while ((i=fileInputStream.read()) != -1) {
            out.write(i);
        }
        fileInputStream.close();
        out.close();

        // Delete original file
        File myObj = new File(filePath);
        if (myObj.delete()) {
            System.out.println("Deleted the file: " + myObj.getName());
        } else {
            System.out.println("Failed to delete the file.");
        }

        // Delete encrypted file
        myObj = new File(EncryptedfilePath);
        if (myObj.delete()) {
            System.out.println("Deleted the file: " + myObj.getName());
        } else {
            System.out.println("Failed to delete the file.");
        }

        RequestDispatcher rd = request.getRequestDispatcher("/image-encrypt.jsp");
        rd.forward(request, response);
    }
}
