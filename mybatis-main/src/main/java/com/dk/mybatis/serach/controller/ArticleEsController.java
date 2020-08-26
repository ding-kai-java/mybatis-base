package com.dk.mybatis.serach.controller;

import com.dk.mybatis.core.common.Result;
import com.dk.mybatis.core.dept.entity.Dept;
import com.dk.mybatis.core.dept.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/article")
public class ArticleEsController {

    @Autowired
    private DeptService deptService;

    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    public Result info(@PathVariable("id") String id){
        Dept dept = deptService.getById(id);

        return Result.ok().put("mapper/dept", dept);
    }

}