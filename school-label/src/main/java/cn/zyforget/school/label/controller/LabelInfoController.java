package cn.zyforget.school.label.controller;


import cn.zyforget.school.label.entity.LabelInfo;
import cn.zyforget.school.label.service.LabelInfoService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author 紫阳
 * @since 2020-08-23
 */
@RestController
@Api(tags = "标签")
public class LabelInfoController {

    @Autowired
    private LabelInfoService labelInfoService;

    @PostMapping("/getById")
    @ApiOperation(value = "根据ID查询")
    public LabelInfo getById(Long id) {
        LabelInfo labelInfo = labelInfoService.getOne(id);
        System.out.println(labelInfo.toString());
        return labelInfo;
    }
}
