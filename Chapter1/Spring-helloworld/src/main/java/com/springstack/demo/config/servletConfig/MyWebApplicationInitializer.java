package com.springstack.demo.config.servletConfig;

import com.springstack.demo.controller.UserController;
import org.springframework.context.annotation.AnnotatedBeanDefinitionReader;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.context.support.GenericWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/*public class MyWebApplicationInitializer  implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        //Load Spring web application configuration
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.register(AppConfig.class);

        //also can use GenericWebApplicationContext to register annotated component classes
        GenericWebApplicationContext context1 = new GenericWebApplicationContext();
        AnnotatedBeanDefinitionReader reader = new AnnotatedBeanDefinitionReader(context1);
        reader.register(AppConfig.class, UserController.class);
        // Create and register the DispatcherServlet
        DispatcherServlet servlet = new DispatcherServlet(context);
        ServletRegistration.Dynamic registration = servletContext.addServlet("app",servlet);
        registration.setLoadOnStartup(1);
        registration.addMapping("/app/*");
    }
}*/
