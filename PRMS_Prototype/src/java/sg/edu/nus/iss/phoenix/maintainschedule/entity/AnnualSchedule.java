/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sg.edu.nus.iss.phoenix.maintainschedule.entity;

import java.io.Serializable;

/**
 *
 * @author sudarsan
 */
public class AnnualSchedule implements Serializable {
    private int year;
    private String assignedBy;

    public AnnualSchedule() {
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getAssignedBy() {
        return assignedBy;
    }

    public void setAssignedBy(String assignedBy) {
        this.assignedBy = assignedBy;
    }
    
}
