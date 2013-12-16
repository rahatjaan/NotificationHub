package com.servercentral.communication.hub.init;

import org.apache.axis2.engine.ServiceLifeCycle;
import org.apache.axis2.context.ConfigurationContext;
import org.apache.axis2.description.AxisService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SpringInit implements ServiceLifeCycle {
        
    private static Log logger = LogFactory
        .getLog(SpringInit.class);


    public void startUp(ConfigurationContext ignore, AxisService service) {
        ClassLoader classLoader = service.getClassLoader();
        System.out.println("loading spring");
        ClassPathXmlApplicationContext appCtx = new
            ClassPathXmlApplicationContext(new String[] {"classpath:spring/spring-config.xml"}, false);
        appCtx.setClassLoader(classLoader);
        appCtx.refresh();
        System.out.println("load spring done");
        if (logger.isDebugEnabled()) {
            logger.debug("\n\nstartUp() set spring classloader via axisService.getClassLoader() ... ");
        }
    }
    /**
     * this will be called during the deployement time of the service. irrespective
     * of the service scope this method will be called
     */
    public void shutDown(ConfigurationContext ignore, AxisService service) {

    }
}
