package com.softnovo.domain;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;

public class ExportAppVo extends BaseRowModel {
	/**
	 * 品牌编码
	 */
	@ExcelProperty(value = { "品牌编码" }, index = 0)
	private String brandCode;

	/**
	 * 采集时间
	 */
	@ExcelProperty(value = { "采集时间" }, index = 1)
	private String collectTime;

	/**
	 * 占比
	 */
	@ExcelProperty(value = { "占比/量级" }, index = 2)
	private String insightPercent;

	/**
	 * 大盘
	 */
	@ExcelProperty(value = { "大盘" }, index = 3)
	private String grailPercent;

	/**
	 * 对比大盘
	 */
	@ExcelProperty(value = { "对比大盘" }, index = 4)
	private String comparePercent;

	public String getBrandCode() {
		return brandCode;
	}

	public void setBrandCode(String brandCode) {
		this.brandCode = brandCode;
	}

	public String getCollectTime() {
		return collectTime;
	}

	public void setCollectTime(String collectTime) {
		this.collectTime = collectTime;
	}

	public String getInsightPercent() {
		return insightPercent;
	}

	public void setInsightPercent(String insightPercent) {
		this.insightPercent = insightPercent;
	}

	public String getGrailPercent() {
		return grailPercent;
	}

	public void setGrailPercent(String grailPercent) {
		this.grailPercent = grailPercent;
	}

	public String getComparePercent() {
		return comparePercent;
	}

	public void setComparePercent(String comparePercent) {
		this.comparePercent = comparePercent;
	}
}
