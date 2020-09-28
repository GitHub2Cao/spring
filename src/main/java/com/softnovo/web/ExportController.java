package com.softnovo.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.softnovo.service.ExportService;

@CrossOrigin
@RestController
@RequestMapping("/mip/export")
public class ExportController {
	@Autowired
	private ExportService exportService;
	
    @GetMapping("/downLoadApp")
    public void downLoadApp(HttpServletRequest request, HttpServletResponse response) {
        exportService.downLoadInsightApp(response);
    }
}
