# 自定义xml bean 解析处理方式
* xml定义实现通过*.xsd实现
* 实现 NamespaceHandler 注解
* 通过在 META-INF/spring.handlers定义schema->NamespaceHandler的映射

# 定时任务实现
定时任务注解 scheduled-tasks解析结构
![定时任务注解 scheduled-tasks解析结构](image/scheduled-tasks.png)