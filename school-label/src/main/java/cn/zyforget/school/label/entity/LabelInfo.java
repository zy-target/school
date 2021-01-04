package cn.zyforget.school.label.entity;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;



import com.baomidou.mybatisplus.annotations.Version;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author 紫阳
 * @since 2020-08-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("LABEL_INFO")
public class LabelInfo extends Model<LabelInfo> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "ID", type = IdType.AUTO)
    private Long id;

    /**
     * 名称
     */
    @TableField("NAME")
    private String name;

    /**
     * 类型
     */
    @TableField("TYPE")
    private Integer type;

    /**
     * 是否删除0：否，1是
     */
    @TableField("DELETED")
    private Integer deleted;

    @TableField("WHO_CREATE")
    private String whoCreate;

    @TableField("WHEN_CREATE")
    private Date whenCreate;

    @TableField("WHO_MODIFIED")
    private String whoModified;

    @TableField("WHEN_MODIFIED")
    private Date whenModified;

    public static final String ID = "ID";
    public static final String NAME = "NAME";
    public static final String TYPE = "TYPE";
    public static final String DELETED = "DELETED";
    public static final String WHO_CREATE = "WHO_CREATE";
    public static final String WHEN_CREATE = "WHEN_CREATE";
    public static final String WHO_MODIFIED = "WHO_MODIFIED";
    public static final String WHEN_MODIFIED = "WHEN_MODIFIED";


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
