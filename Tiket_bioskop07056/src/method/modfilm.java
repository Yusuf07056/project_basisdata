/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package method;

import javax.swing.table.DefaultTableModel;
import koneksi.koneksi;
import abstraksi.abstrak_film;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author YUSUF KRISNA . N
 */
public class modfilm extends abstrak_film { 
    film[] film = new film[100];
    int dx=0;

    @Override
    public void insert(int kode_film, String nama, String genre,String rating, int harga) {
      
    }

    @Override
    public void del(int kode_film) {

    }

    @Override
    public void update(int update, int kode_film, String nama, String genre, int harga) {
        
    }
//     public DefaultTableModel view(){
//        DefaultTableModel modfilm = new DefaultTableModel();
//        modfilm.addColumn("kodefilm");
//        modfilm.addColumn("nama film");
//        modfilm.addColumn("genre");
//        modfilm.addColumn("rating");
//        modfilm.addColumn("harga");
//        for (int i = 0; i < dx; i++) {
//            Object[]temp = new Object[5];
//            temp[0] = film[i].gekodfilm();
//            temp[1] = film[i].genamafilm();
//            temp[2] = film[i].gegenre();
//            temp[3] = film[i].gerating();
//            temp[4] = film[i].get_harga();
//            modfilm.addRow(temp);
//        }            
//     return modfilm;
//    }    
}
