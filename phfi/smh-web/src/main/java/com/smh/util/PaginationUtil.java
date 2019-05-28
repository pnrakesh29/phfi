package com.smh.util;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;

import com.smh.constants.PHFIWebConstant;

public final class PaginationUtil {

	private static Logger logger = Logger.getLogger(PaginationUtil.class);
	
	private PaginationUtil() {

	}

	/**
	 * Method to get Sublist of MAX size from the list
	 * 
	 * @param max
	 * @param pageNumber
	 * @param list
	 * @return
	 */
	public static List<?> getSubList(int max, int pageNumber, List<?> list) {
		if (null == list || list.isEmpty()) {
			return list;
		}
		int fromIndex = 0;
		int toIndex = max;
		if (max < list.size()) {
			fromIndex = (pageNumber * max) - max;
			toIndex = fromIndex + max;
		}
		toIndex = (toIndex > list.size()) ? list.size() : toIndex;
		return list.subList(fromIndex, toIndex);
	}

	/**
	 * @param list
	 * @param viewData
	 * @param modelandview
	 * @param session
	 * @return
	 */
	public static ModelAndView getPaginationList(List<? extends Object> list,
			String viewData, ModelAndView modelandview, HttpSession session) {

		try {
			final int MAX_COUNT = getMaxDisplayCount();
			modelandview.addObject(viewData,
					PaginationUtil.getSubList(MAX_COUNT, PHFIWebConstant.ONE, list));
			int pageCounter = (list.size() / MAX_COUNT)
					+ ((list.size() % MAX_COUNT > 0) ? PHFIWebConstant.ONE : 0);
			session.setAttribute(PHFIWebConstant.PORTAL_PAGES_SESSION_NAME,
					pageCounter);
			modelandview.addObject(PHFIWebConstant.PORTAL_PAGES_SESSION_NAME,
					pageCounter);
			modelandview.addObject(
					PHFIWebConstant.MODEL_ATTRIBUTE_PORTAL_LIST_PAGE_NUMBER,
					PHFIWebConstant.ONE);

			modelandview.addObject(
					PHFIWebConstant.MODEL_ATTRIBUTE_PORTAL_LIST_BEGIN_PAGE_NUM,
					PHFIWebConstant.ONE);
			modelandview
					.addObject(
							PHFIWebConstant.MODEL_ATTRIBUTE_PORTAL_LIST_END_PAGE_NUM,
							(pageCounter > PHFIWebConstant.MAX_ENTITY_DISPLAY_SIZE) ? PHFIWebConstant.MAX_ENTITY_DISPLAY_SIZE
									: pageCounter);
		} catch (Exception e) {
			logger.error(
					"error:method1::UserDetailsController::getPaginationList",
					e);
		}
		return modelandview;
	}
	
	public static ModelAndView getPagenationModel(ModelAndView modelAndView, int totalRecords) {
		try {
			final int MAX_COUNT = PHFIWebConstant.MAX_ENTITY_DISPLAY_SIZE;
			int pageCounter = (totalRecords / MAX_COUNT) + ((totalRecords % MAX_COUNT > 0) ? PHFIWebConstant.ONE : 0);

			modelAndView.addObject(PHFIWebConstant.MODEL_ATTRIBUTE_PORTAL_TOTAL_RECORDS_PAGE_NUM, totalRecords);
			modelAndView.addObject(PHFIWebConstant.PORTAL_PAGES_SESSION_NAME, pageCounter);
			modelAndView.addObject(PHFIWebConstant.MODEL_ATTRIBUTE_PORTAL_LIST_PAGE_NUMBER, PHFIWebConstant.ONE);
			modelAndView.addObject(PHFIWebConstant.MODEL_ATTRIBUTE_PORTAL_LIST_BEGIN_PAGE_NUM, PHFIWebConstant.ONE);
			
			modelAndView.addObject(PHFIWebConstant.MODEL_ATTRIBUTE_PORTAL_LIST_END_PAGE_NUM,
							(pageCounter > PHFIWebConstant.MAX_ENTITY_DISPLAY_SIZE) ? PHFIWebConstant.MAX_ENTITY_DISPLAY_SIZE
									: pageCounter);
		} catch (Exception e) {
			logger.error("error:method1::PaginationUtil::getPaginationList", e);
		}

		return modelAndView;
	}
	
	public static ModelAndView getPagenationModelSuccessive(ModelAndView modelAndView, int currentPage, int totalRecords) {
	  try {
	   final int MAX_COUNT = PHFIWebConstant.MAX_ENTITY_DISPLAY_SIZE;
	   int pageCounter = (totalRecords / MAX_COUNT) + ((totalRecords % MAX_COUNT > 0) ? PHFIWebConstant.ONE : 0);

	   modelAndView.addObject(PHFIWebConstant.MODEL_ATTRIBUTE_PORTAL_TOTAL_RECORDS_PAGE_NUM, totalRecords);
	   modelAndView.addObject(PHFIWebConstant.PORTAL_PAGES_SESSION_NAME, pageCounter);
	   modelAndView.addObject(PHFIWebConstant.MODEL_ATTRIBUTE_PORTAL_LIST_PAGE_NUMBER, currentPage);
	   modelAndView.addObject(PHFIWebConstant.MODEL_ATTRIBUTE_PORTAL_LIST_BEGIN_PAGE_NUM, PHFIWebConstant.ONE);
	   
	   int begin = PHFIWebConstant.ONE;
	   int end = PHFIWebConstant.MAX_ENTITIES_PORTAL_DISPLAY_SIZE;

	   if (currentPage > PHFIWebConstant.MAX_ENTITIES_PORTAL_DISPLAY_SIZE) {
	    begin = currentPage - (PHFIWebConstant.FOUR + PHFIWebConstant.ONE);
	    end = currentPage + PHFIWebConstant.FOUR;

	    if (end > pageCounter) {
	     end = pageCounter;
	     begin = end - PHFIWebConstant.MAX_ENTITIES_PORTAL_DISPLAY_SIZE
	       + PHFIWebConstant.ONE;
	    }

	    begin = (begin + PHFIWebConstant.MAX_ENTITIES_PORTAL_DISPLAY_SIZE > pageCounter) ? pageCounter
	      - (PHFIWebConstant.MAX_ENTITIES_PORTAL_DISPLAY_SIZE - PHFIWebConstant.ONE)
	      : begin;
	   } else {
	    end = (end > pageCounter) ? pageCounter : end;
	   }

	   modelAndView.addObject(PHFIWebConstant.MODEL_ATTRIBUTE_PORTAL_LIST_BEGIN_PAGE_NUM, begin);
	   modelAndView.addObject(PHFIWebConstant.MODEL_ATTRIBUTE_PORTAL_LIST_END_PAGE_NUM, end);
	  } catch (Exception e) {
	   logger.error("error:method1::PaginationUtil::getPagenationModelSuccessive", e);
	  }

	  return modelAndView;
	 }

	public static int getMaxDisplayCount() {
		return PHFIWebConstant.MAX_ENTITY_DISPLAY_SIZE;
	}
}
