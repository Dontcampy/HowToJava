package com.dont39.NIO.Channel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * Learn from https://zhuanlan.zhihu.com/p/27365009
 */
public class WebServer {
    public static void main(String[] args) {
        try {
            ServerSocketChannel ssc = ServerSocketChannel.open(); // 用工厂方法创建新的ServerSocketChannel对象
            ssc.socket().bind(new InetSocketAddress("127.0.0.1", 8000));
            SocketChannel socketChannel = ssc.accept();

            ByteBuffer[] bufferArray = {ByteBuffer.allocate(128), ByteBuffer.allocate(16)}; // 用于Scatter

            socketChannel.read(bufferArray); // 从channel？中读取数据后放入bufferArray中

            // 所有buffer都反转，然后读取，这里的实现仅限这个WebClient不会出问题。
            for (ByteBuffer buffer :
                    bufferArray) {
                buffer.flip();
                while (buffer.hasRemaining()) {
                    System.out.println((char)buffer.get());
                }
            }

            socketChannel.close();
            ssc.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
