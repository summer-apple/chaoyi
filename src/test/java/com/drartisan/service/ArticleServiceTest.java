package com.drartisan.service;

/**
 * Created by summer on 2017/4/17.
 */
import com.drartisan.entity.Article;
import com.drartisan.entity.User;
import com.drartisan.repository.ArticleRepository;
import com.drartisan.repository.UserRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class ArticleServiceTest {

    private ApplicationContext ctx = null;
    private ArticleRepository articleRepository = null;

    @Before
    public void setup() {
        ctx = new ClassPathXmlApplicationContext("spring.xml");
        articleRepository = (ArticleRepository)ctx.getBean("articleRepository");
        System.out.println("setup");
    }

    @After
    public void tearDown() {
        ctx = null;
        System.out.println("tearDown");
    }


    @Test
    public void testSave(){
        List<Article> articles = new ArrayList<>();
        Article article = null;

        for (int i=1; i<100; i++){
            article = new Article();
            article.setId(i);
            article.setTitle("test"+i);
            article.setAuthor(100-i);

            System.out.println(article.getId()+" "+article.getTitle());
            articles.add(article);
        }

        articleRepository.save(articles);
    }


    
}
