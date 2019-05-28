package com.smh.velocity.impl;

import java.io.StringWriter;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;

import com.smh.velocity.IVelocityTemplateCreator;


public class VelocityTemplateCreatorImpl implements IVelocityTemplateCreator {

	private static VelocityEngine velocityEngine = null;

	public String createEmailTemplate(Map<String, String> requestMap, String templatePath) throws Exception {
		VelocityContext context = new VelocityContext();
		Set<String> requestMapSet = requestMap.keySet();
		Iterator<String> requestMapSetIterator = requestMapSet.iterator();

		while (requestMapSetIterator.hasNext()) {
			String key = requestMapSetIterator.next();
			context.put(key, requestMap.get(key));
		}

		Template template = getVelocityEngineInstance().getTemplate(templatePath, "UTF-8");
		StringWriter writer = new StringWriter();
		template.merge(context, writer);
		return writer.toString();
	}

	private VelocityEngine getVelocityEngineInstance() {
		if (velocityEngine == null) {
			velocityEngine = new VelocityEngine();
			velocityEngine.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
			velocityEngine.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
			velocityEngine.init();
		}
		
		return velocityEngine;
	}
}