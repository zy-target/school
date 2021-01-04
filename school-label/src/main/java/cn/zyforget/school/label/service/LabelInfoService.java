package cn.zyforget.school.label.service;

import cn.zyforget.school.label.entity.LabelInfo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 紫阳
 * @since 2020-08-23
 */
public interface LabelInfoService extends IService<LabelInfo> {

    LabelInfo getOne(Long id);
}
