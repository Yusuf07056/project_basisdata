/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transaksi;
import koneksi.koneksi;
import method.*;
import form.*;
import javax.swing.table.DefaultTableModel;
import koneksi.koneksi;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author YUSUF KRISNA . N
 */
public class transaksi {
    koneksi koneksi;
    ArrayList<film>arrfilm;
    ArrayList<pelanggan>arrreg;
    ArrayList<jadwal_met>arrjdwl;
     ArrayList<tiket>arrtkt;
    public transaksi() throws SQLException{
        this.koneksi = new koneksi();
        this.arrfilm = new ArrayList<>();
        this.arrjdwl = new ArrayList<>();
        this.arrreg = new ArrayList<>();
        this.arrtkt = new ArrayList<>();
    }
    public ArrayList<film>get_film()throws SQLException{
        this.arrfilm.clear();
        ResultSet result = this.koneksi.GetData("SELECT * FROM FILM_07056");
        while (result.next()) {            
            film film = new film();
            film.setkodefilm(result.getString("KODEFILM"));
            film.setnamafilm(result.getString("NAMAFILM"));
            film.setgenre(result.getString("GENRE"));
            film.setrating(result.getString("RATING"));
            film.setharga(result.getInt("HARGA"));
            this.arrfilm.add(film);
        }
        return this.arrfilm;
    }
    public ArrayList<jadwal_met> getDataJadwal() throws SQLException {
        this.arrjdwl.clear();
        ResultSet rs = this.koneksi.GetData("SELECT * FROM JADWAL_07056 JOIN FILM_07056 ON JADWAL_07056.KODEFILM = FILM_07056.KODEFILM");
        while (rs.next()) {
            film film = new film();
            film.setkodefilm(rs.getString("KODEFILM"));
            film.setnamafilm(rs.getString("NAMAFILM"));
            film.setgenre(rs.getString("GENRE"));
            film.setrating(rs.getString("RATING"));
            film.setharga(rs.getInt("HARGA"));

            jadwal_met jadwal = new jadwal_met();
            jadwal.setkodejadwal(rs.getInt("KODEJADWAL"));
            jadwal.setfilm(film);
            jadwal.settanggal(new Date(rs.getString("TANGGALTAYANG")));
            jadwal.setjamtayang(rs.getString("JAMTAYANG"));
            jadwal.setruang(rs.getString("RUANG"));

            this.arrjdwl.add(jadwal);
        }
        return this.arrjdwl;
    }
    public ArrayList<pelanggan>get_regis()throws SQLException{
        this.arrreg.clear();
        ResultSet result = this.koneksi.GetData("SELECT * FROM PELANGGAN_07056 JOIN REGISTER_07056 ON PELANGGAN_07056.IDREGISTER = REGISTER_07056.IDREGISTER ORDER BY PELANGGAN_07056.NOKTP");
        while (result.next()) {            
            registrasi_method reg = new registrasi_method();
            reg.set_noktp(result.getInt("NOKTP"));
            reg.set_nama(result.getString("NAMAUSER"));
            reg.set_alamat(result.getString("ALAMAT"));
            reg.set_notelp(result.getString("NO_TELP"));
            pelanggan pel = new pelanggan();
            pel.setIdreg(result.getInt("IDREGISTER"));
            pel.setPassword("PASSWORD");
            reg.setPel(pel);
            pel.setRegi(reg);
            
            this.arrreg.add(pel);
        }
        return this.arrreg;
    }
   
