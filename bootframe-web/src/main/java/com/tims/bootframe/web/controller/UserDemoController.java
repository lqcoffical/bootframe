package com.tims.bootframe.web.controller;

import com.tims.bootframe.biz.service.UserDemoService;
import com.tims.bootframe.biz.service.impl.UserDemoServiceImpl;
import com.tims.bootframe.common.front.BaseResponse;
import com.tims.bootframe.common.front.PageResponse;
import com.tims.bootframe.dao.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserDemoController {

    @Autowired
    private UserDemoService userDemoService;

    /**
     * 可以顺着写，没有的方法就在service层的接口和实现类自动创建
     *
     * @return
     */
    @GetMapping("/all")
    public BaseResponse<?> getAllUsers() {
        List<User> userList = userDemoService.selectAllUsers();
        return BaseResponse.success(userList);
    }

    /**
     * 分页查询user
     * @RequestParam注解起到一个前端传参名字和后端映射的作用，如果后端方法签名形参和前端写的一样，可以不写这个注解。如果不一样，name属性或者value属性要写前端的参数名
     * name和value属性互为别名，如果只指定value的值的话，value= 可以省略不写
     * @RequestParam也不用管前端传的是什么类型，比如string能转成int
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping("/page")
    public PageResponse<?> getUsersByPage(@RequestParam(name = "pageNum", defaultValue = "1") Integer pageNum,
                                          @RequestParam(name = "pageSize", defaultValue = "5") Integer pageSize) {
        return userDemoService.getUsersByPage(pageNum, pageSize);
    }

    @GetMapping("/pageHelper")
    public PageResponse<?> getUsersByPageHelper(@RequestParam(name = "pageNum", defaultValue = "1") Integer pageNum,
                                          @RequestParam(name = "pageSize", defaultValue = "5") Integer pageSize) {
        return userDemoService.getUsersByPageHelper(pageNum, pageSize);
    }

    @GetMapping("/mbPlus")
    public PageResponse<?> getUsersByMbPlus(@RequestParam(name = "pageNum", defaultValue = "1") Integer pageNum,
                                                @RequestParam(name = "pageSize", defaultValue = "5") Integer pageSize) {
        return userDemoService.getUsersByMbPlus(pageNum, pageSize);
    }


}
