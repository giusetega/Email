package com.mycompany.emailapp;

public class EmailApp {

    public static void main(String[] args) {         
        Email email1 = new Email("John","Smith");   
        System.out.println("Your email based on your first name, last name and department: " + email1.getEmail());        
        System.out.println(email1);        
        System.out.println("----------------------------------");        
        
        email1.changePassword();
        System.out.println("Your new password is: " + email1.getPassword());
        System.out.println(email1);
    }
    
}
