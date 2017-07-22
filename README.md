# Spring Spring MVC Mybatis Maven整合
####导语
>  Mybatis基础的增删改查
## 一、增加定时任务
  xmlns 加下面的内容:
	xmlns:task="http://www.springframework.org/schema/task"
    然后xsi:schemaLocation加下面的内容:
	http://www.springframework.org/schema/task
	http://www.springframework.org/schema/task/spring-task-3.2.xsd
<!-- task任务扫描注解 -->
<task:annotation-driven/>
我配置的扫描位置是:
<context:component-scan base-package="com.ssm.controller" /> 

