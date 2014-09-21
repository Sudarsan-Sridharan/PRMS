/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.phoenix.core.exception;

import java.sql.SQLException;

/**
 *
 * @author sudarsan
 */
public class AppException extends Exception{

    public AppException(Exception e) {
        super(e.getMessage()); //To change body of generated methods, choose Tools | Templates.
    }

   

    
    
}
