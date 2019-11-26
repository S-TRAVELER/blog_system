package com.blog.component;

import org.springframework.stereotype.Component;

/**
 * @author: blanche
 * @Date: 2019/11/11 10:26
 * Describe: 手机验证码随机生成
 */
@Component
public class PhoneRandomBuilder {

    public static String randomBuilder(){

        String result = "";
        for(int i=0;i<4;i++){
            result += Math.round(Math.random() * 9);
        }

        return result;

    }

}
