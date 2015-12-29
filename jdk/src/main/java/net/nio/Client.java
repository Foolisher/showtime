package net.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * Desc:
 * Created by wanggen on 2015-12-10 下午1:37.
 */
public class Client {

    public static void main(String[] args) throws IOException {


        SocketChannel socketChannel = SocketChannel.open();
        boolean connect = socketChannel.connect(new InetSocketAddress("127.0.0.1", 9001));

//        socketChannel.write(ByteBuffer.wrap(Files.toByteArray(new File("/Users/wanggen/workspace/showtime/jdk/src/main/java/net/nio/Client.java"))));

        socketChannel.write(ByteBuffer.wrap("你好,我是客户端".getBytes()));

        socketChannel.finishConnect();

        socketChannel.close();


    }


}
