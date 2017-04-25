package com.drartisan.repository;

import com.drartisan.entity.Goods;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by summer on 2017/4/25.
 */
public interface IGoodsRepository extends CrudRepository<Goods,Integer> {
}
