package com.trainstation.utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TSUtil {

	public static final String TRAIN_STATION_CSV_FILE_PATH = "eng-climate-summary.csv";
	public static final SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);
	public static final Logger logger = LogManager.getLogger(TSUtil.class);
	public static Date getTSDate(String trainDate)  {
		try {
			return TSUtil.formatter.parse(trainDate);
		} catch (ParseException e) {
			logger.error("Error while parsing {}. Error says {}",trainDate,e.getMessage());
			e.printStackTrace();
			return null;
		}
	}
	
}
