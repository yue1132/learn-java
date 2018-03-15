## Java 自定义注解

    ### 注解分类
        >> 源码注解  (注解只在源码中存在，编译成class文件就不存在了)
        >> 编译时注解 (注解在源码和class文件都存在，例如:@Override、@Deprecated、@Suppvisewarnings)
        >> 运行时注解 (在运行阶段还在起作用，甚至会影响运行逻辑的注解，例如：@Autowired)
        
        >> 元注解 （注解的注解）       
  
    
    ### Spring 相关注解说明：
        @Configuration 是一个类级注解，只是对象是一个bean定义的源.@Configuration类通过@Bean注解的公共方法声明bean
        @Bean注解是用来表示一个方法的实例化，配置和初始化时有Spring Ioc容器管理的一个新的对象。
        通俗的讲@Configuration一般与@Bean注解配合使用，用@Configuration注解类等价于XMl中配置beans，
        用@Bean注解方法等价于XML中配置bean。例如：
        XML代码如下：
         <beans>
            <bean id="userService" class = "com.user.UserService">
                <properties name = "userDAO" ref = "userDao"/> 
            </bean>
            <bean id="userDao" class="com.user.UserDao"></bean>
         </beans>
        等价于：
        
        @Configuration
        public class Config{
            @Bean
            public UserService getUserService(){
                UserService userService = new UserService();
                userService.setUserDao(null);
                return userService;
            }
            
            @Bean
            public UserDao getUserDao(){
                return new UserDao();
            }
        } 
        
        public class UserService{
            private UserDao userdao;
            
            public Userdao getUserDao(){
                return userDao;
            }
            
            public void setUserDao(UserDao userDao){
                this.userDao = userDao;
            }
        }
        
        public class UserDao{
        
        }