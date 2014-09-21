/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.phoenix.maintainschedule.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import sg.edu.nus.iss.phoenix.core.dao.DBConstants;
import sg.edu.nus.iss.phoenix.core.exceptions.NotFoundException;
import sg.edu.nus.iss.phoenix.maintainschedule.dao.ProgramSlotDAO;
import sg.edu.nus.iss.phoenix.maintainschedule.entity.ProgramSlot;

/**
 *
 * @author sudarsan
 */
public class ProgramSlotDAOImpl implements ProgramSlotDAO {

    Connection connection;

    public ProgramSlotDAOImpl() {
        super();

    }

    public ProgramSlot createValueObject() {
        return new ProgramSlot();

    }

    @Override
    public List<ProgramSlot> loadAll() throws SQLException {
        openConnection();
        String sql = "SELECT * FROM `program-slot` ORDER BY `dateOfProgram` ASC; ";
        List<ProgramSlot> searchResults = listQuery(connection
                .prepareStatement(sql));
        closeConnection();
        System.out.println("record size" + searchResults.size());
        return searchResults; //To change body of generated methods, choose Tools | Templates.
    }

    protected List<ProgramSlot> listQuery(PreparedStatement stmt) throws SQLException {

        ArrayList<ProgramSlot> searchResults = new ArrayList<ProgramSlot>();
        ResultSet result = null;
        openConnection();
        try {
            result = stmt.executeQuery();

            while (result.next()) {
                ProgramSlot temp = createValueObject();

                temp.setDateOfProgram(result.getDate("dateOfProgram"));
                temp.setDuration(result.getTime("duration"));
                temp.setPresenter(result.getString("presenter"));
                temp.setProducer(result.getString("producer"));
                temp.setProgramName(result.getString("program-Name"));
                temp.setStartTime(result.getTime("startTime"));
                searchResults.add(temp);
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

        return (List<ProgramSlot>) searchResults;
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

    @Override
    public List<ProgramSlot> loadWeekly(Date dateOfProgram) throws SQLException {
        openConnection();
        String sql = "SELECT * FROM `program-slot` WHERE `dateOfProgram` between ? and ? ORDER BY `dateOfProgram`, `startTime` ASC";
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateOfProgram);
        Date fromDate = new Date(calendar.getTime().getTime());
        calendar.add(Calendar.DATE, 6);
        Date toDate = new Date(calendar.getTime().getTime());
        PreparedStatement stmt = null;

        stmt = connection.prepareStatement(sql);

        stmt.setDate(1, (java.sql.Date) fromDate);
        stmt.setDate(2, (java.sql.Date) toDate);

        List<ProgramSlot> searchResults = listQuery(stmt);

        return searchResults;
    }
    
    @Override
	public List<ProgramSlot> loadAnnual(int year) throws SQLException {
		openConnection();
		Calendar calendar = Calendar.getInstance();
		calendar.set(year,0,1);
		Date fromDate = new Date(calendar.getTime().getTime());
		calendar.set(year,11,31);
		Date toDate = new Date(calendar.getTime().getTime());
		String sql = "SELECT * FROM `program-slot` WHERE `dateOfProgram` between ? and ? ORDER BY `dateOfProgram`, `startTime` ASC";
		PreparedStatement stmt = null;

		stmt = this.connection.prepareStatement(sql);
		stmt.setDate(1,fromDate);
		stmt.setDate(2,toDate);
		
		List<ProgramSlot> searchResults = listQuery(stmt);

		return searchResults;
	}

    @Override
    public synchronized void create(ProgramSlot ps) throws SQLException {
        String sql = "";
        PreparedStatement stmt = null;
        openConnection();
        try {
            sql = "INSERT INTO `program-slot` (`duration`, `dateOfProgram`, `startTime`, `program-name`, `presenter`, `producer`) VALUES (?, ?, ?, ?, ?, ?) ";
            stmt = this.connection.prepareStatement(sql);

			//check if the schedule id in YYYYMMDDHHMM format
            stmt.setTime(1, ps.getDuration());
            java.sql.Date sDate = new java.sql.Date(ps.getDateOfProgram().getTime());
            stmt.setDate(2, sDate);
            stmt.setTime(3, ps.getStartTime());
            stmt.setString(4, ps.getProgramName());
            stmt.setString(5, ps.getPresenter());
            stmt.setString(6, ps.getProducer());

            int rowcount = databaseUpdate(stmt);
            if (rowcount != 1) {
                // System.out.println("PrimaryKey Error when updating DB!");
                throw new SQLException("PrimaryKey Error when updating DB!");
            }

        } finally {
            if (stmt != null) {
                stmt.close();
            }
            closeConnection();
        }
    }

    @Override
    public void update(ProgramSlot ps) throws SQLException, NotFoundException {
        String sql = "UPDATE `program-slot` set  `program-name`=?, `presenter`=?, `producer`=? WHERE (`duration`= ? && `dateOfProgram`= ? && `startTime`= ?) ";
        PreparedStatement stmt = null;
        openConnection();
        try {
            stmt = this.connection.prepareStatement(sql);
            stmt.setString(1, ps.getProgramName());
            stmt.setString(2, ps.getPresenter());
            stmt.setString(3, ps.getProducer());
            stmt.setTime(4, ps.getDuration());
            stmt.setDate(5, ps.getDateOfProgram());
            stmt.setTime(6, ps.getStartTime());
            int rowcount = databaseUpdate(stmt);
            if (rowcount == 0) {
                // System.out.println("Object could not be saved! (PrimaryKey not found)");
                throw new NotFoundException(
                        "Object could not be saved! (PrimaryKey not found)");
            }
            if (rowcount > 1) {
                // System.out.println("PrimaryKey Error when updating DB! (Many objects were affected!)");
                throw new SQLException(
                        "PrimaryKey Error when updating DB! (Many objects were affected!)");
            }

        } finally {
            if (stmt != null) {
                stmt.close();
            }
            closeConnection();
        }
    }

    protected int databaseUpdate(PreparedStatement stmt) throws SQLException {

        int result = stmt.executeUpdate();

        return result;
    }

    @Override
    public void delete(ProgramSlot ps) throws SQLException, NotFoundException {
        String sql = "DELETE FROM `program-slot` WHERE (`duration`= ? && `dateOfProgram`= ? && `startTime`= ?) ";
        PreparedStatement stmt = null;
        openConnection();
        try {
            stmt = this.connection.prepareStatement(sql);
            stmt.setTime(1, ps.getDuration());
            stmt.setDate(2, ps.getDateOfProgram());
            stmt.setTime(3, ps.getStartTime());
            int rowcount = databaseUpdate(stmt);
            if (rowcount == 0) {
                // System.out.println("Object could not be deleted (PrimaryKey not found)");
                throw new NotFoundException(
                        "Object could not be deleted! (PrimaryKey not found)");
            }
            if (rowcount > 1) {
                // System.out.println("PrimaryKey Error when updating DB! (Many objects were deleted!)");
                throw new SQLException(
                        "PrimaryKey Error when updating DB! (Many objects were deleted!)");
            }
        } finally {
            if (stmt != null) {
                stmt.close();
            }
            closeConnection();
        }
    }

}
