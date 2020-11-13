package com.imooc.pojo.bo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: lvrb
 * @Date: 2020/11/13 14:07
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserBO {
    private String username;
    private String password;
    private String confirmPassword;
}
