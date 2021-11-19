package com.tomgao.netty;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpServerCodec;

/**
 * @author tomgao
 * @Description 初始化器 channel注册后, 执行里面的初始化方法
 * @Date 创建于 2021/11/18
 */
public class HelloServerInitializer extends ChannelInitializer<SocketChannel> {

    protected void initChannel(SocketChannel socketChannel) throws Exception {

        // 通过SocketChannel获取对应的管道
        ChannelPipeline pipeline = socketChannel.pipeline();
        // 通过管道添加handler HttpServerCodec是netty提供的处理器(编解码器), 当请求到服务端,需要解码, 响应到客户端需要编码
        pipeline.addLast("HttpServerCodec", new HttpServerCodec())
                // 添加自定义处理类
                .addLast("customHandler", new CustomHandler());

    }
}
