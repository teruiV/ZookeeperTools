package utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.TreeMap;

import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.xml.sax.SAXException;

import play.Application;
import play.GlobalSettings;
import play.cache.Cache;
import play.libs.F.Promise;
import play.mvc.Action;
import play.mvc.Content;
import play.mvc.Http.Request;
import play.mvc.Http.RequestHeader;
import play.mvc.SimpleResult;

public class Global extends GlobalSettings {

	private static final Logger logger = Logger.getLogger(Global.class);
//	
//	public static final Long ITEM_PER_PAGE = 5l;
//	public static final String AJAX_GRANTED = "granted";
//	public static final String UNAUTHORIZED = "Unauthorized, please connect Tech Support Team(ds_my@dena.jp).";
//	public static final String CSV_TMP_FOLDER = "/tmp";
//	public static final String CSV_FAILED = "/var/data/dmp/crystal/csv/failed.csv";
//	public static final String DMP_FAILED = "/var/data/dmp/crystal/hive_output/sql_failed.txt";
//	public static final String EXCEL_FAILED = "/var/data/dmp/crystal/excel/failed.txt";
//
//	public static final int MAX_DATE_SPAN = 31;
//
//	public static final String BAD_REQUEST = "parameter illegal.";
//
	private static ApplicationContext ac;
	private static boolean isDebug;
//	private static String hiveServer;
	

	/**
	 * 
	 */
	public Global() {
	}
	
	
	
	@Override
	public void onStart(Application arg0) {
		super.onStart(arg0);
		
		logger.info("Application is starting...");
//		
//		// init spring
		logger.info("start init spring config");
		ac = new FileSystemXmlApplicationContext(
				"classpath:META-INF/applicationContext.xml");
		logger.info("ac:" + ac);
//		
//		try {
//			FormGenerator.initFormMap();
//			logger.info("init form map OK.");
//		} catch (ParserConfigurationException e) {
//			logger.error("init form map error(1).");
//			logger.error(e);
//		} catch (SAXException e) {
//			logger.error("init form map error(2).");
//			logger.error(e);
//		} catch (IOException e) {
//			logger.error("init form map error(3).");
//			logger.error(e);
//		}
//		
//		
//		Properties prop = new Properties(); 
//        InputStream in = this.getClass().getResourceAsStream("/mysql-config/config.properties");
//        try {
//            prop.load(in);
//        } catch(Exception e) {
//        	logger.error(e);
//        } finally {
//        	try {
//				in.close();
//			} catch (IOException e) {
//				logger.error(e);
//			}
//        }
//        
//        String environment = prop.getProperty("environment");
//        logger.info("environment : " + environment);
//        if (environment != null && environment.equals("local")) {
//        	isDebug = true;
//        } else {
//        	isDebug = false;
//        }
//        
//        if (environment != null && environment.equals("production")) {
//        	hiveServer = "10.96.4.252";
//        } else {
//        	hiveServer = "10.96.5.250";
//        }
        
		
	}

	@Override
	public void onStop(Application app) {
		logger.info("Application shutdown...");
	}

	@Override
	public Promise<SimpleResult> onError(RequestHeader request, Throwable t) {
		String error = "Error occured" + "\r\n\r\n";
		error = error + "host: " + request.host();
		error = error + "uri: " + request.uri() + "\r\n";
		error = error + "params: " + request.queryString() + "\r\n";
		error = error + "methods: " + request.method() + "\r\n";
		error = error + "path: " + request.path() + "\r\n\r\n";
		error = error + "headers: " + "\r\n";
		for (String key : request.headers().keySet()) {
			error = error + key + " = ";
			String[] values = request.headers().get(key);
			if (values != null && values.length > 0) {
				for (String value : values) {
					error = error + value + ",";
				}
			}
			error = error + "\r\n";
		}
		error = error + "\r\n";
		error = error + ExceptionUtils.getStackTrace(t);
		logger.error(error);
//		SendMailService sendMailService = (SendMailService)getBean("sendMailService");
//		sendMailService.sendErrorMail(error, "weixin");
		return super.onError(request, t);
	}

	

	
	public static void cleanCache() {
		//Cache.remove();
	}

	@Override
	public Action onRequest(Request request, Method arg1) {
		// memory kanshi
		logger.debug("total memory: " + Runtime.getRuntime().totalMemory()
				/ 1024 + "KB");
		logger.debug("free memory: " + Runtime.getRuntime().freeMemory() / 1024
				+ "KB");
		logger.info("request url: " + request.uri());
		return super.onRequest(request, arg1);
	}

	public static Object getBean(String beanName) {
		return ac.getBean(beanName);
	}
	
	
	public static boolean isDebug() {
		isDebug = true;
		return isDebug;
	}
	
//	public static String getHiveServer() {
//		return hiveServer;
//	}
	
	
	public static List<Long> sortKeySet(Set<Long> set) {
		List<Long> list = new ArrayList<Long>();
		for (Long key : set) {
			list.add(key);
		}
		Collections.sort(list);
		return list;
	}



	
}
