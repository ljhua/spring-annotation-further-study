package me.junhua.service.impl;

import me.junhua.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public void saveUser() {
        System.out.println(" 实现了用户保存 ");
    }
}
