package com.trainstation.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.core.io.ClassPathResource;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.trainstation.pojos.TrainStation;
import com.trainstation.utility.TSUtil;

@Service
@EnableScheduling
public class TrainStationService {

	public static final Logger logger = LogManager.getLogger(TrainStationService.class);

	public List<TrainStation> trainStationDetails = new ArrayList<>();

	public Map<String, Object> getStationList(int startIndex, int pageSize, String startDate, String endDate) {
		Map<String, Object> data = new HashMap<>();
		int totalRecords = trainStationDetails.size();
		data.put("recordsTotal", totalRecords);
		
		if (!StringUtils.isEmpty(startDate) && !StringUtils.isEmpty(endDate)) {
			logger.info(" date range filter applied for {} and {}", startDate, endDate);
			List<TrainStation> dateFiltered = trainStationDetails.stream()
					.filter(trainStation -> trainStation.getDate().after(TSUtil.getTSDate(startDate))
							&& trainStation.getDate().before(TSUtil.getTSDate(endDate)))
					.collect(Collectors.toList());

			int filteredRecords = dateFiltered.size();
			int start = startIndex >= filteredRecords ? filteredRecords : startIndex;
			int end = (start + pageSize) >= filteredRecords ? filteredRecords : (start + pageSize);

			data.put("recordsFiltered", filteredRecords);
			data.put("data", dateFiltered.subList(start, end));

		} else {
			int start = startIndex >= totalRecords ? totalRecords : startIndex;
			int end = (start + pageSize) >= totalRecords ? totalRecords : (start + pageSize);
			data.put("recordsFiltered", totalRecords);
			data.put("data", trainStationDetails.subList(start, end));
		}

		return data;
	}

	/*
	 * Ideally we should be using Spring batch but for now lets update list nighly.
	 */
	@Scheduled(cron = "0 0 * * * *")
	public boolean readCSVFileToUpdateStationList() {
		LineIterator lineIterator;
		try {
			logger.info("Processing csv file to fetch trainstaion details");
			lineIterator = FileUtils.lineIterator(new ClassPathResource(TSUtil.TRAIN_STATION_CSV_FILE_PATH).getFile());

			trainStationDetails.clear();
			String[] lineText = null, temp = null;
			lineIterator.next();
			while (lineIterator.hasNext()) {
				temp = new String[6];
				lineText = lineIterator.next().split(",");
				for (int i = 0; i < lineText.length; i++) {
					temp[i] = lineText[i];
				}
				try {
					trainStationDetails.add(new TrainStation(temp[0], temp[1], temp[2], temp[3], temp[4], temp[5]));
					
					/*
					 * IF any record fail to parse - does not stop reading further.Skip the record. Keep note of it and Proceed.
					 * Update the file - when cron job runs next time it will be updated.
					 * */
					
				} catch (Exception ex) {
					logger.error("Error while processing record  {}  , error message  {} ", lineText, ex.getMessage());
				}
			}
			logger.info("Processing csv file completed. total {} records processed.", trainStationDetails.size());

		} catch (IOException e) {
			e.printStackTrace();
			logger.error("I/O Error while reading .csv file from resources folder. {}", e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Error while reading .csv file from resources folder. {}", e.getMessage());
		}
		return true;
	}

	public List<TrainStation> getStationDetail(String stationName) {
		logger.info("sending {} details", stationName);
		return trainStationDetails.stream()
				.filter(trainStation -> trainStation.getStationName().equalsIgnoreCase(stationName))
				.collect(Collectors.toList());
	}

}
