# Summary

本书的大部分内容取材自我个人的博客以及个人编写的开源书（也算是为开源事业贡献微薄之力吧），不想看本书的也可以直接关注我博客（<https://waylau.com>）或者开源书（<https://waylau.com/books>）的内容。当然，博客相对来说比较零散，没有这本书来的严谨。

* [内容简介](docs/Introduction.md)
* [前言](docs/Preface.md)
* 第一部分 分布式系统基础理论
* 第1章 分布式系统基础知识
	* 1.1 概述  -> [用大白话聊聊分布式系统](https://waylau.com/talk-about-distributed-system/)、[分布式 Java](https://github.com/waylau/distributed-java)
	* 1.2 线程  -> [Java 编程要点](https://github.com/waylau/essential-java)
	* 1.3 通信  -> [远程过程调用(RPC)详解](https://waylau.com/remote-procedure-calls/)、[TCP 协议的三次握手、四次分手](https://waylau.com/tcp-connect-and-close/)、[AS3使用thrift的与JHava servlet服务器端通信](https://waylau.com/as3-using-thrift-and-java-servlet-server-side-communication/)
	* 1.4 一致性
	* 1.5 容错性
	* 1.6 CAP 理论 -> [浅谈 CAP 理论](https://waylau.com/cap-theorem/)
	* 1.7 安全性  ->  [校园网信息网络安全问题以及对策综述](https://waylau.com/campus-network-security-problems-and-countermeasures/)
	* 1.8 并发  -> [Java I/O 模型的演进](https://waylau.com/java-io-model-evolution/)、[Golang-简洁的并发](https://waylau.com/golang-clear-concurreny/)、[Netty 实战(精髓)](http://waylau.com/essential-netty-in-action)
* 第2章 分布式系系统架构体系
	* 2.1 基于对象的体系结构
	* 2.2 面向服务的架构（SOA）
	* 2.3 RESTful 风格的架构   -> [REST 实战](https://github.com/waylau/rest-in-action)、[RESTful API 设计最佳实践](https://waylau.com/best-practices-for-better-restful-api/)
	* 2.4 微服务架构（MSA） -> [简述 Microservices（微服务）](https://waylau.com/ahout-microservices/)
	* 2.5 容器技术  
	* 2.6 Serverless 架构
* 第二部分 分布式系统常用技术
* 第3章 分布式消息服务
	* 3.1 Apache ActiveMQ
	* 3.2 RabbitMQ
	* 3.3 RocketMQ
	* 3.4 Apache Kafka
* 第4章 分布式计算
	* 4.1 MapReduce
	* 4.2 Apache Hadoop  -> [Apache Hadoop 入门教程](https://waylau.com/about-hadoop/) 
	* 4.3 Apache Spark
	* 4.4 Apache Mesos  -> [Apache Mesos 在不同平台下的安装](https://waylau.com/mesos-installation/)
* 第5章 分布式存储
	* 5.1 Bigtable
	* 5.2 Apache HBase -> [Apache HBase 入门教程](https://waylau.com/about-hbase/)
	* 5.3 Apache Cassandra
	* 5.4 Memcached
	* 5.5 Redis  -> [Redis 数据类型及抽象](https://waylau.com/redis-data-type/)
	* 5.6 MongoDB
* 第6章 分布式监控系统
	* 6.1 Nagios	-> [Nagios 在不同平台下的安装](https://waylau.com/nagios-installation/)
	* 6.2 Zabbix	-> [Zabbix 在不同平台下的安装](https://waylau.com/zabbix-installation/)
	* 6.3 Consul
	* 6.4 ZooKeeper
* 第7章 分布式版本控制系统
	* 7.1 Bazaar
	* 7.2 Mercurial
	* 7.3 Git	-> [如何在 GitHub 上传代码、分享项目](https://waylau.com/share-how-to-upload-code-github-project/)
* 第8章 RESTful API、微服务及容器技术
	* 8.1 Jersey    ->  [Jersey 2.x 用户指南](https://github.com/waylau/Jersey-2.x-User-Guide)、[用Jersey构建RESTful服务](http://blog.csdn.net/column/details/jersey-rest.html)
	* 8.2 Spring Boot  -> [Spring Boot 教程](https://github.com/waylau/spring-boot-tutorial)
	* 8.3 Docker  -> [简述 Docker](https://waylau.com/ahout-docker/)
* 第三部分 分布式系统案例分析
* 第9章 淘宝网：“双十一”神话的缔造者
	* 9.1 从 LAMP 到 Java 平台的转变
	* 9.2 坚定不移的走“去IOE”的道路
	* 9.3 打造云计算，决战“双十一”
* 第10章 Twitter：实时信息传递的王者
	* 10.1 缓存，让响应更快
	* 10.2 服务拆分与治理
	* 10.3 抗击流量的洪流