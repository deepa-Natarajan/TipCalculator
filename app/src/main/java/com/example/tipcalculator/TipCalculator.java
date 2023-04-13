package com.example.tipcalculator;

public class TipCalculator {

    private float tip;
    private float bill;

    public TipCalculator(float newTip, float newBill) {
        setTip(newTip);
        setBill(newBill);

    }

    protected void setBill(float newBill) {
        if (newBill >= 0)
            this.bill = newBill;
    }

    protected void setTip(float newTip) {
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

        return (tip )* bill;
    }
    public float billAmount(){

        return tipAmount()+ getBill();

    }

}
