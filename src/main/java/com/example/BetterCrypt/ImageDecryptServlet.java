package com.example.BetterCrypt;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;

@WebServlet(name = "ImageDecryptServlet", value = "/ImageDecryptServlet")
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024, // 1 MB
        maxFileSize = 1024 * 1024 * 10,      // 10 MB
        maxRequestSize = 1024 * 1024 * 100   // 100 MB
)
public class ImageDecryptServlet extends HttpServlet {
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
        String filePath = dir + fileName;
        part.write(filePath);

        //ImageDecryptAES.decrypt(dir, fileName ,secretKey);

        fileName = ImageEncDec.decrypt(dir, filePath, secretKey, fileName);
        String decryptedFilePath = dir+fileName;

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


        File myObj = new File(filePath);
        if (myObj.delete()) {
            System.out.println("Deleted the file: " + myObj.getName());
        } else {
            System.out.println("Failed to delete the file.");
        }

        myObj = new File(decryptedFilePath);
        if (myObj.delete()) {
            System.out.println("Deleted the file: " + myObj.getName());
        } else {
            System.out.println("Failed to delete the file.");
        }

        RequestDispatcher rd = request.getRequestDispatcher("/image-decrypt.jsp");
        rd.forward(request, response);
    }
}
