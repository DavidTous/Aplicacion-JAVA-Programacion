package javaapplication1;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;    
import javax.swing.JOptionPane;

/**
 *
 * @author david
 */
public class conexionbd {
    
    public static void main(String[] args) {
        //System.out.println("perfesto");
        conexionbd conexion = new conexionbd();
    }

     // ATRIBUTO

protected static Connection conn = null;


// CONSTRUCTOR

public conexionbd() {
        this.connect();
    

     }


 // Create DB Connection Method

private void connect(){
    try {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            }catch (ClassNotFoundException exc){
                System.out.println("No driver detected! " + exc);
            }


            conexionbd.conn = DriverManager.getConnection("jdbc:mysql://192.168.56.2:3306/Programacion", "david", "david");
            }catch (java.sql.SQLException sqle){
                System.out.println("ERROR: " + sqle);
                JOptionPane.showMessageDialog(null, "There's been a problem connecting with the database\nPlease try later",
                        "Connection Error", JOptionPane.ERROR_MESSAGE );
            }
}

// Connection test method for login error

public boolean connectionValid(){
    try {
        return conexionbd.conn.isValid(50000);
    } catch (SQLException sqle) {
        System.out.println("CONNECTION ERROR: " + sqle);
        return false;
    }
}

 // Metodo de cerar la base de datos

public static void closeConnection(){
 if(conexionbd.conn!=null){
     try{
         conexionbd.conn.close();
     }catch(SQLException sqle){
         System.out.println("Conexion cerrada"+sqle);
     }
   }
 }
}
