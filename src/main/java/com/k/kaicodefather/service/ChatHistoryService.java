package com.k.kaicodefather.service;

import com.k.kaicodefather.model.dto.chathistory.ChatHistoryQueryRequest;
import com.k.kaicodefather.model.entity.User;
import com.k.kaicodefather.model.enums.ChatHistoryMessageTypeEnum;
import com.mybatisflex.core.paginate.Page;
import com.mybatisflex.core.query.QueryWrapper;
import com.mybatisflex.core.service.IService;
import com.k.kaicodefather.model.entity.ChatHistory;

import java.time.LocalDateTime;

/**
 * 对话历史 服务层。
 *
 * @author <a href="https://github.com/999kkk999">程序员旷子贤</a>
 */
public interface ChatHistoryService extends IService<ChatHistory> {

    /**
     * 添加对话历史
     *
     * @param appId         应用ID
     * @param message       消息内容
     * @param messageType   消息类型
     * @param userId        用户ID
     * @return 是否添加成功
     */
    boolean addChatMessage(Long appId, String message, String messageType, Long userId);


    /**
     * 根据应用ID删除对话历史
     *
     * @param appId 应用ID
     * @return 是否删除成功
     */
    boolean deleteByAppId(Long appId);

    /**
     * 获取查询包装类
     *
     * @param chatHistoryQueryRequest 查询参数
     * @return 查询包装类
     */
    QueryWrapper getQueryWrapper(ChatHistoryQueryRequest chatHistoryQueryRequest);

    /**
     * 获取应用对话历史分页列表
     *
     * @param appId       应用ID
     * @param pageSize    分页大小
     * @param lastCreateTime 最后创建时间
     * @param loginUser   登录用户
     * @return 对话历史分页列表
     */
    Page<ChatHistory> listAppChatHistoryByPage(Long appId, int pageSize,
                                               LocalDateTime lastCreateTime,
                                               User loginUser);
}
