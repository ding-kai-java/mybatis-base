package com.dk.mybatis.music.service.impl;

import com.dk.mybatis.core.common.util.PageUtils;
import com.dk.mybatis.core.common.util.Query;
import com.dk.mybatis.music.entity.Admin;
import com.dk.mybatis.music.mapper.AdminMapper;
import com.dk.mybatis.music.service.AdminService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author dk
 * @since 2020-08-25
 */
@Service
@Slf4j
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements AdminService {

    /**
     * 分页查询
     * @param params
     * @return
     */
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<Admin> page=baseMapper.selectPage(new Query<Admin>(params).getPage(),
                new QueryWrapper<Admin>().lambda());
        return new PageUtils(page);
    }

}
