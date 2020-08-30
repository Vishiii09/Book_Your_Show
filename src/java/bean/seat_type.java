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
public class seat_type {
     private int id,T_id;
    private String seat_avail,silver,gold,platinum,S_Rate,G_Rate,P_Rate;

    public seat_type() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getT_id() {
        return T_id;
    }

    public void setT_id(int T_id) {
        this.T_id = T_id;
    }

    public String getSeat_avail() {
        return seat_avail;
    }

    public void setSeat_avail(String seat_avail) {
        this.seat_avail = seat_avail;
    }

    public String getSilver() {
        return silver;
    }

    public void setSilver(String silver) {
        this.silver = silver;
    }

    public String getGold() {
        return gold;
    }

    public void setGold(String gold) {
        this.gold = gold;
    }

    public String getPlatinum() {
        return platinum;
    }

    public void setPlatinum(String platinum) {
        this.platinum = platinum;
    }

    public String getS_Rate() {
        return S_Rate;
    }

    public void setS_Rate(String S_Rate) {
        this.S_Rate = S_Rate;
    }

    public String getG_Rate() {
        return G_Rate;
    }

    public void setG_Rate(String G_Rate) {
        this.G_Rate = G_Rate;
    }

    public String getP_Rate() {
        return P_Rate;
    }

    public void setP_Rate(String P_Rate) {
        this.P_Rate = P_Rate;
    }
}
