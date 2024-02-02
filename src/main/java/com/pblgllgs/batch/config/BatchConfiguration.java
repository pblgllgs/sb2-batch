package com.pblgllgs.batch.config;
/*
 *
 * @author pblgl
 * Created on 02-02-2024
 *
 */

import com.pblgllgs.batch.steps.ItemDescompressStep;
import com.pblgllgs.batch.steps.ItemProcessorStep;
import com.pblgllgs.batch.steps.ItemReaderStep;
import com.pblgllgs.batch.steps.ItemWriterStep;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.JobScope;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
public class BatchConfiguration {

    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Bean
    @JobScope
    public ItemDescompressStep itemDescompressStep() {
        return new ItemDescompressStep();
    }

    @Bean
    @JobScope
    public ItemReaderStep itemReaderStep() {
        return new ItemReaderStep();
    }

    @Bean
    @JobScope
    public ItemProcessorStep itemProcessorStep() {
        return new ItemProcessorStep();
    }

    @Bean
    @JobScope
    public ItemWriterStep itemWriterStep() {
        return new ItemWriterStep();
    }

    @Bean
    public Step descompressFileStep() {
        return stepBuilderFactory.get("itemDecompressStep")
                .tasklet(itemDescompressStep())
                .build();
    }

    @Bean
    public Step readFileStep() {
        return stepBuilderFactory.get("itemReaderStep")
                .tasklet(itemReaderStep())
                .build();
    }

    @Bean
    public Step processFileStep() {
        return stepBuilderFactory.get("itemProcessStep")
                .tasklet(itemProcessorStep())
                .build();
    }

    @Bean
    public Step writeFileStep() {
        return stepBuilderFactory.get("itemWriteStep")
                .tasklet(itemWriterStep())
                .build();
    }

    @Bean
    public Job readCSVJob(){
        return jobBuilderFactory.get("readCSVJob")
                .start(descompressFileStep())
                .next(readFileStep())
                .next(processFileStep())
                .next(writeFileStep())
                .build();
    }

}
