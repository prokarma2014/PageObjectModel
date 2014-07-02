package com.cattle.reports;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;

import unitth.core.UnitTH;

public class Reports {
    public static void showResult() throws QAException, IOException {

	String path = "reportStorage";
	File reportStorage = new File("reportStorage");
	if (!reportStorage.exists()) {
	    reportStorage.mkdir();
	}
	File junitReports = new File("target/surefire-reports");

	/*
	 * if(!junitReports.exists()){ junitReports.mkdir(); }
	 */
	SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd-Hmmss");
	Date today = new Date();
	String newJunitReports = formatter.format(new java.sql.Timestamp(today
		.getTime()));
	File f = new File("reportStorage/report-" + newJunitReports);
	f.mkdir();

	FileUtils.copyDirectory(junitReports, f);

	List<String> fileName = new ArrayList<String>();
	File folder = new File(path);
	if (folder.isDirectory()) {
	    File[] listOfDirectories = folder.listFiles();
	    for (File innerDirectory : listOfDirectories) {
		if (innerDirectory.isDirectory()) {
		    fileName.add("reportStorage/" + innerDirectory.getName());
		}

	    }
	}
	System.out.println("FIle Name is:" + fileName.toString());
	String[] xmls = fileName.toArray(new String[fileName.size()]);
	System.out.println(xmls);
	UnitTH unitTh = new UnitTH(xmls);
	Desktop.getDesktop().open(new File("report.th/index.html"));

    }

    public static void main(String[] args) throws Exception {
	Reports.showResult();
    }
}