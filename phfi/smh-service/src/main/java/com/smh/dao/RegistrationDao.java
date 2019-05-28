/**
 * 
 */
package com.smh.dao;

import java.util.List;

import com.smh.dao.model.Delivery;
import com.smh.dao.model.Doctor;
import com.smh.dao.model.PostpartumVisit;
import com.smh.dao.model.PregnancyVisit;
import com.smh.dao.model.Registration;
import com.smh.model.PhfiRegistrationRequest;


/**
 *
 * << Add Comments Here >>
 *
 * @author Shekhar Prasad
 * @date Jan 4, 2016 8:12:25 PM
 * @version 1.0
 */
public interface RegistrationDao {

	/**
	 * @param uid
	 * @return
	 */
	public Registration findByUid(int uid);

	/**
	 * @param registrationData
	 */
	public void createRegistration(Registration registrationData);

	/**
	 * @param phfiRegistrationRequest
	 * @return
	 */
	public List<PhfiRegistrationRequest> getRegistredWoman(PhfiRegistrationRequest phfiRegistrationRequest);

	/**
	 * @param wid
	 * @return
	 */
	public List<PregnancyVisit> findByWid(int wid);

	/**
	 * @param pregnancyVisitData
	 */
	public void createPregnancyVisit(PregnancyVisit pregnancyVisitData);

	/**
	 * @param postpartumVisitData
	 */
	public void createPostpartumVisit(PostpartumVisit postpartumVisitData);

	/**
	 * @param deliveryData
	 */
	public void createDelivery(Delivery deliveryData);

	/**
	 * @param doctorData
	 */
	public void createDoctorCreate(Doctor doctorData);

	/**
	 * @return
	 */
	public List<Integer> getAllWid();

	/**
	 * @return
	 */
	public List<String> getAllWomanName();
	

}
