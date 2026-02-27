package com.k.kaicodefather.controller;

import com.k.kaicodefather.common.BaseResponse;
import com.k.kaicodefather.common.ResultUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName: HealthController
 * Description:
 *
 * @Author kzxStart
 * @Create 2026/2/27 17:08
 * @Version 1.0
 * @date 2026/02/27 18:12
 */
@RestController
@RequestMapping("/health")
public class HealthController {

    @GetMapping("/")
    public BaseResponse<String> heathCheck(){
        return ResultUtils.success("ok");
    }
}
