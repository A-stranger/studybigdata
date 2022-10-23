package cn.studybigdata.hbase;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.IOException;

public class MockData {

    public static Connection connection;


    public static void main(String[] args) throws IOException {


        Configuration hbaseConf = HBaseConfiguration.create();
        hbaseConf.set("hbase.zookeeper.quorum", "node1");
        hbaseConf.set("hbase.zookeeper.property.clientPort", "2181");

        //拿到connection对象
        getConnection(hbaseConf);

        TableName tableName = TableName.valueOf("student_a");

        createTable(tableName);

        for (int i = 0; i < 25000; i++) {
            String rowKey = "rk-"+ i;
            //插入数据
            addValue(tableName, rowKey, "Info", "Name",
                      "zhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsa" +
                            "zhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsa" +
                            "zhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsa" +
                            "zhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsa" +
                            "zhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsa" +
                            "zhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsa" +
                            "zhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsa" +
                            "zhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsa"+
                              "zhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsa" +
                              "zhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsa" +
                              "zhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsa" +
                              "zhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsa" +
                              "zhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsa" +
                              "zhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsa" +
                              "zhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsa" +
                              "zhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsa"+
                              "zhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsa" +
                              "zhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsa" +
                              "zhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsa" +
                              "zhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsa" +
                              "zhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsa" +
                              "zhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsa" +
                              "zhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsa" +
                              "zhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsa"+
                              "zhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsa" +
                              "zhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsa" +
                              "zhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsa" +
                              "zhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsa" +
                              "zhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsa" +
                              "zhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsa" +
                              "zhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsa" +
                              "zhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsa"+
                              "zhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsa" +
                              "zhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsa" +
                              "zhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsa" +
                              "zhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsa" +
                              "zhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsa" +
                              "zhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsa" +
                              "zhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsa" +
                              "zhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsa"+
                              "zhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsa" +
                              "zhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsa" +
                              "zhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsa" +
                              "zhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsa" +
                              "zhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsa" +
                              "zhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsa" +
                              "zhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsa" +
                              "zhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsa"+
                              "zhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsa" +
                              "zhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsa" +
                              "zhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsa" +
                              "zhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsa" +
                              "zhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsa" +
                              "zhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsa" +
                              "zhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsa" +
                              "zhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsa"+
                              "zhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsa" +
                              "zhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsa" +
                              "zhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsa" +
                              "zhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsa" +
                              "zhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsa" +
                              "zhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsa" +
                              "zhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsa" +
                              "zhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsanzhangsa");
            addValue(tableName, rowKey, "Info", "Sex",
                      "malemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemal" +
                            "malemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemal" +
                            "malemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemal" +
                            "malemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemal" +
                            "malemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemal" +
                            "malemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemal" +
                            "malemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemal" +
                            "malemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemal"+
                              "malemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemal" +
                              "malemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemal" +
                              "malemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemal" +
                              "malemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemal" +
                              "malemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemal" +
                              "malemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemal" +
                              "malemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemal" +
                              "malemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemal"+
                              "malemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemal" +
                              "malemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemal" +
                              "malemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemal" +
                              "malemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemal" +
                              "malemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemal" +
                              "malemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemal" +
                              "malemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemal" +
                              "malemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemal"+
                              "malemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemal" +
                              "malemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemal" +
                              "malemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemal" +
                              "malemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemal" +
                              "malemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemal" +
                              "malemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemal" +
                              "malemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemal" +
                              "malemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemal"+
                              "malemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemal" +
                              "malemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemal" +
                              "malemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemal" +
                              "malemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemal" +
                              "malemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemal" +
                              "malemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemal" +
                              "malemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemal" +
                              "malemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemal"+
                              "malemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemal" +
                              "malemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemal" +
                              "malemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemal" +
                              "malemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemal" +
                              "malemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemal" +
                              "malemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemal" +
                              "malemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemal" +
                              "malemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemal"+
                              "malemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemal" +
                              "malemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemal" +
                              "malemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemal" +
                              "malemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemal" +
                              "malemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemal" +
                              "malemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemal" +
                              "malemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemal" +
                              "malemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemal"+
                              "malemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemal" +
                              "malemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemal" +
                              "malemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemal" +
                              "malemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemal" +
                              "malemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemal" +
                              "malemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemal" +
                              "malemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemal" +
                              "malemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemalemal");
            addValue(tableName, rowKey, "Score", "Hadoop",
                      "HadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoo" +
                            "HadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoo" +
                            "HadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoo" +
                            "HadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoo" +
                            "HadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoo" +
                            "HadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoo" +
                            "HadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoo" +
                            "HadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoo" +
                            "HadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoo"+
                              "HadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoo" +
                              "HadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoo" +
                              "HadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoo" +
                              "HadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoo" +
                              "HadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoo" +
                              "HadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoo" +
                              "HadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoo" +
                              "HadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoo" +
                              "HadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoo"+
                              "HadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoo" +
                              "HadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoo" +
                              "HadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoo" +
                              "HadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoo" +
                              "HadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoo" +
                              "HadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoo" +
                              "HadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoo" +
                              "HadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoo" +
                              "HadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoo"+
                              "HadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoo" +
                              "HadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoo" +
                              "HadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoo" +
                              "HadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoo" +
                              "HadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoo" +
                              "HadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoo" +
                              "HadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoo" +
                              "HadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoo" +
                              "HadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoo"+
                              "HadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoo" +
                              "HadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoo" +
                              "HadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoo" +
                              "HadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoo" +
                              "HadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoo" +
                              "HadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoo" +
                              "HadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoo" +
                              "HadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoo" +
                              "HadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoo"+
                              "HadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoo" +
                              "HadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoo" +
                              "HadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoo" +
                              "HadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoo" +
                              "HadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoo" +
                              "HadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoo" +
                              "HadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoo" +
                              "HadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoo" +
                              "HadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoo"+
                              "HadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoo" +
                              "HadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoo" +
                              "HadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoo" +
                              "HadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoo" +
                              "HadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoo" +
                              "HadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoo" +
                              "HadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoo" +
                              "HadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoo" +
                              "HadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoo"+
                              "HadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoo" +
                              "HadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoo" +
                              "HadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoo" +
                              "HadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoo" +
                              "HadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoo" +
                              "HadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoo" +
                              "HadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoo" +
                              "HadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoo" +
                              "HadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoopHadoo"
                    );
            addValue(tableName, rowKey, "Score", "HBase",
                      "HBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBas" +
                            "HBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBas" +
                            "HBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBas" +
                            "HBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBas" +
                            "HBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBas" +
                            "HBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBas" +
                            "HBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBas" +
                            "HBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBas"+
                              "HBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBas" +
                              "HBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBas" +
                            "HBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBas" +
                            "HBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBas" +
                            "HBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBas" +
                            "HBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBas" +
                            "HBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBas" +
                            "HBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBas"+
                              "HBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBas" +
                              "HBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBas" +
                              "HBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBas" +
                              "HBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBas" +
                              "HBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBas" +
                              "HBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBas" +
                              "HBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBas" +
                              "HBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBas"+
                              "HBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBas" +
                              "HBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBas" +
                              "HBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBas" +
                              "HBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBas" +
                              "HBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBas" +
                              "HBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBas" +
                              "HBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBas" +
                              "HBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBas"+
                              "HBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBas" +
                              "HBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBas" +
                              "HBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBas" +
                              "HBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBas" +
                              "HBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBas" +
                              "HBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBas" +
                              "HBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBas" +
                              "HBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBas"+
                              "HBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBas" +
                              "HBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBas" +
                              "HBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBas" +
                              "HBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBas" +
                              "HBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBas" +
                              "HBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBas" +
                              "HBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBas" +
                              "HBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBas"+
                              "HBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBas" +
                              "HBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBas" +
                              "HBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBas" +
                              "HBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBas" +
                              "HBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBas" +
                              "HBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBas" +
                              "HBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBas" +
                              "HBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBas"+
                              "HBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBas" +
                              "HBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBas" +
                              "HBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBas" +
                              "HBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBas" +
                              "HBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBas" +
                              "HBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBas" +
                              "HBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBas" +
                              "HBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBaseHBas");
            addValue(tableName, rowKey, "Score", "Spark",
                      "SparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSpar" +
                            "SparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSpar" +
                            "SparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSpar" +
                            "SparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSpar" +
                            "SparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSpar" +
                            "SparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSpar" +
                            "SparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSpar" +
                            "SparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSpar"+
                              "SparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSpar" +
                              "SparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSpar" +
                              "SparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSpar" +
                              "SparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSpar" +
                              "SparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSpar" +
                              "SparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSpar" +
                              "SparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSpar" +
                              "SparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSpar"+
                              "SparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSpar" +
                              "SparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSpar" +
                              "SparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSpar" +
                              "SparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSpar" +
                              "SparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSpar" +
                              "SparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSpar" +
                              "SparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSpar" +
                              "SparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSpar"+
                              "SparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSpar" +
                              "SparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSpar" +
                              "SparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSpar" +
                              "SparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSpar" +
                              "SparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSpar" +
                              "SparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSpar" +
                              "SparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSpar" +
                              "SparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSpar"+
                              "SparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSpar" +
                              "SparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSpar" +
                              "SparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSpar" +
                              "SparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSpar" +
                              "SparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSpar" +
                              "SparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSpar" +
                              "SparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSpar" +
                              "SparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSpar"+
                              "SparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSpar" +
                              "SparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSpar" +
                              "SparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSpar" +
                              "SparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSpar" +
                              "SparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSpar" +
                              "SparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSpar" +
                              "SparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSpar" +
                              "SparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSpar"+
                              "SparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSpar" +
                              "SparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSpar" +
                              "SparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSpar" +
                              "SparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSpar" +
                              "SparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSpar" +
                              "SparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSpar" +
                              "SparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSpar" +
                              "SparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSpar"+
                              "SparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSpar" +
                              "SparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSpar" +
                              "SparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSpar" +
                              "SparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSpar" +
                              "SparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSpar" +
                              "SparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSpar" +
                              "SparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSpar" +
                              "SparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSpar");

            System.out.println(rowKey);
        }
    }


