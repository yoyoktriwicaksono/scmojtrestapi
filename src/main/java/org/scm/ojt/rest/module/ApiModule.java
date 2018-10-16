package org.scm.ojt.rest.module;

import org.scm.ojt.rest.config.ConfigurationManager;
import org.scm.ojt.rest.dao.ConnectionManager;
import org.scm.ojt.rest.filter.CrossOriginResourceSharingFilter;
import org.scm.ojt.rest.servlet.ApiApplication;
import org.scm.ojt.rest.servlet.SwaggerBootstrap;
import com.google.inject.servlet.ServletModule;
import io.swagger.jaxrs.config.BeanConfig;
import org.glassfish.jersey.servlet.ServletContainer;
import org.scm.ojt.rest.utils.AppConstants;

import java.util.HashMap;
import java.util.Map;

/**
 * @author cluttered.code@gmail.com
 */
public class ApiModule extends ServletModule {


    @Override
    protected void configureServlets() {
        bind(ConnectionManager.class).asEagerSingleton();
        bind(ServletContainer.class).asEagerSingleton();
        bind(CrossOriginResourceSharingFilter.class).asEagerSingleton();

        initializeApplicationServlet();
        initializeSwaggerBootstrap();

        // CORS Filter
        filter("/*").through(CrossOriginResourceSharingFilter.class);
    }

    private void initializeApplicationServlet() {
        final Map<String, String> props = new HashMap<>();
        props.put(AppConstants.JAVAXRS, ApiApplication.class.getName());
        props.put(AppConstants.JERSEYCONFIG, Boolean.TRUE.toString());
        serve("/v1/*").with(ServletContainer.class, props);
    }

    private void initializeSwaggerBootstrap() {
        serve("").with(SwaggerBootstrap.class);
        BeanConfig beanConfig = new BeanConfig();
        beanConfig.setVersion("1.0.0-SNAPSHOT");
        beanConfig.setSchemes(new String[]{"http"});
        beanConfig.setTitle("Todo API");
        beanConfig.setDescription("Description of Todo API");
        beanConfig.setHost(ConfigurationManager.getInstance().getAppConfigData().host() + ":" + ConfigurationManager.getInstance().getAppConfigData().port().toString());
        beanConfig.setBasePath("/api/v1");
        beanConfig.setResourcePackage(AppConstants.SERVICEPACKAGE);
        beanConfig.setScan(true);
    }
}