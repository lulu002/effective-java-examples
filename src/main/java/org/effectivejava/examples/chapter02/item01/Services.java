// Service provider framework sketch

// Noninstantiable class for service registration and access - Pages 8-9
package org.effectivejava.examples.chapter02.item01;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Services {
	private Services() {
	} 

	// 提供服务的Map，使用线程安全的hashmap.
	private static final Map<String, Provider> providers = new ConcurrentHashMap<String, Provider>();
	public static final String DEFAULT_PROVIDER_NAME = "<def>";

	/**
	 * 注册默认服务
	 * 
	 * @param p
	 */
	public static void registerDefaultProvider(Provider p) {
		registerProvider(DEFAULT_PROVIDER_NAME, p);
	}

	/**注册自定义名称服务
	 * @param name
	 * @param p
	 */
	public static void registerProvider(String name, Provider p) {
		providers.put(name, p);
	}

	/**
	 * 生成默认服务对象
	 * @return
	 */
	public static Service newInstance() {
		return newInstance(DEFAULT_PROVIDER_NAME);
	}

	/**
	 * 生成提供服务对象
	 * @param name
	 * @return
	 */
	public static Service newInstance(String name) {
		Provider p = providers.get(name);
		if (p == null)
			throw new IllegalArgumentException(
					"No provider registered with name: " + name);
		return p.newService();
	}
}
