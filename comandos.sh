bin/spark-class org.apache.spark.deploy.master.Master  --help
bin/spark-class org.apache.spark.deploy.master.Master
bin/spark-class org.apache.spark.deploy.worker.Worker --help
bin/spark-class org.apache.spark.deploy.worker.Worker -h 0.0.0.0 spark://172.31.46.205:7077
bin/spark-submit --master spark://172.31.46.205:7077 --class com.curso.conceptos.EstimarPIMapReduceSpark introduccion_2.13-0.1.0-SNAPSHOT.jar


