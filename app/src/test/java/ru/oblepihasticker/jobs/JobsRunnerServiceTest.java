package ru.oblepihasticker.jobs;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.UUID;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {JobsRunnerServiceTestConfiguration.class})
public class JobsRunnerServiceTest {

    private JobsRunnerService jobsRunnerService = new JobsRunnerService();

    @Test
    @DisplayName("If job returns true it must be stopped")
    public void runJobTest() {
        jobsRunnerService.runJob(UUID.randomUUID(), "0/5 * * * * *", () -> {
            System.out.println("Do some work");
            return Boolean.TRUE;
        });
    }
}
