package com.taotao.fdfs.client;

import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.StorageClient1;
import org.csource.fastdfs.StorageServer;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.junit.Test;

/**
 * FastDFS客户端测试
 * <p>Title: FdfsClient</p>
 * <p>Description: </p>
 * <p>Company: www.itcast.com</p> 
 * @author	入云龙
 * @date	2015年10月21日上午11:28:11
 * @version 1.0
 */
public class FdfsClient {

	@Test
	public void testFdfsClient() throws Exception {
		// 第一步：创建一个java工程
		// 第二步：导入FastDFSClient的jar包。
		// 第三步：加载FastDFSClient的配置文件。
		ClientGlobal.init("D:\\workspaces-itcast\\0619\\FastDFSClient\\config\\client.conf");
		// 第四步：创建一个TrackerClient对象
		TrackerClient trackerClient = new TrackerClient();
		// 第五步：通过TrackerClient创建一个TrackerServer对象。
		TrackerServer trackerServer = trackerClient.getConnection();
		// 第六步：创建StorageClient对象。需要TrackerServer对象需要一个StorageServer对象（null）。
		StorageServer storageServer = null;
		StorageClient1 storageClient1 = new StorageClient1(trackerServer, storageServer);
		// 第七步：StorageClient的方法上传文件。
		//第一个参数：文件的全路径,第二个参数：文件扩展名。第三个参数：文件的一些属性，例如文件的大小、文件的原始名称。
		String urls = storageClient1.upload_file1("D:\\Documents\\Pictures\\images\\2010062413421645.jpg", null, null);
		/*for (String string : urls) {
			System.out.println(string);
		}*/
		System.out.println(urls);
		
	}
	
	@Test
	public void testFdfsClient2() throws Exception {
		FastDFSClient client = new FastDFSClient("D:\\workspaces-itcast\\0619\\FastDFSClient\\config\\client.conf");
		String url = client.uploadFile("D:\\Documents\\Pictures\\images\\2010062413421645.jpg");
		System.out.println(url);
	}
}
