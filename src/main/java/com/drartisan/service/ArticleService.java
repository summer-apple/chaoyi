package com.drartisan.service;

import com.drartisan.entity.Article;
import com.drartisan.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by summer on 2017/4/19.
 */
public class ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    @Transactional
    public void save(List<Article> articles){
        articleRepository.save(articles);
    }
}
