package com.softnovo.zk;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;

public class CuratorUtil {
	// 非Fluent风格.
//	RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
//    CuratorFramework client = CuratorFrameworkFactory.newClient("192.168.128.129:2181", 5000, 5000, retryPolicy);
	// Fluent 风格.
	// 第一个参数为baseSleepTimeMs初始的sleep时间，用于计算之后的每次重试的sleep时间。第二个参数为maxRetries，最大重试次数。
	private static RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);

	private static CuratorFramework client = CuratorFrameworkFactory.builder().connectString("127.0.0.1:2181")
			.sessionTimeoutMs(5000) // 会话超时时间
			.connectionTimeoutMs(5000) // 连接超时时间
			.retryPolicy(retryPolicy).namespace("spring") // 为了实现不同的ZooKeeper业务之间的隔离，往往会为每个业务分配一个独立的命名空间，即指定一个ZooKeeper根路径。例如，下面所示的代码片段中定义了某一个客户端的独立命名空间为/base，那么该客户端对ZooKeeper上数据节点的任何操作，都是基于该相对目录进行的
			.build();

	static {
		client.start();
	}

	public static CuratorFramework getClient() {
		return client;
	}
}
