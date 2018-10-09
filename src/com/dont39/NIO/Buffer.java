package com.dont39.NIO;

import java.nio.ByteBuffer;

public class Buffer {
    public static void main(String[] args) {
        byte b = 23;
        ByteBuffer byteBuffer = ByteBuffer.allocate(256); // 不能用new, 此时mark = -1, pos = 0, limit = 256, capacity = 256
        byteBuffer.put(b); // pos += 1
        System.out.println(byteBuffer.get(0));
        System.out.println(byteBuffer.get()); // pos += 1
        System.out.println(byteBuffer.position());
        byteBuffer.mark(); // 标记当前position 与 reset配合使用
        System.out.println(byteBuffer.flip()); // 反转
        byteBuffer.clear(); // pos = 0, limit = cap, mark = -1。相当于清空缓冲区
        byteBuffer.rewind(); // pos = 0, mark = -1
        byteBuffer.remaining(); // 返回limit - position的值，即返回剩余未写空间或未读空间
        byteBuffer.hasRemaining(); // 判断position < limit
    }
}
