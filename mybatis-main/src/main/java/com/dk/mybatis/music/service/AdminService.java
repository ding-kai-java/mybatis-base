package com.dk.mybatis.music.service;

import com.dk.mybatis.core.common.util.PageUtils;
import com.dk.mybatis.music.entity.Admin;
import com.baomidou.mybatisplus.extension.service.IService;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author dk
 * @since 2020-08-25
 */
public interface AdminService extends IService<Admin> {

    /**
     * 分页查询
     * @param params
     * @return
     */
     PageUtils queryPage(Map<String, Object> params);
}
