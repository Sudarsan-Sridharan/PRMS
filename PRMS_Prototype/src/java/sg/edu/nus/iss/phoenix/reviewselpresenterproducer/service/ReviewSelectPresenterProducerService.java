/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.phoenix.reviewselpresenterproducer.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import sg.edu.nus.iss.phoenix.authenticate.dao.UserDao;
import sg.edu.nus.iss.phoenix.authenticate.dao.impl.UserDaoImpl;
import sg.edu.nus.iss.phoenix.authenticate.entity.Role;
import sg.edu.nus.iss.phoenix.authenticate.entity.User;

/**
 *
 * @author sudarsan
 */
public class ReviewSelectPresenterProducerService {
    
    UserDao userdao;
    public ReviewSelectPresenterProducerService() {
         userdao= new UserDaoImpl();
    }
    
    

    public List<User> getAllPresenters() throws SQLException{
        User user = new User();
        List<Role> roles = new ArrayList<Role>();
        Role role = new Role();
        role.setRole("presenter");
        roles.add(role);
        user.setRoles(new ArrayList<Role>(roles));
        List<User> users = new ArrayList<User>();
        users = userdao.searchMatching(user);
        return users;
    }

    public List<User> getAllProducers() throws SQLException{
        User user = new User();
        List<Role> roles = new ArrayList<Role>();
        Role role = new Role();
        role.setRole("producer");
        roles.add(role);
        user.setRoles(new ArrayList<Role>(roles));
        List<User> users = new ArrayList<User>();
        users = userdao.searchMatching(user);
        return users; //To change body of generated methods, choose Tools | Templates.
    }
    
}
