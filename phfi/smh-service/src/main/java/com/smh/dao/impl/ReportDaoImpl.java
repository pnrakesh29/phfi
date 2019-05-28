/**
 * 
 */
package com.smh.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mysema.query.jpa.impl.JPAQuery;
import com.mysema.query.types.expr.BooleanExpression;
import com.smh.constants.Constant;
import com.smh.dao.ReportDao;
import com.smh.dao.model.Delivery;
import com.smh.dao.model.PostpartumVisit;
import com.smh.dao.model.PregnancyVisit;
import com.smh.dao.model.QDelivery;
import com.smh.dao.model.QPostpartumVisit;
import com.smh.dao.model.QPregnancyVisit;
import com.smh.dao.model.QRegistration;
import com.smh.dao.model.Registration;
import com.smh.dao.repository.DeliveryRepository;
import com.smh.dao.repository.PostpartumVisitRepository;
import com.smh.dao.repository.PregnancyVisitRepository;
import com.smh.dao.repository.RegistrationRepository;
import com.smh.model.ReportRequest;
import com.smh.util.StringUtil;

/**
 *
 * << Add Comments Here >>
 *
 * @author Shekhar Prasad
 * @date Jan 24, 2016 12:32:46 PM
 * @version 1.0
 */
@Repository("reportDao")
public class ReportDaoImpl implements ReportDao{
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Autowired
	private RegistrationRepository registrationRepository;
	
	@Autowired
	PregnancyVisitRepository pregnancyVisitRepository;

	@Autowired
	PostpartumVisitRepository postpartumVisitRepository; 
	
	@Autowired
	DeliveryRepository deliveryRepository; 

	/**
	 * @return
	 */
	@Override
	public List<Registration> findAll() {
		return registrationRepository.findAll();
	}

	/**
	 * @param uid
	 * @return
	 */
	@Override
	public List<PregnancyVisit> findByWid(int uid) {
		return pregnancyVisitRepository.findByWidOrderByCreatedDateDesc(uid);
	}

	/**
	 * @param uid
	 * @return
	 */
	@Override
	public List<PostpartumVisit> findByPWid(int uid) {
		return postpartumVisitRepository.findByWidOrderByCreatedDateDesc(uid);
	}

	/**
	 * @param reportRequest
	 * @return
	 */
	@Override
	public List<Registration> getReport(ReportRequest reportRequest) {
		int offset = 0;
		int limit = 0;
		Integer totalRecords = reportRequest.getNoOfRecords();
	
		if (reportRequest.getPageIndex() == null
				|| reportRequest.getPageIndex() == 1) {
			totalRecords = getTotalNumberOfRecords(reportRequest);
			reportRequest.setNoOfRecords(totalRecords);
		}
	
		if (reportRequest.getPageIndex() == null && reportRequest.getPageSize() == null) {
			offset = 0;
			limit = Constant.DEFAULT_PAGE_SIZE;
		} else {
			offset = (reportRequest.getPageIndex() - 1) * reportRequest.getPageSize();
			limit = reportRequest.getPageSize();
		}
		
		JPAQuery query = new JPAQuery(entityManager);
		QRegistration registration = QRegistration.registration;
		List<Registration> registrationList = query
				.from(registration)
				.where(isUIDEq(reportRequest.getWid()),
					   isMaternityStatusEq(reportRequest.getMaternityStatus()))
				.offset(offset)
				.limit(limit)
				.orderBy(QRegistration.registration.createdDate.desc())
				.list(registration);
	
		return registrationList;
	
	}

	/**
	 * @param reportRequest
	 * @return
	 */
	private Integer getTotalNumberOfRecords(ReportRequest reportRequest) {
		JPAQuery query = new JPAQuery(entityManager);
		QRegistration registration = QRegistration.registration;
		List<Integer> list = query
				.from(registration)
				.where(isUIDEq(reportRequest.getWid()))
				.list(registration.id);
		return (StringUtil.isListNotNullNEmpty(list) ? list.size() : 0);
		}
	private BooleanExpression isUIDEq(Integer uid) {
		return (uid !=null && !("".equals(uid))) ? QRegistration.registration.uid.eq(uid): null;
	}
	private BooleanExpression isMaternityStatusEq(String maternityStatus) {
		return (maternityStatus !=null && !("".equals(maternityStatus))) ? QRegistration.registration.maternityStatus.eq(maternityStatus): null;
	}

	/**
	 * @return
	 */
	@Override
	public List<Registration> getMasterRawData() {
		JPAQuery query = new JPAQuery(entityManager);
		QRegistration registration = QRegistration.registration;
		List<Registration> registrationList = query
				.from(registration)
				.orderBy(QRegistration.registration.createdDate.desc())
				.list(registration);
		return registrationList;
	}

	/**
	 * @return
	 */
	@Override
	public List<PregnancyVisit> getPregnancyRawData() {
		JPAQuery query = new JPAQuery(entityManager);
		QPregnancyVisit pregnancyVisit = QPregnancyVisit.pregnancyVisit;
		List<PregnancyVisit> registrationList = query
				.from(pregnancyVisit)
				.orderBy(QPregnancyVisit.pregnancyVisit.createdDate.desc())
				.list(pregnancyVisit);
		return registrationList;
	}

	/**
	 * @return
	 */
	@Override
	public List<PostpartumVisit> getPostpartumRawData() {
		JPAQuery query = new JPAQuery(entityManager);
		QPostpartumVisit postpartumVisit = QPostpartumVisit.postpartumVisit;
		List<PostpartumVisit> registrationList = query
				.from(postpartumVisit)
				.orderBy(QPostpartumVisit.postpartumVisit.createdDate.desc())
				.list(postpartumVisit);
		return registrationList;
	}

	/**
	 * @return
	 */
	@Override
	public List<Delivery> getDeliveryRawData() {
		JPAQuery query = new JPAQuery(entityManager);
		QDelivery delivery = QDelivery.delivery;
		List<Delivery> registrationList = query
				.from(delivery)
				.orderBy(QDelivery.delivery.id.desc())
				.list(delivery);
		return registrationList;
	}
	

}
