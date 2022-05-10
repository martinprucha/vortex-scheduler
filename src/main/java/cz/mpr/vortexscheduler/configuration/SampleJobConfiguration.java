package cz.mpr.vortexscheduler.configuration;

import cz.mpr.vortexscheduler.job.SampleJob;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.quartz.SimpleScheduleBuilder.simpleSchedule;

@Configuration
public class SampleJobConfiguration {

    @Bean
    public JobDetail jobDetail1() {
        return JobBuilder.newJob().ofType(SampleJob.class)
                .storeDurably()
                .withIdentity("Qrtz_Job_Detail_1")
                .withDescription("Invoke Sample Job service 1...")
                .build();
    }

    @Bean
    public JobDetail jobDetail2() {
        return JobBuilder.newJob().ofType(SampleJob.class)
                .storeDurably()
                .withIdentity("Qrtz_Job_Detail_2")
                .withDescription("Invoke Sample Job service 2...")
                .build();
    }

    @Bean
    public Trigger trigger1(JobDetail jobDetail1) {
        return TriggerBuilder.newTrigger().forJob(jobDetail1)
                .withIdentity("Qrtz_Trigger_1")
                .withDescription("Sample trigger 1")
                .withSchedule(simpleSchedule().repeatForever().withIntervalInSeconds(5))
                .build();
    }

    @Bean
    public Trigger trigger2(JobDetail jobDetail2) {
        return TriggerBuilder.newTrigger().forJob(jobDetail2)
                .withIdentity("Qrtz_Trigger_2")
                .withDescription("Sample trigger 2")
                .withSchedule(simpleSchedule().repeatForever().withIntervalInSeconds(10))
                .build();
    }
}
