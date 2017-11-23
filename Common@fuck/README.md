# 公共模块


# 编译上传到maven服务器
* 修改setting.xml 添加
<server>
	<id>Releases</id>
	<username>admin</username>
	<password>admin123</password>
</server> 

* 运行命令
mvn deploy
