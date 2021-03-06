package com.zhumeng.uimei.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zhumeng.uimei.model.UserEntity;
import com.zhumeng.uimei.model.UserSexEnum;
import com.zhumeng.uimei.service.User1Service;

//@Service
@RestController
public class UserController {

    @Autowired
    private User1Service user1Service;

    @RequestMapping("/getUsers")
    public List<UserEntity> getUsers() {
        List<UserEntity> users=user1Service.getUsers();
        return users;
    }
    
    @RequestMapping("/findByParams")
    public List<UserEntity> findByParams(UserEntity user) {
        List<UserEntity> users=user1Service.findByParams(user);
        return users;
    }
    

    //测试
    @RequestMapping(value="update1")
    public String updateTransactional(@RequestParam(value = "id") Long id,
                                    @RequestParam(value = "user_id") Long user_id,
                                    @RequestParam(value = "order_id") Long order_id,
                                    @RequestParam(value = "nickName") String nickName,
                                    @RequestParam(value = "passWord") String passWord,
                                    @RequestParam(value = "userName") String userName
                                    ) {
        UserEntity user2 = new UserEntity();
        user2.setId(id);
        user2.setUser_id(user_id);
        user2.setOrder_id(order_id);
        user2.setNickName(nickName);
        user2.setPassWord(passWord);
        user2.setUserName(userName);
        user2.setUserSex(UserSexEnum.WOMAN);
        user1Service.updateTransactional(user2);
        return "test";
    }
}

