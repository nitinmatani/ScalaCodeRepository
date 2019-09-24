To run the Spark SBT Project

1.sbt package
2.https://jaceklaskowski.gitbooks.io/mastering-apache-spark/exercises/spark-first-app.html
3. target/scala-2.11/spark_local_2.11-0.1.jar there is the final application ready for deployment.
4.~/dev/oss/spark/bin/spark-submit --master "local[*]" --class org.ugam.spark.SparkMeApp target/scala-2.11/spark_local_2.11-0.1.jar build.sbt