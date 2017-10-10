import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Mapper.Context;

public class SortXMapper extends Mapper<Object,Text,DoubleWritable,Text>{
	@Override
	protected void map(Object key,Text value,Context context) throws IOException,InterruptedException{
		String line = value.toString();
		String k = line.split(" ")[0];
		DoubleWritable x = new DoubleWritable();
		x.set(Double.valueOf(k));
		context.write(x, value);
	}
}
