/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utility;

import java.io.File;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class FileUploader {
 public static String getUploadedPath(ServletContext context,String parentDirectory,HttpServletRequest request){
     String imagePath="";
     
                   try{
                       System.out.println("Multipart data found.......");
                    FileItemFactory factory = new DiskFileItemFactory();
                    ServletFileUpload upload = new ServletFileUpload(factory);
                    List items = null;
                    items = upload.parseRequest(request);

                    Iterator itr = items.iterator();
                    while (itr.hasNext()) {
                        FileItem item = (FileItem) itr.next();
                        if (!item.isFormField()) {
                            String photo = item.getName();
                            imagePath = parentDirectory +"/" + photo;
                            System.out.println("imagePath"+imagePath);
                            File savedFile = new File(context.getRealPath("/") + imagePath);
                            item.write(savedFile);

                        }

                    }
                   }catch(Exception e){
                       System.out.println("File Upload Error  :"+ e.getMessage());
                   }
     
     return imagePath;
 }   
}

