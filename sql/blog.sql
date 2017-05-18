/*
SQLyog Ultimate v11.33 (64 bit)
MySQL - 5.6.34 : Database - blog
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`blog` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `blog`;

/*Table structure for table `admin` */

DROP TABLE IF EXISTS `admin`;

CREATE TABLE `admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `role` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `admin` */

insert  into `admin`(`id`,`userName`,`password`,`role`) values (1,'ldb','123','1');

/*Table structure for table `blog` */

DROP TABLE IF EXISTS `blog`;

CREATE TABLE `blog` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(30) DEFAULT NULL,
  `author` varchar(20) DEFAULT NULL,
  `content` longtext,
  `summary` varchar(1000) DEFAULT NULL,
  `coverImageName` varchar(200) DEFAULT NULL,
  `publishTime` datetime DEFAULT NULL,
  `readNum` int(11) DEFAULT NULL,
  `is_Recommend` tinyint(1) DEFAULT NULL,
  `blogTypeId` int(11) DEFAULT NULL,
  `blogTagId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `blogTypeId` (`blogTypeId`),
  KEY `blogTagId` (`blogTagId`),
  CONSTRAINT `blog_ibfk_1` FOREIGN KEY (`blogTypeId`) REFERENCES `blogtype` (`id`),
  CONSTRAINT `blog_ibfk_2` FOREIGN KEY (`blogTagId`) REFERENCES `blogtag` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `blog` */

insert  into `blog`(`id`,`title`,`author`,`content`,`summary`,`coverImageName`,`publishTime`,`readNum`,`is_Recommend`,`blogTypeId`,`blogTagId`) values (1,'我的个人简介','D.B | 氧化钡','<p style=\"text-align:center\"><img src=\"/Blog/Blog/images/20160929/1475112326703050226.jpg\" title=\"1475112326703050226.jpg\" alt=\"未标题-1.jpg\" height=\"269\" width=\"401\"/></p><p>以上就是博主的照片啦</p><p>博主真实名字是:刘东宝，95后，广东揭阳揭西人</p><p>现在是华南师范大学职业教育学院的一名大三学生</p><p>梦想是进入BAT，加油</p><p><br/></p><p>以下是我的微信，交个朋友吧~</p><p style=\"text-align:center\"><img src=\"/Blog/Blog/images/20160929/1475131982175078981.jpg\" title=\"1475131982175078981.jpg\" alt=\"1475131982175078981.jpg\" height=\"150\" width=\"150\"/></p><p><br/></p>','Ut enim ad minim veniam, quis nostrud eiusmod tempor incididunt ut labore et dolore magna aliqua exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.','/foreground/images/t4.jpg','2016-09-29 00:29:10',1006,1,5,6),(2,'代码高亮测试','ldb','<pre class=\"brush:java;toolbar:false\">\r\npackage&nbsp;com.ldb.controller.admin;\r\nimport&nbsp;com.ldb.pojo.po.LoginHistoryPO;\r\nimport&nbsp;com.ldb.service.*;\r\nimport&nbsp;org.springframework.beans.factory.annotation.Autowired;\r\nimport&nbsp;org.springframework.stereotype.Controller;\r\nimport&nbsp;org.springframework.web.bind.annotation.RequestMapping;\r\nimport&nbsp;org.springframework.web.bind.annotation.SessionAttributes;\r\nimport&nbsp;org.springframework.web.servlet.ModelAndView;\r\nimport&nbsp;java.util.HashMap;\r\n/**\r\n&nbsp;*&nbsp;Created&nbsp;by&nbsp;ldb&nbsp;on&nbsp;2017/4/20.\r\n&nbsp;*/\r\n@Controller\r\n@RequestMapping(&quot;/admin&quot;)\r\n@SessionAttributes(value&nbsp;=&nbsp;{&quot;blogNum&quot;,&quot;commentNum&quot;})\r\npublic&nbsp;class&nbsp;MainController&nbsp;{\r\n&nbsp;&nbsp;&nbsp;&nbsp;@Autowired\r\n&nbsp;&nbsp;&nbsp;&nbsp;private&nbsp;AdminService&nbsp;adminService;\r\n&nbsp;&nbsp;&nbsp;&nbsp;@Autowired\r\n&nbsp;&nbsp;&nbsp;&nbsp;private&nbsp;VisitorService&nbsp;visitorService;\r\n&nbsp;&nbsp;&nbsp;&nbsp;@Autowired\r\n&nbsp;&nbsp;&nbsp;&nbsp;private&nbsp;LikeService&nbsp;likeService;\r\n&nbsp;&nbsp;&nbsp;&nbsp;@Autowired\r\n&nbsp;&nbsp;&nbsp;&nbsp;private&nbsp;CommentService&nbsp;commentService;\r\n&nbsp;&nbsp;&nbsp;&nbsp;@Autowired\r\n&nbsp;&nbsp;&nbsp;&nbsp;private&nbsp;BlogAdviceService&nbsp;blogAdviceService;\r\n&nbsp;&nbsp;&nbsp;&nbsp;@Autowired\r\n&nbsp;&nbsp;&nbsp;&nbsp;private&nbsp;BlogService&nbsp;blogService;\r\n&nbsp;&nbsp;&nbsp;&nbsp;@RequestMapping(&quot;/main&quot;)\r\n&nbsp;&nbsp;&nbsp;&nbsp;public&nbsp;ModelAndView&nbsp;goMain(){\r\n&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;ModelAndView&nbsp;mav=new&nbsp;ModelAndView(&quot;background/main&quot;);\r\n&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;//获取上一条登录信息\r\n&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;LoginHistoryPO&nbsp;loginHistory&nbsp;=&nbsp;adminService.getLoginHistory();\r\n&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;//获取今日访客数量\r\n&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Long&nbsp;todayReadNum=visitorService.getTodayReadNum();\r\n&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;//获取今日点赞量\r\n&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Long&nbsp;todayLike=likeService.getTodayLike();\r\n&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;//访问总数\r\n&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Long&nbsp;readNum=visitorService.getReadNum();\r\n&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;//点赞总数\r\n&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Long&nbsp;likeNum=likeService.getLikeCount();\r\n&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;//获取评论总数\r\n&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Long&nbsp;commentNum=commentService.getCommentCount();\r\n&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;//获取未回复留言总数\r\n&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Long&nbsp;notReplyNum=blogAdviceService.getNotReplyCount();\r\n&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;//获取文章总数\r\n&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Long&nbsp;blogNum=blogService.getBlogCount(new&nbsp;HashMap&lt;&gt;());\r\n&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;mav.addObject(&quot;loginHistory&quot;,loginHistory);\r\n&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;mav.addObject(&quot;todayReadNum&quot;,todayReadNum);\r\n&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;mav.addObject(&quot;todayLike&quot;,todayLike);\r\n&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;mav.addObject(&quot;readNum&quot;,readNum);\r\n&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;mav.addObject(&quot;likeNum&quot;,likeNum);\r\n&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;mav.addObject(&quot;commentNum&quot;,commentNum);\r\n&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;mav.addObject(&quot;notReplyNum&quot;,notReplyNum);\r\n&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;mav.addObject(&quot;blogNum&quot;,blogNum);\r\n&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;return&nbsp;mav;\r\n&nbsp;&nbsp;&nbsp;&nbsp;}\r\n}</pre><p><br/></p>','是打发','http://oohpa87x2.bkt.clouddn.com//image/coverImage/20170501144443.jpg','2017-05-01 14:44:47',53,0,1,2),(3,'测试 饿','人','<p>撒发</p>','撒地方','http://oohpa87x2.bkt.clouddn.com//image/coverImage/20170501154405.jpg','2017-05-01 15:44:08',0,0,1,2),(4,'嗯嗯嗯','饿','<p>是打发第三方</p>','玩儿额外','http://oohpa87x2.bkt.clouddn.com//image/coverImage/20170501154423.jpg','2017-05-01 15:44:26',0,0,1,3),(5,'是打发','发','<p>撒地方</p>','一般我们总会有些文件无需纳入 Git 的管理，也不希望它们总出现在未跟踪文件列表。通常都是些自动生成的文件，比如日志文件，或者编译过程中创建的临时文件等。我们可以创建一个名为 .gitignore 的文件，列出要忽略的文件模式。','http://oohpa87x2.bkt.clouddn.com//image/coverImage/20170501154439.jpg','2017-05-01 15:44:42',4,0,2,2),(6,'11','11','<p><br/></p><p><img src=\"http://oohpa87x2.bkt.clouddn.com//image/20170503/1493815825320035528.jpg\" title=\"\" alt=\"1493811846(1).jpg\"/></p>','一般我们总会有些文件无需纳入 Git 的管理，也不希望它们总出现在未跟踪文件列表。通常都是','http://oohpa87x2.bkt.clouddn.com//image/coverImage/20170503205043.png','2017-05-03 20:50:44',6,0,1,1);

