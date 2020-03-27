# mvc 源码分析
spring-mvc支持Spring容器与MVC容器共存，此时，Spring容器即根容器，mvc容器将根容器视为父容器。

Spring容器(根容器)以下列形式进行配置(web.xml):
```xml
<listener>
    <listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
</listener>
```
根据Servlet规范，各组件的加载 顺序如下:
listener -> filter -> servlet