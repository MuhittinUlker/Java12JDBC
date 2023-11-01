package com.muhittinu;

import com.muhittinu.service.PostService;
import com.muhittinu.service.UserService;

public class Main {
    public static void main(String[] args) {

        UserService userService = new UserService();
//        userService.save();
//
        PostService postService = new PostService();
//        postService.createPost();
        //userService.findByNameAndPostCount("Hasan",6L).forEach(user -> System.out.println(user));
        //System.out.println(userService.allPostsCount());

    }
}