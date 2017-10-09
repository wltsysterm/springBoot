package com.neo.interceptor.configure;

import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.util.Comparator;
import java.util.Map;

/**
 * created by 魏霖涛 on 2017/10/9 0009
 */
public class DefaultMvcSupport extends WebMvcConfigurationSupport {
    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        configurer.setUseSuffixPatternMatch(false);
        configurer.setUseTrailingSlashMatch(true);
        configurer.setPathMatcher(new org.springframework.util.PathMatcher() {
            @Override
            public boolean isPattern(String s) {
                return false;
            }

            @Override
            public boolean match(String s, String s1) {
                return false;
            }

            @Override
            public boolean matchStart(String s, String s1) {
                return false;
            }

            @Override
            public String extractPathWithinPattern(String s, String s1) {
                return null;
            }

            @Override
            public Map<String, String> extractUriTemplateVariables(String s, String s1) {
                return null;
            }

            @Override
            public Comparator<String> getPatternComparator(String s) {
                return null;
            }

            @Override
            public String combine(String s, String s1) {
                return null;
            }
        });
    }
}
