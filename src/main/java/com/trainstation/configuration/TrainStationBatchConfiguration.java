/*package com.trainstation.configuration;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.batch.item.support.ListItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import com.trainstation.pojos.TrainStation;
import com.trainstation.utility.TSUtil;

@Configuration
@EnableBatchProcessing
public class TrainStationBatchConfiguration {

	@Autowired
	public JobBuilderFactory jobBuilderFactory;

	@Autowired
	public StepBuilderFactory stepBuilderFactory;

	@Bean
	public LineMapper<TrainStation> lineMapper() {
		DefaultLineMapper<TrainStation> mapper = new DefaultLineMapper<TrainStation>();
		mapper.setFieldSetMapper(fieldSet -> new TrainStation(fieldSet.readString(0), fieldSet.readString(1),
				fieldSet.readString(2), fieldSet.readString(3), fieldSet.readString(4), fieldSet.readString(5)));
		mapper.setLineTokenizer(new DelimitedLineTokenizer());
		return mapper;
	}

	@Bean
	public Job importUserJob(Step step) {
		return jobBuilderFactory.get("importUserJob").incrementer(new RunIdIncrementer()).flow(step).end().build();
	}
	
	@Bean
	public ItemWriter writer(){
		return trainStations -> {
			for(Object ts:trainStations)
				System.out.println(ts.toString());
		};
	}
	

	@Bean
	public Step step(ListItemWriter<TrainStation> writer) {
		return stepBuilderFactory.get("step").chunk(20)
				.reader(new FlatFileItemReaderBuilder<TrainStation>().name("READ_CSV_FILE")
						.resource(new ClassPathResource(TSUtil.TRAIN_STATION_CSV_FILE_PATH)).linesToSkip(1)
						.lineMapper(lineMapper()).build()).writer(writer())
				.build();
	}

	
	
}*/
