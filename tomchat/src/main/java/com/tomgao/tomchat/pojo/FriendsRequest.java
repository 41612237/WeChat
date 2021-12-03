package com.tomgao.tomchat.pojo;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Table(name = "friends_request")
@Data
public class FriendsRequest {
    @Id
    private String id;

    @Column(name = "send_user_id")
    private String sendUserId;

    @Column(name = "accept_user_id")
    private String acceptUserId;

    /**
     * 发送请求的事件
     */
    @Column(name = "request_date_time")
    private Date requestDateTime;


    /**
     * 获取发送请求的事件
     *
     * @return request_date_time - 发送请求的事件
     */
    public Date getRequestDateTime() {
        return requestDateTime;
    }

    /**
     * 设置发送请求的事件
     *
     * @param requestDateTime 发送请求的事件
     */
    public void setRequestDateTime(Date requestDateTime) {
        this.requestDateTime = requestDateTime;
    }
}