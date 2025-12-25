package com.miniProj.exception;


public class ResourceNotFoundException extends RuntimeException {
	
	public ResourceNotFoundException(String resourceName, String fieldName, Object fieldValue) {
        // Construct a descriptive message to pass to the RuntimeException superclass
        super(String.format("%s not found with %s : '%s'", resourceName, fieldName, fieldValue));
    }
	
	
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
