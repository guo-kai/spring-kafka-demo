#1.安装配置kafka
#下载最新的kafka
wget https://www.apache.org/dyn/closer.cgi?path=/kafka/0.10.1.0/kafka_2.11-0.10.1.0.tgz
#解压文件
tar zxvf kafka_2.11-0.10.1.0.tgz
#修改配置文件(server.properties)
vim kafka_2.11-0.10.0.1/config/server.properties
broker.id=0 (集群唯一)
listeners=PLAINTEXT://192.168.88.75:9092
port=9092 
zookeeper服务器地址可指向到多台, 隔开
zookeeper.connect=192.168.88.74:2181

#kafka启动 (如需启动多个broker 请复制server,properties 修改配置)
bin/kafka-server-start.sh config/server.properties &

#kafka关闭
bin/kafka-server-stop.sh 

#查看topic
bin/kafka-topics.sh --list --zookeeper 192.168.88.74:2181
__consumer_offsets
event

#删除topic
bin/kafka-topics.sh --delete --zookeeper 192.168.88.74:2181 --topic mhb-test
Topic mhb-test is marked for deletion.
Note: This will have no impact if delete.topic.enable is not set to true.

#创建topic
bin/kafka-topics.sh —create --zookeeper 192.168.88.74:2181 --topic test-topic

#启动consumer控制台
bin/kafka-console-consumer.sh --zookeeper 192.168.88.74:2181 --topic event --from-beginning

#启动producer控制台
bin/kafka-console-producer.sh --broker-list 192.168.88.75:9092 --topic event

#2.安装雅虎开源的kafka 监控程序kafka-manager
#下载最新的源码
git clone https://github.com/yahoo/kafka-manager.git
cd kafka-manager/
#采用Scala sbt编译
sbt dist
#找到编译后的zip包（unzip kafka-manager-1.3.2.1.zip ）
cd target/universal/
unzip kafka-manager-1.3.2.1.zip 
$修改配置文件
vim kafka-manager-1.3.2.1/conf/application.conf 
修改zookeeper指向
kafka-manager.zkhosts="192.168.88.74:2181”
#移动kafka-manager到usr/local目录下
sudo mv kafka-manager-1.3.2.1 /usr/local/kafka-manager
cd /usr/local/kafka-manager
#运行kafka监控程序
bin/kafka-manager -Dconfig.file=conf/application.conf -Dhttp.port=9999 &



附一个kafka学习blog
http://blog.csdn.net/lizhitao/article/details/39499283
