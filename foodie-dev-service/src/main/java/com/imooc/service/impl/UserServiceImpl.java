package com.imooc.service.impl;

import com.imooc.pojo.Users;
import com.imooc.pojo.bo.UserBO;
import com.imooc.service.UserService;

import com.imooc.mapper.UsersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

/**
 * @Author: lvrb
 * @Date: 2020/11/13 14:13
 * @Description:
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    public UsersMapper usersMapper;

    @Override
    public boolean queryUsernameIsExist(String username) {
        Example userExample = new Example(Users.class);
        Example.Criteria userCriteria = userExample.createCriteria();
        userCriteria.andEqualTo("username", username);
        Users result = usersMapper.selectOneByExample(userExample);

        return result == null ? false : true;
    }

    @Override
    public Users createUser(UserBO userBO) {
        return null;
    }

    @Override
    public Users queryUserForLogin(String username, String password) {
        return null;
    }
}
