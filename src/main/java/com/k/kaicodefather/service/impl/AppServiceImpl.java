package com.k.kaicodefather.service.impl;

import com.mybatisflex.spring.service.impl.ServiceImpl;
import com.k.kaicodefather.model.entity.App;
import com.k.kaicodefather.mapper.AppMapper;
import com.k.kaicodefather.service.AppService;
import org.springframework.stereotype.Service;

/**
 * 应用 服务层实现。
 *
 * @author <a href="https://github.com/999kkk999">程序员旷子贤</a>
 */
@Service
public class AppServiceImpl extends ServiceImpl<AppMapper, App>  implements AppService{

}
