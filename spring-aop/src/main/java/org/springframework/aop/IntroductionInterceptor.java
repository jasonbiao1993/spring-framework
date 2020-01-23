/*
 * Copyright 2002-2007 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.aop;

import org.aopalliance.intercept.MethodInterceptor;

/**
 * Subinterface of AOP Alliance MethodInterceptor that allows additional interfaces
 * to be implemented by the interceptor, and available via a proxy using that
 * interceptor. This is a fundamental AOP concept called <b>introduction</b>.
 *
 * <p>Introductions are often <b>mixins</b>, enabling the building of composite
 * objects that can achieve many of the goals of multiple inheritance in Java.
 *
 * @author Rod Johnson
 * @see DynamicIntroductionAdvice
 *
 * Introduction（引入）是个特别的Advice，类通过实现AOP中的org.springframework.aop.IntroductionInterceptor在不改变原有方法的基础上却可以增加新的方法。
 * IntroductionInterceptor继承了MethodInterceptor和DynamicIntroductionAdvice接口，其中implementsInterface()方法（继承自DynamicIntroductionAdvice）
 * 如果返回true，表示目前的 IntroductionInterceptor实现了给定的接口（也就是要额外增加行为的接口），此时要使用invoke()调用该接口上的方法，让目标执行额外的行为。
 * 需要注意的是不可能使用MethodInvocation的proceed()方法，因为要执行的是类原来没有的行为，proceed()方法没有意义。
 */
public interface IntroductionInterceptor extends MethodInterceptor, DynamicIntroductionAdvice {

}
