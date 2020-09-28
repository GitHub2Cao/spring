package com.softnovo.service.impl;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.IndexedColors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Font;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.metadata.TableStyle;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.softnovo.domain.ExportAppVo;
import com.softnovo.service.ExportService;

@Service
public class ExportServiceImpl implements ExportService {
	private static final Logger LOGGER = LoggerFactory.getLogger(ExportService.class);

	@Override
	public void downLoadInsightApp(HttpServletResponse response) {
		String fileName = "用户洞察中心App报表" + new Date();
		String sheetName = "用户洞察中心App报表";
		try {
			OutputStream out = getOutputStream(response, fileName, ExcelTypeEnum.XLSX);
			// 这里指定需要表头，因为model通常包含表信头息
			ExcelWriter writer = new ExcelWriter(out, ExcelTypeEnum.XLSX, true);
			// 写第一个sheet,数据全是List<String> 无模型映射关系
			Sheet sheet = new Sheet(1, 0, ExportAppVo.class);
			// 设置自适应宽度
			sheet.setAutoWidth(Boolean.TRUE);
			// 设置表格样式
			sheet.setTableStyle(createTableStyle());
			// 设置sheetName
			sheet.setSheetName(sheetName);

			// 分页查询数据
			int pageNumber = 1;
			int pageSize = 500;
			int dataLength = pageSize;
			long start = System.currentTimeMillis() / 1000;// 单位秒
			Map<String, Integer> condition = new HashMap<>();
			List<ExportAppVo> resultList = null;// 置list为空，清空内存
			while (dataLength == pageSize) {
				int startIndex = (pageNumber - 1) * pageSize; // 99 * 5000 = 495000;
				condition.put("startIndex", startIndex);
				condition.put("pageSize", pageSize);
				resultList = queryInsightApp(condition);
				if (resultList == null || resultList.isEmpty()) {
					// 写数据
					writer.write(resultList, sheet);
					break;
				}
				dataLength = resultList.size();
				pageNumber++;
				// 写数据
				writer.write(resultList, sheet);
			}
			// 关闭writer的输出流
			writer.finish();
			long end = System.currentTimeMillis() / 1000;
			LOGGER.info("导出耗时：" + (end - start) + " 秒");
		} catch (Exception e) {
			LOGGER.error("导出异常", e);
		}
	}

	/**
	 * 数据库查询
	 * 
	 * @param condition
	 * @return
	 */
	private List<ExportAppVo> queryInsightApp(Map<String, Integer> condition) {
		// return dalClient.queryForList("export.queryInsightAppByPage", condition,
		// ExportAppVo.class);
		if (condition.get("startIndex") > 50000) {
			return null;
		}
		List<ExportAppVo> list = new ArrayList<>(500);
		
		for (int i = 0; i < 500; i++) {
			ExportAppVo vo = new ExportAppVo();
			vo.setBrandCode("brandCode" + i);
			vo.setCollectTime("collectTime" + i);
			vo.setComparePercent("comparePercent" + i);
			vo.setGrailPercent("grailPercent" + i);
			vo.setInsightPercent("insightPercent" + i);
			list.add(vo);
		}
		
		return list;
	}

	/**
	 * 得到流
	 * 
	 * @param response      响应
	 * @param fileName      文件名
	 * @param excelTypeEnum excel类型
	 * @return
	 */
	private OutputStream getOutputStream(HttpServletResponse response, String fileName, ExcelTypeEnum excelTypeEnum) {
		try {
			// 设置响应输出的头类型
			if (Objects.equals(".xls", excelTypeEnum.getValue())) {
				// 导出xls格式
				response.setContentType("application/vnd.ms-excel;charset=GBK");
			} else if (Objects.equals(".xlsx", excelTypeEnum.getValue())) {
				// 导出xlsx格式
				response.setContentType(
						"application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=GBK");
			}
			// 设置下载文件名称(注意中文乱码)
			response.addHeader("Content-Disposition", "attachment;filename="
					+ new String((fileName).getBytes("GB2312"), "ISO8859-1") + excelTypeEnum.getValue());
			response.addHeader("Pragma", "No-cache");
			response.addHeader("Cache-Control", "No-cache");
			response.setCharacterEncoding("utf8");
			return response.getOutputStream();
		} catch (IOException e) {
			LOGGER.error("EasyExcelUtil-->getOutputStream exception:", e);
		}
		return null;
	}

	private TableStyle createTableStyle() {
		TableStyle tableStyle = new TableStyle();
		Font headFont = new Font();
		headFont.setBold(true);
		headFont.setFontHeightInPoints((short) 20);
		headFont.setFontName("楷体");
		tableStyle.setTableHeadFont(headFont);
		tableStyle.setTableHeadBackGroundColor(IndexedColors.LIGHT_GREEN);

		Font contentFont = new Font();
		contentFont.setFontHeightInPoints((short) 12);
		contentFont.setFontName("黑体");
		tableStyle.setTableContentFont(contentFont);
		return tableStyle;
	}
}
