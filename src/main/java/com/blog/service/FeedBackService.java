package com.blog.service;

import com.blog.model.FeedBack;
import net.sf.json.JSONObject;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author: zhenweijin
 * @Date: 2019/11/23 17:21
 * Describe:反馈业务操作
 */
public interface FeedBackService {

    /**
     * 保存反馈信息
     * @param feedBack
     * @return
     */
    @Transactional
    JSONObject submitFeedback(FeedBack feedBack);

    /**
     * 获得所有的反馈
     * @return
     */
    JSONObject getAllFeedback(int rows, int pageNum);

}
