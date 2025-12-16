package xyz.onezylee.censor.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.FieldStrategy;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;

@TableName("censor_check_log")
public class CensorCheckLog {
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    private Boolean hasKeyword;
    private String originalText;
    private String maskedText;
    @TableField(value = "created_at", insertStrategy = FieldStrategy.NEVER)
    private LocalDateTime createdAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getHasKeyword() {
        return hasKeyword;
    }

    public void setHasKeyword(Boolean hasKeyword) {
        this.hasKeyword = hasKeyword;
    }

    public String getOriginalText() {
        return originalText;
    }

    public void setOriginalText(String originalText) {
        this.originalText = originalText;
    }

    public String getMaskedText() {
        return maskedText;
    }

    public void setMaskedText(String maskedText) {
        this.maskedText = maskedText;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
