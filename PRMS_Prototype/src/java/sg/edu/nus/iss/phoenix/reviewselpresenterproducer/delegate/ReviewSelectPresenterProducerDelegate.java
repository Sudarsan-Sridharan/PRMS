/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.phoenix.reviewselpresenterproducer.delegate;

import java.util.List;
import sg.edu.nus.iss.phoenix.authenticate.entity.User;
import sg.edu.nus.iss.phoenix.reviewselpresenterproducer.service.ReviewSelectPresenterProducerService;

/**
 *
 * @author sudarsan
 */
public class ReviewSelectPresenterProducerDelegate {

    

    
    public List<User> getAllPresenters() throws Exception{
        ReviewSelectPresenterProducerService rspps=new ReviewSelectPresenterProducerService();
        List<User> presenters =rspps.getAllPresenters();//To change body of generated methods, choose Tools | Templates.
        return presenters;
    }

    public List<User> getAllProducers() throws Exception{
        ReviewSelectPresenterProducerService rspps=new ReviewSelectPresenterProducerService();
        List<User> producers =rspps.getAllProducers();//To change body of generated methods, choose Tools | Templates.
        return producers;
    }

    
}
