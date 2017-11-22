package junit.test;

import java.io.IOException;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooKeeper;
import org.junit.Test;

import test1.NodeOperation;

public class ZooKeeperTest {
	private NodeOperation nodeOperation = new NodeOperation();
	ZooKeeper zooKeeper=null;
	{
		try {
			zooKeeper = nodeOperation.connectionKeeper();
		} catch (IOException e) {
		
			e.printStackTrace();
		}
	}
	@Test
	public void testCreatNode() throws KeeperException, InterruptedException{
		String path="/java";
		String nodeData="com.atguigu.zooService";
		String result = nodeOperation.creatNewNode(zooKeeper, path, nodeData);
		System.out.println(result);
	}
	
	
	

	
	@Test
	public void testConnection() throws IOException, InterruptedException{
		ZooKeeper connectionKeeper = nodeOperation.connectionKeeper();
		System.out.println(connectionKeeper);
		Thread.sleep(Long.MAX_VALUE);
		
	}
	
	
	

}
