package io.github.joker.pper.p6spy.helper;

import io.github.joker.pper.p6spy.metadata.P6spyConstants;

import java.util.LinkedHashMap;
import java.util.Map;

public class P6spyReplaceUrlHelper {

    /**
     * p6spy replace url config
     */
    private static final Map<String, String> P6SPY_REPLACE_URL_CONFIG = new LinkedHashMap<>(16);

    static {
        P6SPY_REPLACE_URL_CONFIG.put("jdbc:mysql:", "jdbc:p6spy:mysql:");
        P6SPY_REPLACE_URL_CONFIG.put("jdbc:mariadb:", "jdbc:p6spy:mariadb:");
        P6SPY_REPLACE_URL_CONFIG.put("jdbc:oracle:thin:", "jdbc:p6spy:oracle:thin:");
        P6SPY_REPLACE_URL_CONFIG.put("jdbc:oceanbase:", "jdbc:p6spy:oceanbase:");
        P6SPY_REPLACE_URL_CONFIG.put("jdbc:sqlserver:", "jdbc:p6spy:sqlserver:");
        P6SPY_REPLACE_URL_CONFIG.put("jdbc:microsoft:sqlserver:", "jdbc:p6spy:microsoft:sqlserver:");
        P6SPY_REPLACE_URL_CONFIG.put("jdbc:postgresql:", "jdbc:p6spy:postgresql:");
        P6SPY_REPLACE_URL_CONFIG.put("jdbc:sybase:", "jdbc:p6spy:sybase:");
        P6SPY_REPLACE_URL_CONFIG.put("jdbc:jtds:sybase:", "jdbc:p6spy:jtds:sybase:");
        P6SPY_REPLACE_URL_CONFIG.put("jdbc:db2:", "jdbc:p6spy:db2:");
        P6SPY_REPLACE_URL_CONFIG.put("jdbc:h2:", "jdbc:p6spy:h2:");
    }

    /**
     * 加载url替换配置
     *
     * @param configMap
     */
    public static synchronized void initConfig(Map<String, String> configMap) {
        if (configMap == null || configMap.isEmpty()) {
            return;
        }
        P6SPY_REPLACE_URL_CONFIG.putAll(configMap);
    }

    /**
     * 获取处理结果
     *
     * @param url
     * @return
     */
    public static String getResolvedResult(String url) {
        if (url == null || url.isEmpty()) {
            return url;
        }

        //通过url替换配置缓存进行处理
        for (Map.Entry<String, String> configEntry : P6SPY_REPLACE_URL_CONFIG.entrySet()) {
            if (url.startsWith(configEntry.getKey())) {
                //匹配到时进行替换
                return url.replace(configEntry.getKey(), configEntry.getValue());
            }
        }

        //通过前缀标识进行处理
        if (url.startsWith(P6spyConstants.JDBC_URL_PREFIX) && !url.startsWith(P6spyConstants.P6SPY_JDBC_URL_PREFIX)) {
            return url.replace(P6spyConstants.JDBC_URL_PREFIX, P6spyConstants.P6SPY_JDBC_URL_PREFIX);
        }

        return url;
    }


}
