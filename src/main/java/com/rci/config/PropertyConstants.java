/**
 * 
 */
package com.rci.config;

/**
 * @Description
 * @author zj
 * @Date 2014年8月5日
 *	
 */
public class PropertyConstants{
	private PropertyConstants() {}

	public static final String TIMER_ENABLED = "framework.timer.enabled";
	public static final String LOCALE = "framework.locale";
	public static final String MESSAGE_RESOURCES="framework.i18n.resources";
	public static final String PROPERTY_RESOURCES="framework.properties.resources";

	public static final String CONFIGURATION_RELOADABLE="framework.global.configuration.reloadable";
	public static final String I18N_RELOADABLE="framework.i18n.resources.reloadable";
	/*
	 * 配置文件文件刷新时间
	 */
	public static final String GLOBAL_REFRESH_SECOND="framework.global.configuration.refresh.second";
	public static final String I18N_REFRESH_SECOND="framework.i18n.resources.refresh.second";
	public static final String PROPERTY_REFRESH_SECOND="framework.properties.resources.refresh.second";

	public static final String DEFAULT_PAGESIZE="framework.global.pagination.default_pagesize";
	
	//Business 业务相关常量
	public static final String SYSNAME = "system.name";
	public static final String CASH = "paymode.num.cash";
	public static final String DPTG = "paymode.num.dzdptg";
	public static final String DPSH = "paymode.num.dzdpsh";
	public static final String MT = "paymode.num.mt";
	public static final String ELE = "paymode.num.ele";
	public static final String TDD = "paymode.num.tdd";
	public static final String MTWM = "paymode.num.mtwm";
	public static final String LS = "paymode.num.ls";
	public static final String FREE = "paymode.num.free";
	
	public static final String BIGSUIT_A="big.suit.a";
	public static final String BIGSUIT_B="big.suit.a";
	public static final String SMALLSUIT="small.suit";
	public static final String SUITA="suit.a";
	public static final String SUITB="suit.b";
	public static final String SUITC="suit.c";
	public static final String SUITC_2="suit.c2";
	
	public static final String NODISCOUNT_DISHTYPE = "nodiscount.dishtype.no";
}
