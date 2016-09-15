package curator;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.curator.retry.RetryNTimes;
import org.apache.curator.utils.CloseableUtils;
import org.apache.zookeeper.data.Stat;

/**
 * Created by jianwl on 2016/1/8.
 */
public class CuratorExample {

    private static final String ZK_PATH = "/brokers";
    private static final String ZK_ADDRESS = "192.168.180.78:2181";

    public static void main(String[] args) throws Exception {
        CuratorFramework client = CuratorFrameworkFactory.newClient(
                ZK_ADDRESS,
                new RetryNTimes(10, 5000)
        );
        client.start();
        System.out.println("zk client start successfully!");

        // 2.Client API test
        // 2.1 Create node
//        String data1 = "hello";
//        print("create", ZK_PATH, data1);
//        client.create().
//                creatingParentsIfNeeded().
//                forPath(ZK_PATH, data1.getBytes());

        // 2.2 Get node and data
//        print("ls", "/");
//        print(client.getChildren().forPath("/"));
//        print("get", ZK_PATH);
//        print(client.getData().forPath(ZK_PATH));

        // 2.3 Modify data
//        String data2 = "world";
//        print("set", ZK_PATH, data2);
//        client.setData().forPath(ZK_PATH, data2.getBytes());
//        print("get", ZK_PATH);
//        print(client.getData().forPath(ZK_PATH));

        // 2.4 Remove node
//        print("delete", ZK_PATH);
//        client.delete().forPath(ZK_PATH);
//        print("ls", "/");
//        print(client.getChildren().forPath("/"));

        // 2.5 exist znode
//        print("checkExsit",ZK_PATH);
//        print(client.checkExists().forPath(ZK_PATH));

        //2.6 print stat
        printTree(ZK_PATH,client);
    }

    private static void printTree(String path,CuratorFramework client) throws Exception {
//        sb.append("<item text=\" " + path + "\" id= \"" + path + "\"");
        Stat stat = new Stat();
        System.out.println("path == " + client.getChildren().storingStatIn(stat).forPath(path));

    }


    private static void print(String... cmds) {
        StringBuilder text = new StringBuilder("$ ");
        for (String cmd : cmds) {
            text.append(cmd).append(" ");
        }
        System.out.println(text.toString());
    }

    private static void print(Object result) {
        System.out.println(
                result instanceof byte[]
                        ? new String((byte[]) result)
                        : result);
    }
}
