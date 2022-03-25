## p6spy-starter

[![Maven Central](https://img.shields.io/maven-central/v/io.github.joker-pper/p6spy-starter.svg?label=Maven%20Central)](https://search.maven.org/search?q=g:%22io.github.joker-pper%22%20AND%20a:%22p6spy-starter%22)
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)


    通过属性配置便可以自动替换springboot数据源中p6spy的配置(支持常见数据库).

### 功能介绍
    
 + 仅对springboot中的环境变量配置进行自动替换 (p6spy使用方式与原来一致)
 
 + 无需改变原数据源配置内容便可实现引入p6spy (一定程度可减少引入p6spy更改配置错误)

 + 动态控制是否启用p6spy功能
 
 + 支撑定制化处理指定driverKey和urlKey的替换
 

### 快速使用

```

<dependency>
  <groupId>io.github.joker-pper</groupId>
  <artifactId>p6spy-starter</artifactId>
  <version>${version}</version>
</dependency>

```

### 属性配置

```
    spring.datasource.p6spy.enable   
     
        描述:
            是否启用组件功能,关闭后将不会生效
        
        缺省值:
            false

    spring.datasource.p6spy.quick   
     
        描述:
            是否启用快速模式,开启后将自动替换默认数据源的配置,其中
                driver class name keys:
                    spring.datasource.driver-class-name
                    spring.datasource.driverClassName
            
                url keys:
                    spring.datasource.url
        缺省值:
            true
    
    spring.datasource.p6spy.customize.url-keys
     
        描述:
            自定义要处理的url keys,多个值时用,分割

    spring.datasource.p6spy.customize.driver-class-name-keys    
     
        描述:
            自定义要处理的driver class name keys,多个值时用,分割



```

### 属性配置示例

```

properties格式

spring.datasource.p6spy.enable=true
spring.datasource.p6spy.quick=true
spring.datasource.p6spy.customize.url-keys=spring.datasource.second.url
spring.datasource.p6spy.customize.driver-class-name-keys=spring.datasource.second.driverClassName,spring.datasource.second.driver-class-name


yml格式

spring:
  datasource:
    p6spy:
      enable: true
      quick: true
      customize:
        url-keys: spring.datasource.second.url
        driver-class-name-keys: spring.datasource.second.driverClassName,spring.datasource.second.driver-class-name
```


### 示例项目

 [https://github.com/joker-pper/p6spy-starter-samples](https://github.com/joker-pper/p6spy-starter-samples)
 


### 其他

```
    https://github.com/p6spy/p6spy
    
    https://www.javadoc.io/doc/p6spy/p6spy/latest/index.html
    
    https://p6spy.readthedocs.io/en/latest/configandusage.html
    
```    