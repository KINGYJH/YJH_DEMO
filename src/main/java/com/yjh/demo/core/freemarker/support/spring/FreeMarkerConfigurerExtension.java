package com.yjh.demo.core.freemarker.support.spring;

import com.yjh.demo.core.freemarker.directive.DirectiveUtils;
import freemarker.template.Configuration;
import freemarker.template.TemplateException;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import java.io.IOException;


/**
 * Created by YJH on 2016/3/3.
 */
public class FreeMarkerConfigurerExtension extends FreeMarkerConfigurer {
    /**
     * Return a new Configuration object. Subclasses can override this for
     * custom initialization, or for using a mock object for testing.
     * <p>Called by {@code createConfiguration()}.
     *
     * @return the Configuration object
     * @throws java.io.IOException       if a config file wasn't found
     * @throws freemarker.template.TemplateException on FreeMarker initialization failure
     * @see #createConfiguration()
     */
    @Override
    protected Configuration newConfiguration() throws IOException, TemplateException {
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_21);
        DirectiveUtils.exposeRapidMacros(configuration);
        return configuration;
    }
}

