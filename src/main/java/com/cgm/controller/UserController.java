package com.cgm.controller;

import com.cgm.controller.viewPojo.UserVO;
import com.cgm.dao.UserDOMapper;
import com.cgm.service.UserService;
import com.cgm.service.model.UserModel;
import com.cgm.utils.Result;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Random;

/**
 * @author: CGM
 * @date: 2019/3/15 21:54
 */
@Controller
@RequestMapping("/user")

@CrossOrigin
public class UserController   extends  BaseController{

    @Autowired
    private UserService userService;

    @Autowired
    private HttpServletRequest httpServletRequest;
public  Result register(){

    return  null;
}

    @RequestMapping(value = "/getOtp",method ={RequestMethod.POST},consumes =CONTENT_TYPE_FROMED )
    @ResponseBody
    public  Result get0tp(String telphone){
        //生成OTP验证码
        Random random=new Random();

        int randomInt=random.nextInt(99999);
        randomInt+=10000;
        String otpCode=String.valueOf(randomInt);

        //将OTP验证码同对应用户的手机号关联，一般放到到redis中
        httpServletRequest.getSession().setAttribute(telphone,otpCode);

        //将OTP验证码通过短信通知手机用户
        System.out.println("telphone="+telphone+"&code="+otpCode);

        return  Result.creat(null);
    }


    @RequestMapping("/findOne")
    @ResponseBody
    public Result findUserById(Integer id){
        UserModel userModel=userService.findUserByID(id);
        return Result.creat(userModel);
    }
    /**
     * 转换模型
     * @param userModel
     * @return
     */
    private UserVO convertFromUserModel(UserModel userModel){

        if(userModel==null){
            return  null;
        }
        UserVO userVO=new UserVO();
        BeanUtils.copyProperties(userModel,userVO);

        return  userVO;

    }


}
