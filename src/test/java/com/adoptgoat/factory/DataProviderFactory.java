package com.adoptgoat.factory;

import com.adoptgoat.dataprovider.ConfigDataProvider;
import com.adoptgoat.dataprovider.TestDataProvider;

public class DataProviderFactory {
	
	public static ConfigDataProvider getConfigProperty() {
		
		return new ConfigDataProvider();
	}
	
	public static TestDataProvider getDataProperty() {
		
		return new TestDataProvider();
	}
	
	/*public static ExcelDataProvider getExcelProperty() {
		
		return new ExcelDataProvider();
	}*/

}
