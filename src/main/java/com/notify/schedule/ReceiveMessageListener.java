package com.notify.schedule;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import com.notify.nms.model.SendMessageParam;
import com.notify.nms.service.NmsNotificationLogCategoryService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author : kevin Chang
 * @since : 2022/3/1
 * 監聽Queue中是否有資料，若有資料則進行消費。
 */

@Component
@Slf4j
public class ReceiveMessageListener {

    @Autowired
    SendAlertScheduleTask sendAlertScheduleTask;

    @Autowired
    NmsNotificationLogCategoryService nmsNotificationLogCategoryService;


    /**
     * receive teamplus queue
     * @param sendMessageParam
     */
    @RabbitListener(queues = {"teamplus.queue"})
    public void receive(SendMessageParam sendMessageParam) throws JsonProcessingException {

        log.info("receive snsType: {} ", sendMessageParam.getSnsType());

        if(sendMessageParam.getSnsType()==1) {
            sendAlertScheduleTask.sendteamplusTask(sendMessageParam);
        }

        if(sendMessageParam.getSnsType()==2) {
            sendAlertScheduleTask.sendxsmsTask(sendMessageParam);
        }

    }
}
