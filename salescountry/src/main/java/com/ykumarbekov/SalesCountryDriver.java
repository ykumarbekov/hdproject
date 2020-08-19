package com.ykumarbekov;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.*;

public class SalesCountryDriver
{
    public static void main( String[] args)
    {
//        JobClient my_client = new JobClient();
        JobConf job_conf = new JobConf(SalesCountryDriver.class);
        job_conf.setJobName("SalePerCountry");
        job_conf.setOutputKeyClass(Text.class);
        job_conf.setOutputValueClass(IntWritable.class);
        job_conf.setMapperClass(SalesMapper.class);
        job_conf.setReducerClass(SalesCountryReducer.class);
        job_conf.setInputFormat(TextInputFormat.class);
        job_conf.setOutputFormat(TextOutputFormat.class);

        if (args.length == 2) {
            FileInputFormat.setInputPaths(job_conf, new Path(args[0]));
            FileOutputFormat.setOutputPath(job_conf, new Path(args[1]));
            new JobClient().setConf(job_conf);
//            my_client.setConf(job_conf);
            try {
                JobClient.runJob(job_conf);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else
            System.out.println("Usage: hdproject <input-folder> <output-folder>");

    }
}
