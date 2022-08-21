package com.scheduling.service;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalTime;

@Service
@ConditionalOnProperty(value = "com.scheduling.enabled", havingValue = "true")
public class FixDelayService {
    private int count =0;

    //In this case, the duration between the end of the last execution and the start of the next execution is fixed. The task always waits until the previous one is finished.
    //This option should be used when it’s mandatory that the previous execution is completed before running again.
    // this option will delay 1 second after the previous execution done

//    @Scheduled(fixedDelay = 1000)
    public void fixDelayMethod() throws InterruptedException {
        System.out.println("fix delay: " + count);
        Thread.sleep(2000);
        System.out.println("fix delay: " + count + " end");
        count++;
    }

//     delay 10 seconds after startup
//    @Scheduled(initialDelay = 10_000, fixedRate = 2000)
    public void fixInitialDelayMethod() throws InterruptedException {
        System.out.println("fix initial delay: " + count);
        Thread.sleep(2000);
        System.out.println("fix initial delay: " + count + " end");
        count++;
    }
    //This option should be used when each execution of the task is independent.
    // the "fix delay: 2" will display immediately after "fix delay: 1 end". because 1000 was counter to 0 before
//    @Scheduled(fixedRate = 1000)
    public void fixRateMethod() throws InterruptedException {
        System.out.println("fix rate: " + count);
        Thread.sleep(2000);
        System.out.println("fix rate: " + count + " end");
        count++;
    }

    @Async
//    @Scheduled(fixedRate = 1000)
    public void fixRateAsyncMethod() throws InterruptedException {
        System.out.println("fix rate async: " + count);
        Thread.sleep(3000);
        System.out.println("fix rate async: " + count + " end");
        count++;
    }

// https://www.freeformatter.com/cron-expression-generator-quartz.html to create or read cron
// here is each 5 seconds will cal 1 times
//    @Scheduled(cron = "0/5 * * ? * *")
    public void cronMethod() {
        System.out.println("cron : " + count++ + "  time: " + LocalTime.now());
    }

}
