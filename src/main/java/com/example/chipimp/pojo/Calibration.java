package com.example.chipimp.pojo;

import lombok.Data;

@Data
public class Calibration {
    private String Number ;

    private String IP0_0;
    private String NOx_0;
    private String COR_0 ;

    private String IP0_1;
    private String NOx_1;
    private String COR_1 ;

    private String IP0_2;
    private String NOx_2;
    private String COR_2;

    public Calibration(){

    }

    public Calibration(String Number,String IP0_0,String NOx_0,String COR_0 ,String IP0_1,String NOx_1,String COR_1,String IP0_2,String NOx_2,String COR_2){
        this.Number = Number ;
        this.IP0_0 = IP0_0 ;
        this.NOx_0 = NOx_0 ;
        this.COR_0 = COR_0 ;

        this.IP0_1 = IP0_1 ;
        this.NOx_1 = NOx_1 ;
        this.COR_1 = COR_1 ;

        this.IP0_2 = IP0_2 ;
        this.NOx_2 = NOx_2 ;
        this.COR_2 = COR_2 ;

    }


    public void setNumber(String Number) {
        this.Number = Number;
    }

    public String getNumber() {
        return Number;
    }

    public void setIP0_0(String IP0_0) {
        this.IP0_0 = IP0_0;
    }

    public String getIP0_0() {
        return IP0_0;
    }

    public void setNOx_0(String NOx_0) {
        this.NOx_0 = NOx_0;
    }

    public String getNOx_0() {
        return NOx_0;
    }

    public void setCOR_0(String COR_0) {
        this.COR_0 = COR_0;
    }

    public String getCOR_0() {
        return COR_0;
    }

    public void setIP0_1(String IP0_1) {
        this.IP0_1 = IP0_1;
    }

    public String getIP0_1() {
        return IP0_1;
    }

    public void setNOx_1(String NOx_1) {
        this.NOx_1 = NOx_1;
    }

    public String getNOx_1() {
        return NOx_1;
    }

    public void setCOR_1(String COR_1) {
        this.COR_1 = COR_1;
    }

    public String getCOR_1() {
        return COR_1;
    }

    public void setIP0_2(String IP0_2) {
        this.IP0_2 = IP0_2;
    }

    public String getIP0_2() {
        return IP0_2;
    }

    public void setNOx_2(String NOx_2) {
        this.NOx_2 = NOx_2;
    }

    public String getNOx_2() {
        return NOx_2;
    }

    public void setCOR_2(String COR_2) {
        this.COR_2 = COR_2;
    }

    public String getCOR_2() {
        return COR_2;
    }

    @Override
    public String toString() {
        return "Calibration{" +
                "Number='" + Number + '\'' +
                ", IP0_0='" + IP0_0 + '\'' +
                ", NOx_0='" + NOx_0 + '\'' +
                ", COR_0='" + COR_0 + '\'' +
                ", IP0_1='" + IP0_1 + '\'' +
                ", NOx_1='" + NOx_1 + '\'' +
                ", COR_1='" + COR_1 + '\'' +
                ", IP0_2='" + IP0_2 + '\'' +
                ", NOx_2='" + NOx_2 + '\'' +
                ", COR_2='" + COR_2 + '\'' +
                '}';
    }

}
