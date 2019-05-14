package org.superbiz.struts;

import com.opensymphony.sitemesh.webapp.SiteMeshFilter;
import org.apache.struts2.dispatcher.filter.StrutsPrepareAndExecuteFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;

@SpringBootApplication
public class Application {

    public static void main (String[] arguments) {
        SpringApplication.run(Application.class, arguments);
    }

    @Bean
    public FilterRegistrationBean siteMeshPageFilter(){
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new SiteMeshFilter());
        registrationBean.setUrlPatterns(singletonList("/*"));
        registrationBean.setOrder(1);
        return registrationBean;
    }

    @Bean
    public FilterRegistrationBean filterDispatchAndActionCleanup(){
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new StrutsPrepareAndExecuteFilter());
        registrationBean.setUrlPatterns(asList("/", "/addUserForm.action", "/addUser.action",
                "/findUserForm.action", "/findUser.action",
                "/listAllUsers.action"));
        registrationBean.setOrder(2);
        return registrationBean;
    }
}
