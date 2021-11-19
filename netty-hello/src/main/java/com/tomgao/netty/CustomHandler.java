package com.tomgao.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.*;
import io.netty.util.CharsetUtil;

/**
 * @author tomgao
 * @Description
 * @Date 创建于 2021/11/18
 */

//SimpleChannelInboundHandler对于请求来讲 其实相当于 "入站"
public class CustomHandler extends SimpleChannelInboundHandler<HttpObject> {

    // 从缓冲区读数据
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, HttpObject msg) throws Exception {

        // 获取channel
        Channel channel = channelHandlerContext.channel();

        if (msg instanceof HttpRequest) {
            // 显示客户端远程地址
            System.out.println(channel.remoteAddress());

            // 定义发送的数据消息 写到缓存区
            ByteBuf content = Unpooled.copiedBuffer("Hello netty!", CharsetUtil.UTF_8);

            // 构建一个响应 http response
            FullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK, content);
            // 设置http响应头
            response.headers().set(HttpHeaderNames.CONTENT_TYPE, "text/plain");
            response.headers().set(HttpHeaderNames.CONTENT_LENGTH, content.readableBytes());

            // 把响应刷到客户端
            channelHandlerContext.writeAndFlush(response);
        }


    }
}
