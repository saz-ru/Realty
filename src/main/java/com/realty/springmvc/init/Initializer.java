package com.realty.springmvc.init;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

public class Initializer implements WebApplicationInitializer {

  public void onStartup(ServletContext servletContext)
      throws ServletException {
    AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
    ctx.register(WebAppConfig.class);
    servletContext.addListener(new ContextLoaderListener(ctx));
    ctx.setServletContext(servletContext);
    /*ClassLoader loader=Runtime.getRuntime().getClass().getClassLoader();
    Thread.currentThread().setContextClassLoader(loader);*/

    /*Dynamic servlet = servletContext.addServlet("mvc-dispatcher",
        new DispatcherServlet(ctx));
    servlet.addMapping("/");
    servlet.setLoadOnStartup(1);*/
  }
}
