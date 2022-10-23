package cn.studybigdata.minicluster;


import com.google.common.io.Files;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hdfs.MiniDFSCluster;
import org.apache.hadoop.yarn.server.MiniYARNCluster;

import java.io.File;
import java.io.IOException;

public class MiniCluster {
    public static void main(String[] args) throws IOException {

        System.setProperty("hadoop.home.dir", "D:\\IdeaProjects\\spark\\hadoop-winutils\\hadoop-3.3.1");
        System.setProperty("java.io.tmpdir", "D:\\IdeaProjects\\hadoop-train\\minicluster\\src\\main\\resources");
        System.load("D:\\IdeaProjects\\spark\\hadoop-winutils\\hadoop-3.3.1\\bin\\hadoop.dll");
        Configuration configuration = new Configuration();
        File tempDir = Files.createTempDir();
        configuration.set(MiniDFSCluster.HDFS_MINIDFS_BASEDIR, tempDir.getAbsolutePath());
//        new MiniDFSCluster.Builder(configuration).build();
        MiniDFSCluster hdfs = new MiniDFSCluster.Builder(configuration).numDataNodes(3).nameNodePort(8888).nameNodeHttpPort(50070).build();

        System.out.println();

//        MiniYARNCluster yrCluster = new MiniYARNCluster("test", 1, 1, 1);
//        yrCluster.init(configuration);
//        yrCluster.start();
    }
}
