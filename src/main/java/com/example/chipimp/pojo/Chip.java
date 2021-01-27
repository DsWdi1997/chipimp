package com.example.chipimp.pojo;

import lombok.Data;

@Data
public class Chip {
    private int chipID ;
    private String chipMODEL ;
    private String OE ;
    private String Voltage;

    public Chip(){
        super();
    }

    public Chip(int chipID){
        this.chipID =chipID ;
    }

    public Chip(int chipID , String chipMODEL, String OE, String Voltage){
        this.chipID = chipID ;
        this.chipMODEL = chipMODEL ;
        this.OE = OE ;
        this.Voltage = Voltage ;
    }

    public int getId(){
        return chipID ;
    }

    public void setId(int chipID){
        this.chipID = chipID ;
    }

    public String getModel(){
        return chipMODEL ;
    }

    public void setModel(String chipMODEL){
        this.chipMODEL = chipMODEL ;
    }

    public void setOE(String OE){
        this.OE = OE ;
    }

    public String getOE() {
        return OE;
    }

    public String getVoltage(){
        return Voltage;
    }

    public void setVoltage(String Voltage) {
      this.Voltage = Voltage;
    }


    @Override
    public String toString() {
        return "Chip{" +
                "chipID=" + chipID +
                ",chipMODEL='" + chipMODEL + '\'' +
                ", OE='" + OE + '\'' +
                ", Voltage='" + Voltage + '\'' +
                '}';
    }



}
