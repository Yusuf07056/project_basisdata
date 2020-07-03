/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oraclejava;
import form.*;
import koneksi.koneksi;
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import method.film;
/**
 *
 * @author YUSUF KRISNA . N
 */
public class main {

    public static void main(String[] args) throws SQLException, ParseException{
        // TODO code application logic here
        new awal().show();
        new koneksi();
        
    }
    
}
