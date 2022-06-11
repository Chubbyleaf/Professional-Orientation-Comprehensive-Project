package org.zyzh.cloudprovideruser.sys.vo;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;

@Data
public class AvatarVo {
    @NotNull(message = "用户ID不能为空！")
    private String userId;

    @NotNull(message = "头像不能为空！")
    private MultipartFile file;
}
