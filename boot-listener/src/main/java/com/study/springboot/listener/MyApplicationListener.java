package com.study.springboot.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;

/**
 * ApplicationStartedEvent SpringBoot启动开始时执行的事件
 * ApplicationEnvironmentPreparedEvent：spring boot 对应Enviroment已经准备完毕，但此时上下文context还没有创建。
 * ApplicationPreparedEvent spring boot上下文context创建完成，但此时spring中的bean是没有完全加载完成的。
 * ApplicationFailedEvent spring boot启动异常时执行事件
 * @author lk
 */
public class MyApplicationListener implements ApplicationListener<ApplicationStartedEvent> {

    private Logger logger = LoggerFactory.getLogger(MyApplicationListener.class);
    @Override
    public void onApplicationEvent(ApplicationStartedEvent applicationStartedEvent) {
        logger.error("======= application start =======");
    }
}
