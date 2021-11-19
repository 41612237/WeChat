package com.tomgao.netty.websocket;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.stream.ChunkedWriteHandler;

/**
 * @author tomgao
 * @Description
 * @Date 创建于 2021/11/18
 */
public class WSServerInitializer extends ChannelInitializer<SocketChannel> {

    protected void initChannel(SocketChannel socketChannel) throws Exception {

        ChannelPipeline pipeline = socketChannel.pipeline();
        // websocket基于http协议 需要http编解码器
        pipeline.addLast(new HttpServerCodec())
                // 对写大数据流的支持
                .addLast(new ChunkedWriteHandler())
                // http聚合器 对httpMessage进行聚合 聚合成FullHttpRequest FullHttpResponse
                // 在netty编程中, 几乎都会用到此handler
                .addLast(new HttpObjectAggregator(1024 * 64));

        // ========================以上是用于支持http协议=============================

        /**
         * websocket 服务器处理的协议, 用于指定给客户端连接访问的路由 /ws
         * 会帮助你处理websocket的握手, close, ping , pong
         * 对于websocket来说, 都是以frames进行传输的, 不同数据类型,对应的frames也不同
         */
        pipeline.addLast(new WebSocketServerProtocolHandler("/ws"))
                // 自定义
                .addLast(new ChatHandler());
    }
}
