/**
 * 
 */
package com.smh.service.impl;

import org.apache.http.HttpStatus;
import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Service;

import com.smh.exception.SmhAdminException;
import com.smh.model.MedicalCaseSheetDTO;
import com.smh.model.PhfiDeliveryFormResponse;
import com.smh.model.PhfiPostPartumVisitResponse;
import com.smh.model.PhfiRegistrationResponse;
import com.smh.model.PhfiVisitResponse;
import com.smh.model.ReportRequest;
import com.smh.model.ReportResponse;
import com.smh.service.ReportService;
import com.smh.util.JsonUtil;
import com.sun.jersey.api.client.ClientResponse;

/**
 *
 * << Add Comments Here >>
 *
 * @author Shekhar Prasad
 * @date Jan 24, 2016 11:55:43 AM
 * @version 1.0
 */

@Service("reportService")
public class ReportServiceImpl implements ReportService{

	public static Logger logger = Logger.getLogger(RegistrationServiceImpl.class);

	private ObjectMapper mapper = new ObjectMapper();
	
	/**
	 * @param reportRequest
	 * @return
	 * @throws SmhAdminException 
	 */
	@Override
	public ReportResponse getMasterReport(ReportRequest reportRequest) throws SmhAdminException {
		logger.info("Entering :: RegistrationServiceImpl:: getRegistedWoman method");
		try {
			ClientResponse response = JsonUtil.postRequest(reportRequest,"/reportService/getMasterReport");
			if (response.getStatus() != HttpStatus.SC_OK) {
				throw new SmhAdminException("Unable to process your request. Please try again");
			} else {
				String output = response.getEntity(String.class);
				ReportResponse reportResponse = mapper.readValue(output, ReportResponse.class);
				return reportResponse;
			}
		} catch (Exception e) {
			throw new SmhAdminException("Unable to process your request. Please try again");
		}
	}

	/**
	 * @param reportRequest
	 * @return
	 * @throws SmhAdminException 
	 */
	@Override
	public MedicalCaseSheetDTO getCaseSheetReport(ReportRequest reportRequest) throws SmhAdminException {
		logger.info("Entering :: RegistrationServiceImpl:: getCaseSheetReport method");
		try {
			ClientResponse response = JsonUtil.postRequest(reportRequest,"/reportService/getCaseSheetReport");
			if (response.getStatus() != HttpStatus.SC_OK) {
				throw new SmhAdminException("Unable to process your request. Please try again");
			} else {
				String output = response.getEntity(String.class);
				MedicalCaseSheetDTO reportResponse = mapper.readValue(output, MedicalCaseSheetDTO.class);
				return reportResponse;
			}
		} catch (Exception e) {
			throw new SmhAdminException("Unable to process your request. Please try again");
		}
	}

	/**
	 * @return
	 * @throws SmhAdminException 
	 */
	@Override
	public PhfiRegistrationResponse getRawMaterData() throws SmhAdminException {
		PhfiRegistrationResponse rawDataResponse= new PhfiRegistrationResponse();
		logger.info("Entering :: RegistrationServiceImpl:: getCaseSheetReport method");
		try {
			ClientResponse response = JsonUtil.postRequest("/reportService/getMasterRawData");
			if (response.getStatus() != HttpStatus.SC_OK) {
				throw new SmhAdminException("Unable to process your request. Please try again");
			} else {
				String output = response.getEntity(String.class);
				rawDataResponse = mapper.readValue(output, PhfiRegistrationResponse.class);
				return rawDataResponse;
			}
		} catch (Exception e) {
			throw new SmhAdminException("Unable to process your request. Please try again");
		}
	}

	/**
	 * @return
	 * @throws SmhAdminException
	 */
	@Override
	public PhfiVisitResponse getVisitRawMaterData() throws SmhAdminException {
		PhfiVisitResponse rawDataResponse= new PhfiVisitResponse();
		logger.info("Entering :: RegistrationServiceImpl:: getCaseSheetReport method");
		try {
			ClientResponse response = JsonUtil.postRequest("/reportService/getVisitRawData");
			if (response.getStatus() != HttpStatus.SC_OK) {
				throw new SmhAdminException("Unable to process your request. Please try again");
			} else {
				String output = response.getEntity(String.class);
				rawDataResponse = mapper.readValue(output, PhfiVisitResponse.class);
				return rawDataResponse;
			}
		} catch (Exception e) {
			throw new SmhAdminException("Unable to process your request. Please try again");
		}
	}

	/**
	 * @return
	 * @throws SmhAdminException
	 */
	@Override
	public PhfiPostPartumVisitResponse getPostpartumRawMaterData() throws SmhAdminException {
		PhfiPostPartumVisitResponse rawDataResponse= new PhfiPostPartumVisitResponse();
		logger.info("Entering :: RegistrationServiceImpl:: getCaseSheetReport method");
		try {
			ClientResponse response = JsonUtil.postRequest("/reportService/getPostpartumRawData");
			if (response.getStatus() != HttpStatus.SC_OK) {
				throw new SmhAdminException("Unable to process your request. Please try again");
			} else {
				String output = response.getEntity(String.class);
				rawDataResponse = mapper.readValue(output, PhfiPostPartumVisitResponse.class);
				return rawDataResponse;
			}
		} catch (Exception e) {
			throw new SmhAdminException("Unable to process your request. Please try again");
		}
	}

	/**
	 * @return
	 * @throws SmhAdminException
	 */
	@Override
	public PhfiDeliveryFormResponse getDeliveryRawMaterData() throws SmhAdminException {
		PhfiDeliveryFormResponse rawDataResponse= new PhfiDeliveryFormResponse();
		logger.info("Entering :: RegistrationServiceImpl:: getCaseSheetReport method");
		try {
			ClientResponse response = JsonUtil.postRequest("/reportService/getDeliveryRawData");
			if (response.getStatus() != HttpStatus.SC_OK) {
				throw new SmhAdminException("Unable to process your request. Please try again");
			} else {
				String output = response.getEntity(String.class);
				rawDataResponse = mapper.readValue(output, PhfiDeliveryFormResponse.class);
				return rawDataResponse;
			}
		} catch (Exception e) {
			throw new SmhAdminException("Unable to process your request. Please try again");
		}
	}

}
