
import org.apache.spark._
import org.apache.spark.SparkContext._
import java.io._
import scala.io.Source
import scala.io.Source._
import org.apache.spark.sql.Dataset
import org.apache.spark.sql.Row
import org.apache.spark.sql.SQLContext
import scala.collection.mutable.ListBuffer
import scala.io

val inputFile = args(0)
val outputFile = args(1)

val conf = new SparkConf().setAppName("proteinSeq");

// Create a Scala Spark Context.
val sc = new SparkContext(conf)

//Create a SQL Context using SparkContext
val sqlContext = new SQLContext(sc)

for (line <- Source.fromFile(inputFile).getLines) {
var proteins = new ListBuffer[String]()
val newList = sc.parallelize(line.sliding(4).mkString(",").split(",")).toDS()
val protein_seq = newList.select("value").groupBy("value").count
protein_seq.write.format("csv").mode("append").save(outputFile)
}
