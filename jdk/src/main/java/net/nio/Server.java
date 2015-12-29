package net.nio;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.joda.time.DateTime;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

import static java.nio.channels.Selector.open;

/**
 * Desc:
 * Created by wanggen on 2015-12-10 下午1:37.
 */
@Slf4j
public class Server {


    public static void main(String[] args) throws IOException {

        ServerSocketChannel serverSocketChannel = ServerSocketChannel
                .open()
                .bind(new InetSocketAddress(InetAddress.getByName("127.0.0.1"), 9001));
        serverSocketChannel.configureBlocking(false);

        Selector selector = open();
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        while (selector.select() > 0) {
            System.out.println("New connection comming");
            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();

            while (iterator.hasNext()) {
                SelectionKey key = iterator.next();
                iterator.remove();
                ServerSocketChannel socketChannel = (ServerSocketChannel) key.channel();

                if (key.isAcceptable()) {
                    SocketChannel accept = socketChannel.accept();
                    accept.configureBlocking(false);
                    new Connection(accept, new Connection.Handler() {
                    }).start();

                } else {
                    System.err.println("Key is not isAcceptable");
                }

            }

        }
    }


    @Data
    public static class Connection extends Thread {

        private SocketChannel socketChannel;

        private Selector selector;

        private Handler handler;

        public interface Handler {
            default void read(SocketChannel channel) {
                ByteBuffer buf = ByteBuffer.allocate(1024);
                int len;
                System.out.println("客户端传来消息:   ");
                try {
                    while ((len = channel.read(buf)) > 0) {
                        buf.flip();
                        System.out.println(new String(buf.array(), 0, len));
                        buf.clear();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            default void write(SocketChannel channel, Object msg) {
                System.out.println("待输出内容:" + msg);
                try {
                    channel.write(ByteBuffer.wrap(("ECHO: " + msg.toString()).getBytes()));
                    channel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        public Connection(SocketChannel socketChannel, Handler handler) {
            this.socketChannel = socketChannel;
            try {
                selector = Selector.open();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            try {
                socketChannel.register(selector, SelectionKey.OP_READ);
                while (selector.select() > 0) {
                    handleEvent();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        private void handleEvent() throws IOException {
            Iterator<SelectionKey> iter = selector.selectedKeys().iterator();
            while (iter.hasNext()) {
                SelectionKey key = iter.next();
                iter.remove();
                if (key.isReadable()) {
                    SocketChannel channel = (SocketChannel) key.channel();
                    handler.read(channel);
                    socketChannel.register(selector, SelectionKey.OP_WRITE, "message:" + DateTime.now());
                } else if (key.isWritable()) {
                    handler.write((SocketChannel) key.channel(), key.attachment());
                }


            }
        }
    }


}