    /**
     * @param hbaseConf
     */
    public static void getConnection(Configuration hbaseConf) {

        try {
            connection = ConnectionFactory.createConnection(hbaseConf);
        } catch (IOException e) {
            System.out.println("链接不上Zookeeper了，你再检查检查。。。");
            e.printStackTrace();
        }
    }

    /**
     * 创建表
     *
     * @return
     */
    public static void createTable(TableName tableTest) {
        try {
            Admin admin = connection.getAdmin();

            //判断表是否存在
            boolean exists = admin.tableExists(tableTest);
            if (exists) {
                System.out.println("表已存在！");
                return;
            }

            // 表描述
            HTableDescriptor tableDesc = new HTableDescriptor(tableTest);


            // 列族 Info
            HColumnDescriptor studentInfo = new HColumnDescriptor("Info");
            // 列族 Score
            HColumnDescriptor studentScore = new HColumnDescriptor("Score");

            tableDesc.addFamily(studentInfo);
            tableDesc.addFamily(studentScore);
            // 创建表
            admin.createTable(tableDesc);

            // 日志提示一下
            System.out.println("创建表成功~");

        } catch (IOException e) {
            System.out.println("创建表失败，失败原因如下：");
            e.printStackTrace();
        }
    }

    /**
     * 向某单元格插入数据
     *
     * @param tableName
     * @param rowKey
     * @param family
     * @param column
     * @param value
     * @throws IOException
     */
    public static void addValue(TableName tableName, String rowKey, String family, String column, String value) throws IOException {

        Table table = connection.getTable(tableName);

        Put put = new Put(Bytes.toBytes(rowKey));
        put.addColumn(Bytes.toBytes(family), Bytes.toBytes(column), Bytes.toBytes(value));
        table.put(put);
        table.close();
    }

}
