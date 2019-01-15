package com.liming.weixin.common;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ConfigPropertites {
	public static ConfigPropertites build;
	@Autowired
	private ConfigPropertites configPropertites;

	@PostConstruct
	public void init() {
		build = this.configPropertites;
	}
    @Value("${jdbc.datasource}")
	private String JDBC_DATASOURCE;
    public static void main(String[] args) {
    	ConfigPropertites con=new ConfigPropertites();
    	System.out.println(con.JDBC_DATASOURCE);
	}
}
