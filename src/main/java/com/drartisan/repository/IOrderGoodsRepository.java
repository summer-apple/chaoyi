package com.drartisan.repository;

import com.drartisan.entity.OrderGoods;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by summer on 2017/4/25.
 */
public interface IOrderGoodsRepository extends CrudRepository<OrderGoods,String> {
}
