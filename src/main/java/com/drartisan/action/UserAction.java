//package com.drartisan.action;
//
//import com.drartisan.entity.User;
//import com.drartisan.service.impl.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
///**
// * @Controller
// @RequestMapping("/rest")
// public class RestController {
// @RequestMapping(value="/user/{id}",method=RequestMethod.GET)
// public String get(@PathVariable("id") Integer id){
// System.out.println("get"+id);
// return "/hello";
// }
//
// @RequestMapping(value="/user/{id}",method=RequestMethod.POST)
// public String post(@PathVariable("id") Integer id){
// System.out.println("post"+id);
// return "/hello";
// }
//
// @RequestMapping(value="/user/{id}",method=RequestMethod.PUT)
// public String put(@PathVariable("id") Integer id){
// System.out.println("put"+id);
// return "/hello";
// }
//
// @RequestMapping(value="/user/{id}",method=RequestMethod.DELETE)
// public String delete(@PathVariable("id") Integer id){
// System.out.println("delete"+id);
// return "/hello";
// }
//
// */
//
///**
// * Created by summer on 16-8-11.
// */
//@RestController
//@RequestMapping("/user")
//public class    UserAction {
//
//    @Autowired
//    UserService userService;
//
//
//    /**
//     *  非restful参数传递
//     * @param name
//     * @return
//     */
//    @RequestMapping("/test")
//    public String test(String name){
//        return "Hello " + name;
//    }
//
//    @RequestMapping("/get-user")
//    public User getUserById(int id){
//        return userService.getById(id);
//    }
//
//
//    @RequestMapping("/login")
//    public User login(String username, String password){
//        return userService.login(username,password);
//    }
//
//
//    @RequestMapping("/update")
//    public boolean update(int id,String username, String password){
//        return userService.update(new User(id,username,password));
//    }
//
//    @RequestMapping("/register")
//    public int register(User user){
//        return userService.register(user);
//    }
//
//
//}
//
//
