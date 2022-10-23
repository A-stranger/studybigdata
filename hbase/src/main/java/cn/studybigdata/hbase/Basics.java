package cn.studybigdata.hbase;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.*;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.IOException;

public class Basics {

    public static Connection connection;


    public static void main(String[] args) throws IOException {


        Configuration hbaseConf = HBaseConfiguration.create();
        hbaseConf.set("hbase.zookeeper.quorum","node1");
        hbaseConf.set("hbase.zookeeper.property.clientPort","2181");

        //拿到connection对象
        getConnection(hbaseConf);

        createTable();


//        TableName tableName = TableName.valueOf("student_test");

        //插入数据
//        addValue(tableName, "0002","Info","Name","duanyu");
//        addValue(tableName, "0002","Info","Sex","male");
//        addValue(tableName, "0002","Score","Hadoop","95");
//        addValue(tableName, "0002","Score","HBase","98");

        //查询一个逻辑行
//        selectData(tableName, "0002");

    }



    /**
     * @param hbaseConf
     */
    public static void getConnection(Configuration hbaseConf){

        try {
            connection = ConnectionFactory.createConnection(hbaseConf);
        } catch (IOException e) {
            System.out.println("链接补上Zookeeper了，你再检查检查。。。");
            e.printStackTrace();
        }
    }

    /**
     * 创建表
     * @return
     */
    public static void createTable(){
        try {
            Admin admin = connection.getAdmin();

            // 表名
            TableName tableTest = TableName.valueOf("student_a");

            // 查询所有表
//            TableName[] tableNames = admin.listTableNames();
//            for (TableName tableName : tableNames) {
//                System.out.println(tableName.getNameAsString());
//                if (tableName.getNameAsString().equals("student_test")){
//                    System.out.println("表已存在"+tableName.getNameAsString());
//                    break;
//                }
//            }
            //判断表是否存在
            boolean exists = admin.tableExists(tableTest);
            if (exists){
//                admin.disableTable(tableTest); //禁用
//                admin.deleteTable(tableTest);  //删除
                System.out.println("表已存在！");
                return ;
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
        System.out.println("新增数据成功！");

    }

    /**
     * 查询一个逻辑行，并使用CellUtil解析
     * @param tableName
     * @param rowKey
     * @throws IOException
     */
    public static void selectData(TableName tableName, String rowKey) throws IOException {

        Table table = connection.getTable(tableName);
        Get get = new Get(Bytes.toBytes(rowKey));
        // 逻辑行
        Result result = table.get(get);
        //单元格
        Cell[] cells = result.rawCells();

        for (Cell cell : cells) {
            String f = new String(CellUtil.cloneFamily(cell));
            String col = new String(CellUtil.cloneQualifier(cell));
            String value = new String(CellUtil.cloneValue(cell));

            System.out.println("列族：" +f);
            System.out.println("列：" +col);
            System.out.println("值：" +value);

        }

    }
    
}
