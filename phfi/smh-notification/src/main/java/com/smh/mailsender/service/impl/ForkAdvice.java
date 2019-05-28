
package com.smh.mailsender.service.impl;

import org.aspectj.lang.ProceedingJoinPoint;

public class ForkAdvice {
	
	public void fork(final ProceedingJoinPoint pjp) {
		new Thread(new Runnable() {
			public void run() {
				try {
					pjp.proceed();
				} catch (Throwable t) {
				}
			}
		}).start();
	}
}
