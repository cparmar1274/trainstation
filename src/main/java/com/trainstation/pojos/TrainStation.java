package com.trainstation.pojos;

import java.io.Serializable;
import java.util.Date;

import org.springframework.util.StringUtils;

import com.trainstation.utility.TSUtil;

public class TrainStation implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public String stationName;
	public String province;
	public Date date;
	public Float meanTemp;
	public Float highestMonthlyMaxiTemp;
	public Float lowestMonthlyMinTemp;

	public TrainStation() {
		super();
	}

	public TrainStation(String stationName, String province, String date, String meanTemp,
			String highestMonthlyMaxiTemp, String lowestMonthlyMinTemp) {
		this.stationName = stationName;
		this.province = province;
		this.date = TSUtil.getTSDate(date);
		this.meanTemp = StringUtils.isEmpty(meanTemp) ? null : Float.valueOf(meanTemp);
		this.highestMonthlyMaxiTemp = StringUtils.isEmpty(highestMonthlyMaxiTemp) ? null
				: Float.valueOf(highestMonthlyMaxiTemp);
		this.lowestMonthlyMinTemp = StringUtils.isEmpty(lowestMonthlyMinTemp) ? null
				: Float.valueOf(lowestMonthlyMinTemp);
	}

	public String getStationName() {
		return stationName;
	}

	public void setStationName(String stationName) {
		this.stationName = stationName;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Float getMeanTemp() {
		return meanTemp;
	}

	public void setMeanTemp(Float meanTemp) {
		this.meanTemp = meanTemp;
	}

	public Float getHighestMonthlyMaxiTemp() {
		return highestMonthlyMaxiTemp;
	}

	public void setHighestMonthlyMaxiTemp(Float highestMonthlyMaxiTemp) {
		this.highestMonthlyMaxiTemp = highestMonthlyMaxiTemp;
	}

	public Float getLowestMonthlyMinTemp() {
		return lowestMonthlyMinTemp;
	}

	public void setLowestMonthlyMinTemp(Float lowestMonthlyMinTemp) {
		this.lowestMonthlyMinTemp = lowestMonthlyMinTemp;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((highestMonthlyMaxiTemp == null) ? 0 : highestMonthlyMaxiTemp.hashCode());
		result = prime * result + ((lowestMonthlyMinTemp == null) ? 0 : lowestMonthlyMinTemp.hashCode());
		result = prime * result + ((meanTemp == null) ? 0 : meanTemp.hashCode());
		result = prime * result + ((province == null) ? 0 : province.hashCode());
		result = prime * result + ((stationName == null) ? 0 : stationName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TrainStation other = (TrainStation) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (highestMonthlyMaxiTemp == null) {
			if (other.highestMonthlyMaxiTemp != null)
				return false;
		} else if (!highestMonthlyMaxiTemp.equals(other.highestMonthlyMaxiTemp))
			return false;
		if (lowestMonthlyMinTemp == null) {
			if (other.lowestMonthlyMinTemp != null)
				return false;
		} else if (!lowestMonthlyMinTemp.equals(other.lowestMonthlyMinTemp))
			return false;
		if (meanTemp == null) {
			if (other.meanTemp != null)
				return false;
		} else if (!meanTemp.equals(other.meanTemp))
			return false;
		if (province == null) {
			if (other.province != null)
				return false;
		} else if (!province.equals(other.province))
			return false;
		if (stationName == null) {
			if (other.stationName != null)
				return false;
		} else if (!stationName.equals(other.stationName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TrainStation [stationName=" + stationName + ", province=" + province + ", date=" + date + ", meanTemp="
				+ meanTemp + ", highestMonthlyMaxiTemp=" + highestMonthlyMaxiTemp + ", lowestMonthlyMinTemp="
				+ lowestMonthlyMinTemp + "]";
	}

}
