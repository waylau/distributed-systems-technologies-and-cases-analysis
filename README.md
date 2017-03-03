# 《分布式系统常用技术及案例分析》

我一直想写一本关于分布式系统方面的书。一方面是想把个人多年工作中涉及的分布式技术做一下总结，另一方面也想把个人的经验分享给广大的读者朋友。由于我的开发工作大都以Java为主，所以一开始的主题设想是“分布式Java”，书也以开源方式发布在互联网上（网址为https://github.com/waylau/distributed-java）。

当然，本书不单只是涉及Java领域中的分布式技术，主要内容如下。

## 内容介绍

本书分为三大部分，即分布式系统基础理论、分布式系统常用技术以及经典的分布式系统案例分析。第一部分为第1章和第2章，主要介绍分布式系统基础理论知识，总结一些在设计分布式系统时需要考虑的范式、知识点以及可能会面临的问题。 第二部分为第3章到第8章，主要列举了在分布式系统应用中经常用到的一些主流技术，并介绍这些技术的作用和用法。第三部分为第9章和第10章，选取了以淘宝网和Twitter为代表的国内外知名互联网企业的大型分布式系统案例，分析其架构设计以及演变过程。

* 第1章介绍分布式系统基础理论知识，总结一些在设计分布式系统时需要考虑的范式、知识点以及可能会面临的问题，其中包括线程、通信、一致性、容错性、CAP理论、安全性和并发等相关内容。
* 第2章详细介绍分布式系统的架构体系，包括传统的基于对象的体系结构、SOA，也包括最近比较火的RESTful风格架构、微服务、容器技术、Serverless架构等。
* 第3章介绍常用的分布式消息服务框架，包括Apache ActiveMQ、RabbitMQ、RocketMQ、Apache Kafka等。
* 第4章介绍分布式计算理论和应用框架方面的内容，包括MapReduce、Apache Hadoop、Apache Spark、Apache Mesos 等。
* 第5章介绍分布式存储理论和应用框架方面的内容，包括Bigtable、Apache HBase、Apache Cassandra、Memcached、Redis、MongoDB等。
* 第6章介绍分布式监控方面常用的技术，包括Nagios、Zabbix、Consul、ZooKeeper等。
* 第7章介绍常用的分布式版本控制工具，包括Bazaar、Mercurial、Git等。
* 第8章介绍RESTful API、微服务及容器相关的技术，着重介绍Jersey、Spring Boot、Docker等技术的应用。
* 第9章和第10章分别介绍以淘宝网和Twitter为代表的国内外知名互联网企业的大型分布式系统案例，分析其架构设计以及演变过程。

您可以查看详细的书籍[目录](SUMMARY.md)。

本书涉及面相当之广，可以说涵盖了在设计分布式系统时，所要考虑的大部分问题及解决方案。

![《分布式系统常用技术及案例分析》封面](https://cloud.githubusercontent.com/assets/3233966/23100754/bb13b9a2-f6c3-11e6-874c-7a2a0cb50958.jpg)
## 源代码

本书提供源代码下载，地址位于[本项目](https://github.com/waylau/distributed-systems-technologies-and-cases-analysis)下的`samples`目录。

## 勘误和交流
本书如有勘误，会在<https://github.com/waylau/distributed-systems-technologies-and-cases-analysis/issues>上进行发布。由于笔者能力有限，时间仓促，难免错漏，欢迎读者批评指正。

读者也可以到博文视点官网的本书页面进行交流（<http://www.broadview.com.cn/30771>）。

您也可以上豆瓣（<https://book.douban.com/subject/26975204/>）进行评论。

## 联系作者

您也可以直接联系我：

* 博客：https://waylau.com
* 邮箱：[waylau521(at)gmail.com](mailto:waylau521@gmail.com)
* 微博：http://weibo.com/waylau521
* 开源：https://github.com/waylau

## 获取本书

实体店及部分网店有售：

* 亚马逊：<https://www.amazon.cn/dp/B06X3RJMGC>
* 当当网：<http://product.dangdang.com/24183821.html>
* 京东：<https://item.jd.com/12124492.html>
* china-pub：<http://product.china-pub.com/5173118>


## 其他书籍

若您对本书不感冒，笔者还写了其他方面的超过一打的书籍（可见<https://waylau.com/books/>），多是开源电子书。

本人也维护了一个[books-collection](https://github.com/waylau/books-collection)项目，里面提供了优质的专门给程序员的开源、免费图书集合。

![开源捐赠](https://waylau.com/images/showmethemoney-sm.jpg)
