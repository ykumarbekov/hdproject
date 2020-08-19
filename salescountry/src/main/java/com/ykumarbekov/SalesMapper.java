package com.ykumarbekov;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.*;

import java.io.IOException;

public class SalesMapper extends MapReduceBase implements Mapper <LongWritable, Text, Text, IntWritable> {
    private final static IntWritable one = new IntWritable(1);
    @Override
    public void map(LongWritable longWritable, Text value, OutputCollector<Text, IntWritable> output,
                    Reporter reporter) throws IOException {
        String[] SingleCountryData = value.toString().split(",");
        output.collect(new Text(SingleCountryData[7]), one);
    }
}
