package com.realty.springmvc.init;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

public class Initializer implements WebApplicationInitializer {

  public void onStartup(ServletContext servletContext) throws ServletException {
    AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
    ctx.register(WebAppConfig.class);
    servletContext.addListener(new ContextLoaderListener(ctx));
    ctx.setServletContext(servletContext);

    //servletContext.addFilter("Spring OpenEntityManagerInViewFilter", org.springframework.orm.jpa.support.OpenEntityManagerInViewFilter.class).addMappingForUrlPatterns(null, false, "/*");
    servletContext.addFilter("HttpMethodFilter", org.springframework.web.filter.HiddenHttpMethodFilter.class).addMappingForUrlPatterns(null, false, "/*");
    servletContext.addFilter("springSecurityFilterChain", new DelegatingFilterProxy("springSecurityFilterChain")).addMappingForUrlPatterns(null, false, "/*");

    FilterRegistration charEncodingfilterReg = servletContext.addFilter("CharacterEncodingFilter", CharacterEncodingFilter.class);
    charEncodingfilterReg.setInitParameter("encoding", "UTF-8");
    charEncodingfilterReg.setInitParameter("forceEncoding", "true");
    charEncodingfilterReg.addMappingForUrlPatterns(null, false, "/*");

    Dynamic servlet = servletContext.addServlet("dispatcher", new DispatcherServlet(ctx));
    servlet.setInitParameter("trimSpaces", "true");
    servlet.setInitParameter("defaultHtmlEscape", "true");
    servlet.addMapping("/");
    servlet.setLoadOnStartup(1);
  }
}
