package cn.studybigdata.hadoop.mapred.dpartition;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapreduce.Partitioner;

public class DeptPartitioner extends Partitioner<IntWritable, Employee> {


    @Override
    public int getPartition(IntWritable key, Employee value, int numPartitions) {

        if (key.get()%numPartitions==0){
            return 0;
        }else if (key.get()%numPartitions==1) {
            return 1;
        }else {
            return 2;
        }
    }
}
