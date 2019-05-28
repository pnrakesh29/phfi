/**
 * 
 */
package com.smh.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import com.smh.dao.model.Delivery;

/**
 *
 * << Add Comments Here >>
 *
 * @author Shekhar Prasad
 * @date Jan 21, 2016 11:05:05 PM
 * @version 1.0
 */
public interface DeliveryRepository extends JpaRepository<Delivery, Long>, QueryDslPredicateExecutor<Delivery> {

}
