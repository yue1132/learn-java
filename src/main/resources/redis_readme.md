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
    make 
    make install
### redis启动
    redis-server -h 127.0.0.1 -p 6379
    redis-cli 

### redis数据类型
    数据类型              存储的值                  读写能力
    String  可以是字符串、整数或浮点，统称为元素    对字符串操作，对整数类型加减
    List  一个序列集合并且每个节点都包含了一个元素  序列从两端推入或弹出元素 修改、查找或移除元素
    Set     各不相同的元素                         从集合中插入或者删除元素
    Hash    有key-value的散列组，其中的key为字符串  按照Key进行增加删除
    SortSet 带分数的score-value有序集合，其中score  集合插入，按照分数范围查找
            为浮点，value为元素                    

    String :
        插入元素：set string1 chengy/set string2 4
        获取元素：get string1             
        对元素递增：incr string2  （对sting2元素加1）
        对元素递减：decrby string2 3  （对string2元素减3）
    
    List:
        从左边推入元素：lpush list1 12 
                      lpush list1 13 
                      lpush list1 14
        从右边弹出元素： rpop list1
        
        查看list中元素的个数：llen list1
        
    Set:
        添加元素: sadd set1 12
                 sadd set1 13
                  sadd set1 14
                  sadd set1 13
        查看set中的元素个数：scard set1
        删除set中的元素：srem set1 13(删除set1中元素13)
        判断元素是否在集合中：sismember set1 13（13是否在set1中） 
    hash：
        插入元素：hset hash1 key1 12
                 hset hash1 key2 14
                 hset hash2 key3 18
        获取元素：hget hash1 key1
        获取元素个数：hlen hash1
        同时获取多个元素：hmget hash1 key1 key2 (同时获取key1和key2的值)    
    sort set:
        插入元素： zadd zset1 10.1 val1
                  zadd zset1 11.2 val2
                  zadd zset1 9.2 val3
         查看元素个数：zcard zset1
         查看根据分数排名的情况：zrange zset1 0 2 withscrores
         查看元素在set中排名情况：zrank zset1 val2
         更改zset中元素的分值  zadd zset1 12.2 val3 
         
      
         