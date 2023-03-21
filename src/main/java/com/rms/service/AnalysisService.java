package com.rms.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.rms.dto.CanvasjsChartData;

@Service
public class AnalysisService {

	public List<List<Map<Object, Object>>> getCanvasjsChartData() {
		return CanvasjsChartData.getCanvasjsDataList();
	}

}