package com.czy;

import lombok.Data;

import java.util.Random;

/**
 * 用户
 *
 * @author caizy
 * @date 2020/1/15 14:10
 **/
@Data
public class User {

    private String userName;
    private String sex;
    private String mobile;

    public int zslRandomLevel() {
        int level = 1;
        while ((new Random().nextInt()&0xFFFF) < (0.25 * 0xFFFF))
            level += 1;
        return (level<32) ? level : 32;
    }

    public static void main(String[] args) {
        User user = new User();
        for(int i = 0 ;i<32;i++){
            System.out.println(user.zslRandomLevel());
        }
    }

}
