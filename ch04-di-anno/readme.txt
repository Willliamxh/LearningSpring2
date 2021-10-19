ch04-di-anno:通过spring的注解完成java对象的创建，属性。代替xml文件

实现步骤：
1.加入依赖
2.创建类，在类中加入注解
3.创建spring的配置文件
    声明组件扫描器的标签，指明注解在你的项目中的位置。
4.使用注解创建对象，创建容器ApplicationContext

@Repository 用于对 DAO 实现类进行注解
➢ @Service 用于对 Service 实现类进行注解
➢ @Controller 用于对 Controller 实现类进行注解
这三个注解与@Component 都可以创建对象，但这三个注解还有其他的含义， @Service
创建业务层对象，业务层对象可以加入事务功能， @Controller 注解创建的对象可以作为处
理器接收用户的请求。
@Repository， @Service， @Controller 是对@Component 注解的细化，标注不同层的对
象。 即持久层对象，业务层对象，控制层对象。
@Component 不指定 value 属性， bean 的 id 是类名的首字母小写

