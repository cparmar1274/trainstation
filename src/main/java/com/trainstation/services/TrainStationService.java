package com.trainstation.services;

import java.io.File;
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
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.trainstation.pojos.TrainStation;
import com.trainstation.utility.TSUtil;

@Service
public class TrainStationService {

	Logger logger = LogManager.getLogger(TrainStationService.class);

	public List<TrainStation> trainStationDetails = new ArrayList<>();

	public Map<String, Object> getStationList(int startIndex, int pageSize, String startDate, String endDate) {
		Map<String, Object> data = new HashMap<>();
		int totalRecords = trainStationDetails.size();

		if (!StringUtils.isEmpty(startDate) && !StringUtils.isEmpty(endDate)) {

			List<TrainStation> dateFiltered = trainStationDetails.stream()
					.filter(trainStation -> trainStation.getDate().after(TSUtil.getTSDate(startDate))
							&& trainStation.getDate().before(TSUtil.getTSDate(endDate)))
					.collect(Collectors.toList());

			int filteredRecords = dateFiltered.size();
			int start = startIndex >= filteredRecords ? filteredRecords : startIndex;
			int end = (start + pageSize) >= filteredRecords ? filteredRecords : (start + pageSize);

			data.put("recordsTotal", totalRecords);
			data.put("recordsFiltered", filteredRecords);
			data.put("data", dateFiltered.subList(start, end));

		} else {
			int start = startIndex >= totalRecords ? totalRecords : startIndex;
			int end = (start + pageSize) >= totalRecords ? totalRecords : (start + pageSize);
			data.put("recordsTotal", totalRecords);
			data.put("recordsFiltered", totalRecords);
			data.put("data", trainStationDetails.subList(start, end));
		}

		return data;
	}

	public boolean readCSVFileToUpdateStationList() {
		LineIterator lineIterator;
		try {
			logger.info("Processing csv file to fetch trainstaion details");
			lineIterator = FileUtils.lineIterator(new File("src/main/resources/eng-climate-summary.csv"));

			trainStationDetails.clear();
			String[] lineText = null, temp = null;
			lineIterator.next();
			while (lineIterator.hasNext()) {
				temp = new String[6];
				lineText = lineIterator.next().split(",");
				for (int i = 0; i < lineText.length; i++) {
					temp[i] = lineText[i];
				}
				trainStationDetails.add(new TrainStation(temp[0], temp[1], temp[2], temp[3], temp[4], temp[5]));
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