/*Table structure for table `blogadvice` */

DROP TABLE IF EXISTS `blogadvice`;

CREATE TABLE `blogadvice` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nickName` varchar(20) DEFAULT NULL,
  `userIP` varchar(20) DEFAULT NULL,
  `content` varchar(1000) DEFAULT NULL,
  `publishTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `blogadvice` */

/*Table structure for table `blogadvice_reply` */

DROP TABLE IF EXISTS `blogadvice_reply`;

CREATE TABLE `blogadvice_reply` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(1000) DEFAULT NULL,
  `userIP` varchar(30) DEFAULT NULL,
  `publishTime` datetime DEFAULT NULL,
  `blogAdviceId` int(11) NOT NULL,
  `role` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `blogAdviceId` (`blogAdviceId`),
  CONSTRAINT `blogadvice_reply_ibfk_1` FOREIGN KEY (`blogAdviceId`) REFERENCES `blogadvice` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `blogadvice_reply` */

/*Table structure for table `blogtag` */

DROP TABLE IF EXISTS `blogtag`;

CREATE TABLE `blogtag` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tagName` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

/*Data for the table `blogtag` */

insert  into `blogtag`(`id`,`tagName`) values (1,'Java'),(2,'SSM框架'),(3,'S2SH框架'),(4,'JavaScript'),(5,'前端知识'),(6,'生活感悟'),(7,'知乎干货'),(8,'Java面试');

/*Table structure for table `blogtype` */

DROP TABLE IF EXISTS `blogtype`;

CREATE TABLE `blogtype` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `typeName` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `blogtype` */

insert  into `blogtype`(`id`,`typeName`) values (1,'技术探讨'),(2,'技术干货'),(3,'项目分享'),(4,'经验总结'),(5,'碎言碎语');

/*Table structure for table `comment` */

DROP TABLE IF EXISTS `comment`;

CREATE TABLE `comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nickName` varchar(20) DEFAULT NULL,
  `userIP` varchar(20) DEFAULT NULL,
  `content` varchar(1000) DEFAULT NULL,
  `publishTime` datetime DEFAULT NULL,
  `blogId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `blogId` (`blogId`),
  CONSTRAINT `comment_ibfk_1` FOREIGN KEY (`blogId`) REFERENCES `blog` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `comment` */

/*Table structure for table `comment_reply` */

DROP TABLE IF EXISTS `comment_reply`;

CREATE TABLE `comment_reply` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(1000) DEFAULT NULL,
  `userIP` varchar(30) DEFAULT NULL,
  `publishTime` datetime DEFAULT NULL,
  `commentId` int(11) DEFAULT NULL,
  `role` tinyint(1) DEFAULT NULL COMMENT '0为游客',
  PRIMARY KEY (`id`),
  KEY `commentId` (`commentId`),
  CONSTRAINT `comment_reply_ibfk_1` FOREIGN KEY (`commentId`) REFERENCES `comment` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `comment_reply` */

/*Table structure for table `like` */

DROP TABLE IF EXISTS `like`;

CREATE TABLE `like` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userIP` varchar(30) DEFAULT NULL,
  `clickTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `like` */

/*Table structure for table `link` */

DROP TABLE IF EXISTS `link`;

CREATE TABLE `link` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `linkName` varchar(20) DEFAULT NULL,
  `linkUrl` varchar(100) DEFAULT NULL,
  `orderNum` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `link` */

insert  into `link`(`id`,`linkName`,`linkUrl`,`orderNum`) values (1,'叶落莫相离','http://www.liqinghe.com',1),(2,'二次元的卷猫','http://anneke.cn/',2),(3,'dafeiyu的博客','http://dafeiyu.cn',3),(4,'风的记忆','http://sendtion.cn/',4),(5,'WJY的博客','http://www.wenjingyi.top',5),(6,'早茶月光','http://www.zcmol.cn',6);

/*Table structure for table `login_history` */

DROP TABLE IF EXISTS `login_history`;

CREATE TABLE `login_history` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ip` varchar(30) DEFAULT NULL,
  `ipName` varchar(30) DEFAULT NULL,
  `loginTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

/*Data for the table `login_history` */

insert  into `login_history`(`id`,`ip`,`ipName`,`loginTime`) values (1,'183.63.97.110','广东省广州市','2017-05-01 14:39:36'),(2,'183.63.97.110','广东省广州市','2017-05-01 14:42:31'),(3,'183.63.97.110','广东省广州市','2017-05-01 15:43:44'),(4,'183.63.97.110','广东省广州市','2017-05-01 22:11:11'),(5,'202.116.36.113','广东省广州市','2017-05-03 20:13:35'),(6,'183.62.180.26','广东省深圳市','2017-05-03 20:30:57'),(7,'183.62.180.26','广东省深圳市','2017-05-03 20:32:34'),(8,'183.62.180.26','广东省深圳市','2017-05-03 20:35:48'),(9,'183.62.180.26','广东省深圳市','2017-05-03 20:46:20'),(10,'183.62.180.26','广东省深圳市','2017-05-03 20:49:53'),(11,'183.62.180.26','广东省深圳市','2017-05-03 20:55:18'),(12,'183.62.180.26','广东省深圳市','2017-05-03 21:12:11'),(13,'183.62.180.26','广东省深圳市','2017-05-03 21:17:05'),(14,'119.9.91.55','湖南省','2017-05-03 21:37:32'),(15,'183.62.180.26','广东省深圳市','2017-05-05 14:53:56'),(16,'120.236.163.48','CHINA','2017-05-05 21:08:08'),(17,'183.63.97.110','广东省广州市','2017-05-05 23:40:11');

/*Table structure for table `mood` */

DROP TABLE IF EXISTS `mood`;

CREATE TABLE `mood` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) DEFAULT NULL,
  `content` varchar(1000) DEFAULT NULL,
  `publishTime` datetime DEFAULT NULL,
  `is_show` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `mood` */

insert  into `mood`(`id`,`title`,`content`,`publishTime`,`is_show`) values (1,'测试','测试数据','2017-05-01 13:19:39',1);

/*Table structure for table `motto` */

DROP TABLE IF EXISTS `motto`;

CREATE TABLE `motto` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `motto` varchar(50) DEFAULT NULL,
  `is_show` tinyint(1) DEFAULT '0',
  `publishTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `motto` */

insert  into `motto`(`id`,`motto`,`is_show`,`publishTime`) values (1,'Just do IT',1,'2017-04-30 21:42:12');

/*Table structure for table `photo` */

DROP TABLE IF EXISTS `photo`;

CREATE TABLE `photo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `imagesName` varchar(50) DEFAULT NULL,
  `publishTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `photo` */

/*Table structure for table `signature` */

DROP TABLE IF EXISTS `signature`;

CREATE TABLE `signature` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(30) DEFAULT NULL,
  `content` varchar(500) DEFAULT NULL,
  `buttonText` varchar(20) DEFAULT NULL,
  `is_show` tinyint(1) DEFAULT '0',
  `publishTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `signature` */

insert  into `signature`(`id`,`title`,`content`,`buttonText`,`is_show`,`publishTime`) values (1,'提醒自己一件事，千万不要自己感动自己','大部分人看似的努力，不过是愚蠢导致的。什么熬夜看书到天亮，连续几天只睡几小时，多久没放假了，如果这些东西也值得夸耀，那么富士康流水线上任何一个人都比你努力多了。人难免天生有自怜的情绪，唯有时刻保持清醒，才能看清真正的价值在哪里。','Hello World!',1,'2017-04-30 21:46:32');

/*Table structure for table `visitor` */

DROP TABLE IF EXISTS `visitor`;

CREATE TABLE `visitor` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userIP` varchar(30) DEFAULT NULL,
  `userBrowser` varchar(100) DEFAULT NULL,
  `userOS` varchar(100) DEFAULT NULL,
  `readTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=109 DEFAULT CHARSET=utf8;

/*Data for the table `visitor` */

