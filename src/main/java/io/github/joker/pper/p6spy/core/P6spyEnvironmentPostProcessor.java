package io.github.joker.pper.p6spy.core;

import io.github.joker.pper.p6spy.helper.P6spyReplaceUrlHelper;
import io.github.joker.pper.p6spy.metadata.P6spyConstants;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P6spyEnvironmentPostProcessor implements EnvironmentPostProcessor {

    @Override
    public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
        if (!Boolean.TRUE.equals(environment.getProperty(P6spyConstants.P6SPY_ENABLE_KEY, Boolean.class, P6spyConstants.P6SPY_ENABLE_DEFAULT_VALUE))) {
            //未启用时退出
            return;
        }

        //根据配置进行替换对应的datasource配置
        Map<String, Object> replaceConfigMap = new HashMap<>(16);

        //通过快速模式处理默认的主数据源
        if (Boolean.TRUE.equals(environment.getProperty(P6spyConstants.P6SPY_QUICK_KEY, Boolean.class, P6spyConstants.P6SPY_QUICK_DEFAULT_VALUE))) {
            //替换driverClassName
            for (String driverClassNameKey : P6spyConstants.P6SPY_QUICK_DRIVER_CLASS_NAME_KEYS) {
                String driverClassName = environment.getProperty(driverClassNameKey);
                if (driverClassName != null) {
                    replaceConfigMap.put(driverClassNameKey, P6spyConstants.P6SPY_DRIVER_CLASS_NAME);
                }
            }

            //替换url
            for (String urlKey : P6spyConstants.P6SPY_QUICK_URL_KEYS) {
                String url = environment.getProperty(urlKey);
                if (url != null) {
                    replaceConfigMap.put(urlKey, P6spyReplaceUrlHelper.getResolvedResult(url));
                }
            }
        }

        //通过自定义配置进行处理
        List<Object> customizeDriverClassNameKeys = getPropertyListResult(environment, P6spyConstants.P6SPY_CUSTOMIZE_DRIVER_CLASS_NAME_KEYS_KEY);
        if (customizeDriverClassNameKeys != null && !customizeDriverClassNameKeys.isEmpty()) {
            for (Object customizeDriverClassNameKey : customizeDriverClassNameKeys) {
                if (customizeDriverClassNameKey == null) {
                    continue;
                }
                String driverClassNameKey = String.valueOf(customizeDriverClassNameKey);
                String driverClassName = environment.getProperty(driverClassNameKey);
                if (driverClassName != null) {
                    replaceConfigMap.put(driverClassNameKey, P6spyConstants.P6SPY_DRIVER_CLASS_NAME);
                }
            }
        }

        List<Object> customizeUrlKeys = getPropertyListResult(environment, P6spyConstants.P6SPY_CUSTOMIZE_URL_KEYS_KEY);
        if (customizeUrlKeys != null && !customizeUrlKeys.isEmpty()) {
            for (Object customizeUrlKey : customizeUrlKeys) {
                if (customizeUrlKey == null) {
                    continue;
                }
                String urlKey = String.valueOf(customizeUrlKey);
                String url = environment.getProperty(urlKey);
                if (url != null) {
                    replaceConfigMap.put(urlKey, P6spyReplaceUrlHelper.getResolvedResult(url));
                }
            }
        }

        //进行替换变量配置
        if (!replaceConfigMap.isEmpty()) {
            environment.getPropertySources().addFirst(new MapPropertySource("p6spy starter replaced env", replaceConfigMap));
        }

    }


    private List<Object> getPropertyListResult(ConfigurableEnvironment environment, String key) {
        try {
            return (List<Object>) environment.getProperty(key, List.class);
        } catch (Exception ex) {
            return Collections.emptyList();
        }
    }

}
