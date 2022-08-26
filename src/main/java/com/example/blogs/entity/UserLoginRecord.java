package com.example.blogs.entity;

    import com.baomidou.mybatisplus.annotation.FieldFill;
    import com.baomidou.mybatisplus.annotation.TableField;
    import com.baomidou.mybatisplus.annotation.TableId;
    import com.baomidou.mybatisplus.annotation.TableName;
    import java.io.Serializable;
    import java.time.LocalDateTime;
    import io.swagger.annotations.ApiModel;
    import io.swagger.annotations.ApiModelProperty;
    import lombok.Data;

/**
* 用户登录记录表
*
* @author FF
* @since 2022-08-27
*/
@Data
@TableName("user_login_record")
@ApiModel(value = "UserLoginRecord对象", description = "用户登录记录表")
public class UserLoginRecord implements Serializable {

private static final long serialVersionUID = 1L;

    @ApiModelProperty("ID")
    @TableId("id")
    private Long id;

    @ApiModelProperty("用户id")
    @TableField("user_id")
    private Long userId;

    @ApiModelProperty("用户名")
    @TableField("username")
    private String username;

    @ApiModelProperty("状态：1登录 2退出")
    @TableField("type")
    private Integer type;

    @ApiModelProperty("创建时间")
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;



    @Override
    public String toString() {
        return "UserLoginRecord{" +
                "id=" + id +
                ", userId=" + userId +
                ", username=" + username +
                ", type=" + type +
                ", createTime=" + createTime +
        "}";
    }

}
