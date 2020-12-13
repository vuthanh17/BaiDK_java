/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai2.dk;

import java.io.Serializable;

/**
 *
 * @author Ophis
 */
public class ThiSinh implements Serializable{
    private int sbd;
    private String hoten;
    private float diem1;
    private float diem2;
    private float diem3;
    
    public ThiSinh(int stt, String name, float d1, float d2, float d3){
        sbd = stt;
        hoten = name;
        diem1 = d1;
        diem2 = d2;
        diem3 = d3;
    }

    @Override
    public String toString() {
        return "ThiSinh{" + "sbd=" + sbd + ", hoten=" + hoten + ", diem1=" + diem1 + ", diem2=" + diem2 + ", diem3=" + diem3 + '}';
    }
    
    public ThiSinh(){
        
    }
}
