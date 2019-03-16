package com.cgm.service;

import com.cgm.service.model.UserModel;

/**
 * @author: CGM
 * @date: 2019/3/15 21:56
 */
public interface UserService {

    UserModel findUserByID( Integer userid);
}
