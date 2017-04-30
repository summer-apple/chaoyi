package com.drartisan.service;

import com.drartisan.entity.TransOrder;
import com.drartisan.repository.ITransOrderRepository;
import com.drartisan.repository.jpaUtils.Criteria;
import com.drartisan.repository.jpaUtils.Criterion;
import com.drartisan.repository.jpaUtils.Restrictions;
import com.drartisan.service.Interface.ITransOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by summer on 2017/4/27.
 */
@Service
public class TransOrderService implements ITransOrderService {


    @Autowired
    ITransOrderRepository iTransOrderRepository;

    @Override
    public TransOrder createTransOrder(TransOrder transOrder) {
        return iTransOrderRepository.save(transOrder);
    }

    @Override
    public TransOrder updateTransOrder(String orderId, String state) {
        TransOrder transOrder = iTransOrderRepository.findOne(orderId);
        transOrder.setState(state);
        return iTransOrderRepository.save(transOrder);
    }

    @Override
    public void deleteTransOrder(String orderId) {
        iTransOrderRepository.delete(orderId);
    }

    @Override
    public TransOrder getOrderById(String orderId) {
        return iTransOrderRepository.findOne(orderId);
    }

    @Override
    public Page<TransOrder> getOrderByMainStore(int mainStoreId, int page, int size) {

        List<Sort.Order> orders = new ArrayList<>();
        Sort.Order order1 = new Sort.Order(Sort.Direction.DESC,"state");
        Sort.Order order2 = new Sort.Order(Sort.Direction.DESC,"orderId");
        orders.add(order1);
        orders.add(order2);

        Sort sort = new Sort(orders);

        Pageable pageable = new PageRequest(page-1,size,sort);

        return iTransOrderRepository.findByMainStoreId(mainStoreId, pageable);
    }

    @Override
    public Page<TransOrder> getOrderByBranchStore(int branchStoreId, int page, int size) {

        List<Sort.Order> orders = new ArrayList<>();
        Sort.Order order1 = new Sort.Order(Sort.Direction.DESC,"state");
        Sort.Order order2 = new Sort.Order(Sort.Direction.DESC,"orderId");
        orders.add(order1);
        orders.add(order2);

        Sort sort = new Sort(orders);

        Pageable pageable = new PageRequest(page-1,size,sort);

        return iTransOrderRepository.findByBranchStoreId(branchStoreId, pageable);
    }

    @Override
    public Page<TransOrder> getOrderByConditions(HashMap<String, Object> conditions, int page, int size) {

        Specification<TransOrder> s1 = new Specification<TransOrder>() {
            @Override
            public Predicate toPredicate(Root<TransOrder> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                return null;
            }
        };
        Sort sort =  new Sort(new Sort.Order(Sort.Direction.DESC,"orderId"));
        Page<TransOrder> transOrders = iTransOrderRepository.findAll(Specifications.where(s1),new PageRequest(page-1,size,sort));
        return null;
    }

    public Page<TransOrder> getOrderByConditions2(HashMap<String, Object> conditions, int page, int size) {

        Criteria<TransOrder> criteria = new Criteria<TransOrder>();
        criteria.add(Restrictions.eq("mainStoreId",1,true));
        criteria.add(Restrictions.and(Restrictions.gt("totalPrice",1250,true)));
        Sort sort =  new Sort(new Sort.Order(Sort.Direction.DESC,"orderId"));

        return iTransOrderRepository.findAll(criteria,new PageRequest(page-1,size,sort));

    }





//    Criteria<UserEntity> criteria = new Criteria<UserEntity>();
//
//criteria.add(Restrictions.like("name", cond.getName()));
//criteria.add(Restrictions.gt("age", cond.getAge()));
//
//criteria.add(Restrictions.or(Restrictions.gt("salary", cond.getSalary()),
//        Restrictions.eq("dept", cond.getDept())));






}
