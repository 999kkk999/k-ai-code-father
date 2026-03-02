package com.k.kaicodefather.service;

import com.k.kaicodefather.model.dto.app.AppQueryRequest;
import com.k.kaicodefather.model.vo.AppVO;
import com.mybatisflex.core.query.QueryWrapper;
import com.mybatisflex.core.service.IService;
import com.k.kaicodefather.model.entity.App;

import java.util.List;

/**
 * 应用 服务层。
 *
 * @author <a href="https://github.com/999kkk999">程序员旷子贤</a>
 */
public interface AppService extends IService<App> {

    /**
     * 查询APP关联信息
     * @param app
     * @return
     */
    AppVO getAppVO(App app);

    /**
     * 获取APP列表
     * @param appList
     * @return
     */
    List<AppVO> getAppVOList(List<App> appList);

    /**
     *  构造查询对象
     * @param appQueryRequest
     * @return
     */
    QueryWrapper getQueryWrapper(AppQueryRequest appQueryRequest);
}
