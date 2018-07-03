package com.zhumeng.uimei.service;

import java.util.List;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhumeng.uimei.mapper.User1Mapper;
import com.zhumeng.uimei.model.UserEntity;

@Slf4j
@Service
public class User1Service {

    @Autowired
    private User1Mapper user1Mapper;

    public List<UserEntity> getUsers() {
        List<UserEntity> users=user1Mapper.getAll();
        return users;
    }

    public List<UserEntity> findByParams(UserEntity user) {
        List<UserEntity> users=user1Mapper.findByParams(user);
        return users;
    }
    
//    @Transactional(value="test1TransactionManager",rollbackFor = Exception.class,timeout=36000)  //说明针对Exception异常也进行回滚，如果不标注，则Spring 默认只有抛出 RuntimeException才会回滚事务
    public void updateTransactional(UserEntity user) {
        try{
            user1Mapper.insert(user);
        System.err.println((String.valueOf(user)));
        }catch(Exception e){
        	System.err.println("find exception!");
            throw e;   // 事物方法中，如果使用trycatch捕获异常后，需要将异常抛出，否则事物不回滚。
        }

    }
}

