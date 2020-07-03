/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package method;

import java.util.ArrayList;

/**
 *
 * @author YUSUF KRISNA . N
 */
public class tiket {
    private Integer Kode_Tiket;
    private registrasi_method reg;
    private pelanggan pel;
    private Integer Banyak;
    private ArrayList<set>arrset;
    private Integer total;
    private String duduk;

    public String getDuduk() {
        return duduk;
    }

    public void setDuduk(String duduk) {
        this.duduk = duduk;
    }
    public Integer getKode_Tiket(){
        return Kode_Tiket;
    }
    public void setKode_Tiket(Integer Kode_Tiket){
        this.Kode_Tiket=Kode_Tiket;
    }

    public pelanggan getPel() {
        return pel;
    }

    public void setPel(pelanggan pel) {
        this.pel = pel;
    }
    public registrasi_method getreg(){
        return reg;
    }
    public void setreg(registrasi_method reg){
        this.reg=reg;
    }
    public Integer getBanyak(){
        return Banyak;
    }
    public void setBanyak(Integer Banyak){
        this.Banyak=Banyak;
    }
    public void setarrHave(ArrayList<set>arrset){
        this.arrset=arrset;
    }
    public ArrayList<set>getarrHave(){
        return arrset;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
