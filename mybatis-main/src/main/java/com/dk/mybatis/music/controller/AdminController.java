package com.dk.mybatis.music.controller;

import com.dk.mybatis.core.common.Result;
import com.dk.mybatis.core.common.util.PageUtils;
import com.dk.mybatis.core.common.validator.ValidatorUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Arrays;
import java.util.Map;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.dk.mybatis.music.entity.Admin;
import com.dk.mybatis.music.service.AdminService;
import org.springframework.web.bind.annotation.RestController;
import com.dk.mybatis.core.common.base.AbstractController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author dk
 * @since 2020-08-25
 */
@RestController
@Slf4j
@RequestMapping("/admin/music/admin")
public class AdminController extends AbstractController {
    @Autowired
    private AdminService adminService;

    /**
     * 列表
     */
    @GetMapping("/list")
    @RequiresPermissions("music:admin:list")
    public Result list(@RequestParam Map<String, Object> params){
        PageUtils page = adminService.queryPage(params);

        return Result.ok().put("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    @RequiresPermissions("music:admin:info")
    public Result info(@PathVariable("id") String id){
       Admin admin = adminService.getById(id);

        return Result.ok().put("admin", admin);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    @RequiresPermissions("music:admin:save")
    public Result save(@RequestBody Admin admin){
        ValidatorUtils.validateEntity(admin);
        adminService.save(admin);

        return Result.ok();
    }

    /**
     * 修改
     */
    @PutMapping("/update")
    @RequiresPermissions("music:admin:update")
    public Result update(@RequestBody Admin admin){
        ValidatorUtils.validateEntity(admin);
        adminService.updateById(admin);
        return Result.ok();
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete")
    @RequiresPermissions("music:admin:delete")
    public Result delete(@RequestBody String[] ids){
        adminService.removeByIds(Arrays.asList(ids));

        return Result.ok();
    }
}
