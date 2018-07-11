package com.george.booking.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.george.mvcbookingbackend.dto.Property;

public class PropertyValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Property.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		
		Property property = (Property) target;
		
		//check whether file has been selected or not
		if(property.getFile()==null || 
				property.getFile().getOriginalFilename().equals("")) {
			errors.rejectValue("file", null, "Please select an image file to upload!");
			return;
		}
		
		if(! (property.getFile().getContentType().equals("image/jpeg") ||
				property.getFile().getContentType().equals("image/png") ||
				property.getFile().getContentType().equals("image/gif") ||
				property.getFile().getContentType().equals("image/js")
				)) {
			errors.rejectValue("file", null, "Please use only image file for upload");
			return;
		}

	}

}
