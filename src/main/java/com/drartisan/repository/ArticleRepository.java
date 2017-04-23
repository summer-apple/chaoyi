package com.drartisan.repository;

import com.drartisan.entity.Article;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by summer on 2017/4/19.
 */
public interface ArticleRepository extends CrudRepository<Article,Integer> {
    
}
