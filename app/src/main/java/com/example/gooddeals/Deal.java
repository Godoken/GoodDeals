package com.example.gooddeals;

public class Deal {

    private String header;
    private String text;
    private int coast;

    public Deal(String header, String text, int coast){
        this.header = header;
        this.text = text;
        this.coast = coast;
    }

    public int getCoast() {
        return coast;
    }

    public void setCoast(int coast) {
        this.coast = coast;
    }

    public String getHeader(){
        return header;
    }

    public void setHeader(String header){
        this.header = header;
    }

    public String getText(){
        return text;
    }

    public void setText(String text){
        this.text = text;
    }
}
