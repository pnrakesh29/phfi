/**
 * 
 */
package com.smh.service;

import com.smh.exception.SmhAdminException;
import com.smh.model.MedicalCaseSheetDTO;
import com.smh.model.PhfiDeliveryFormResponse;
import com.smh.model.PhfiPostPartumVisitResponse;
import com.smh.model.PhfiRegistrationResponse;
import com.smh.model.PhfiVisitResponse;
import com.smh.model.ReportRequest;
import com.smh.model.ReportResponse;

/**
 *
 * << Add Comments Here >>
 *
 * @author Shekhar Prasad
 * @date Jan 24, 2016 11:55:23 AM
 * @version 1.0
 */
public interface ReportService {

	/**
	 * @param reportRequest
	 * @return
	 * @throws SmhAdminException 
	 */
	public ReportResponse getMasterReport(ReportRequest reportRequest) throws SmhAdminException;

	/**
	 * @param reportRequest
	 * @return
	 * @throws SmhAdminException 
	 */
	public MedicalCaseSheetDTO getCaseSheetReport(ReportRequest reportRequest) throws SmhAdminException;

	/**
	 * @return
	 * @throws SmhAdminException 
	 */
	public PhfiRegistrationResponse getRawMaterData() throws SmhAdminException;

	/**
	 * @return
	 */
	public PhfiVisitResponse getVisitRawMaterData() throws SmhAdminException;

	/**
	 * @return
	 */
	public PhfiPostPartumVisitResponse getPostpartumRawMaterData() throws SmhAdminException;

	/**
	 * @return
	 */
	public PhfiDeliveryFormResponse getDeliveryRawMaterData() throws SmhAdminException;

}
