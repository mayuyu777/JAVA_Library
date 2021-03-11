/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

/**
 *
 * @author natto
 */

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.*;  


public class conn {
     Connection connect;
    Statement state;
    public conn(){  
        try{  
            Class.forName("com.mysql.cj.jdbc.Driver");
            connect =DriverManager.getConnection("jdbc:mysql:///librarydb","root","");
            state =connect.createStatement();  
            
           
        }catch(ClassNotFoundException | SQLException e){ 
            System.out.println(e);
        }  
    }  
}
