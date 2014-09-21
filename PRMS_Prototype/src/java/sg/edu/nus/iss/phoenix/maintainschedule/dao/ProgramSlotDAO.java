/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sg.edu.nus.iss.phoenix.maintainschedule.dao;

import java.sql.SQLException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import sg.edu.nus.iss.phoenix.core.exceptions.NotFoundException;
import sg.edu.nus.iss.phoenix.maintainschedule.entity.AnnualSchedule;
import sg.edu.nus.iss.phoenix.maintainschedule.entity.ProgramSlot;

/**
 *
 * @author sudarsan
 */
public interface ProgramSlotDAO {
    
    public abstract List<ProgramSlot> loadAll() throws SQLException;

    public List<ProgramSlot> loadWeekly(Date dateOfProgram)throws SQLException;

    public List<ProgramSlot> loadAnnual(int year) throws SQLException ;
    
    public void create(ProgramSlot ps)throws SQLException;

    public void delete(ProgramSlot ps) throws SQLException,NotFoundException;
    
    public void update(ProgramSlot ps)throws SQLException,NotFoundException;

    
}

