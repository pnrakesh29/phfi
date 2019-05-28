/**
 * 
 */
package com.smh.dao;

import java.util.List;

import com.smh.dao.model.Delivery;
import com.smh.dao.model.PostpartumVisit;
import com.smh.dao.model.PregnancyVisit;
import com.smh.dao.model.Registration;
import com.smh.model.ReportRequest;

/**
 *
 * << Add Comments Here >>
 *
 * @author Shekhar Prasad
 * @date Jan 24, 2016 12:32:35 PM
 * @version 1.0
 */
public interface ReportDao {

	/**
	 * @return List<Registration>
	 */
	public List<Registration> findAll();

	/**
	 * @param uid
	 * @return PregnancyVisit
	 */
	public List<PregnancyVisit> findByWid(int uid);

	/**
	 * @param uid
	 * @return
	 */
	public List<PostpartumVisit> findByPWid(int uid);

	/**
	 * @param reportRequest
	 * @return
	 */
	public List<Registration> getReport(ReportRequest reportRequest);

	/**
	 * @return
	 */
	public List<Registration> getMasterRawData();

	/**
	 * @return
	 */
	public List<PregnancyVisit> getPregnancyRawData();

	/**
	 * @return
	 */
	public List<PostpartumVisit> getPostpartumRawData();

	/**
	 * @return
	 */
	public List<Delivery> getDeliveryRawData();

}
