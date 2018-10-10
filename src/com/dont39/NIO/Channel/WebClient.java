package com.dont39.NIO.Channel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class WebClient {
    public static void main(String[] args) {
        SocketChannel socketChannel = null;
        try {
            socketChannel = SocketChannel.open();
            socketChannel.connect(new InetSocketAddress("127.0.0.1", 8000));

            ByteBuffer writeBuffer = ByteBuffer.allocate(128);
            ByteBuffer buffer2 = ByteBuffer.allocate(16);
            writeBuffer.put("hello world".getBytes()); // 在buffer中放入hello world

            writeBuffer.flip(); // 反转buffer用于读取
            socketChannel.write(writeBuffer); // 从writeBuffer中读取数据然后写（发送）到Server？
            socketChannel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
