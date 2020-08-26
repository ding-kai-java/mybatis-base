package com.dk.mybatis.core.dept.controller;

import com.dk.mybatis.core.common.Result;
import com.dk.mybatis.core.common.base.AbstractController;
import com.dk.mybatis.core.common.util.PageUtils;
import com.dk.mybatis.core.common.validator.ValidatorUtils;
import com.dk.mybatis.core.dept.entity.Dept;
import com.dk.mybatis.core.dept.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wh
 * @since 2019-06-28
 */
@RestController
@Slf4j
@RequestMapping("/admin/dept")
public class DeptController extends AbstractController {
    @Autowired
    private DeptService deptService;

    /**
     * 列表
     */
    @GetMapping("/list")
    public Result list(@RequestParam Map<String, Object> params){
        PageUtils page = deptService.queryPage(params);

        return Result.ok().put("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    public Result info(@PathVariable("id") String id){
       Dept dept = deptService.getById(id);

        return Result.ok().put("mapper/dept", dept);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    public Result save(@RequestBody Dept dept){
        ValidatorUtils.validateEntity(dept);
        deptService.save(dept);

        return Result.ok();
    }

    /**
     * 修改
     */
    @PutMapping("/update")
    public Result update(@RequestBody Dept dept){
        ValidatorUtils.validateEntity(dept);
        deptService.updateById(dept);
        return Result.ok();
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete")
    public Result delete(@RequestBody String[] ids){
        deptService.removeByIds(Arrays.asList(ids));

        return Result.ok();
    }
}
