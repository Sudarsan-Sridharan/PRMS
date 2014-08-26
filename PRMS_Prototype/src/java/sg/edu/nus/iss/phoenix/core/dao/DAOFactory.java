/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.phoenix.core.dao;

import sg.edu.nus.iss.phoenix.authenticate.dao.RoleDao;
import sg.edu.nus.iss.phoenix.authenticate.dao.UserDao;
import sg.edu.nus.iss.phoenix.radioprogram.dao.RadioProgramDAO;

/**
 *
 * @author projects
 */
public interface DAOFactory {

	RadioProgramDAO getRadioProgramDAO();

	RoleDao getRoleDAO();

	UserDao getUserDAO();
	
}
