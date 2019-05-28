/**
 * 
 */
package com.smh.handler;

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
 * @date Jan 24, 2016 12:28:49 PM
 * @version 1.0
 */
public interface ReportHandler {

	/**
	 * @param reportRequest
	 * @return
	 */
	public ReportResponse getMasterReport(ReportRequest reportRequest);

	/**
	 * @param reportRequest
	 * @return
	 */
	public MedicalCaseSheetDTO getCaseSheetReport(ReportRequest reportRequest);

	/**
	 * @return
	 */
	public PhfiRegistrationResponse getMasterRawData();

	/**
	 * @return
	 */
	public PhfiVisitResponse getPregnancyRawData();

	/**
	 * @return
	 */
	public PhfiPostPartumVisitResponse getPostpartumRawData();

	/**
	 * @return
	 */
	public PhfiDeliveryFormResponse getDeliveryRawData();

}
