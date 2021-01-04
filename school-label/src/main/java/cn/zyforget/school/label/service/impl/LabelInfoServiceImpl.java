package cn.zyforget.school.label.service.impl;

import cn.zyforget.school.label.entity.LabelInfo;
import cn.zyforget.school.label.mapper.LabelInfoMapper;
import cn.zyforget.school.label.service.LabelInfoService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 紫阳
 * @since 2020-08-23
 */
@Service
public class LabelInfoServiceImpl extends ServiceImpl<LabelInfoMapper, LabelInfo> implements LabelInfoService {

    @Autowired
    private LabelInfoMapper mapper;

    @Override
    public LabelInfo getOne(Long id) {
        return mapper.getOne(id);
    }
}
