/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package method;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author YUSUF KRISNA . N
 */
public class modjadwal extends inti{
    public jadwal_met[]jadwal = new jadwal_met[100];
    public int dx = 0;
    public String temp;
    
//    public void insert(String kodejadwal,String jamtayang,String tanggaltayang,String ruang){
//        jadwal_met[dx] = new jadwal_met(kodejadwal, jamtayang, tanggaltayang, ruang);
//        dx++;
//    }
//    public void search(String kodejadwal){
//        for (int i = 0; i < dx; i++) {
//            if (kodejadwal.equals(jadwal_met[i].kodejadwal)) {
//                temp = jadwal_met[i].kodejadwal;
//            }
//            
//        }
//    }
//    public void insertfilm(film film){
//        jadwal_met[dx].film = film;
//    }
//    public DefaultTableModel view(){
//        DefaultTableModel modeljadwal = new DefaultTableModel();
//        modeljadwal.addColumn("kode jadwal_met");
//        modeljadwal.addColumn("jam tayang");
//        modeljadwal.addColumn("tanggal tayang");
//        modeljadwal.addColumn("kode film");
//        modeljadwal.addColumn("ruang");
//        for (int i = 0; i < dx; i++) {
//            Object[]temp = new Object[6];
//            temp[0] = jadwal_met[i].getkodeljadwal();
//            temp[1] = jadwal_met[i].getjam();
//            temp[2] = jadwal_met[i].gettgl();
//            temp[3] = jadwal_met[i].film.namafilm;
//            temp[4] = jadwal_met[i].getruang();
//            modeljadwal.addRow(temp);
//        }
//                
//     return modeljadwal;
//    }
    
}
