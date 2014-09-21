package sg.edu.nus.iss.phoenix.core.dao;

import sg.edu.nus.iss.phoenix.authenticate.dao.RoleDao;
import sg.edu.nus.iss.phoenix.authenticate.dao.UserDao;
import sg.edu.nus.iss.phoenix.authenticate.dao.impl.RoleDaoImpl;
import sg.edu.nus.iss.phoenix.authenticate.dao.impl.UserDaoImpl;
import sg.edu.nus.iss.phoenix.maintainschedule.dao.AnnualScheduleDAO;
import sg.edu.nus.iss.phoenix.maintainschedule.dao.ProgramSlotDAO;
import sg.edu.nus.iss.phoenix.maintainschedule.dao.impl.AnnualScheduleDAOImpl;
import sg.edu.nus.iss.phoenix.maintainschedule.dao.impl.ProgramSlotDAOImpl;
import sg.edu.nus.iss.phoenix.radioprogram.dao.RadioProgramDAO;
import sg.edu.nus.iss.phoenix.radioprogram.dao.impl.RadioProgramDAOImpl;

public class DAOFactoryImpl implements DAOFactory {
	private UserDao userDAO = new UserDaoImpl();
	private RoleDao roleDAO = new RoleDaoImpl();
	private RadioProgramDAO rpdao = new RadioProgramDAOImpl();
        private ProgramSlotDAO psdao = new ProgramSlotDAOImpl();
        private AnnualScheduleDAO annualdao = new AnnualScheduleDAOImpl();
	@Override
	public UserDao getUserDAO() {
		// TODO Auto-generated method stub
		return userDAO;
	}

	@Override
	public RoleDao getRoleDAO() {
		// TODO Auto-generated method stub
		return roleDAO;
	}

	@Override
	public RadioProgramDAO getRadioProgramDAO() {
		// TODO Auto-generated method stub
		return rpdao;
	}

    @Override
    public ProgramSlotDAO getProgramSlotDao() {
        return psdao;
    }

    @Override
    public AnnualScheduleDAO getAnnualScheduleDao() {
        return annualdao; //To change body of generated methods, choose Tools | Templates.
    }

}
