package com.imooc.controller;
import com.imooc.pojo.Users;
import com.imooc.pojo.bo.UserBO;
import com.imooc.service.UserService;
import com.imooc.util.IMOOCJSONResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: lvrb
 * @Date: 2020/11/14 9:31
 * @Description:
 */
@RestController
public class PassportController {
    @Autowired
    UserService userService;

    @GetMapping("/usernameIsExist")
    public IMOOCJSONResult usernamaisExisty(@RequestParam String username){

        if(StringUtils.isBlank(username)){
         return IMOOCJSONResult.errorMsg("用户名为空");
        }
        boolean result=  userService.queryUsernameIsExist(username);
        if(result){
            return IMOOCJSONResult.errorMsg("用户名已存在");
        }
        return  IMOOCJSONResult.ok();
    }

    @PostMapping("/regist")
    public IMOOCJSONResult regist(@RequestBody UserBO userBO){
        String username = userBO.getUsername();
        String password = userBO.getPassword();
        String confirmPwd = userBO.getConfirmPassword();

        // 0. 判断用户名和密码必须不为空
        if (StringUtils.isBlank(username) ||
                StringUtils.isBlank(password) ||
                StringUtils.isBlank(confirmPwd)) {
            return IMOOCJSONResult.errorMsg("用户名或密码不能为空");
        }
        //校验密码长度
        if(password.length()<5){
            return IMOOCJSONResult.errorMsg("密码长度不够");
        }
        //校验密码是否一致
        if(!password.equals(confirmPwd)){
            return IMOOCJSONResult.errorMsg("两次密码不一致");
        }
        //校验用户名不存在
        boolean result=  userService.queryUsernameIsExist(username);
        if(result){
            return IMOOCJSONResult.errorMsg("用户名已存在");
        }
        //判断两次密码是否一致
        return IMOOCJSONResult.ok(userService.createUser(userBO));

    }


}
