package com.cgm.service.impl;

import com.cgm.dao.UserDOMapper;
import com.cgm.dao.UserPasswordDOMapper;
import com.cgm.pojo.UserDO;
import com.cgm.pojo.UserPasswordDO;
import com.cgm.service.UserService;
import com.cgm.service.model.UserModel;
import org.apache.catalina.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: CGM
 * @date: 2019/3/15 21:56
 */

@Service
public class UserServiceImpl  implements UserService {
    @Autowired
    private UserDOMapper userDOMapper;

    @Autowired
    private UserPasswordDOMapper userPasswordDOMapper;


    private  UserModel converFromUser(UserDO userDO,UserPasswordDO userPasswordDO){
        if(userDO==null){
            return null;
        }
        UserModel ss=new UserModel();
        BeanUtils.copyProperties(userDO,ss);

        if(userPasswordDO!=null){
            ss.setEncrptPassword(userPasswordDO.getEncrptPassword());
        }

        return  ss;
    }
    @Override
    public UserModel findUserByID(Integer userid) {

        UserDO userModel=userDOMapper.selectByPrimaryKey(userid);

        if(userModel==null){
            return  null;
        }

        UserPasswordDO userPasswordDO=userPasswordDOMapper.selectByUserID(userModel.getId());
        return converFromUser(userModel,userPasswordDO);
    }
}
