package com.lmc.shopleasing.global;

/**
 * 公共参数
 * 
 * @author lmc
 */
public final class CommonAttributes {

	/**
	 * 日期格式配比
	 */
	public static final String[] DATE_PATTERNS = new String[] { "yyyy", "yyyy-MM", "yyyyMM", "yyyy/MM", "yyyy-MM-dd", "yyyyMMdd", "yyyy/MM/dd", "yyyy-MM-dd HH:mm:ss", "yyyyMMddHHmmss", "yyyy/MM/dd HH:mm:ss" };

	/**
	 * shopleasing.xml文件路径
	 */
	public static final String SHOPLEASING_XML_PATH = "/shopleasing.xml";

	/**
	 * shopleasing.properties文件路径
	 */
	public static final String SHOPLEASING_PROPERTIES_PATH = "/shopleasing.properties";

	/**
	 * 不可实例化
	 */
	private CommonAttributes() {
	}

}