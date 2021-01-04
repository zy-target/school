package cn.zyforget.school.label.mapper;

import cn.zyforget.school.label.entity.LabelInfo;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 紫阳
 * @since 2020-08-23
 */
@Mapper
public interface LabelInfoMapper extends BaseMapper<LabelInfo> {

    LabelInfo getOne(Long id);
}
