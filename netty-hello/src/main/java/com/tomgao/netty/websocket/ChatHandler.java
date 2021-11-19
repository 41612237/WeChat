package com.tomgao.netty.websocket;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.util.concurrent.GlobalEventExecutor;

import java.time.LocalDateTime;

/**
 * @author tomgao
 * @Description 处理消息的handler
 * @Date 创建于 2021/11/19
 */
public class ChatHandler extends SimpleChannelInboundHandler<TextWebSocketFrame> {

    // 记录和管理所有客户端channel的容器
    private static ChannelGroup clients = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    //TextWebSocketFrame 在netty中, 用于为websocket中处理文本的对象 frame是消息的载体
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, TextWebSocketFrame msg) throws Exception {

        // 获取客户端传输过来的消息
        String content = msg.text();
        System.out.println("接收到数据: " + content);

//        for (Channel channel : clients) {
//            channel.writeAndFlush(
//                    new TextWebSocketFrame("服务器接收到消息的时间: " + LocalDateTime.now() + " 消息为:" + content)
//            );
//        }
//        与上面方法一致
        clients.writeAndFlush(
                new TextWebSocketFrame("服务器接收到消息的时间: " + LocalDateTime.now() + " 消息为:" + content)
        );
        // 不同客户端对应在不同channel
    }

    /**
     * 客户端连接服务端之后
     * 获取客户端的channel, 并且放到channelGroup中进行管理
     * @param ctx
     * @throws Exception
     */
    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {

        clients.add(ctx.channel());
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {

        // 当触发handlerRemoved ChannelGroup会自动移除对应客户端的channel
//        clients.remove(ctx.channel());
        System.out.println("客户端断开, channel longId: " + ctx.channel().id().asLongText());
        System.out.println("客户端断开, channel shortId: " + ctx.channel().id().asShortText());
    }
}
