import org.csource.fastdfs.*;
import org.junit.Test;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by xdcao on 2017/5/26.
 */
public class TestFileUpload {

    @Test
    public void testIp(){
        InetAddress addr = null;
        try {
            addr = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        String ip=addr.getHostAddress().toString();//获得本机IP

        System.out.println(ip);
    }

    @Test
    public void testUpload() throws Exception{

        ClientGlobal.init("H:\\xdcao_taotao_springboot\\src\\main\\resources\\client.conf");
        TrackerClient trackerClient=new TrackerClient();
        TrackerServer trackerServer=trackerClient.getConnection();
        StorageServer storageServer=null;
        StorageClient storageClient=new StorageClient(trackerServer,storageServer);
        String[] strings=storageClient.upload_file("H:\\xdcao_taotao_springboot\\src\\main\\resources\\11.jpg","jpg",null);
        for(String string:strings){
            System.out.println(string);
        }
    }

}
