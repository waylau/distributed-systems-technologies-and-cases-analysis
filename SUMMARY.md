# Summary

第1章　分布式系统基础知识

1.1　概述

1.1.1　什么是分布式系统

1.1.2　集中式系统与分布式系统

1.1.3　如何设计分布式系统

1.1.4　分布式系统所面临的挑战

1.2　线程

1.2.1　什么是线程

1.2.2　进程和线程

1.2.3　线程和纤程

1.2.4　编程语言中的线程对象

1.2.5　SimpleThreads示例

1.3　通信

1.3.1　网络I/O模型的演进

1.3.2　远程过程调用（RPC）

1.3.3　面向消息的通信

1.4 一致性

1.4.1　以数据为中心的一致性模型

1.4.2　以客户为中心的一致性

1.5　容错性

1.5.1　基本概念

1.5.2　故障分类

1.5.3　使用冗余来掩盖故障

1.5.4　分布式提交

1.6　CAP理论

1.6.1　什么是CAP理论

1.6.2　为什么CAP只能三选二

1.6.3　CAP常见模型

1.6.4　CAP的意义

1.6.5　CAP新发展

1.7　安全性

1.7.1　基本概念

1.7.2　加密算法

1.7.3　安全通道

1.7.4　访问控制

1.8　并发

1.8.1　线程与并发

1.8.2　并发与并行

1.8.3　并发带来的风险

1.8.4　同步（Synchronization）

1.8.5  原子访问（Atomic Access）

1.8.6  无锁化设计提升并发能力

1.8.7  缓存提升并发能力

1.8.8  更细颗粒度的并发单元

第2章　分布式系统架构体系

2.1　基于对象的体系结构

2.1.1　分布式对象

2.1.2　Java RMI

2.2　面向服务的架构（SOA）

2.2.1　SOA的基本概念

2.2.2　基于Web Services的SOA

2.2.3　SOA的演变

2.3　REST风格的架构

2.3.1　什么是REST

2.3.2　REST有哪些特征

2.3.3　Java实现REST的例子

2.3.4　REST API佳实践

2.4　微服务架构（MSA）

2.4.1　什么是MSA

2.4.2　MSA与SOA

2.4.3　何时采用MSA

2.4.4　如何构建微服务

2.5　容器技术

2.5.1　虚拟化技术

2.5.2　容器与虚拟机

2.5.3　基于容器的持续部署

2.6　Serverless架构

2.6.1　什么是Serverless架构

2.6.2　Serverless典型的应用场景

2.6.3　Serverless架构原则

2.6.4　例子：使用Serverless实现游戏全球同服

第3章　分布式消息服务

3.1　分布式消息概述

3.1.1　基本概念

3.1.2　使用场景

3.1.3　常用技术

3.2　Apache ActiveMQ

3.2.1  例子：producer-consumer

3.2.2  例子：使用JMX来监控ActiveMQ

3.2.3  例子：使用Java实现producer-consumer

3.3  RabbitMQ

3.3.1　例子：Work Queues

3.3.2　例子：Publish/Subscribe

3.3.3　例子：Routing

3.3.4　例子：Topics

3.3.5  例子：RPC

3.4  Apache RocketMQ

3.4.1  例子：使用Java实现producer-consumer

3.4.2  RocketMQ佳实践

3.5  Apache Kafka

3.5.1  Apache Kafka的核心概念

3.5.2  Apache Kafka的使用场景

3.6  实战：基于JMS的消息发送和接收

3.6.1  项目概述

3.6.2  项目配置

3.6.3  编码实现

3.6.4  运行

第4章　分布式计算

4.1　分布式计算概述

4.1.1　使用场景

4.1.2　常用技术

4.2　MapReduce

4.2.1　MapReduce简介

4.2.2  MapReduce的编程模型

4.2.3  MapReduce接口实现

4.2.4　MapReduce的使用技巧

4.3  Apache Hadoop

4.3.1  Apache Hadoop的核心组件

