package ru.oblepihasticker.jobs;

import org.jobrunr.scheduling.BackgroundJob;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class JobsRunnerService {

    public void runJob(UUID jobId, String cron, JobLambda jobLambda) {
        BackgroundJob.scheduleRecurrently(jobId.toString(), cron, () -> {
            if(jobLambda.run() == Boolean.TRUE) {
                BackgroundJob.delete(jobId.toString());
            }
        });
    }
}
