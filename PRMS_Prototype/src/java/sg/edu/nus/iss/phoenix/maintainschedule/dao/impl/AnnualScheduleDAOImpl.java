/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.phoenix.maintainschedule.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import sg.edu.nus.iss.phoenix.core.dao.DBConstants;
import sg.edu.nus.iss.phoenix.maintainschedule.dao.AnnualScheduleDAO;
import sg.edu.nus.iss.phoenix.maintainschedule.entity.AnnualSchedule;

/**
 *
 * @author sudarsan
 */
public class AnnualScheduleDAOImpl implements AnnualScheduleDAO{

    Connection connection;

    public AnnualScheduleDAOImpl() {
        super();
    }
    public AnnualSchedule createValueObject() {
        return new AnnualSchedule();

    }
    
    @Override
    public ArrayList<AnnualSchedule> loadYears() throws SQLException{
        openConnection();
        String sql = "SELECT * FROM `annual-schedule` ORDER BY `year` ASC; ";
        ArrayList<AnnualSchedule> searchResults = listQuery(connection
                .prepareStatement(sql));
        closeConnection();
        System.out.println("record size" + searchResults.size());
        return searchResults; //To change body of generated methods, choose Tools | Templates.
   
    }protected ArrayList<AnnualSchedule> listQuery(PreparedStatement stmt) throws SQLException {

        ArrayList<AnnualSchedule> years = new ArrayList<AnnualSchedule>();
        ResultSet result = null;
        openConnection();
        try {
            result = stmt.executeQuery();

            while (result.next()) {
                AnnualSchedule temp = createValueObject();
                temp.setAssignedBy(result.getString("assingedBy"));
                temp.setYear(result.getInt("year"));
                years.add(temp);
            }

        } finally {
            if (result != null) {
                result.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            closeConnection();
        }

        return (ArrayList<AnnualSchedule>) years;
    }

    private void openConnection() {
        try {
            Class.forName(DBConstants.COM_MYSQL_JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        try {
            this.connection = DriverManager.getConnection(DBConstants.dbUrl,
                    DBConstants.dbUserName, DBConstants.dbPassword);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    private void closeConnection() {
        try {
            this.connection.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    }