4.3.2  例子：词频统计WordCount程序

4.4  Spark

4.4.1  Spark简介

4.4.2  Spark与Hadoop的关系

4.4.3  Spark 2.0的新特性

4.4.4　Spark集群模式

4.5  Mesos

4.5.1  Mesos简介

4.5.2  设计高可用的Mesos framework

4.6  实战：基于Spark的词频统计

4.6.1  项目概述

4.6.2  项目配置

4.6.3  编码实现

4.6.4  运行

第5章　分布式存储

5.1　分布式存储概述

5.1.1　使用场景

5.1.2　常用技术

5.2　Bigtable

5.2.1　Bigtable的数据模型

5.2.2　Bigtable的实现

5.2.3　Bigtable的性能优化

5.3　Apache HBase

5.3.1　Apache HBase的基本概念

5.3.2　Apache HBase的架构

5.4　Apache Cassandra

5.4.1　Apache Cassandra简介

5.4.2　Apache Cassandra的应用场景

5.4.3　Apache Cassandra的架构和数据模型

5.4.4　用于配置Apache Cassandra的核心组件

5.5　Memcached

5.5.1　Memcached简介

5.5.2　Memcached的架构

5.5.3　Memcached客户端

5.6　Redis

5.6.1　Redis简介

5.6.2　Redis的下载与简单使用

5.6.3　Redis的数据类型及抽象

5.7　MongoDB

5.7.1　MongoDB简介

5.7.2　MongoDB核心概念

5.7.3　MongoDB的数据模型

5.7.4　示例：Java连接MongoDB

5.8  实战：基于Redis的分布式锁

5.8.1  项目概述

5.8.2  项目配置

5.8.3  编码实现

5.8.4  运行

第6章　分布式监控

6.1　分布式监控概述

6.1.1　使用场景

6.1.2　常用技术

6.2　Nagios

6.2.1　Nagios监控

6.2.2　Nagios插件

6.3　Zabbix

6.3.1　Zabbix对容器的支持

6.3.2　Zabbix的基本概念

6.4　Consul

6.4.1　Consul架构

6.4.2　Consul agent

6.5　ZooKeeper

6.5.1　ZooKeeper简介

6.5.2　ZooKeeper内部工作原理

6.5.3　例子：ZooKeeper实现barrier和producer-consumer queue

6.6  实战：基于ZooKeeper的服务注册和发现

6.6.1  项目概述

6.6.2  项目配置

6.6.3  编码实现

6.6.4  运行

第7章　分布式版本控制系统

7.1　分布式版本控制系统概述

7.1.1　集中式与分布式

7.1.2　分布式版本控制系统的核心概念

7.2　Bazaar

7.2.1　Bazaar的核心概念

7.2.2　Bazaar的使用

7.3　Mercurial

7.3.1　Mercurial的核心概念

7.3.2　Mercurial的使用

7.4　Git

7.4.1　Git的基础概念

7.4.2　Git的使用

7.5　Git Flow—团队协作佳实践

7.5.1　分支定义

7.5.2　新功能开发工作流

7.5.3　Bug修复工作流

7.5.4　版本发布工作流

第8章　RESTful API、微服务及容器技术

8.1　Jersey

8.1.1　Jersey简介

8.1.2　Jersey的模块和依赖

8.1.3　JAX-RS核心概念

8.1.4　例子：用SSE构建实时Web应用

8.2　Spring Boot

8.2.1　Spring Boot简介

8.2.2　Spring Boot的安装

8.2.3　Spring Boot的使用

8.2.4　Spring Boot的属性与配置

8.3　Docker

8.3.1　Docker简介

8.3.2　Docker的核心组成、架构及工作原理

8.3.3　Docker的使用

8.4　实战：基于Docker构建、运行、发布微服务

8.4.1　编写微服务

8.4.2　微服务容器化

8.4.3　构建Docker image

8.4.4　运行image

8.4.5　访问应用


8.4.6　发布微服务