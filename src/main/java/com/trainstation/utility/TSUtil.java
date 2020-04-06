package com.trainstation.utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class TSUtil {

	public static final SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);
	public static final String TRAIN_STATION_CSV_FILE_PATH = "src/main/resources/eng-climate-summary.csv";
	
	public static Date getTSDate(String trainDate)  {
		try {
			return TSUtil.formatter.parse(trainDate);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
