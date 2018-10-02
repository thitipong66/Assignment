/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.util.Date;

/**
 *
 * @author thitipong
 */
public class ApplicationData {
    
    private String application_id;
    private int running_number;
    private Date create_date;
    private String application_type;

    /**
     * @return the application_id
     */
    public String getApplication_id() {
        return application_id;
    }

    /**
     * @param application_id the application_id to set
     */
    public void setApplication_id(String application_id) {
        this.application_id = application_id;
    }

    /**
     * @return the running_number
     */
    public int getRunning_number() {
        return running_number;
    }

    /**
     * @param running_number the running_number to set
     */
    public void setRunning_number(int running_number) {
        this.running_number = running_number;
    }

    /**
     * @return the create_date
     */
    public Date getCreate_date() {
        return create_date;
    }

    /**
     * @param create_date the create_date to set
     */
    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }

    /**
     * @return the application_type
     */
    public String getApplication_type() {
        return application_type;
    }

    /**
     * @param application_type the application_type to set
     */
    public void setApplication_type(String application_type) {
        this.application_type = application_type;
    }
    
}
