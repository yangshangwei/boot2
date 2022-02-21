package com.artisan.vo;

import com.artisan.customvalidator.EnumString;
import com.artisan.group.CustomValidateGroup;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;

/**
 * @author 小工匠
 * @version 1.0
 * @mark: show me the code , change the world
 */


@Data
public class Artisan {

    private String id;


    @NotEmpty(message = "Code不能为空")
    private String code;

    @NotBlank(message = "名字为必填项")
    private String name;


        @Length(min = 8, max = 12, message = "password长度必须位于8到12之间")
        @NotNull(groups = CustomValidateGroup.Crud.Create.class,message = "新增接口密码不能为空")
        @Null(groups = CustomValidateGroup.Crud.Update.class)
        private String password;


    @Email(message = "请填写正确的邮箱地址")
    private String email;


    @EnumString(value = {"F", "M"}, message = "性别只允许为F或M")
    private String sex;


}
    