/*
 * Copyright 2002-2012 the original author or authors.
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

package org.springframework.scheduling.config;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * {@code NamespaceHandler} for the 'task' namespace.
 * 定时任务处理处理
 * @author Mark Fisher
 * @since 3.0
 */
public class TaskNamespaceHandler extends NamespaceHandlerSupport {

	@Override
	public void init() {
		this.registerBeanDefinitionParser("annotation-driven", new AnnotationDrivenBeanDefinitionParser());
		// 设置线程池执行器底层是 ThreadPoolExecutor
		this.registerBeanDefinitionParser("executor", new ExecutorBeanDefinitionParser());

		// 设置scheduled-tasks 任务，并确定定时任务线程池
		this.registerBeanDefinitionParser("scheduled-tasks", new ScheduledTasksBeanDefinitionParser());

		// 设置定时任务线程池 底层是 ScheduledThreadPoolExecutor
		this.registerBeanDefinitionParser("scheduler", new SchedulerBeanDefinitionParser());
	}

}
