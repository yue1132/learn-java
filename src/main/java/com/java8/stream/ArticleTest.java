package com.java8.stream;

import java.util.*;
import java.util.stream.Collectors;

public class ArticleTest {

    /**
     * 获取文章集合
     *
     * @return 所有文章对象集合的List
     */
     static List<Article> getArticles() {
        List<Article> articles = new ArrayList<>();

        Article article1 = new Article("深入理解Java虚拟机", "周志明", Arrays.asList("Java", "Jvm"));
        Article article7 = new Article("Java虚拟机", "周志明", Arrays.asList("Java", "Jvm"));
        Article article2 = new Article("Java核心技术 卷Ⅱ", "凯S.霍斯特曼", Arrays.asList("Java","JavaEE"));
        Article article3 = new Article("少年中国说", "梁启超", Arrays.asList("china", "literature"));
        Article article4 = new Article("Vim实用技巧", "Drew Neil", Arrays.asList("vim","Editor"));
        Article article5 = new Article("锋利的SQL", "张洪举", Arrays.asList("sql", "database"));
        Article article6 = new Article("Java RESTful Web Service实战", "韩陆", Arrays.asList("Java", "restful"));

        articles.add(article1);
        articles.add(article2);
        articles.add(article3);
        articles.add(article4);
        articles.add(article5);
        articles.add(article6);
        articles.add(article7);

        System.out.println("================Articles:==================");
        System.out.println(articles);
        return articles;
    }

    /**
     * 在集合中查找包含“Java”标签的第一篇文章
     *
     * @return 返回包含“Java”标签的第一个文章对象
     */
    public static Article getFirstJavaArticle() {
        List<Article> articles = getArticles();
        System.out.println("================GetFirstJavaArticle计算结果==================");
        //传统方式：
        /* for (Article article : articles) {
            if (article.getTags().toString().toLowerCase().contains("java")) {
                return article;
            }
        }
        return null; */
        //实用Java8新语法
//        List<Article> list = articles.stream().filter(article -> article.getTags().contains("Java")).collect(Collectors.toList());
        Optional<Article> optional = articles.stream().filter(article -> article.getTags().contains("Java")).findFirst();
        if (optional.isPresent()) {
            return optional.get();
        }
        return null;
    }

    /**
     * 根据作者把所有文章分组
     *
     * @return 返回根据作者分组的map集合
     */
    public static Map<String, List<Article>> groupByAuthor() {
        List<Article> articles = getArticles();
        Map<String, List<Article>> result = new HashMap<>();
        //传统方式
/*        for (Article article : articles) {
            if (result.containsKey(article.getAuthor())) {
                result.get(article.getAuthor()).add(article);
            } else {
                List<Article> list = new ArrayList<>();
                list.add(article);
                result.put(article.getAuthor(), list);
            }
        }*/
        //使用stream.collect
        result = articles.stream().collect(Collectors.groupingBy(Article::getAuthor));
        System.out.println("================GroupByAuthor==================");
        return result;
    }

    /**
     * 查找集合中所有不同的标签
     *
     * @return 所有的标签集合
     */
    public static Set<String> getDistinctTags() {
        List<Article> articles = getArticles();
        Set<String> result = new HashSet<>();
        System.out.println("================GetDistinctTags==================");
        //传统方式
//        for(Article article : articles){
//            result.addAll(article.getTags());
//        }
        //使用flatmap 帮我们把标签转换为一个返回流，然后使用collect去创建一个集合作为返回值
        result = articles.stream()
                .flatMap(article -> article.getTags().stream())
                .collect(Collectors.toSet());


        return result;
    }


    public static void main(String[] args) {
//        System.out.println("getFirstJavaArticle:" + ArticleTest.getFirstJavaArticle());

        Map<String, List<Article>> stringListMap = ArticleTest.groupByAuthor();
        stringListMap.entrySet().stream().forEach(System.out::println);

        System.out.println(getDistinctTags());

        List<Article> articles = getArticles();

        articles.forEach(item -> {
            if("C".equals(item)){
                System.out.println(item);
            }
        });


        System.out.println("================Arrays ForEach==================");
        List<String> list = Arrays.asList("AB", "Cake", "Cup", "C", "AA","C");
        list.stream()
                .filter(i -> "C".equals(i))
                .forEach(System.out::println);
        list.forEach(item -> {
            if("C".equals(item)){
                System.out.println("forEach +if:"+item);
            }
        });
        Map<String, String> collect = articles.stream().collect(Collectors.toMap(Article::getTitle, Article::getAuthor));
        System.out.println("================Map==================");

//        collect.forEach((a,b) -> System.out.println("key:" + a +",value=" +b));
    }

}
