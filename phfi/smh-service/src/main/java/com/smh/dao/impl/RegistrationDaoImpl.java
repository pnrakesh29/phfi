/**
 * 
 */
package com.smh.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mysema.query.Tuple;
import com.mysema.query.jpa.impl.JPAQuery;
import com.mysema.query.types.expr.BooleanExpression;
import com.smh.constants.Constant;
import com.smh.dao.RegistrationDao;
import com.smh.dao.model.Delivery;
import com.smh.dao.model.Doctor;
import com.smh.dao.model.PostpartumVisit;
import com.smh.dao.model.PregnancyVisit;
import com.smh.dao.model.QRegistration;
import com.smh.dao.model.Registration;
import com.smh.dao.repository.DeliveryRepository;
import com.smh.dao.repository.DoctorRepository;
import com.smh.dao.repository.PostpartumVisitRepository;
import com.smh.dao.repository.PregnancyVisitRepository;
import com.smh.dao.repository.RegistrationRepository;
import com.smh.model.PhfiRegistrationRequest;
import com.smh.util.StringUtil;

/**
 *
 * << Add Comments Here >>
 *
 * @author Shekhar Prasad
 * @date Jan 4, 2016 8:12:46 PM
 * @version 1.0
 */
@Repository("registrationDao")
public class RegistrationDaoImpl implements RegistrationDao{
	
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
	
	@Autowired
	DoctorRepository doctorRepository; 

	/**
	 * @param uid
	 * @return
	 */
	@Override
	public Registration findByUid(int uid) {
		return registrationRepository.findByUid(uid);
	}

	/**
	 * @param registrationData
	 */
	@Override
	public void createRegistration(Registration registrationData) {
		registrationRepository.save(registrationData);		
	}

	/**
	 * @param phfiRegistrationRequest
	 * @return
	 */
	@Override
	public List<PhfiRegistrationRequest> getRegistredWoman(PhfiRegistrationRequest phfiRegistrationRequest) {
		List<PhfiRegistrationRequest> registrationList = new ArrayList<PhfiRegistrationRequest>();
		int startIndex = 0;
		int endIndex = 0;
		Integer totalRecords = phfiRegistrationRequest.getNoOfRecords();

		if (phfiRegistrationRequest.getPageIndex() == null || phfiRegistrationRequest.getPageIndex() == 1) {
			totalRecords = getTotalNumberOfRecords(phfiRegistrationRequest);
			phfiRegistrationRequest.setNoOfRecords(totalRecords);
		}

		if (phfiRegistrationRequest.getPageIndex() == null && phfiRegistrationRequest.getPageSize() == null) {
			startIndex = 0;
			endIndex = Constant.DEFAULT_PAGE_SIZE;
		} else {
			startIndex = (phfiRegistrationRequest.getPageIndex() - 1)* phfiRegistrationRequest.getPageSize();
			endIndex = phfiRegistrationRequest.getPageSize();
		}
		JPAQuery query = new JPAQuery(entityManager);
		QRegistration registration = QRegistration.registration;
		List<Tuple> tupleList = query
				.from(registration)
				.where(isUIDEq(phfiRegistrationRequest.getUid()))
				.offset(startIndex)
				.limit(endIndex)
				.orderBy(QRegistration.registration.createdDate.desc())
				.list(registration.regDate, registration.uid, registration.womenFirstName,
						registration.womenSurname, registration.dateOfRecentDelivery, registration.age,
						registration.bloodgroup, registration.lmp);

		for (Tuple tuple : tupleList) {
			PhfiRegistrationRequest request = new PhfiRegistrationRequest();
			request.setRegDate(tuple.get(registration.regDate));
			request.setUid(tuple.get(registration.uid));
			request.setWomenFirstName(tuple.get(registration.womenFirstName));
			request.setWomenSurname(tuple.get(registration.womenSurname));
			request.setDateOfRecentDelivery(tuple.get(registration.dateOfRecentDelivery));
			request.setAge(tuple.get(registration.age));
			request.setBloodgroup(tuple.get(registration.bloodgroup));
			request.setLmp(tuple.get(registration.lmp));
			registrationList.add(request);
		}

		return registrationList;
	}
	private BooleanExpression isUIDEq(Integer uid) {
		return (uid !=null && !("".equals(uid))) ? QRegistration.registration.uid.eq(uid): null;
	}
	
	private int getTotalNumberOfRecords(PhfiRegistrationRequest phfiRegistrationRequest) {
		JPAQuery query = new JPAQuery(entityManager);
		QRegistration registration = QRegistration.registration;
		List<Integer> list = query
				.from(registration)
				.where(isUIDEq(phfiRegistrationRequest.getUid()))
				.list(registration.id);
		return (StringUtil.isListNotNullNEmpty(list) ? list.size() : 0);
	}

	/**
	 * @param wid
	 * @return
	 */
	@Override
	public List<PregnancyVisit> findByWid(int wid) {
		return pregnancyVisitRepository.findByWidOrderByCreatedDateDesc(wid);
	}

	/**
	 * @param pregnancyVisitData
	 */
	@Override
	public void createPregnancyVisit(PregnancyVisit pregnancyVisitData) {
		pregnancyVisitRepository.save(pregnancyVisitData);
		
	}

	/**
	 * @param postpartumVisitData
	 */
	@Override
	public void createPostpartumVisit(PostpartumVisit postpartumVisitData) {
		postpartumVisitRepository.save(postpartumVisitData);
	}

	/**
	 * @param deliveryData
	 */
	@Override
	public void createDelivery(Delivery deliveryData) {
		deliveryRepository.save(deliveryData);
		
	}

	/**
	 * @param doctorData
	 */
	@Override
	public void createDoctorCreate(Doctor doctorData) {
		doctorRepository.save(doctorData);
	}

	/**
	 * @return
	 */
	@Override
	public List<Integer> getAllWid() {
		JPAQuery query = new JPAQuery(entityManager);
		QRegistration registration = QRegistration.registration;
		List<Integer> list = query
				.from(registration)
				.list(registration.uid);
		return list;
	}

	/**
	 * @return
	 */
	@Override
	public List<String> getAllWomanName() {
		List<String> nameList = new ArrayList<String>();
		JPAQuery query = new JPAQuery(entityManager);
		QRegistration registration = QRegistration.registration;
		List<Tuple> tupleList = query.from(registration).list(
				registration.womenFirstName, registration.womenSurname);
		for (Tuple tuple : tupleList) {

			nameList.add(tuple.get(registration.womenFirstName)+" "+tuple.get(registration.womenSurname));
		}
		return nameList;
	}
}

