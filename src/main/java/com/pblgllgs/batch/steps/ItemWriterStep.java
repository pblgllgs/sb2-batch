package com.pblgllgs.batch.steps;
/*
 *
 * @author pblgl
 * Created on 02-02-2024
 *
 */

import com.pblgllgs.batch.entities.Person;
import com.pblgllgs.batch.service.IPersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Slf4j
public class ItemWriterStep implements Tasklet {

    @Autowired
    private IPersonService iPersonService;

    @Override
    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
        log.info("----------START BATCH PROCESS: WRITER---------");
        List<Person> personList = (List<Person>) chunkContext
                .getStepContext()
                .getStepExecution()
                .getJobExecution()
                .getExecutionContext()
                .get("personList");

        assert personList != null;
        personList.forEach(person -> {
            if (person != null) {
                log.info(person.toString());
            }
        });
        iPersonService.saveAll(personList);
        log.info("----------FINISH BATCH PROCESS: WRITER---------");
        return RepeatStatus.FINISHED;
    }
}