    public void insert_film(film film)throws SQLException{
        this.koneksi.ManipulasiData("INSERT INTO FILM_07056 VALUES("+"'"+film.gekodfilm()+"'"+","+"'"+film.genamafilm()+"'"+","+"'"+film.gegenre()+"'"+","+"'"+film.gerating()+"'"+","+film.get_harga()+")");
    }
    public void delete_film(String i) throws SQLException{
        this.koneksi.ManipulasiData("DELETE FROM FILM_07056 WHERE KODEFILM = '"+i+"'");
    }
    public void update(String kode, Integer harga) throws SQLException{
        this.koneksi.ManipulasiData("UPDATE FILM_07056 SET HARGA ="+harga.toString()+" WHERE KODEFILM = "+"'"+kode+"'");
    }
    public void input_jadwal(jadwal_met jdwl) throws SQLException{
        String tgl = new SimpleDateFormat("dd/MM/yyyy").format(jdwl.gettgl());
        this.koneksi.ManipulasiData("INSERT INTO JADWAL_07056 VALUES("+jdwl.getkodeljadwal()+","+"'"+jdwl.getfilm().gekodfilm()+"'"+",TO_DATE('" + tgl + "','dd/MM/yyyy'),"+"'"+jdwl.getjam()+"'"+","+"'"+jdwl.getruang()+"'"+")");
    }
    public void delete_jadwal(Integer i) throws SQLException{
        this.koneksi.ManipulasiData("DELETE FROM jadwal_07056 WHERE KODEJADWAL = "+i);
    }
    public void update_jadwal(Integer kode, String ruang, String jam) throws SQLException{
        this.koneksi.ManipulasiData("UPDATE JADWAL_07056 SET JAMTAYANG ='"+jam+"',"+"RUANG = '"+ruang+"' WHERE KODEJADWAL = "+kode);
    }
    public void registrasi(registrasi_method reg)throws SQLException{
        this.koneksi.ManipulasiData("INSERT INTO REGISTER_07056 values ("+reg.get_noktp()+","+"'"+reg.get_nama()+"'"+","+"'"+reg.get_alamat()+"'"+","+"'"+reg.get_notelp().toString()+"'"+","+reg.getIdregistrasi()+")");
    }
//    public void pelanggan(pelanggan pel)throws SQLException{
//        this.koneksi.ManipulasiData("INSERT INTO PELANGGAN_07056 values ("+pel.getIdreg()+","+pel.get_noktp()+","+"'"+pel.getPassword()+"'"+")");
//    }
    
