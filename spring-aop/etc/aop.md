# 代理
[spring aop代理和aspecj代理的区别](https://www.jianshu.com/p/872d3dbdc2ca)

[Aspectj 在Spring中的使用](https://www.jianshu.com/p/958af6a90477)
## spring aop 代理
Spring 实现动态代理的方 java代理和cglib代理
### 实现类
* 类 AspectJAwareAdvisorAutoProxyCreator
> 用于判断是否代理Bean
  * 方法 postProcessBeforeInstantiation
  * 方法 postProcessAfterInitialization
* 类 AopUtils
> 用于判断是否代理

## AspectJ 代理
### 实现类
* 类 AnnotationAwareAspectJAutoProxyCreator

## AOP切面的坑
* 定义在private方法上的切面不会被执行，这个很容易理解，毕竟子类不能覆盖父类的私有方法。
* 同一个代理子类内部的方法相互调用不会再次执行切面。
这里以Cglib为例对第二点进行说明，cglib的相关核心组件可以参考前面CallbackFilter & Callback部分。对于配置了一个切面的典型场景，Spring内部的执行流程可总结如下图: