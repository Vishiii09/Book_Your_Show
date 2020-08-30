/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

/**
 *
 * @author HP
 */
public class Booking {
     private int B_id,Trans_id,T_id,total_seats;
    private String Amount,Date,timing,seat_type;

    public Booking() {
    }

    public int getB_id() {
        return B_id;
    }

    public void setB_id(int B_id) {
        this.B_id = B_id;
    }

    public int getTrans_id() {
        return Trans_id;
    }

    public void setTrans_id(int Trans_id) {
        this.Trans_id = Trans_id;
    }

    public int getT_id() {
        return T_id;
    }

    public void setT_id(int T_id) {
        this.T_id = T_id;
    }

    public int getTotal_seats() {
        return total_seats;
    }

    public void setTotal_seats(int total_seats) {
        this.total_seats = total_seats;
    }

    public String getAmount() {
        return Amount;
    }

    public void setAmount(String Amount) {
        this.Amount = Amount;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }

    public String getTiming() {
        return timing;
    }

    public void setTiming(String timing) {
        this.timing = timing;
    }

    public String getSeat_type() {
        return seat_type;
    }

    public void setSeat_type(String seat_type) {
        this.seat_type = seat_type;
    }
}
