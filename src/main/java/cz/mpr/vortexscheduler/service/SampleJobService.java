package cz.mpr.vortexscheduler.service;

import org.quartz.JobExecutionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class SampleJobService {
    public void executeSampleJob(JobExecutionContext context) {
        Logger logger = LoggerFactory.getLogger(SampleJobService.class);
        logger.info(context.getJobDetail().getKey() + " - executeSampleJob method running.");
    }
}
