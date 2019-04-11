import org.apache.spark._
import org.apache.spark.SparkContext._
import scala.collection.mutable.ListBuffer
import java.io._
import scala.io.Source
import scala.io.Source._
import org.apache.spark.sql.Dataset
import org.apache.spark.sql.Row
import org.apache.spark.sql.SQLContext
//import org.apache.spark.rdd.RDD
//import java.util.ArrayList

object WordCount {
    def main(args: Array[String]) {

    def isPrime2(i :Int) : Boolean = {
     if (i <= 1)
       false
     else if (i == 2)
       true
     else
       !(2 to (i-1)).exists(x => i % x == 0)
   }
      //var totalPrimes = 0

      val inputFile = args(0)
      val outputFile = args(1)

      val conf = new SparkConf().setAppName("proteinSeq");

      // Create a Scala Spark Context.
      val sc = new SparkContext(conf)

      //Create a SQL Context using SparkContext
      val sqlContext = new SQLContext(sc)

      case class Proteins(seq: String, count: Int)

      import sqlContext.implicits._

      //val protein_seq = sqlContext.emptyDataset[Proteins]

      val writer = new BufferedWriter(new FileWriter(outputFile,true))

      // Load our input data.
      //val file =  sc.textFile(inputFile)
      val file = sqlContext.read.text(inputFile).as[String]
      //val intLines = lines.map(_.toInt)
      //val words = lines.flatMap(_.split(" "))

      //var primeNums = scala.collection.mutable.Buffer[Int]()
      for (List(one,two,three,four) <- file.sliding(4)) writer.write(one+two+three+four+'\n')

      //intLines.take(limit.toInt).foreach(a => if(isPrime2(a.toInt)) primeNums += a)

      //for (a <- words) {
      //    if(isPrime2(a.toInt)) writer.write(a+"\n")
      //    totalPrimes += 1;
      //}

      //writer.write("Total prime numbers: "+primeNums.size)

      // Split up into words.
      //val words = input.flatMap(line => line.split(" "))

      //var primeNums = new ListBuffer[String]()
      //words.collect().foreach(a => if(isPrime2(a.toInt)) writer.write(a+"\n"))

      writer.close

      // Save the word count back out to a text file, causing evaluation.
      // counts.saveAsTextFile(outputFile)
    }
}
