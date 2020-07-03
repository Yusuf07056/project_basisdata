/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package method;

import sun.security.pkcs11.P11TlsKeyMaterialGenerator;

/**
 *
 * @author YUSUF KRISNA . N
 */
public class registrasi_method extends inti{
    public String nama, alamat, notelp,password;//idregistrasi;
    public Integer idregistrasi;
    pelanggan pel;

    public pelanggan getPel() {
        return pel;
    }

    public void setPel(pelanggan pel) {
        this.pel = pel;
    }
    public void set_noktp(Integer noktp){
        super.noktp = noktp;
    }
    
    public void set_nama(String nama){
        this.nama = nama;
    }
    
    public Integer getIdregistrasi() {
        return idregistrasi;
    }
    
    public void setIdregistrasi(Integer idregistrasi) {
        this.idregistrasi = idregistrasi;
    }
    
    public void set_alamat(String alamat){
        this.alamat = alamat;
    }
    
    public void set_notelp(String notelp){
        this.notelp = notelp;
    }
    
    public Integer get_noktp(){
        return noktp;
    }
    
    public String get_nama(){
        return nama;
    }
    
    public String get_notelp(){
        return notelp;
    }
    
    public String get_alamat(){
        return alamat;
    }
}
