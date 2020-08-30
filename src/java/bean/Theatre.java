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
public class Theatre {
     private int T_id;
    private String T_name,No_of_shows;

    public Theatre() {
    }

    public int getT_id() {
        return T_id;
    }

    public void setT_id(int T_id) {
        this.T_id = T_id;
    }

    public String getT_name() {
        return T_name;
    }

    public void setT_name(String T_name) {
        this.T_name = T_name;
    }


    public String getNo_of_shows() {
        return No_of_shows;
    }

    public void setNo_of_shows(String No_of_shows) {
        this.No_of_shows = No_of_shows;
    }

}
