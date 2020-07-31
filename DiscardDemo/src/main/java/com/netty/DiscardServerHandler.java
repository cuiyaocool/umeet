package com.netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;

/**
 * @author cuiyaocy
 * @date 2020/07/08
 */

public class DiscardServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        System.out.println(msg);
        ByteBuf in = (ByteBuf)msg;
        System.out.println(in.toString(io.netty.util.CharsetUtil.US_ASCII));
    }

    @Override
    public void channelActive(final ChannelHandlerContext ctx) {
        System.out.println("发送消息");
        ctx.writeAndFlush("hello to here!");
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }
}
