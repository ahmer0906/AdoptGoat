package com.adoptgoat.factory;

import com.adoptgoat.dataprovider.ConfigDataProvider;

public class DataProviderFactory {

	public static ConfigDataProvider getConfigProperty() {
		return new ConfigDataProvider();
	}
}
