package com.drartisan.repository;

import com.drartisan.entity.Category;
import com.drartisan.entity.Goods;
import org.omg.CORBA.Object;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by summer on 2017/4/25.
 */
public interface ICategoryRepository extends JpaRepository<Category,Integer>,JpaSpecificationExecutor<Category> {

}
