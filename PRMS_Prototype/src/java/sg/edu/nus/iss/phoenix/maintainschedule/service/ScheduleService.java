/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sg.edu.nus.iss.phoenix.maintainschedule.service;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import sg.edu.nus.iss.phoenix.core.dao.DAOFactoryImpl;
import sg.edu.nus.iss.phoenix.core.exception.AppException;
import sg.edu.nus.iss.phoenix.core.exception.OverlapException;
import sg.edu.nus.iss.phoenix.core.exceptions.NotFoundException;
import sg.edu.nus.iss.phoenix.maintainschedule.dao.AnnualScheduleDAO;
import sg.edu.nus.iss.phoenix.maintainschedule.dao.ProgramSlotDAO;
import sg.edu.nus.iss.phoenix.maintainschedule.entity.AnnualSchedule;
import sg.edu.nus.iss.phoenix.maintainschedule.entity.ProgramSlot;

/**
 *
 * @author sudarsan
 */
public class ScheduleService {
    DAOFactoryImpl factory;
    ProgramSlotDAO psdao;
    AnnualScheduleDAO annualdao;
	public ScheduleService() {
		super();
		factory = new DAOFactoryImpl();
		psdao = factory.getProgramSlotDao();
                annualdao = factory.getAnnualScheduleDao();
	}

    public ArrayList<ProgramSlot> findAllPS() {
        ArrayList<ProgramSlot> currentList = new ArrayList<ProgramSlot>();
		try {
			currentList = (ArrayList<ProgramSlot>) psdao.loadAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return currentList;}

    public void insertOrClonePS(ProgramSlot ps) throws OverlapException, AppException {
        try{
        Boolean overlap = checkOverlap(ps);
        if (overlap.booleanValue() == true)
				throw new OverlapException("Overlap with existing schedule!");
              psdao.create(ps);
		} catch (SQLException e) {
			Logger.getLogger(ScheduleService.class.getName()).log(Level.SEVERE, "Error occured while create new schedule :"+ e.getMessage(), e);
			throw new AppException(e);
                }
    }
    
    private Boolean checkOverlap(ProgramSlot schedule) throws SQLException
	{
		
			//get all schedule within same day
			List<ProgramSlot> scheduleList = psdao.loadWeekly(schedule.getDateOfProgram());
			//check any overlap
			for (int i=0; i<scheduleList.size(); i++)
			{
				if (scheduleList.get(i).getDateOfProgram().compareTo(schedule.getDateOfProgram())!=0)
					continue;
				else{
                                        String[] dateStrings = { schedule.getDuration().toString(), schedule.getStartTime().toString() };
                                        DateFormat df = new SimpleDateFormat("hh:mm:ss");
                                        String[] dateStrings1 = { scheduleList.get(i).getDuration().toString(), scheduleList.get(i).getStartTime().toString() };
                                        Date endTime = sumDates(dateStrings, df);
                                        Date endTime1 = sumDates(dateStrings1, df);
                                        String[] dateStrings3 = { "00:00:00", schedule.getStartTime().toString() };
                                        Date startTime = sumDates(dateStrings3, df);
                                        String[] dateStrings4 = { "00:00:00", scheduleList.get(i).getStartTime().toString() };
                                        Date startTime1 = sumDates(dateStrings4, df);
//                                        long et1=endTime.getTime();
//                                        long st1=schedule.getStartTime().getTime();
//                                        long st2=scheduleList.get(i).getStartTime().getTime();
//                                        long et2=endTime1.getTime();
//                                        long elaps1 = endTime.getTime() - schedule.getStartTime().getTime();
//					long elaps2 = endTime1.getTime() - scheduleList.get(i).getStartTime().getTime();
//					long elaps3 = endTime.getTime() - scheduleList.get(i).getStartTime().getTime();
//					System.out.println(elaps1+" "+elaps2+" "+elaps3);
//					if (Math.abs(elaps3)<(Math.abs(elaps1) + Math.abs(elaps2))){
//						return new Boolean(true);
//					}else
//						continue;
//				}
//			}
//			return new Boolean (false);
//                                        if(((
//                                                ((endTime.getTime())>(scheduleList.get(i).getStartTime().getTime()))&&
//                                                ((schedule.getStartTime().getTime())<(endTime1.getTime())))||
//                                                ((endTime1.getTime())>(schedule.getStartTime().getTime())&&
//                                                ((scheduleList.get(i).getStartTime().getTime())<(endTime.getTime()))))){
                                          if
                                                  (
                                                    (startTime.before(endTime1)&&
                                                  startTime.after(startTime1))||
                                                  (endTime.before(endTime1))&&
                                                  (endTime.after(startTime1)))
                                                  
                                          {
                                            return new Boolean(true);
                                            }
                                        else
						continue;
				}
                        }
                        return new Boolean (false);
                }
	
    
        public Date sumDates(String[] dateStrings, DateFormat df) {
                int secs=0, mins=0, hrs=0;
                Calendar calendar = Calendar.getInstance();
                try {
            for (int i=0; i<dateStrings.length; i++) 
            {
                  String dateString = dateStrings[i];
                  Date date;
                    
                        date = (Date) df.parse(dateString);
                    
                  calendar.setTime(date);
                  secs += calendar.get(Calendar.SECOND);
                  mins += calendar.get(Calendar.MINUTE);
                  hrs += calendar.get(Calendar.HOUR);
            }
                calendar.set(0, 0, 0, hrs, mins, secs);
                
            } catch (ParseException ex) {
                        Logger.getLogger(ScheduleService.class.getName()).log(Level.SEVERE, null, ex);
                    }
                return calendar.getTime();
    
    }

    public void updatePS(ProgramSlot ps) throws OverlapException, AppException,NotFoundException {
       try{
//        Boolean overlap = checkOverlap(ps);
//        if (overlap.booleanValue() == true)
//				throw new OverlapException("Overlap with existing schedule!");
              psdao.update(ps);
		} catch (SQLException e) {
			Logger.getLogger(ScheduleService.class.getName()).log(Level.SEVERE, "Error occured while create new schedule :"+ e.getMessage(), e);
			throw new AppException(e);
                }
    } 

    public void deletePS(ProgramSlot ps2) throws AppException {
        try 
		{
			psdao.delete(ps2);
		} catch (NotFoundException e){
			Logger.getLogger(ScheduleService.class.getName()).log(Level.SEVERE, "Schedule not existing while delete schedule :"+ e.getMessage(), e);
                        throw new AppException(e);
		} catch (SQLException e) {
			Logger.getLogger(ScheduleService.class.getName()).log(Level.SEVERE, "Error occured while delete schedule :"+ e.getMessage(), e);
                        throw new AppException(e);
		} 
    }
    
    public ArrayList<AnnualSchedule> findAllAnnums() throws SQLException
    {
        ArrayList<AnnualSchedule> years=annualdao.loadYears();
        return years;
    
    }
}
