package com.fujie.edu.service;

import cn.edu.niit.dao.LoginDao;
import cn.edu.niit.dao.RegisterDao;
import cn.edu.niit.javabean.User;

import java.sql.SQLException;

/**
 * @program: Library
 * @ClassName: RegisterService
 * @description: Test
 * @author: Cai
 * @create: 2021-03-23 01:32
 **/
public class RegisterService {
    private RegisterDao registerDao=new RegisterDao();
    LoginDao loginDao = new LoginDao();

    public String  register(User register) throws SQLException {
            String result=String.valueOf(registerDao.register(register));

         if (result.equals("0")){
            return "注册失败";
        }else {
                return "注册成功";
            }
        }

    }



