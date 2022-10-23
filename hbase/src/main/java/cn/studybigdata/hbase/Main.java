package cn.studybigdata.hbase;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.*;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.IOException;

public class Main {

    public static Connection connection;

    public static void main(String[] args) {
        getConnect();
//        createTable();
//        addName();
        addAge();
        getData();
    }

    public static void getConnect() {
        Configuration conf = HBaseConfiguration.create();
        conf.set("hbase.zookeeper.quorum", "node0");
        conf.set("hbase.zookeeper.property.clientPort", "2181");
        try {
            connection = ConnectionFactory.createConnection(conf);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void createTable() {

        try {
            Admin admin = connection.getAdmin();
            TableName student = TableName.valueOf("Student");
            if (admin.tableExists(student)) {
                admin.disableTable(student);
                admin.deleteTable(student);
                System.out.println("student表已存在，被删了");
            }
            HTableDescriptor studentDesc = new HTableDescriptor(student);
            HColumnDescriptor studentInfoCF = new HColumnDescriptor("Info");
            HColumnDescriptor studentScoreCF = new HColumnDescriptor("Score");
            studentDesc.addFamily(studentInfoCF);
            studentDesc.addFamily(studentScoreCF);

            admin.createTable(studentDesc);
            System.out.println("建表成功");
            admin.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void addName() {
        TableName student = TableName.valueOf("Student");
        try {
            Table table = connection.getTable(student);
            Put put = new Put(Bytes.toBytes("001"));
            put.addColumn(Bytes.toBytes("Info"), Bytes.toBytes("name"), Bytes.toBytes("qiaofeng"));
            table.put(put);
            table.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void addAge() {
        TableName student = TableName.valueOf("Student");
        try {
            Table table = connection.getTable(student);
            Put put = new Put(Bytes.toBytes("001"));
            put.addColumn(Bytes.toBytes("Info"), Bytes.toBytes("age"), Bytes.toBytes("30"));
            table.put(put);
            table.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void getData() {
        try {
            Table table = connection.getTable(TableName.valueOf("Student"));
            Get get = new Get(Bytes.toBytes("001"));
            Result result = table.get(get);
            Cell[] cells = result.rawCells();
            for (Cell cell : cells) {
//                String record = CellUtil.getCellKeyAsString(cell);
                String family = new String(CellUtil.cloneFamily(cell));
                String qualifier = new String(CellUtil.cloneQualifier(cell));
                String value = new String(CellUtil.cloneValue(cell));
                System.out.println(family);
                System.out.println(qualifier);
                System.out.println(value);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
