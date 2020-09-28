package com.softnovo.zk;

import org.apache.zookeeper.CreateMode;
import org.junit.Test;

public class ZkTest {
	// ------------------------ crud test -------------------------
	@Test
	public void testCreateNode() {
		try {
			CuratorUtil.getClient().create().creatingParentContainersIfNeeded() // 递归创建所需父节点
					.withMode(CreateMode.PERSISTENT) // 创建类型为持久节点
					//.forPath("/nodeA", "init"); // 目录及内容
					.forPath("/nodeA");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testDelete() {
		try {
			CuratorUtil.getClient().delete().guaranteed() // 强制保证删除
					.deletingChildrenIfNeeded() // 递归删除子节点
					//.withVersion(10086) // 指定删除的版本号
					.forPath("/nodeA");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testEdit() {
		try {
			CuratorUtil.getClient().setData()
			//.withVersion(10086) // 指定版本修改
			.forPath("/nodeA", "data1212121".getBytes());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testGet() {
		byte[] bytes = null;
		try {
			bytes = CuratorUtil.getClient().getData().forPath("/nodeA");
		} catch (Exception e) {
			e.printStackTrace();
		} 
        System.out.println(new String(bytes));
	}
	
	

}
