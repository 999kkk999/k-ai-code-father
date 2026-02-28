package com.k.kaicodefather.aop;

import com.k.kaicodefather.annotation.AuthCheck;
import com.k.kaicodefather.exception.BusinessException;
import com.k.kaicodefather.exception.ErrorCode;
import com.k.kaicodefather.model.entity.User;
import com.k.kaicodefather.model.enums.UserRoleEnum;
import com.k.kaicodefather.service.UserService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * ClassName: AuthInterceptor
 * Description:
 *
 * @Author kzxStart
 * @Create 2026/2/28 16:53
 * @Version 1.0
 */

@Aspect
@Component
public class AuthInterceptor {

    @Resource
    private UserService userService;

    @Around("@annotation(authCheck)")
    public Object doInterceptor(ProceedingJoinPoint joinPoint, AuthCheck authCheck) throws Throwable {

        //必须具有的权限
        String mustRole = authCheck.mustRole();
        UserRoleEnum mustRoleEnum = UserRoleEnum.getEnumByValue(mustRole);

        //获取当前请求
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();

        //获取当前登录用户
        User loginUser = userService.getLoginUser(request);
        //无权限要求，直接放行
        if (mustRoleEnum == null){
            return joinPoint.proceed();
        }

        //以下为：必须有该权限才可访问
        //获取当前用户具有的权限
        UserRoleEnum userRoleEnum = UserRoleEnum.getEnumByValue(loginUser.getUserRole());
        //没有权限，拒绝
        if(userRoleEnum==null){
            throw new BusinessException(ErrorCode.NO_AUTH_ERROR);
        }

        //必须具有管理员权限
        if(UserRoleEnum.ADMIN.equals(mustRoleEnum) && !UserRoleEnum.ADMIN.equals(userRoleEnum)){
            throw new BusinessException(ErrorCode.NO_AUTH_ERROR);
        }

        //必须具有普通用户权限（非管理员默认普通用户）
        return joinPoint.proceed();
    }

}

