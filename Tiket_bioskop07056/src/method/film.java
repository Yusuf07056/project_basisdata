/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package method;

/**
 *
 * @author YUSUF KRISNA . N
 */
public class film extends inti{
   private String kode_film,nama_film,genre,rating;
   private Integer harga;
    public void setkodefilm(String kode_film){
       this.kode_film = kode_film;
    }
    public String gekodfilm(){
        return kode_film;
    }
    public void setnamafilm(String nama_film){
       this.nama_film = nama_film;
    }
    public String genamafilm(){
        return nama_film;
    }
    public void setgenre(String genre){
       this.genre = genre;
   }
    public String gegenre(){
        return genre;
    }
    public void setrating(String rating){
       this.rating = rating;
    }
    public String gerating(){
        return rating;
    }
    public void setharga(Integer harga){
       this.harga = harga;
   }
    public Integer get_harga(){
        return harga;
    }
}
