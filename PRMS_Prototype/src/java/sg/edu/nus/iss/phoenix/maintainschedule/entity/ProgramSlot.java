/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sg.edu.nus.iss.phoenix.maintainschedule.entity;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
/**
 *
 * @author sudarsan
 */
public class ProgramSlot implements Serializable,Cloneable{
    private Time duration;
    private Date dateOfProgram;
    private Time startTime;
    private String programName;
    private String presenter;
    private String producer;

    public ProgramSlot() {
    }

    public String getPresenter() {
        return presenter;
    }

    public void setPresenter(String presenter) {
        this.presenter = presenter;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }
    

    public Time getDuration() {
        return duration;
    }

    public void setDuration(Time duration) {
        this.duration = duration;
    }

    public Date getDateOfProgram() {
        return dateOfProgram;
    }

    public void setDateOfProgram(Date dateOfProgram) {
        this.dateOfProgram = dateOfProgram;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }
    
    
}
