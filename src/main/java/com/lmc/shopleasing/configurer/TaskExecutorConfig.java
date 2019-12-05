package com.lmc.shopleasing.configurer;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.aop.interceptor.SimpleAsyncUncaughtExceptionHandler;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * @author lmc
 */
@EnableAsync
@Slf4j
@Configuration
public class TaskExecutorConfig  implements AsyncConfigurer {

    @Value("${task.pool_size}")
    private int taskPoolSize;

    @Value("${task.max_pool_size}")
    private int taskMaxPoolSize;

    @Value("${task.queue_capacity}")
    private int taskQueueCapacity;

    @Value("${task.keep_alive_seconds}")
    private int taskKeepAliveSeconds;

    @Bean
    @Override
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        // 设置核心线程数
        executor.setCorePoolSize(taskPoolSize);
        // 设置最大线程数
        executor.setMaxPoolSize(taskMaxPoolSize);
        // 设置队列容量
        executor.setQueueCapacity(taskQueueCapacity);
        // 设置线程活跃时间（秒）
        executor.setKeepAliveSeconds(taskKeepAliveSeconds);
        // 设置默认线程名称
        executor.setThreadNamePrefix("异步线程池-");
        // 设置拒绝策略
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        // 等待所有任务结束后再关闭线程池
        executor.setWaitForTasksToCompleteOnShutdown(true);
        return executor;
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return new SimpleAsyncUncaughtExceptionHandler();
    }
}