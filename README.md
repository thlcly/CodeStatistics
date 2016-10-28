# PREFACE
如果真正要准确的统计代码数量暂时不要使用CodeStatistics, 因为CodeStatistics的测试还不够完善, 只是为了提高编码水平重复造轮子, 在mac端可以使用[CLOC](http://www.cnblogs.com/wengzilin/p/4580646.html)进行准确的代码统计

# CodeStatistics
代码统计工具
 - 基于JDK 8

 - 基于MAVEN 3

 - 支持JAVA代码的统计(后续会加上其他语言的支持)

# INSTALL

 - 安装[jdk 8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html), [git](https://git-scm.com/download), [maven](https://maven.apache.org/download.cgi)

 - 下载项目源代码: `git clone https://github.com/thlcly/CodeStatistics.git`

 - 打包可运行jar文件: `mvn package`

 - 运行: `java -jar <jar-file-path> <file-path>`