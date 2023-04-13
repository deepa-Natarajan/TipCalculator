package com.example.tipcalculator;

public class TipCalculator {
    private float tip;
    private float bill;

    public TipCalculator(float newBill, float newTip) {
        setTip(newTip);
        setBill(newBill);

    }

    private void setBill(float newBill) {
        if (newBill >= 0)
            this.bill = newBill;
    }

    private void setTip(float newTip) {
        if (newTip >= 0)
            this.tip = newTip;
    }

    public float getTip() {
        return tip;
    }

    public float getBill() {
        return bill;
    }

    public float tipAmount() {

        return (tip /100)* bill;
    }
    public float billAmount(){

        return tipAmount()+ getBill();

    }

}
