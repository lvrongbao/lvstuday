package com.imooc.pojo.bo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户新增或修改地址的BO
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddressBO {

    private String addressId;

    private String userId;
    private String receiver;
    private String mobile;
    private String province;
    private String city;
    private String district;
    private String detail;

}
