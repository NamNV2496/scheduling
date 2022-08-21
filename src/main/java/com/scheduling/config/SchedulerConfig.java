package com.scheduling.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

// Why do I put this annotation at here????
// in big project, we need summarize config to 1 folder to restrict duplicate enable annotation for 1 feature
@EnableScheduling
@Configuration
public class SchedulerConfig {
}
