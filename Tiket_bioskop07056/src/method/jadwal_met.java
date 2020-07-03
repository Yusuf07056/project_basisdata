/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package method;

import java.util.Date;
import oracle.sql.DATE;

/**
 *
 * @author YUSUF KRISNA . N
 */
public class jadwal_met extends inti{
    private film film;
    private String jamtayang,ruang;
    Date tanggaltayang;
    public void setkodejadwal(Integer kodejadwal){
        super.kodejadwal = kodejadwal;
    }
     public void setfilm(film film){
        this.film=film;
    }
    public void setjamtayang(String jamtayang){
        this.jamtayang = jamtayang;
    }
    public void settanggal(Date tanggaltayang){
        this.tanggaltayang = tanggaltayang;
    }
    public void setruang(String ruang){
        this.ruang = ruang;
    }
    public Integer getkodeljadwal(){
        return kodejadwal;
    }
    public film getfilm(){
        return film;
    }
    public String getjam(){
        return jamtayang;
    }
    public Date gettgl(){
        return tanggaltayang;
    }
    public String getruang(){
        return ruang;
    }
}
