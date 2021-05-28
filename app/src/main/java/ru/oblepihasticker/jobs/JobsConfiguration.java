package ru.oblepihasticker.jobs;

import org.jobrunr.configuration.JobRunr;
import org.jobrunr.scheduling.JobScheduler;
import org.jobrunr.storage.sql.common.SqlStorageProviderFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class JobsConfiguration {

    @Bean
    public JobScheduler configureJobs(ApplicationContext applicationContext) {
        return JobRunr.configure()
                .useStorageProvider(SqlStorageProviderFactory.using(applicationContext.getBean(DataSource.class)))
                .useJobActivator(applicationContext::getBean)
                .initialize();
    }
}
