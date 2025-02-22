# april-project-authorize
# 

将这个项目引入后会自动监测授权，无需任何操作

~~~xml
<dependency>
    <!-- https://central.sonatype.com/artifact/com.mobaijun/april-project-authorize/versions -->
    <groupId>com.mobaijun</groupId>
    <artifactId>april-project-authorize</artifactId>
    <version>${latest.version}</version>
</dependency>
~~~

## Spring Boot 项目

1. 初始化 `AuthorizationTask `接口

~~~java
/**
 * 创建一个名为 authorizationTask 的 Bean，用于执行授权任务。
 *
 * @return 返回一个 AuthorizationTask 实例，用于执行授权任务。
 */
@Bean
public AuthorizationTask authorizationTask() {
    return new AuthorizationTaskImpl();
}
~~~

2. 调用初始化接口

~~~java
/**
 * 用于初始化授权任务的异步方法，仅执行一次。
 *
 * <p>该方法使用 {@code @Async} 注解使其异步执行，并且使用 {@code @Scheduled} 注解定义了仅执行一次的定时任务。
 * 它将在应用程序启动后执行一次，用于初始化授权任务。
 *
 * @implNote 授权任务的初始化工作由 {@code authorizationTask} 对象的 {@code init()} 方法完成。
 * 该方法内部调用了 {@code authorizationTask} 的初始化方法。
 * @implSpec 由于定时任务的间隔时间设置为 {@code Long.MAX_VALUE}，因此该任务将只执行一次。
 */
@Async
@Scheduled(fixedDelay = Long.MAX_VALUE) // 使用一个非常大的延迟时间，使任务仅执行一次
public void authorizationTaskInit() {
    authorizationTask.init();
}
~~~

3. 调用授权监测接口，并传入授权参数

~~~java
authorizationTask.execute(6);
~~~

