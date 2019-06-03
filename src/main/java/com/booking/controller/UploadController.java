package com.booking.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

@Controller
@RequestMapping("/upload")
@MultipartConfig
public class UploadController {

	
	@RequestMapping(value = "/page",method = RequestMethod.GET)
	public String getPage()
	{
		return "Form";
	}

	@RequestMapping(value = "/file",method = RequestMethod.POST)
	public String upload(HttpServletRequest req,@RequestParam CommonsMultipartFile file) throws IOException, ServletException{
		Part filePart = req.getPart("file"); // code to get file
		String fileName = filePart.getSubmittedFileName(); //gives the file Name
		InputStream fileContent = filePart.getInputStream();

		byte[] buffer = null;
		String fName = "C:/Users/QSP/Desktop/Book My Doctor/File"+fileName;
		if(fileName.length() != 0){
			buffer = new byte[fileContent.available()];
			fileContent.read(buffer);
			OutputStream outStream = new FileOutputStream(fName);
			outStream.write(buffer);
			outStream.close();
			fileContent.close();
			return "Success";
		}else{
			return "Failed";
		}
	}

}
