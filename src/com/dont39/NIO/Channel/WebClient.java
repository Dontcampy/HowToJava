package com.dont39.NIO.Channel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * Learn from https://zhuanlan.zhihu.com/p/27365009
 */
public class WebClient {
    public static void main(String[] args) {
        SocketChannel socketChannel = null;
        try {
            socketChannel = SocketChannel.open();
            socketChannel.connect(new InetSocketAddress("127.0.0.1", 8000));

            // 采用Gather方式
            ByteBuffer writeBuffer = ByteBuffer.allocate(128);
            ByteBuffer buffer2 = ByteBuffer.allocate(16);
            writeBuffer.put("hello ".getBytes());
            buffer2.put("world".getBytes());

            writeBuffer.flip(); // 反转buffer用于读取
            buffer2.flip();
            ByteBuffer[] bufferArray = {writeBuffer, buffer2}; // like this https://iamxpy.github.io/images/four-gather.png
            socketChannel.write(bufferArray); // 从bufferArray中读取数据然后写（发送）到Server？
            socketChannel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
