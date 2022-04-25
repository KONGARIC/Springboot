package com.luv2code.springsecurity.demo.config;

import com.luv2code.springsecurity.demo.config.DemoAppConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MySpringMvcDispatcherServletinitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] { DemoAppConfig.class };
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}