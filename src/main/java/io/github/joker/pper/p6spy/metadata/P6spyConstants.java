package io.github.joker.pper.p6spy.metadata;

import java.util.Arrays;
import java.util.List;

public final class P6spyConstants {

    /**
     * p6spy starter key prefix
     */
    private static final String P6SPY_STARTER_KEY_PREFIX = "spring.datasource.p6spy.";

    /**
     * p6spy driver class name
     */
    public static final String P6SPY_DRIVER_CLASS_NAME = com.p6spy.engine.spy.P6SpyDriver.class.getName();

    /**
     * jdbc url prefix
     */
    public static final String JDBC_URL_PREFIX = "jdbc:";

    /**
     * p6spy jdbc url prefix
     */
    public static final String P6SPY_JDBC_URL_PREFIX = "jdbc:p6spy:";

    /**
     * 是否启用
     */
    public static final String P6SPY_ENABLE_KEY = "spring.datasource.p6spy.enable";

    /**
     * 是否启用缺省值
     */
    public static final Boolean P6SPY_ENABLE_DEFAULT_VALUE = Boolean.FALSE;

    /**
     * 是否为快速模式
     */
    public static final String P6SPY_QUICK_KEY = P6SPY_STARTER_KEY_PREFIX + "quick";

    /**
     * 是否为快速模式缺省值
     */
    public static final Boolean P6SPY_QUICK_DEFAULT_VALUE = Boolean.TRUE;

    /**
     * 快速模式默认处理的driver class name keys
     */
    public static final List<String> P6SPY_QUICK_DRIVER_CLASS_NAME_KEYS = Arrays.asList("spring.datasource.driverClassName", "spring.datasource.driver-class-name");

    /**
     * 快速模式默认处理的url keys
     */
    public static final List<String> P6SPY_QUICK_URL_KEYS = Arrays.asList("spring.datasource.url");

    /**
     * 自定义要处理的driver class name keys
     */
    public static final String P6SPY_CUSTOMIZE_DRIVER_CLASS_NAME_KEYS_KEY = P6SPY_STARTER_KEY_PREFIX + "customize.driver-class-name-keys";

    /**
     * 自定义要处理的url keys
     */
    public static final String P6SPY_CUSTOMIZE_URL_KEYS_KEY = P6SPY_STARTER_KEY_PREFIX + "customize.url-keys";
}
