package com.cgm;

import com.cgm.dao.UserDOMapper;
import com.cgm.pojo.UserDO;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@RestController
@MapperScan("com.cgm.dao")
public class App
{
    @Autowired
    private UserDOMapper userDOMapper;

    @RequestMapping("/one")
    public UserDO getOne(){
        UserDO userDO=userDOMapper.selectByPrimaryKey(1);
        return  userDO;

    }
    @RequestMapping("/")
    public  String qq(){
        return "heoll";
    }
    public static void main( String[] args )
    {
        SpringApplication.run(App.class,args);
    }
}
