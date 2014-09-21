/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.phoenix.maintainschedule.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import sg.edu.nus.iss.phoenix.maintainschedule.entity.AnnualSchedule;

/**
 *
 * @author sudarsan
 */
public interface AnnualScheduleDAO {
    
    public ArrayList<AnnualSchedule> loadYears() throws SQLException;
}
