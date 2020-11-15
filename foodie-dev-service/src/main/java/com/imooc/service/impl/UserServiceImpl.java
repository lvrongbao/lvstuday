package com.imooc.service.impl;


import com.imooc.enums.Sex;
import com.imooc.org.n3r.idworker.Sid;
import com.imooc.pojo.Users;
import com.imooc.pojo.bo.UserBO;
import com.imooc.service.UserService;

import com.imooc.mapper.UsersMapper;
import com.imooc.util.DateUtil;
import com.imooc.util.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;

/**
 * @Author: lvrb
 * @Date: 2020/11/13 14:13
 * @Description:
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    public UsersMapper usersMapper;
    @Autowired
   public Sid sid;

    private static final String USER_FACE = "D:/img/1.jpg";

    @Transactional(propagation = Propagation.SUPPORTS)
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
        String id=sid.nextShort();
         Users user= new Users();
         user.setId(id);
         try {
             user.setPassword(MD5Utils.getMD5Str(userBO.getPassword()));
         }catch (Exception e){
             e.printStackTrace();
         }
         user.setUsername(userBO.getUsername());
        // 默认头像
        user.setFace(USER_FACE);
        // 默认生日
        user.setBirthday(DateUtil.stringToDate("1900-01-01"));
        // 默认性别为 保密
        user.setSex(Sex.secret.type);
        user.setCreatedTime(new Date());
        user.setUpdatedTime(new Date());

        usersMapper.insert(user);

        return user;
    }

    @Override
    public Users queryUserForLogin(String username, String password) {
        Example userExample = new Example(Users.class);
        Example.Criteria userCriteria = userExample.createCriteria();

        userCriteria.andEqualTo("username", username);
        userCriteria.andEqualTo("password", password);

        Users result = usersMapper.selectOneByExample(userExample);

        return result;
    }
}
