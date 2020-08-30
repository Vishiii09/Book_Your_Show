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
public class Movie {
    private int m_id; //mid
    private String m_name,m_banner,m_Release_date,m_description,m_Release_out;
        //mNname,mBanner,mRelease#date,mDescription,mReleaseOut.....
    public Movie() {
    }

    public int getM_id() {
        return m_id;
    }

    public void setM_id(int M_id) {
        this.m_id = M_id;
    }

    public String getM_name() {
        return m_name;
    }

    public void setM_name(String M_name) {
        this.m_name = M_name;
    }

    public String getM_banner() {
        return m_banner;
    }

    public void setM_banner(String M_banner) {
        this.m_banner = M_banner;
    }

    public String getM_Release_date() {
        return m_Release_date;
    }

    public void setM_Release_date(String M_Release_date) {
        this.m_Release_date = M_Release_date;
    }

    public String getM_description() {
        return m_description;
    }

    public void setM_description(String M_description) {
        this.m_description = M_description;
    }

    public String getM_Release_out() {
        return m_Release_out;
    }

    public void setM_Release_out(String M_Release_out) {
        this.m_Release_out = M_Release_out;
    }
    public static void main(String[] args) {
        Movie m = new Movie();
        m.setM_name("Kick");
    }
}
