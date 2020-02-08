# Spring 事物驱动处理
## 事物驱动配置案例
```xml
<!-- 注解** 数据源以Sping自带为例，每次请求均返回一个新的连接 -->
<bean id="dataSource" class="org.springframework.jdbc.datasource.DriverManagerDataSource">
    <!-- setter 属性注入 -->
    <property name="driverClassName" value="${jdbc.driverClassName}" />
    <property name="url" value="${jdbc.url}" />
    <property name="username" value="${jdbc.username}" />
    <property name="password" value="${jdbc.password}" />
</bean>
<bean id="transactionManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
    <property name="dataSource" ref="dataSource"/>
</bean>
<tx:annotation-driven transaction-manager="transactionManager"/>


<!-- xml 事务配置处理 -->
 <tx:advice id="txAdvice" transaction-manager="transactionManager">
     <tx:attributes>
         <tx:method name="get*" propagation="SUPPORTS" isolation="DEFAULT"
             read-only="true" />
         <tx:method name="find*" propagation="SUPPORTS" isolation="DEFAULT"
             read-only="true" />
         <tx:method name="load*" propagation="SUPPORTS" isolation="DEFAULT"
             read-only="true" />
         <tx:method name="*" propagation="REQUIRED" rollback-for="java.lang.Exception" />
     </tx:attributes>
 </tx:advice>
 
 <aop:config>
     <aop:pointcut id="bussinessService" expression="execution(public * com.honglin.service..*.*(..))" />
     <aop:advisor pointcut-ref="bussinessService" advice-ref="txAdvice" />
 </aop:config>

```