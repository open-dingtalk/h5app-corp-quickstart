## 启动步骤
1. 将工程clone到本地:
  `git clone https://github.com/open-dingtalk/xsh5app-corp-quickstart.git`
2. 使用IDE导入工程:
  比如eclipse点击`File->import`(推荐使用maven导入)
  IDEA点击`File->New->Project from Existing Sources...`, 文件编码都是UTF-8
3. OA后台创建微应用，并把工程的首页地址/index.html 填到微应用**首页地址**中。
[如何创建微应用？](https://ding-doc.dingtalk.com/doc#/bgb96b/aw3h75)
4. 打开子模块 backend 中 src/main/resources/application.properties 文件，填入企业微应用的 的APP_KEY，APP_SECRET, CORP_ID, AGENT_ID （参考文档：https://ding-doc.dingtalk.com/doc#/bgb96b/aw3h75）
```
dingtalk.app_key=APP_KEY
dingtalk.app_secret=APP_SECRET
dingtalk.agent_id=AGENT_ID
dingtalk.corp_id=CORP_ID
``` 
5. 使用 mvn install 构建 frontend 中必要组建
5. 部署工程，使用 mvn -DskipTests=true spring-boot:run -pl backend 运行或者IDE中的maven插件运行
6. 如修改了frontent中代码需要重新执行 mvn install 更新frontend项目内容