    //---------------------------------------------------PELANGGAN-----------------------------------------------------------------------------------
     public void insertuser(registrasi_method reg, String nama) throws SQLException {
                this.koneksi.ManipulasiData("INSERT INTO REGISTER_07056 VALUES ("+reg.get_noktp()+","+"'"+
                        reg.get_nama()+"'"+","+"'"+reg.get_alamat()+"'"+","
                        +"'"+reg.get_notelp().toString()+"'"+","+null+")");
    
                this.koneksi.ManipulasiData("INSERT INTO PELANGGAN_07056 VALUES (" + 
                        reg.getPel().getIdreg() + 
                        ",'"  + reg.get_noktp() + 
                        "'," + "'" + reg.getPel().getPassword() + "'" + ")");
                this.koneksi.ManipulasiData("UPDATE register_07056 SET IDREGISTER = " + 
                        reg.getPel().getIdreg() + " WHERE NAMAUSER='"+ nama+"'");
    }
    public void login(Integer user, String pass)
    {
        try {
        ResultSet rs0 = this.koneksi.GetData("CREATE VIEW LOGIN AS"
                + " SELECT a.IDREGISTER, b.NAMAUSER, a.PASSWORD, b.NO_TELP, b.ALAMAT, b.NOKTP"
                + " FROM REGISTER_07056 b JOIN PELANGGAN_07056 a"
                + " ON b.NOKTP = a.NOKTP");
        
        ResultSet rs = this.koneksi.GetData("SELECT * FROM LOGIN"
                + " WHERE IDREGISTER = " + user + " AND PASSWORD = '" + pass + "'");
        int baris = 0;
     
            while (rs.next()) {
                baris = rs.getRow();
           
            if (baris ==1) {
                registrasi_method pem = new registrasi_method();
                pem.setIdregistrasi(rs.getInt("IDREGISTER"));
                pem.set_nama(rs.getString("NAMAUSER"));
                pem.set_notelp(rs.getString("NO_TELP"));
                pem.set_noktp(rs.getInt("NOKTP"));
                pem.set_alamat(rs.getString("ALAMAT"));
           
                pelanggan reg = new pelanggan();
                //reg.setIdreg(rs.getInt("IDREGISTER"));
                reg.setPassword(rs.getString("PASSWORD"));

                pem.setPel(reg);
                reg.setRegi(pem);
                new pembelian_tiket(rs.getString("NAMAUSER"), rs.getInt("IDREGISTER")).setVisible(true);
                
            }else {
                
            }
            }
        } catch (SQLException ex) {
            Logger.getLogger(transaksi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
//----------------------------------------PEMBELIAN TIKET------------------------------------
    public ArrayList<tiket> getDataTransaksi() throws SQLException {
        this.arrtkt.clear();
        ResultSet rs = this.koneksi.GetData("SELECT * FROM PELANGGAN_07056 JOIN REGISTER_07056"
                + " ON PELANGGAN_07056.NOKTP = REGISTER_07056.NOKTP"
                + " JOIN TIKET_07056"
                + " ON TIKET_07056.IDREGISTER = PELANGGAN_07056.IDREGISTER ORDER BY TIKET_07056.KODETIKET");
        while (rs.next()) {
            registrasi_method reg = new registrasi_method();
            reg.setIdregistrasi(rs.getInt("IDREGISTER"));
            reg.set_nama(rs.getString("NAMAUSER"));
            reg.set_alamat(rs.getString("ALAMAT"));
            reg.set_notelp(rs.getString("TELP"));
            reg.set_noktp(rs.getInt("NOKTP"));

            pelanggan pel = new pelanggan();
            pel.setIdreg(rs.getInt("IDREGISTER"));
            pel.setRegi(reg);
            pel.setPassword(rs.getString("PASSWORD"));
            
            reg.setPel(pel);
            
            tiket transaksi = new tiket();
            transaksi.setreg(reg);
            transaksi.setKode_Tiket(rs.getInt("KODETIKET"));
            transaksi.setDuduk(rs.getString("BANGKU"));
            transaksi.setBanyak(rs.getInt("JUMLAH"));
            transaksi.setTotal(rs.getInt("NPM087056_TOTAL"));
            
            ResultSet rsHave = this.koneksi.GetData("SELECT * FROM SET_07056 JOIN JADWAL_07056 "
                    + "ON SET_07056.KODEJADWAL = JADWAL_07056.KODEJADWAL "
                    + "JOIN FILM_07056 "
                    + "ON JADWAL_07056.KODEFILM = FILM_07056.KODEFILM "
                    + "WHERE SET_07056.KODETIKET = " + rs.getString("KODETIKET")+"ORDER BY SET_07056.KODETIKET");
            ArrayList<set> set = new ArrayList<>();
            
            while (rsHave.next()) {
                film film = new film();
                film.setkodefilm(rsHave.getString("KODEFILM"));
                film.setnamafilm(rsHave.getString("NAMAFILM"));
                film.setgenre(rsHave.getString("GENRE"));
                film.setrating(rs.getString("RATING"));
                film.setharga(rsHave.getInt("HARGA"));

                jadwal_met jdwl = new jadwal_met();
                jdwl.setkodejadwal(rsHave.getInt("KODEJADWAL"));
                jdwl.setfilm(film);
                jdwl.settanggal(new Date(rsHave.getString("TANGGALTAYANG")));
                jdwl.setjamtayang(rsHave.getString("JAMTAYANG"));
                jdwl.setruang(rsHave.getString("RUANG"));

                set sert = new set();
                sert.setjdwl(jdwl);
//                sert.setTkt(transaksi);
                set.add(sert);
            }
            transaksi.setarrHave(set);

            this.arrtkt.add(transaksi);
        }
        return this.arrtkt;
    }
    public void inserttrans(tiket trans) throws SQLException {
            
        this.koneksi.ManipulasiData("INSERT INTO TIKET_07056 VALUES (" + trans.getKode_Tiket() + 
                ",'" + trans.getDuduk()+  
                "'," + "'" + trans.getBanyak() + "'" +",'"+trans.getPel().getIdreg()+"','"+trans.getTotal()+ "')");
                    
        for (set seet : trans.getarrHave()) {
                this.koneksi.ManipulasiData("INSERT INTO SET_07056 VALUES ("+trans.getKode_Tiket()+",'"+seet.getjdwl().getkodeljadwal()+"'"+")");
            }
    }    

}
