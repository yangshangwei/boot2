package com.artisan.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

/**
 * @author 小工匠
 * @version 1.0
 * @mark: show me the code , change the world
 */


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Artisan {

    private String id;


    @NotEmpty(message = "Code不能为空")
    private String code;

    @NotBlank(message = "名字为必填项")
    private String name;


    @Length(min = 8, max = 12, message = "password长度必须位于8到12之间")
    private String password;


    @Email(message = "请填写正确的邮箱地址")
    private String email;


    private String sex;

    private String phone;

}
    