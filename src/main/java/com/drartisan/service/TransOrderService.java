package com.drartisan.service;

import com.drartisan.entity.TransOrder;
import com.drartisan.repository.ITransOrderRepository;
import com.drartisan.service.Interface.ITransOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;

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
public class TransOrderService implements ITransOrderService {


    @Autowired
    ITransOrderRepository iTransOrderRepository;

    @Override
    public TransOrder createTransOrder(TransOrder transOrder) {
        return iTransOrderRepository.save(transOrder);
    }

    @Override
    public TransOrder updateTransOrder(String orderId, String state) {
        TransOrder transOrder= iTransOrderRepository.findOne(orderId);
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




    /**
     * @Test
    public void testSpecificaiton2() {
    //第一个Specification定义了两个or的组合
    Specification<Student> s1 = new Specification<Student>() {
    @Override
    public Predicate toPredicate(Root<Student> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
    Predicate p1 = criteriaBuilder.equal(root.get("id"),"2");
    Predicate p2 = criteriaBuilder.equal(root.get("id"),"3");
    return criteriaBuilder.or(p1,p2);
    }
    };
    //第二个Specification定义了两个or的组合
    Specification<Student> s2 = new Specification<Student>() {
    @Override
    public Predicate toPredicate(Root<Student> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
    Predicate p1 = criteriaBuilder.like(root.get("address"),"zt%");
    Predicate p2 = criteriaBuilder.like(root.get("name"),"foo%");
    return criteriaBuilder.or(p1,p2);
    }
    };
    //通过Specifications将两个Specification连接起来，第一个条件加where，第二个是and
    List<Student> stus = studentSpecificationRepository.findAll(Specifications.where(s1).and(s2));

    Assert.assertEquals(1,stus.size());
    Assert.assertEquals(3,stus.get(0).getId());
    }

    select * from t_student where (id=2 or id=3) and (address like 'zt%' and name like 'foo%')
     */




}
