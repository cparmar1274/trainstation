package com.trainstation.services;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;
import org.springframework.stereotype.Service;

import com.trainstation.pojos.TrainStation;

@Service
public class TrainStationService {

	public List<TrainStation> trainStationDetails = new ArrayList<>();

	public List<TrainStation> getStationList(int pageSize,int pageNumber) {
		int start = pageSize*pageNumber;
	    int end = start + pageSize;
		return trainStationDetails.subList(start>trainStationDetails.size()?trainStationDetails.size():start, end>trainStationDetails.size()?trainStationDetails.size():end);
	}

	public boolean readCSVFileToUpdateStationList() throws IOException {
		LineIterator lineIterator = FileUtils.lineIterator(new File("src/main/resources/eng-climate-summary.csv"));
		trainStationDetails.clear();
		String[] lineText = null, temp = new String[6];
		lineIterator.next();
		while (lineIterator.hasNext()) {
			lineText = lineIterator.next().split(",");
			for (int i = 0; i < lineText.length; i++) {
				temp[i] = lineText[i];
			}
			trainStationDetails.add(new TrainStation(temp[0], temp[1], temp[2], temp[3], temp[4], temp[5]));
		}
		return true;
	}

}
