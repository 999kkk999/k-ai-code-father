package com.k.kaicodefather.service;

import com.k.kaicodefather.model.dto.app.AppQueryRequest;
import com.k.kaicodefather.model.entity.User;
import com.k.kaicodefather.model.vo.AppVO;
import com.mybatisflex.core.query.QueryWrapper;
import com.mybatisflex.core.service.IService;
import com.k.kaicodefather.model.entity.App;
import org.springframework.http.codec.ServerSentEvent;
import reactor.core.publisher.Flux;

import java.util.List;

/**
 * 应用 服务层。
 *
 * @author <a href="https://github.com/999kkk999">程序员旷子贤</a>
 */
public interface AppService extends IService<App> {


    /**
     * 通过对话生成应用代码
     *
     * @param appId       应用 id
     * @param userMessage 用户提示词
     * @param loginUser   登录用户
     * @return
     */
    Flux<ServerSentEvent<String>> chatToGenCode(Long appId, String userMessage, User loginUser);


    /**
     * 部署应用
     * @param appId 应用 id
     * @param loginUser 登录用户
     * @return 部署结果
     */
    String deployApp(Long appId, User loginUser);

    /**
     * 查询APP关联信息
     *
     * @param app
     * @return
     */
    AppVO getAppVO(App app);

    /**
     * 获取APP列表
     *
     * @param appList
     * @return
     */
    List<AppVO> getAppVOList(List<App> appList);

    /**
     * 构造查询对象
     *
     * @param appQueryRequest
     * @return
     */
    QueryWrapper getQueryWrapper(AppQueryRequest appQueryRequest);

}
