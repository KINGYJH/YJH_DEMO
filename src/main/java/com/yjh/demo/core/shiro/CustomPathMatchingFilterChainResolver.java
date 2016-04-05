package com.yjh.demo.core.shiro;

import org.apache.shiro.web.filter.mgt.FilterChainManager;
import org.apache.shiro.web.filter.mgt.PathMatchingFilterChainResolver;

import javax.servlet.FilterChain;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by YJH on 2016/4/5 0005.
 */
public class CustomPathMatchingFilterChainResolver extends PathMatchingFilterChainResolver {

    private CustomDefaultFilterChainManager customDefaultFilterChainManager;

    public void setCustomDefaultFilterChainManager(CustomDefaultFilterChainManager customDefaultFilterChainManager) {
        this.customDefaultFilterChainManager = customDefaultFilterChainManager;
        setFilterChainManager(customDefaultFilterChainManager);
    }

    @Override
    public FilterChain getChain(ServletRequest request, ServletResponse response, FilterChain originalChain) {
        FilterChainManager filterChainManager = getFilterChainManager();
        if (!filterChainManager.hasChains()) {
            return null;
        }
        String requestUrl = getPathWithinApplication(request);
        List<String> chainNames = new ArrayList<String>();
        for (String pathPattern : filterChainManager.getChainNames()) {
            if (pathMatches(pathPattern, requestUrl)) {
                chainNames.add(pathPattern);
            }
        }

        if (chainNames.size() == 0) {
            return null;
        }
        return customDefaultFilterChainManager.proxy(originalChain, chainNames);
    }

}
