package com.example.BetterCrypt;

import com.example.Security.Image.AESImage;

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

        String dir="", fileName = "", filePath="", error ="";

        // read form fields
        String secretKey = request.getParameter("floatingKey");
        String bits = request.getParameter("bits");

        try{
            dir = getServletContext().getRealPath("/");
            Part part = request.getPart("file");
            fileName = part.getSubmittedFileName();
            filePath = dir + fileName;
            part.write(filePath);
        } catch (Exception e){
            e.printStackTrace();
            RequestDispatcher rd = request.getRequestDispatcher("/image-decrypt.jsp");
            request.setAttribute("error", "Please upload an image");
            rd.forward(request, response);
        }


        try {
            fileName = AESImage.decrypt(dir, filePath, secretKey, Integer.parseInt(bits) ,fileName);
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

            request.setAttribute("error", null);

        } catch (Exception e){
            e.printStackTrace();
            RequestDispatcher rd = request.getRequestDispatcher("/image-decrypt.jsp");
            request.setAttribute("error", "The key doesn't match with the image");
            rd.forward(request, response);
        }

        request.setAttribute("success", "Image Decrypted");
        RequestDispatcher rd = request.getRequestDispatcher("/image-decrypt.jsp");
        request.setAttribute("error", null);
        rd.forward(request, response);
    }
}
