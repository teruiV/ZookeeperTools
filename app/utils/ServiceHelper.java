/**
 * 
 */
package utils;

import com.mob.hubble.service.ZkClusterService;

/**
 * @auth JiannWeilin
 *
 * @since 2016年1月25日
 */
public class ServiceHelper {
	public static ZkClusterService getZkClusterService() {
		return (ZkClusterService) Global.getBean("zkClusterService");
	}
}
