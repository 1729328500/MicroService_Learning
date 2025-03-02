package top.whyh.contentservice.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import java.util.Date;

@Data
@TableName("t_share")
public class Share {
    @TableId(type = IdType.AUTO)
    private Integer id;

    @TableField("user_id")
    private Integer userId; // 映射 user_id

    private String title;

    @TableField("create_time")
    private Date createTime; // 映射 create_time

    @TableField("update_time")
    private Date updateTime; // 映射 update_time

    @TableField("is_original")
    private Boolean original; // 映射 is_original

    private String author;

    @TableField("cover")
    private String cover; // 映射 cover

    @TableField("summary")
    private String summary; // 映射 summary

    @TableField("price")
    private Integer price; // 映射 price

    @TableField("download_url")
    private String downloadUrl; // 映射 download_url

    @TableField("buy_count")
    private Integer buyCount; // 映射 buy_count

    @TableField("show_flag")
    private Boolean showFlag; // 映射 show_flag

    @TableField("audit_status")
    private String auditStatus; // 映射 audit_status

    @TableField("reason")
    private String reason; // 映射 reason
}