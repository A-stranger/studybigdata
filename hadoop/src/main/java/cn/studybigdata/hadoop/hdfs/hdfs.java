package cn.studybigdata.hadoop.hdfs;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.net.URI;

public class hdfs {

    public static void main(String[] args) throws Exception {
        URI uri = new URI("hdfs://node0:9000/");
        Configuration conf = new Configuration();
        String user = "zhangsan";
        FileSystem fs = FileSystem.get(uri,conf,user);

        fs.copyFromLocalFile(new Path("D:\\he.txt"), new Path("/user/zhangsan/"));

        boolean exist = fs.exists(new Path("/user/zhangsan/he.txt"));
        if(exist) {
            System.out.println("success");
        }else {
            System.out.println("failed");
        }
        fs.close();
    }

}
