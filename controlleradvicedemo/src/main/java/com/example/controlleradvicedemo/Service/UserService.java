package com.example.controlleradvicedemo.Service;

import com.example.controlleradvicedemo.Entity.User;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class UserService {

    public User getUser() {
        User user = new User();
        user.setAge(11);
        user.setName("xiaoming");
        return user;
    }

    // 随机数测试返回正常结果和异常
    public User throwException() throws Exception{
        User user = new User();
        user.setAge(11);
        user.setName("xiaoming");
        Random r = new Random();
        int i = r.nextInt();
        System.out.println("i = " + i);
        if (i % 2 == 0) {
            return user;
        }
        throw new Exception("error in user service");
    }

}
