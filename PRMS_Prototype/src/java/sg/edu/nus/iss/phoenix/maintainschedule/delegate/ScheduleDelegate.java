/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sg.edu.nus.iss.phoenix.maintainschedule.delegate;

import java.util.ArrayList;
import java.util.List;
import sg.edu.nus.iss.phoenix.maintainschedule.entity.AnnualSchedule;
import sg.edu.nus.iss.phoenix.maintainschedule.entity.ProgramSlot;
import sg.edu.nus.iss.phoenix.maintainschedule.entity.WeeklySchedule;
import sg.edu.nus.iss.phoenix.maintainschedule.service.ScheduleService;

/**
 *
 * @author sudarsan
 */
public class ScheduleDelegate {
    
    public ArrayList<ProgramSlot> findAllPS() {
		ScheduleService service = new ScheduleService();
		return service.findAllPS();
		
	}

    public void insertOrClonePS(ProgramSlot ps) throws Exception{
         ScheduleService service = new ScheduleService();
               service.insertOrClonePS(ps);
    }

    public void updatePS(ProgramSlot ps) throws Exception{
        ScheduleService service = new ScheduleService(); 
        service.updatePS(ps);
    }

    public void deletePS(ProgramSlot ps2) throws Exception{
        ScheduleService service = new ScheduleService(); 
        service.deletePS(ps2);
    }

    public ArrayList<AnnualSchedule> findAllAnnum() throws Exception
    {
        ScheduleService service = new ScheduleService();
        ArrayList<AnnualSchedule> listannums=service.findAllAnnums();
        return listannums;
    }
}
