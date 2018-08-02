# motan-spring-boot-demo

本项目记录将motan与spring-boot相整合的示例，可直接打包成jar包运行，便于搭建微服务器集群

安装请执行 mvn install
打包请执行 mvn package

打成jar包执行时，可以使用本地配置文件
java -jar server-1.0-SNAPSHOT.jar --motan.xml=file:server.xml
