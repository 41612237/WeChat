package com.tomgao.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @author tomgao
 * @Description 实现客户端发送请求, 服务器返回hello netty
 * @Date 创建于 2021/11/18
 */
public class HelloServer {


    public static void main(String[] args) throws InterruptedException {

        // 定义一对线程组 两个线程池
        // 老板线程组  用于接受客户端的连接, 不做任何处理, 不做事
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        // 工作线程组  负责处理boss分派的任务
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        try {
            // netty 服务器的创建  ServerBootstrap是一个启动类
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(bossGroup, workerGroup) // 设置主从线程组
                    .channel(NioServerSocketChannel.class)  // 设置NIO双向通道
                    .childHandler(new HelloServerInitializer());  // 子处理器, 用于处理workerGroup

            // 启动server 并且设置端口号, 启动方式为同步
            ChannelFuture channelFuture = serverBootstrap.bind(8088).sync();

            // 用于监听关闭的channel, 同步启动
            channelFuture.channel().closeFuture().sync();
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }



    }
}