insert  into `visitor`(`id`,`userIP`,`userBrowser`,`userOS`,`readTime`) values (1,'0:0:0:0:0:0:0:1','{\"类型\":\"WEB_BROWSER\",\"名称\":\"Chrome\",\"厂商\":\"GOOGLE\",\"产品系列\":\"CHROME\",\"引擎\":\"WEBKIT\"}','{\"名称\":\"Windows 10\",\"设备类型\":\"COMPUTER\",\"产品系列\":\"WINDOWS\",\"生成厂商\":\"MICROSOFT\"}','2017-05-01 14:39:07'),(2,'0:0:0:0:0:0:0:1','{\"类型\":\"WEB_BROWSER\",\"名称\":\"Chrome\",\"厂商\":\"GOOGLE\",\"产品系列\":\"CHROME\",\"引擎\":\"WEBKIT\"}','{\"名称\":\"Windows 10\",\"设备类型\":\"COMPUTER\",\"产品系列\":\"WINDOWS\",\"生成厂商\":\"MICROSOFT\"}','2017-05-01 14:44:50'),(3,'0:0:0:0:0:0:0:1','{\"类型\":\"WEB_BROWSER\",\"名称\":\"Chrome\",\"厂商\":\"GOOGLE\",\"产品系列\":\"CHROME\",\"引擎\":\"WEBKIT\"}','{\"名称\":\"Windows 10\",\"设备类型\":\"COMPUTER\",\"产品系列\":\"WINDOWS\",\"生成厂商\":\"MICROSOFT\"}','2017-05-01 14:51:50'),(4,'0:0:0:0:0:0:0:1','{\"类型\":\"WEB_BROWSER\",\"名称\":\"Chrome\",\"厂商\":\"GOOGLE\",\"产品系列\":\"CHROME\",\"引擎\":\"WEBKIT\"}','{\"名称\":\"Windows 10\",\"设备类型\":\"COMPUTER\",\"产品系列\":\"WINDOWS\",\"生成厂商\":\"MICROSOFT\"}','2017-05-01 15:10:34'),(5,'0:0:0:0:0:0:0:1','{\"类型\":\"WEB_BROWSER\",\"名称\":\"Chrome\",\"厂商\":\"GOOGLE\",\"产品系列\":\"CHROME\",\"引擎\":\"WEBKIT\"}','{\"名称\":\"Windows 10\",\"设备类型\":\"COMPUTER\",\"产品系列\":\"WINDOWS\",\"生成厂商\":\"MICROSOFT\"}','2017-05-01 15:16:53'),(6,'0:0:0:0:0:0:0:1','{\"类型\":\"WEB_BROWSER\",\"名称\":\"Chrome\",\"厂商\":\"GOOGLE\",\"产品系列\":\"CHROME\",\"引擎\":\"WEBKIT\"}','{\"名称\":\"Windows 10\",\"设备类型\":\"COMPUTER\",\"产品系列\":\"WINDOWS\",\"生成厂商\":\"MICROSOFT\"}','2017-05-01 15:17:02'),(7,'0:0:0:0:0:0:0:1','{\"类型\":\"WEB_BROWSER\",\"名称\":\"Chrome\",\"厂商\":\"GOOGLE\",\"产品系列\":\"CHROME\",\"引擎\":\"WEBKIT\"}','{\"名称\":\"Windows 10\",\"设备类型\":\"COMPUTER\",\"产品系列\":\"WINDOWS\",\"生成厂商\":\"MICROSOFT\"}','2017-05-01 15:29:57'),(8,'0:0:0:0:0:0:0:1','{\"类型\":\"WEB_BROWSER\",\"名称\":\"Chrome\",\"厂商\":\"GOOGLE\",\"产品系列\":\"CHROME\",\"引擎\":\"WEBKIT\"}','{\"名称\":\"Windows 10\",\"设备类型\":\"COMPUTER\",\"产品系列\":\"WINDOWS\",\"生成厂商\":\"MICROSOFT\"}','2017-05-01 15:32:09'),(9,'0:0:0:0:0:0:0:1','{\"类型\":\"WEB_BROWSER\",\"名称\":\"Chrome\",\"厂商\":\"GOOGLE\",\"产品系列\":\"CHROME\",\"引擎\":\"WEBKIT\"}','{\"名称\":\"Windows 10\",\"设备类型\":\"COMPUTER\",\"产品系列\":\"WINDOWS\",\"生成厂商\":\"MICROSOFT\"}','2017-05-01 15:37:05'),(10,'0:0:0:0:0:0:0:1','{\"类型\":\"WEB_BROWSER\",\"名称\":\"Chrome\",\"厂商\":\"GOOGLE\",\"产品系列\":\"CHROME\",\"引擎\":\"WEBKIT\"}','{\"名称\":\"Windows 10\",\"设备类型\":\"COMPUTER\",\"产品系列\":\"WINDOWS\",\"生成厂商\":\"MICROSOFT\"}','2017-05-01 15:41:21'),(11,'0:0:0:0:0:0:0:1','{\"类型\":\"WEB_BROWSER\",\"名称\":\"Chrome\",\"厂商\":\"GOOGLE\",\"产品系列\":\"CHROME\",\"引擎\":\"WEBKIT\"}','{\"名称\":\"Windows 10\",\"设备类型\":\"COMPUTER\",\"产品系列\":\"WINDOWS\",\"生成厂商\":\"MICROSOFT\"}','2017-05-01 15:41:32'),(12,'0:0:0:0:0:0:0:1','{\"类型\":\"WEB_BROWSER\",\"名称\":\"Chrome\",\"厂商\":\"GOOGLE\",\"产品系列\":\"CHROME\",\"引擎\":\"WEBKIT\"}','{\"名称\":\"Windows 10\",\"设备类型\":\"COMPUTER\",\"产品系列\":\"WINDOWS\",\"生成厂商\":\"MICROSOFT\"}','2017-05-01 15:44:45'),(13,'0:0:0:0:0:0:0:1','{\"类型\":\"WEB_BROWSER\",\"名称\":\"Chrome\",\"厂商\":\"GOOGLE\",\"产品系列\":\"CHROME\",\"引擎\":\"WEBKIT\"}','{\"名称\":\"Windows 10\",\"设备类型\":\"COMPUTER\",\"产品系列\":\"WINDOWS\",\"生成厂商\":\"MICROSOFT\"}','2017-05-01 15:45:03'),(14,'0:0:0:0:0:0:0:1','{\"类型\":\"WEB_BROWSER\",\"名称\":\"Chrome\",\"厂商\":\"GOOGLE\",\"产品系列\":\"CHROME\",\"引擎\":\"WEBKIT\"}','{\"名称\":\"Windows 10\",\"设备类型\":\"COMPUTER\",\"产品系列\":\"WINDOWS\",\"生成厂商\":\"MICROSOFT\"}','2017-05-01 15:46:00'),(15,'0:0:0:0:0:0:0:1','{\"类型\":\"WEB_BROWSER\",\"名称\":\"Chrome\",\"厂商\":\"GOOGLE\",\"产品系列\":\"CHROME\",\"引擎\":\"WEBKIT\"}','{\"名称\":\"Windows 10\",\"设备类型\":\"COMPUTER\",\"产品系列\":\"WINDOWS\",\"生成厂商\":\"MICROSOFT\"}','2017-05-01 15:46:06'),(16,'0:0:0:0:0:0:0:1','{\"类型\":\"WEB_BROWSER\",\"名称\":\"Chrome\",\"厂商\":\"GOOGLE\",\"产品系列\":\"CHROME\",\"引擎\":\"WEBKIT\"}','{\"名称\":\"Windows 10\",\"设备类型\":\"COMPUTER\",\"产品系列\":\"WINDOWS\",\"生成厂商\":\"MICROSOFT\"}','2017-05-01 15:47:02'),(17,'0:0:0:0:0:0:0:1','{\"类型\":\"WEB_BROWSER\",\"名称\":\"Chrome\",\"厂商\":\"GOOGLE\",\"产品系列\":\"CHROME\",\"引擎\":\"WEBKIT\"}','{\"名称\":\"Windows 10\",\"设备类型\":\"COMPUTER\",\"产品系列\":\"WINDOWS\",\"生成厂商\":\"MICROSOFT\"}','2017-05-01 15:47:15'),(18,'0:0:0:0:0:0:0:1','{\"类型\":\"WEB_BROWSER\",\"名称\":\"Chrome\",\"厂商\":\"GOOGLE\",\"产品系列\":\"CHROME\",\"引擎\":\"WEBKIT\"}','{\"名称\":\"Windows 10\",\"设备类型\":\"COMPUTER\",\"产品系列\":\"WINDOWS\",\"生成厂商\":\"MICROSOFT\"}','2017-05-01 15:47:38'),(19,'0:0:0:0:0:0:0:1','{\"类型\":\"WEB_BROWSER\",\"名称\":\"Chrome\",\"厂商\":\"GOOGLE\",\"产品系列\":\"CHROME\",\"引擎\":\"WEBKIT\"}','{\"名称\":\"Windows 10\",\"设备类型\":\"COMPUTER\",\"产品系列\":\"WINDOWS\",\"生成厂商\":\"MICROSOFT\"}','2017-05-01 20:52:12'),(20,'0:0:0:0:0:0:0:1','{\"类型\":\"WEB_BROWSER\",\"名称\":\"Chrome\",\"厂商\":\"GOOGLE\",\"产品系列\":\"CHROME\",\"引擎\":\"WEBKIT\"}','{\"名称\":\"Windows 10\",\"设备类型\":\"COMPUTER\",\"产品系列\":\"WINDOWS\",\"生成厂商\":\"MICROSOFT\"}','2017-05-01 20:53:10'),(21,'192.168.191.3','{\"类型\":\"MOBILE_BROWSER\",\"名称\":\"Chrome Mobile\",\"厂商\":\"GOOGLE\",\"产品系列\":\"CHROME\",\"引擎\":\"WEBKIT\"}','{\"名称\":\"Android 5.x\",\"设备类型\":\"MOBILE\",\"产品系列\":\"ANDROID\",\"生成厂商\":\"GOOGLE\"}','2017-05-01 21:02:31'),(22,'0:0:0:0:0:0:0:1','{\"类型\":\"WEB_BROWSER\",\"名称\":\"Chrome\",\"厂商\":\"GOOGLE\",\"产品系列\":\"CHROME\",\"引擎\":\"WEBKIT\"}','{\"名称\":\"Windows 10\",\"设备类型\":\"COMPUTER\",\"产品系列\":\"WINDOWS\",\"生成厂商\":\"MICROSOFT\"}','2017-05-01 21:03:54'),(23,'0:0:0:0:0:0:0:1','{\"类型\":\"WEB_BROWSER\",\"名称\":\"Chrome\",\"厂商\":\"GOOGLE\",\"产品系列\":\"CHROME\",\"引擎\":\"WEBKIT\"}','{\"名称\":\"Windows 10\",\"设备类型\":\"COMPUTER\",\"产品系列\":\"WINDOWS\",\"生成厂商\":\"MICROSOFT\"}','2017-05-01 21:04:06'),(24,'192.168.191.3','{\"类型\":\"MOBILE_BROWSER\",\"名称\":\"Chrome Mobile\",\"厂商\":\"GOOGLE\",\"产品系列\":\"CHROME\",\"引擎\":\"WEBKIT\"}','{\"名称\":\"Android 5.x\",\"设备类型\":\"MOBILE\",\"产品系列\":\"ANDROID\",\"生成厂商\":\"GOOGLE\"}','2017-05-01 21:04:10'),(25,'0:0:0:0:0:0:0:1','{\"类型\":\"WEB_BROWSER\",\"名称\":\"Chrome\",\"厂商\":\"GOOGLE\",\"产品系列\":\"CHROME\",\"引擎\":\"WEBKIT\"}','{\"名称\":\"Windows 10\",\"设备类型\":\"COMPUTER\",\"产品系列\":\"WINDOWS\",\"生成厂商\":\"MICROSOFT\"}','2017-05-01 21:04:33'),(26,'192.168.191.3','{\"类型\":\"MOBILE_BROWSER\",\"名称\":\"Chrome Mobile\",\"厂商\":\"GOOGLE\",\"产品系列\":\"CHROME\",\"引擎\":\"WEBKIT\"}','{\"名称\":\"Android 5.x\",\"设备类型\":\"MOBILE\",\"产品系列\":\"ANDROID\",\"生成厂商\":\"GOOGLE\"}','2017-05-01 21:04:39'),(27,'0:0:0:0:0:0:0:1','{\"类型\":\"WEB_BROWSER\",\"名称\":\"Chrome\",\"厂商\":\"GOOGLE\",\"产品系列\":\"CHROME\",\"引擎\":\"WEBKIT\"}','{\"名称\":\"Windows 10\",\"设备类型\":\"COMPUTER\",\"产品系列\":\"WINDOWS\",\"生成厂商\":\"MICROSOFT\"}','2017-05-01 22:10:56'),(28,'0:0:0:0:0:0:0:1','{\"类型\":\"WEB_BROWSER\",\"名称\":\"Chrome\",\"厂商\":\"GOOGLE\",\"产品系列\":\"CHROME\",\"引擎\":\"WEBKIT\"}','{\"名称\":\"Windows 10\",\"设备类型\":\"COMPUTER\",\"产品系列\":\"WINDOWS\",\"生成厂商\":\"MICROSOFT\"}','2017-05-02 08:56:45'),(29,'0:0:0:0:0:0:0:1','{\"类型\":\"WEB_BROWSER\",\"名称\":\"Chrome\",\"厂商\":\"GOOGLE\",\"产品系列\":\"CHROME\",\"引擎\":\"WEBKIT\"}','{\"名称\":\"Windows 10\",\"设备类型\":\"COMPUTER\",\"产品系列\":\"WINDOWS\",\"生成厂商\":\"MICROSOFT\"}','2017-05-02 09:00:49'),(30,'0:0:0:0:0:0:0:1','{\"类型\":\"WEB_BROWSER\",\"名称\":\"Chrome\",\"厂商\":\"GOOGLE\",\"产品系列\":\"CHROME\",\"引擎\":\"WEBKIT\"}','{\"名称\":\"Windows 10\",\"设备类型\":\"COMPUTER\",\"产品系列\":\"WINDOWS\",\"生成厂商\":\"MICROSOFT\"}','2017-05-03 20:30:45'),(31,'0:0:0:0:0:0:0:1','{\"类型\":\"WEB_BROWSER\",\"名称\":\"Chrome\",\"厂商\":\"GOOGLE\",\"产品系列\":\"CHROME\",\"引擎\":\"WEBKIT\"}','{\"名称\":\"Windows 10\",\"设备类型\":\"COMPUTER\",\"产品系列\":\"WINDOWS\",\"生成厂商\":\"MICROSOFT\"}','2017-05-03 20:32:21'),(32,'0:0:0:0:0:0:0:1','{\"类型\":\"WEB_BROWSER\",\"名称\":\"Chrome\",\"厂商\":\"GOOGLE\",\"产品系列\":\"CHROME\",\"引擎\":\"WEBKIT\"}','{\"名称\":\"Windows 10\",\"设备类型\":\"COMPUTER\",\"产品系列\":\"WINDOWS\",\"生成厂商\":\"MICROSOFT\"}','2017-05-03 20:50:48'),(33,'0:0:0:0:0:0:0:1','{\"类型\":\"WEB_BROWSER\",\"名称\":\"Chrome\",\"厂商\":\"GOOGLE\",\"产品系列\":\"CHROME\",\"引擎\":\"WEBKIT\"}','{\"名称\":\"Windows 10\",\"设备类型\":\"COMPUTER\",\"产品系列\":\"WINDOWS\",\"生成厂商\":\"MICROSOFT\"}','2017-05-03 21:35:35'),(34,'0:0:0:0:0:0:0:1','{\"类型\":\"WEB_BROWSER\",\"名称\":\"Chrome\",\"厂商\":\"GOOGLE\",\"产品系列\":\"CHROME\",\"引擎\":\"WEBKIT\"}','{\"名称\":\"Windows 10\",\"设备类型\":\"COMPUTER\",\"产品系列\":\"WINDOWS\",\"生成厂商\":\"MICROSOFT\"}','2017-05-04 15:01:12'),(35,'0:0:0:0:0:0:0:1','{\"类型\":\"WEB_BROWSER\",\"名称\":\"Chrome\",\"厂商\":\"GOOGLE\",\"产品系列\":\"CHROME\",\"引擎\":\"WEBKIT\"}','{\"名称\":\"Windows 10\",\"设备类型\":\"COMPUTER\",\"产品系列\":\"WINDOWS\",\"生成厂商\":\"MICROSOFT\"}','2017-05-04 15:01:19'),(36,'0:0:0:0:0:0:0:1','{\"类型\":\"WEB_BROWSER\",\"名称\":\"Chrome\",\"厂商\":\"GOOGLE\",\"产品系列\":\"CHROME\",\"引擎\":\"WEBKIT\"}','{\"名称\":\"Windows 10\",\"设备类型\":\"COMPUTER\",\"产品系列\":\"WINDOWS\",\"生成厂商\":\"MICROSOFT\"}','2017-05-04 15:02:25'),(37,'0:0:0:0:0:0:0:1','{\"类型\":\"WEB_BROWSER\",\"名称\":\"Chrome\",\"厂商\":\"GOOGLE\",\"产品系列\":\"CHROME\",\"引擎\":\"WEBKIT\"}','{\"名称\":\"Windows 10\",\"设备类型\":\"COMPUTER\",\"产品系列\":\"WINDOWS\",\"生成厂商\":\"MICROSOFT\"}','2017-05-04 15:03:55'),(38,'0:0:0:0:0:0:0:1','{\"类型\":\"WEB_BROWSER\",\"名称\":\"Chrome\",\"厂商\":\"GOOGLE\",\"产品系列\":\"CHROME\",\"引擎\":\"WEBKIT\"}','{\"名称\":\"Windows 10\",\"设备类型\":\"COMPUTER\",\"产品系列\":\"WINDOWS\",\"生成厂商\":\"MICROSOFT\"}','2017-05-04 15:04:01'),(39,'0:0:0:0:0:0:0:1','{\"类型\":\"WEB_BROWSER\",\"名称\":\"Chrome\",\"厂商\":\"GOOGLE\",\"产品系列\":\"CHROME\",\"引擎\":\"WEBKIT\"}','{\"名称\":\"Windows 10\",\"设备类型\":\"COMPUTER\",\"产品系列\":\"WINDOWS\",\"生成厂商\":\"MICROSOFT\"}','2017-05-04 15:04:55'),(40,'0:0:0:0:0:0:0:1','{\"类型\":\"WEB_BROWSER\",\"名称\":\"Chrome\",\"厂商\":\"GOOGLE\",\"产品系列\":\"CHROME\",\"引擎\":\"WEBKIT\"}','{\"名称\":\"Windows 10\",\"设备类型\":\"COMPUTER\",\"产品系列\":\"WINDOWS\",\"生成厂商\":\"MICROSOFT\"}','2017-05-04 15:05:24'),(41,'0:0:0:0:0:0:0:1','{\"类型\":\"WEB_BROWSER\",\"名称\":\"Chrome\",\"厂商\":\"GOOGLE\",\"产品系列\":\"CHROME\",\"引擎\":\"WEBKIT\"}','{\"名称\":\"Windows 10\",\"设备类型\":\"COMPUTER\",\"产品系列\":\"WINDOWS\",\"生成厂商\":\"MICROSOFT\"}','2017-05-04 15:05:34'),(42,'0:0:0:0:0:0:0:1','{\"类型\":\"WEB_BROWSER\",\"名称\":\"Chrome\",\"厂商\":\"GOOGLE\",\"产品系列\":\"CHROME\",\"引擎\":\"WEBKIT\"}','{\"名称\":\"Windows 10\",\"设备类型\":\"COMPUTER\",\"产品系列\":\"WINDOWS\",\"生成厂商\":\"MICROSOFT\"}','2017-05-04 15:06:06'),(43,'0:0:0:0:0:0:0:1','{\"类型\":\"WEB_BROWSER\",\"名称\":\"Chrome\",\"厂商\":\"GOOGLE\",\"产品系列\":\"CHROME\",\"引擎\":\"WEBKIT\"}','{\"名称\":\"Windows 10\",\"设备类型\":\"COMPUTER\",\"产品系列\":\"WINDOWS\",\"生成厂商\":\"MICROSOFT\"}','2017-05-04 15:06:15'),(44,'0:0:0:0:0:0:0:1','{\"类型\":\"WEB_BROWSER\",\"名称\":\"Chrome\",\"厂商\":\"GOOGLE\",\"产品系列\":\"CHROME\",\"引擎\":\"WEBKIT\"}','{\"名称\":\"Windows 10\",\"设备类型\":\"COMPUTER\",\"产品系列\":\"WINDOWS\",\"生成厂商\":\"MICROSOFT\"}','2017-05-04 15:12:30'),(45,'0:0:0:0:0:0:0:1','{\"类型\":\"WEB_BROWSER\",\"名称\":\"Chrome\",\"厂商\":\"GOOGLE\",\"产品系列\":\"CHROME\",\"引擎\":\"WEBKIT\"}','{\"名称\":\"Windows 10\",\"设备类型\":\"COMPUTER\",\"产品系列\":\"WINDOWS\",\"生成厂商\":\"MICROSOFT\"}','2017-05-04 15:13:09'),(46,'0:0:0:0:0:0:0:1','{\"类型\":\"WEB_BROWSER\",\"名称\":\"Chrome\",\"厂商\":\"GOOGLE\",\"产品系列\":\"CHROME\",\"引擎\":\"WEBKIT\"}','{\"名称\":\"Windows 10\",\"设备类型\":\"COMPUTER\",\"产品系列\":\"WINDOWS\",\"生成厂商\":\"MICROSOFT\"}','2017-05-04 15:13:40'),(47,'0:0:0:0:0:0:0:1','{\"类型\":\"WEB_BROWSER\",\"名称\":\"Chrome\",\"厂商\":\"GOOGLE\",\"产品系列\":\"CHROME\",\"引擎\":\"WEBKIT\"}','{\"名称\":\"Windows 10\",\"设备类型\":\"COMPUTER\",\"产品系列\":\"WINDOWS\",\"生成厂商\":\"MICROSOFT\"}','2017-05-04 15:33:31'),(48,'0:0:0:0:0:0:0:1','{\"类型\":\"WEB_BROWSER\",\"名称\":\"Chrome\",\"厂商\":\"GOOGLE\",\"产品系列\":\"CHROME\",\"引擎\":\"WEBKIT\"}','{\"名称\":\"Windows 10\",\"设备类型\":\"COMPUTER\",\"产品系列\":\"WINDOWS\",\"生成厂商\":\"MICROSOFT\"}','2017-05-04 15:33:42'),(49,'0:0:0:0:0:0:0:1','{\"类型\":\"WEB_BROWSER\",\"名称\":\"Chrome\",\"厂商\":\"GOOGLE\",\"产品系列\":\"CHROME\",\"引擎\":\"WEBKIT\"}','{\"名称\":\"Windows 10\",\"设备类型\":\"COMPUTER\",\"产品系列\":\"WINDOWS\",\"生成厂商\":\"MICROSOFT\"}','2017-05-04 15:49:06'),(50,'0:0:0:0:0:0:0:1','{\"类型\":\"WEB_BROWSER\",\"名称\":\"Chrome\",\"厂商\":\"GOOGLE\",\"产品系列\":\"CHROME\",\"引擎\":\"WEBKIT\"}','{\"名称\":\"Windows 10\",\"设备类型\":\"COMPUTER\",\"产品系列\":\"WINDOWS\",\"生成厂商\":\"MICROSOFT\"}','2017-05-04 15:51:24'),(51,'0:0:0:0:0:0:0:1','{\"类型\":\"WEB_BROWSER\",\"名称\":\"Chrome\",\"厂商\":\"GOOGLE\",\"产品系列\":\"CHROME\",\"引擎\":\"WEBKIT\"}','{\"名称\":\"Windows 10\",\"设备类型\":\"COMPUTER\",\"产品系列\":\"WINDOWS\",\"生成厂商\":\"MICROSOFT\"}','2017-05-04 15:51:51'),(52,'0:0:0:0:0:0:0:1','{\"类型\":\"WEB_BROWSER\",\"名称\":\"Chrome\",\"厂商\":\"GOOGLE\",\"产品系列\":\"CHROME\",\"引擎\":\"WEBKIT\"}','{\"名称\":\"Windows 10\",\"设备类型\":\"COMPUTER\",\"产品系列\":\"WINDOWS\",\"生成厂商\":\"MICROSOFT\"}','2017-05-04 16:11:29'),(53,'0:0:0:0:0:0:0:1','{\"类型\":\"WEB_BROWSER\",\"名称\":\"Chrome\",\"厂商\":\"GOOGLE\",\"产品系列\":\"CHROME\",\"引擎\":\"WEBKIT\"}','{\"名称\":\"Windows 10\",\"设备类型\":\"COMPUTER\",\"产品系列\":\"WINDOWS\",\"生成厂商\":\"MICROSOFT\"}','2017-05-04 16:12:13'),(54,'0:0:0:0:0:0:0:1','{\"类型\":\"WEB_BROWSER\",\"名称\":\"Chrome\",\"厂商\":\"GOOGLE\",\"产品系列\":\"CHROME\",\"引擎\":\"WEBKIT\"}','{\"名称\":\"Windows 10\",\"设备类型\":\"COMPUTER\",\"产品系列\":\"WINDOWS\",\"生成厂商\":\"MICROSOFT\"}','2017-05-04 16:12:15'),(55,'0:0:0:0:0:0:0:1','{\"类型\":\"WEB_BROWSER\",\"名称\":\"Chrome\",\"厂商\":\"GOOGLE\",\"产品系列\":\"CHROME\",\"引擎\":\"WEBKIT\"}','{\"名称\":\"Windows 10\",\"设备类型\":\"COMPUTER\",\"产品系列\":\"WINDOWS\",\"生成厂商\":\"MICROSOFT\"}','2017-05-04 16:13:01'),(56,'0:0:0:0:0:0:0:1','{\"类型\":\"WEB_BROWSER\",\"名称\":\"Chrome\",\"厂商\":\"GOOGLE\",\"产品系列\":\"CHROME\",\"引擎\":\"WEBKIT\"}','{\"名称\":\"Windows 10\",\"设备类型\":\"COMPUTER\",\"产品系列\":\"WINDOWS\",\"生成厂商\":\"MICROSOFT\"}','2017-05-04 16:13:28'),(57,'0:0:0:0:0:0:0:1','{\"类型\":\"WEB_BROWSER\",\"名称\":\"Chrome\",\"厂商\":\"GOOGLE\",\"产品系列\":\"CHROME\",\"引擎\":\"WEBKIT\"}','{\"名称\":\"Windows 10\",\"设备类型\":\"COMPUTER\",\"产品系列\":\"WINDOWS\",\"生成厂商\":\"MICROSOFT\"}','2017-05-04 16:18:27'),(58,'0:0:0:0:0:0:0:1','{\"类型\":\"WEB_BROWSER\",\"名称\":\"Chrome\",\"厂商\":\"GOOGLE\",\"产品系列\":\"CHROME\",\"引擎\":\"WEBKIT\"}','{\"名称\":\"Windows 10\",\"设备类型\":\"COMPUTER\",\"产品系列\":\"WINDOWS\",\"生成厂商\":\"MICROSOFT\"}','2017-05-04 16:20:20'),(59,'0:0:0:0:0:0:0:1','{\"类型\":\"WEB_BROWSER\",\"名称\":\"Chrome\",\"厂商\":\"GOOGLE\",\"产品系列\":\"CHROME\",\"引擎\":\"WEBKIT\"}','{\"名称\":\"Windows 10\",\"设备类型\":\"COMPUTER\",\"产品系列\":\"WINDOWS\",\"生成厂商\":\"MICROSOFT\"}','2017-05-05 14:48:49'),(60,'0:0:0:0:0:0:0:1','{\"类型\":\"WEB_BROWSER\",\"名称\":\"Chrome\",\"厂商\":\"GOOGLE\",\"产品系列\":\"CHROME\",\"引擎\":\"WEBKIT\"}','{\"名称\":\"Windows 10\",\"设备类型\":\"COMPUTER\",\"产品系列\":\"WINDOWS\",\"生成厂商\":\"MICROSOFT\"}','2017-05-05 14:49:00'),(61,'127.0.0.1','{\"类型\":\"WEB_BROWSER\",\"名称\":\"Chrome\",\"厂商\":\"GOOGLE\",\"产品系列\":\"CHROME\",\"引擎\":\"WEBKIT\"}','{\"名称\":\"Windows 10\",\"设备类型\":\"COMPUTER\",\"产品系列\":\"WINDOWS\",\"生成厂商\":\"MICROSOFT\"}','2017-05-05 21:07:15'),(62,'0:0:0:0:0:0:0:1','{\"类型\":\"WEB_BROWSER\",\"名称\":\"Chrome\",\"厂商\":\"GOOGLE\",\"产品系列\":\"CHROME\",\"引擎\":\"WEBKIT\"}','{\"名称\":\"Windows 10\",\"设备类型\":\"COMPUTER\",\"产品系列\":\"WINDOWS\",\"生成厂商\":\"MICROSOFT\"}','2017-05-05 21:08:45'),(63,'0:0:0:0:0:0:0:1','{\"类型\":\"WEB_BROWSER\",\"名称\":\"Chrome\",\"厂商\":\"GOOGLE\",\"产品系列\":\"CHROME\",\"引擎\":\"WEBKIT\"}','{\"名称\":\"Windows 10\",\"设备类型\":\"COMPUTER\",\"产品系列\":\"WINDOWS\",\"生成厂商\":\"MICROSOFT\"}','2017-05-05 21:17:31'),(64,'0:0:0:0:0:0:0:1','{\"类型\":\"WEB_BROWSER\",\"名称\":\"Chrome\",\"厂商\":\"GOOGLE\",\"产品系列\":\"CHROME\",\"引擎\":\"WEBKIT\"}','{\"名称\":\"Windows 10\",\"设备类型\":\"COMPUTER\",\"产品系列\":\"WINDOWS\",\"生成厂商\":\"MICROSOFT\"}','2017-05-05 21:19:19'),(65,'0:0:0:0:0:0:0:1','{\"类型\":\"WEB_BROWSER\",\"名称\":\"Chrome\",\"厂商\":\"GOOGLE\",\"产品系列\":\"CHROME\",\"引擎\":\"WEBKIT\"}','{\"名称\":\"Windows 10\",\"设备类型\":\"COMPUTER\",\"产品系列\":\"WINDOWS\",\"生成厂商\":\"MICROSOFT\"}','2017-05-05 21:21:56'),(66,'0:0:0:0:0:0:0:1','{\"类型\":\"WEB_BROWSER\",\"名称\":\"Chrome\",\"厂商\":\"GOOGLE\",\"产品系列\":\"CHROME\",\"引擎\":\"WEBKIT\"}','{\"名称\":\"Windows 10\",\"设备类型\":\"COMPUTER\",\"产品系列\":\"WINDOWS\",\"生成厂商\":\"MICROSOFT\"}','2017-05-05 21:22:43'),(67,'0:0:0:0:0:0:0:1','{\"类型\":\"WEB_BROWSER\",\"名称\":\"Chrome\",\"厂商\":\"GOOGLE\",\"产品系列\":\"CHROME\",\"引擎\":\"WEBKIT\"}','{\"名称\":\"Windows 10\",\"设备类型\":\"COMPUTER\",\"产品系列\":\"WINDOWS\",\"生成厂商\":\"MICROSOFT\"}','2017-05-05 21:23:34'),(68,'0:0:0:0:0:0:0:1','{\"类型\":\"WEB_BROWSER\",\"名称\":\"Chrome\",\"厂商\":\"GOOGLE\",\"产品系列\":\"CHROME\",\"引擎\":\"WEBKIT\"}','{\"名称\":\"Windows 10\",\"设备类型\":\"COMPUTER\",\"产品系列\":\"WINDOWS\",\"生成厂商\":\"MICROSOFT\"}','2017-05-05 21:24:26'),(69,'0:0:0:0:0:0:0:1','{\"类型\":\"WEB_BROWSER\",\"名称\":\"Chrome\",\"厂商\":\"GOOGLE\",\"产品系列\":\"CHROME\",\"引擎\":\"WEBKIT\"}','{\"名称\":\"Windows 10\",\"设备类型\":\"COMPUTER\",\"产品系列\":\"WINDOWS\",\"生成厂商\":\"MICROSOFT\"}','2017-05-05 21:26:10'),(70,'0:0:0:0:0:0:0:1','{\"类型\":\"WEB_BROWSER\",\"名称\":\"Chrome\",\"厂商\":\"GOOGLE\",\"产品系列\":\"CHROME\",\"引擎\":\"WEBKIT\"}','{\"名称\":\"Windows 10\",\"设备类型\":\"COMPUTER\",\"产品系列\":\"WINDOWS\",\"生成厂商\":\"MICROSOFT\"}','2017-05-05 21:26:31'),(71,'0:0:0:0:0:0:0:1','{\"类型\":\"WEB_BROWSER\",\"名称\":\"Chrome\",\"厂商\":\"GOOGLE\",\"产品系列\":\"CHROME\",\"引擎\":\"WEBKIT\"}','{\"名称\":\"Windows 10\",\"设备类型\":\"COMPUTER\",\"产品系列\":\"WINDOWS\",\"生成厂商\":\"MICROSOFT\"}','2017-05-05 21:27:13'),(72,'0:0:0:0:0:0:0:1','{\"类型\":\"WEB_BROWSER\",\"名称\":\"Chrome\",\"厂商\":\"GOOGLE\",\"产品系列\":\"CHROME\",\"引擎\":\"WEBKIT\"}','{\"名称\":\"Windows 10\",\"设备类型\":\"COMPUTER\",\"产品系列\":\"WINDOWS\",\"生成厂商\":\"MICROSOFT\"}','2017-05-05 21:27:22'),(73,'0:0:0:0:0:0:0:1','{\"类型\":\"WEB_BROWSER\",\"名称\":\"Chrome\",\"厂商\":\"GOOGLE\",\"产品系列\":\"CHROME\",\"引擎\":\"WEBKIT\"}','{\"名称\":\"Windows 10\",\"设备类型\":\"COMPUTER\",\"产品系列\":\"WINDOWS\",\"生成厂商\":\"MICROSOFT\"}','2017-05-05 21:27:37'),(74,'0:0:0:0:0:0:0:1','{\"类型\":\"WEB_BROWSER\",\"名称\":\"Chrome\",\"厂商\":\"GOOGLE\",\"产品系列\":\"CHROME\",\"引擎\":\"WEBKIT\"}','{\"名称\":\"Windows 10\",\"设备类型\":\"COMPUTER\",\"产品系列\":\"WINDOWS\",\"生成厂商\":\"MICROSOFT\"}','2017-05-05 21:27:52'),(75,'0:0:0:0:0:0:0:1','{\"类型\":\"WEB_BROWSER\",\"名称\":\"Chrome\",\"厂商\":\"GOOGLE\",\"产品系列\":\"CHROME\",\"引擎\":\"WEBKIT\"}','{\"名称\":\"Windows 10\",\"设备类型\":\"COMPUTER\",\"产品系列\":\"WINDOWS\",\"生成厂商\":\"MICROSOFT\"}','2017-05-05 21:28:36'),(76,'0:0:0:0:0:0:0:1','{\"类型\":\"WEB_BROWSER\",\"名称\":\"Chrome\",\"厂商\":\"GOOGLE\",\"产品系列\":\"CHROME\",\"引擎\":\"WEBKIT\"}','{\"名称\":\"Windows 10\",\"设备类型\":\"COMPUTER\",\"产品系列\":\"WINDOWS\",\"生成厂商\":\"MICROSOFT\"}','2017-05-05 21:29:56'),(77,'0:0:0:0:0:0:0:1','{\"类型\":\"WEB_BROWSER\",\"名称\":\"Chrome\",\"厂商\":\"GOOGLE\",\"产品系列\":\"CHROME\",\"引擎\":\"WEBKIT\"}','{\"名称\":\"Windows 10\",\"设备类型\":\"COMPUTER\",\"产品系列\":\"WINDOWS\",\"生成厂商\":\"MICROSOFT\"}','2017-05-05 21:31:51'),(78,'0:0:0:0:0:0:0:1','{\"类型\":\"WEB_BROWSER\",\"名称\":\"Chrome\",\"厂商\":\"GOOGLE\",\"产品系列\":\"CHROME\",\"引擎\":\"WEBKIT\"}','{\"名称\":\"Windows 10\",\"设备类型\":\"COMPUTER\",\"产品系列\":\"WINDOWS\",\"生成厂商\":\"MICROSOFT\"}','2017-05-05 21:33:37'),(79,'0:0:0:0:0:0:0:1','{\"类型\":\"WEB_BROWSER\",\"名称\":\"Chrome\",\"厂商\":\"GOOGLE\",\"产品系列\":\"CHROME\",\"引擎\":\"WEBKIT\"}','{\"名称\":\"Windows 10\",\"设备类型\":\"COMPUTER\",\"产品系列\":\"WINDOWS\",\"生成厂商\":\"MICROSOFT\"}','2017-05-05 21:37:30'),(80,'0:0:0:0:0:0:0:1','{\"类型\":\"WEB_BROWSER\",\"名称\":\"Chrome\",\"厂商\":\"GOOGLE\",\"产品系列\":\"CHROME\",\"引擎\":\"WEBKIT\"}','{\"名称\":\"Windows 10\",\"设备类型\":\"COMPUTER\",\"产品系列\":\"WINDOWS\",\"生成厂商\":\"MICROSOFT\"}','2017-05-05 21:39:06'),(81,'0:0:0:0:0:0:0:1','{\"类型\":\"WEB_BROWSER\",\"名称\":\"Chrome\",\"厂商\":\"GOOGLE\",\"产品系列\":\"CHROME\",\"引擎\":\"WEBKIT\"}','{\"名称\":\"Windows 10\",\"设备类型\":\"COMPUTER\",\"产品系列\":\"WINDOWS\",\"生成厂商\":\"MICROSOFT\"}','2017-05-05 21:39:46'),(82,'0:0:0:0:0:0:0:1','{\"类型\":\"WEB_BROWSER\",\"名称\":\"Chrome\",\"厂商\":\"GOOGLE\",\"产品系列\":\"CHROME\",\"引擎\":\"WEBKIT\"}','{\"名称\":\"Windows 10\",\"设备类型\":\"COMPUTER\",\"产品系列\":\"WINDOWS\",\"生成厂商\":\"MICROSOFT\"}','2017-05-05 21:40:05'),(83,'0:0:0:0:0:0:0:1','{\"类型\":\"WEB_BROWSER\",\"名称\":\"Chrome\",\"厂商\":\"GOOGLE\",\"产品系列\":\"CHROME\",\"引擎\":\"WEBKIT\"}','{\"名称\":\"Windows 10\",\"设备类型\":\"COMPUTER\",\"产品系列\":\"WINDOWS\",\"生成厂商\":\"MICROSOFT\"}','2017-05-05 21:43:41'),(84,'0:0:0:0:0:0:0:1','{\"类型\":\"WEB_BROWSER\",\"名称\":\"Chrome\",\"厂商\":\"GOOGLE\",\"产品系列\":\"CHROME\",\"引擎\":\"WEBKIT\"}','{\"名称\":\"Windows 10\",\"设备类型\":\"COMPUTER\",\"产品系列\":\"WINDOWS\",\"生成厂商\":\"MICROSOFT\"}','2017-05-05 21:47:44'),(85,'0:0:0:0:0:0:0:1','{\"类型\":\"WEB_BROWSER\",\"名称\":\"Chrome\",\"厂商\":\"GOOGLE\",\"产品系列\":\"CHROME\",\"引擎\":\"WEBKIT\"}','{\"名称\":\"Windows 10\",\"设备类型\":\"COMPUTER\",\"产品系列\":\"WINDOWS\",\"生成厂商\":\"MICROSOFT\"}','2017-05-05 21:48:42'),(86,'0:0:0:0:0:0:0:1','{\"类型\":\"WEB_BROWSER\",\"名称\":\"Chrome\",\"厂商\":\"GOOGLE\",\"产品系列\":\"CHROME\",\"引擎\":\"WEBKIT\"}','{\"名称\":\"Windows 10\",\"设备类型\":\"COMPUTER\",\"产品系列\":\"WINDOWS\",\"生成厂商\":\"MICROSOFT\"}','2017-05-05 21:49:38'),(87,'0:0:0:0:0:0:0:1','{\"类型\":\"WEB_BROWSER\",\"名称\":\"Chrome\",\"厂商\":\"GOOGLE\",\"产品系列\":\"CHROME\",\"引擎\":\"WEBKIT\"}','{\"名称\":\"Windows 10\",\"设备类型\":\"COMPUTER\",\"产品系列\":\"WINDOWS\",\"生成厂商\":\"MICROSOFT\"}','2017-05-05 21:50:23'),(88,'0:0:0:0:0:0:0:1','{\"类型\":\"WEB_BROWSER\",\"名称\":\"Chrome\",\"厂商\":\"GOOGLE\",\"产品系列\":\"CHROME\",\"引擎\":\"WEBKIT\"}','{\"名称\":\"Windows 10\",\"设备类型\":\"COMPUTER\",\"产品系列\":\"WINDOWS\",\"生成厂商\":\"MICROSOFT\"}','2017-05-05 23:38:20'),(89,'0:0:0:0:0:0:0:1','{\"类型\":\"WEB_BROWSER\",\"名称\":\"Chrome\",\"厂商\":\"GOOGLE\",\"产品系列\":\"CHROME\",\"引擎\":\"WEBKIT\"}','{\"名称\":\"Windows 10\",\"设备类型\":\"COMPUTER\",\"产品系列\":\"WINDOWS\",\"生成厂商\":\"MICROSOFT\"}','2017-05-05 23:40:26'),(90,'0:0:0:0:0:0:0:1','{\"类型\":\"WEB_BROWSER\",\"名称\":\"Chrome\",\"厂商\":\"GOOGLE\",\"产品系列\":\"CHROME\",\"引擎\":\"WEBKIT\"}','{\"名称\":\"Windows 10\",\"设备类型\":\"COMPUTER\",\"产品系列\":\"WINDOWS\",\"生成厂商\":\"MICROSOFT\"}','2017-05-05 23:49:29'),(91,'0:0:0:0:0:0:0:1','{\"类型\":\"WEB_BROWSER\",\"名称\":\"Chrome\",\"厂商\":\"GOOGLE\",\"产品系列\":\"CHROME\",\"引擎\":\"WEBKIT\"}','{\"名称\":\"Windows 10\",\"设备类型\":\"COMPUTER\",\"产品系列\":\"WINDOWS\",\"生成厂商\":\"MICROSOFT\"}','2017-05-05 23:50:01'),(92,'0:0:0:0:0:0:0:1','{\"类型\":\"WEB_BROWSER\",\"名称\":\"Chrome\",\"厂商\":\"GOOGLE\",\"产品系列\":\"CHROME\",\"引擎\":\"WEBKIT\"}','{\"名称\":\"Windows 10\",\"设备类型\":\"COMPUTER\",\"产品系列\":\"WINDOWS\",\"生成厂商\":\"MICROSOFT\"}','2017-05-05 23:50:28'),(93,'0:0:0:0:0:0:0:1','{\"类型\":\"WEB_BROWSER\",\"名称\":\"Chrome\",\"厂商\":\"GOOGLE\",\"产品系列\":\"CHROME\",\"引擎\":\"WEBKIT\"}','{\"名称\":\"Windows 10\",\"设备类型\":\"COMPUTER\",\"产品系列\":\"WINDOWS\",\"生成厂商\":\"MICROSOFT\"}','2017-05-05 23:51:05'),(94,'0:0:0:0:0:0:0:1','{\"类型\":\"WEB_BROWSER\",\"名称\":\"Chrome\",\"厂商\":\"GOOGLE\",\"产品系列\":\"CHROME\",\"引擎\":\"WEBKIT\"}','{\"名称\":\"Windows 10\",\"设备类型\":\"COMPUTER\",\"产品系列\":\"WINDOWS\",\"生成厂商\":\"MICROSOFT\"}','2017-05-05 23:51:16'),(95,'0:0:0:0:0:0:0:1','{\"类型\":\"WEB_BROWSER\",\"名称\":\"Chrome\",\"厂商\":\"GOOGLE\",\"产品系列\":\"CHROME\",\"引擎\":\"WEBKIT\"}','{\"名称\":\"Windows 10\",\"设备类型\":\"COMPUTER\",\"产品系列\":\"WINDOWS\",\"生成厂商\":\"MICROSOFT\"}','2017-05-05 23:51:23'),(96,'0:0:0:0:0:0:0:1','{\"类型\":\"WEB_BROWSER\",\"名称\":\"Chrome\",\"厂商\":\"GOOGLE\",\"产品系列\":\"CHROME\",\"引擎\":\"WEBKIT\"}','{\"名称\":\"Windows 10\",\"设备类型\":\"COMPUTER\",\"产品系列\":\"WINDOWS\",\"生成厂商\":\"MICROSOFT\"}','2017-05-05 23:53:21'),(97,'0:0:0:0:0:0:0:1','{\"类型\":\"WEB_BROWSER\",\"名称\":\"Chrome\",\"厂商\":\"GOOGLE\",\"产品系列\":\"CHROME\",\"引擎\":\"WEBKIT\"}','{\"名称\":\"Windows 10\",\"设备类型\":\"COMPUTER\",\"产品系列\":\"WINDOWS\",\"生成厂商\":\"MICROSOFT\"}','2017-05-05 23:53:31'),(98,'0:0:0:0:0:0:0:1','{\"类型\":\"WEB_BROWSER\",\"名称\":\"Chrome\",\"厂商\":\"GOOGLE\",\"产品系列\":\"CHROME\",\"引擎\":\"WEBKIT\"}','{\"名称\":\"Windows 10\",\"设备类型\":\"COMPUTER\",\"产品系列\":\"WINDOWS\",\"生成厂商\":\"MICROSOFT\"}','2017-05-05 23:55:59'),(99,'0:0:0:0:0:0:0:1','{\"类型\":\"WEB_BROWSER\",\"名称\":\"Chrome\",\"厂商\":\"GOOGLE\",\"产品系列\":\"CHROME\",\"引擎\":\"WEBKIT\"}','{\"名称\":\"Windows 10\",\"设备类型\":\"COMPUTER\",\"产品系列\":\"WINDOWS\",\"生成厂商\":\"MICROSOFT\"}','2017-05-06 00:20:16'),(100,'0:0:0:0:0:0:0:1','{\"类型\":\"WEB_BROWSER\",\"名称\":\"Chrome\",\"厂商\":\"GOOGLE\",\"产品系列\":\"CHROME\",\"引擎\":\"WEBKIT\"}','{\"名称\":\"Windows 10\",\"设备类型\":\"COMPUTER\",\"产品系列\":\"WINDOWS\",\"生成厂商\":\"MICROSOFT\"}','2017-05-06 00:21:07'),(101,'0:0:0:0:0:0:0:1','{\"类型\":\"WEB_BROWSER\",\"名称\":\"Chrome\",\"厂商\":\"GOOGLE\",\"产品系列\":\"CHROME\",\"引擎\":\"WEBKIT\"}','{\"名称\":\"Windows 10\",\"设备类型\":\"COMPUTER\",\"产品系列\":\"WINDOWS\",\"生成厂商\":\"MICROSOFT\"}','2017-05-06 00:21:32'),(102,'0:0:0:0:0:0:0:1','{\"类型\":\"WEB_BROWSER\",\"名称\":\"Chrome\",\"厂商\":\"GOOGLE\",\"产品系列\":\"CHROME\",\"引擎\":\"WEBKIT\"}','{\"名称\":\"Windows 10\",\"设备类型\":\"COMPUTER\",\"产品系列\":\"WINDOWS\",\"生成厂商\":\"MICROSOFT\"}','2017-05-06 00:21:39'),(103,'0:0:0:0:0:0:0:1','{\"类型\":\"WEB_BROWSER\",\"名称\":\"Chrome\",\"厂商\":\"GOOGLE\",\"产品系列\":\"CHROME\",\"引擎\":\"WEBKIT\"}','{\"名称\":\"Windows 10\",\"设备类型\":\"COMPUTER\",\"产品系列\":\"WINDOWS\",\"生成厂商\":\"MICROSOFT\"}','2017-05-06 00:21:42'),(104,'0:0:0:0:0:0:0:1','{\"类型\":\"WEB_BROWSER\",\"名称\":\"Chrome\",\"厂商\":\"GOOGLE\",\"产品系列\":\"CHROME\",\"引擎\":\"WEBKIT\"}','{\"名称\":\"Windows 10\",\"设备类型\":\"COMPUTER\",\"产品系列\":\"WINDOWS\",\"生成厂商\":\"MICROSOFT\"}','2017-05-06 00:22:40'),(105,'0:0:0:0:0:0:0:1','{\"类型\":\"WEB_BROWSER\",\"名称\":\"Chrome\",\"厂商\":\"GOOGLE\",\"产品系列\":\"CHROME\",\"引擎\":\"WEBKIT\"}','{\"名称\":\"Windows 10\",\"设备类型\":\"COMPUTER\",\"产品系列\":\"WINDOWS\",\"生成厂商\":\"MICROSOFT\"}','2017-05-06 00:24:40'),(106,'0:0:0:0:0:0:0:1','{\"类型\":\"WEB_BROWSER\",\"名称\":\"Chrome\",\"厂商\":\"GOOGLE\",\"产品系列\":\"CHROME\",\"引擎\":\"WEBKIT\"}','{\"名称\":\"Windows 10\",\"设备类型\":\"COMPUTER\",\"产品系列\":\"WINDOWS\",\"生成厂商\":\"MICROSOFT\"}','2017-05-06 00:26:35'),(107,'0:0:0:0:0:0:0:1','{\"类型\":\"WEB_BROWSER\",\"名称\":\"Chrome\",\"厂商\":\"GOOGLE\",\"产品系列\":\"CHROME\",\"引擎\":\"WEBKIT\"}','{\"名称\":\"Windows 10\",\"设备类型\":\"COMPUTER\",\"产品系列\":\"WINDOWS\",\"生成厂商\":\"MICROSOFT\"}','2017-05-08 15:42:29'),(108,'0:0:0:0:0:0:0:1','{\"类型\":\"WEB_BROWSER\",\"名称\":\"Chrome\",\"厂商\":\"GOOGLE\",\"产品系列\":\"CHROME\",\"引擎\":\"WEBKIT\"}','{\"名称\":\"Windows 10\",\"设备类型\":\"COMPUTER\",\"产品系列\":\"WINDOWS\",\"生成厂商\":\"MICROSOFT\"}','2017-05-08 15:44:44');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
