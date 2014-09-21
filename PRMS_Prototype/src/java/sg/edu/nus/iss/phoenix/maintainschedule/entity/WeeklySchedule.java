/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sg.edu.nus.iss.phoenix.maintainschedule.entity;

import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author sudarsan
 */
public class WeeklySchedule implements Cloneable,Serializable{
    private Date startDate;
    private String assignedBy;

    public WeeklySchedule() {
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getAssignedBy() {
        return assignedBy;
    }

    public void setAssignedBy(String assignedBy) {
        this.assignedBy = assignedBy;
    }
    
}
