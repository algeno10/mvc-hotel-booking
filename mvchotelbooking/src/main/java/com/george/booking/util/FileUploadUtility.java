package com.george.booking.util;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

public class FileUploadUtility {
	
	private static final String ABS_PATH = "C:\\Users\\User\\Documents\\workspace-sts-3.9.4.RELEASE\\mvc-hotel-booking\\mvchotelbooking\\src\\main\\webapp\\assets\\images";
	private static String REAL_PATH = "";
	
	private static final Logger logger = LoggerFactory.getLogger(FileUploadUtility.class);
	public static void uploadFile(HttpServletRequest request, MultipartFile file, String code) {
		
		// get the real path
		
	}

}
