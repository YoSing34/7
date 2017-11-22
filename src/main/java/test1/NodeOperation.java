package test1;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.ACL;
import org.apache.zookeeper.data.Id;

public class NodeOperation {
	public ZooKeeper connectionKeeper() throws IOException{
		
	
	
	//连接zookeeper服务器信息
	//连接zooKeeper服务器
	
	String connectString ="192.168.2.128:2181";
	int sessionTimeout=50*1000;
	
	ZooKeeper zooKeeper = new ZooKeeper(connectString, sessionTimeout, new Watcher() {
		
		@Override
		public void process(WatchedEvent arg0) {
			//暂时不做任何处理
			
		}
	});
	
	return zooKeeper;
	
	
	}
	
	
	public String creatNewNode(ZooKeeper zooKeeper,String path,String nodeData) throws KeeperException, InterruptedException{
		//將字符串類型數據轉化為字節數組
		byte[] data = nodeData.getBytes();
		
		//訪問控制列表
		//開放
		ArrayList<ACL> openAclUnsafe = Ids.OPEN_ACL_UNSAFE;
		
		//創建模式
		CreateMode mode = CreateMode.PERSISTENT;
		
		String result = zooKeeper.create(path, data, openAclUnsafe, mode);
		
		return result;
	}

}
