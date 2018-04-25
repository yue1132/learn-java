## Redis学习

### redis特性
    1.是远程的
    2.是基于内存的
    3.是非关系型数据库
    
### 应用场景
    1.缓存
    2.队列（push/pop）
    3.数据存储
 
### redis 安装
    依赖gcc环境
    make 
    make install
### redis启动
    redis-server -h 127.0.0.1 -p 6379 /etc/redis/redis.conf
    redis-cli 
### redis关闭
    redis-cli shutdown 

### redis 命令参考
      详见：http://redisdoc.com/
### redis数据类型
    数据类型              存储的值                  读写能力
    String  可以是字符串、整数或浮点，统称为元素    对字符串操作，对整数类型加减
    List  一个序列集合并且每个节点都包含了一个元素  序列从两端推入或弹出元素 修改、查找或移除元素
    Set     各不相同的元素                         从集合中插入或者删除元素
    Hash    有key-value的散列组，其中的key为字符串  按照Key进行增加删除
    SortSet 带分数的score-value有序集合，其中score  集合插入，按照分数范围查找
            为浮点，value为元素                    

    String(字符串) :
        插入元素：set string1 chengy/set string2 4
        获取元素：get string1             
        获取并设置元素：getset string1
        元素拼接：append string1 123
        删除元素: del string1
        对元素递增：incr string2  （对sting2元素加1）
        对元素递减：decrby string2 3  （对string2元素减3）
        同时获取多个值：mget string1 string2
        查看所有的key：keys *
                      keys string1 string2
        判断是否存在:exists key1
        重命名key：rename string1 str1
        设置有效时间：expire newcompany 1000
        查看键值的有效时间：ttl newcompany
        
        查看数据类型：type new company
                     type list1
                     type hash1
    
    List(字符串列表):
        从左边推入元素：lpush list1 12 
                      lpush list1 13 
                      lpush list1 14
        同时添加多个元素: lpush list2 a b cc
                         rpush list2 cc bb aaa
        从右边弹出元素： rpop list1
        查看list中的元素：lrange list2 0 5 
                         lrange list2 0 -1(查看0到最后一个元素)
        查看list中元素的个数：llen list1
        
    Set(字符串集合):
        添加元素: sadd set1 12
                 sadd set1 13
                  sadd set1 14
                  sadd set1 13
        查看set中的元素个数：scard set1
        删除set中的元素：srem set1 13(删除set1中元素13)
        判断元素是否在集合中：sismember set1 13（13是否在set1中） 
    hash(哈希)：
        插入元素：hset hash1 username jack
                 hset hash1 age 24
        同时插入多个元素 hmset hash2 username chengy age 25 
        获取元素：hget hash1 key1
        获取元素个数：hlen hash1
        获取所有元素： hgetall hash1
        同时删除多个元素：hdel hash1 usename age
        同时获取多个元素：hmget hash1 key1 key2 (同时获取key1和key2的值)    
        删除hash列表：del hash1
        属性值增加：hincrby hash1 age 5(hash1中age增加5)
        判断属性是否存在：hexists hash1 username(判断hash1中是否存在usenrame元素)
        获取所有的key：hkeys hash1
        获取所有的值：hvals hash1 
    sort set(有序字符串集合):
        插入元素： zadd zset1 10.1 val1
                  zadd zset1 11.2 val2
                  zadd zset1 9.2 val3
         查看元素个数：zcard zset1
         查看根据分数排名的情况：zrange zset1 0 2 withscrores
         查看元素在set中排名情况：zrank zset1 val2
         更改zset中元素的分值  zadd zset1 12.2 val3 
### redis 特性
    redis多数据库：
       1. 一个redis可以包含多个数据库，默认为0号数据库，最多可以有16个数据库（0~15），
       可以通过select+数据id切换，select 0
      2.则那样在多数据库间交换数据？
        命令：move myset1 1（表示吧当前数据库中的myset1 移到1号数据库） 
        
    reids事物：
        MULTI 、 EXEC 、 DISCARD 和 WATCH 是 Redis 事务的基础       
        事务可以一次执行多个命令， 并且带有以下两个重要的保证：
        1.事务是一个单独的隔离操作：事务中的所有命令都会序列化、按顺序地执行。事务在执行的过程中，不会被其他客户端发送来的命令请求所打断。
        2.事务是一个原子操作：事务中的命令要么全部被执行，要么全部都不执行。
        
        EXEC 命令负责触发并执行事务中的所有命令：
        如果客户端在使用 MULTI 开启了一个事务之后，却因为断线而没有成功执行 EXEC ，那么事务中的所有命令都不会被执行。
        另一方面，如果客户端成功在开启事务之后执行 EXEC ，那么事务中的所有命令都会被执行。
        当使用 AOF 方式做持久化的时候， Redis 会使用单个 write(2) 命令将事务写入到磁盘中。
        然而，如果 Redis 服务器因为某些原因被管理员杀死，或者遇上某种硬件故障，那么可能只有部分事务命令会被成功写入到磁盘中。
        如果 Redis 在重新启动时发现 AOF 文件出了这样的问题，那么它会退出，并汇报一个错误。
        使用 redis-check-aof 程序可以修复这一问题：它会移除 AOF 文件中不完整事务的信息，确保服务器可以顺利启动。
        
        multi用于开启一个事务
        exec 提交
        discard 回滚
        
### redis 持久化
       1.RDB持久化:默认支持，不需要配置,在指定时间隔内把内存中的数据集快照写入到磁盘
       2.AOF持久化:以日志的方式记录服务器所处理的每一个操作，redis启动之初取读取该文件，
    然后重新构建数据库，来保证数据库中的数据是完整的。
       3.无持久化：通过配置禁用redis的持久化功能。（作为缓存）
       4.同时使用RDB和AOF
     
    **RDB**
        优势：所有redis数据都为1个文件，方便备份和恢复。 
              性能最大化比AOF效率高
        劣势：1、保证数据的高可用性，RDB不是很好的选择，在指定时间内的数据还没有存储的时候，服务器出现问题，会造成缓存的数据丢失
              2、采用fork分叉子进程方式来协助持久化操作，当数据集很大的时候可能造成服务器停止几百毫秒或1秒钟。
        配置：  
    **AOF**
        优势：更高的数据安全性。有三种存储方式
                                1.每秒同步，也是异步完成的，会造成1秒内数据的丢失。
                                2.每修改同步
                                3.不同步
              1.在写入过程中出现宕机也不会破坏日志文件中的数据。
              2.在数据写入一半的时候宕机，在下次启动之前可以通过redis-check-aof工具来帮助解决检查数据的一致性问题。
              3.如果日志文件数据过大， redis会启用重写机制，redis 以append模式不断的把修改的数据写入到老的磁盘文件中，同时redis会创建一个新的文件，用于记录此期间
              来产生了哪些修改命令执行了。
              4.aof包含一个格式非常清晰，易于理解的日志文件，用于记录所有的修改操作，可用于这个文件来完成数据的重建。
         劣势：1.相同数量的文件要比RDB文件大
               2.运行效率低于RDB
         配置：appendonly选项设置为yes
               appendsync 配置同步存储方式
         
        
    
        
             
              
                 