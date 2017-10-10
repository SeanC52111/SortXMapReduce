import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.DoubleWritable;

import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.Reducer.Context;

public class SortXReducer extends Reducer<DoubleWritable,Text,Text,NullWritable>{
	@Override
	protected void reduce(DoubleWritable key,Iterable<Text> values,Context context) throws IOException,InterruptedException{
		for(Text t:values) {
			context.write(t, NullWritable.get());
		}
	}
}
