package chatrobot;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 *
 * Created by wanggen/付笑 on 2016-06-13.
 */
public class Robot {


	public static void main(String[] args) throws Exception {

		ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
		serverSocketChannel.configureBlocking(false);
		serverSocketChannel.bind(new InetSocketAddress(8001));

		Selector selector = Selector.open();

		serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);


		while (true) {
			selector.select(1000);
			System.out.println(selector.select());
			if (selector.selectedKeys().isEmpty()) continue;
			Iterator<SelectionKey> keys = selector.selectedKeys().iterator();
			while (keys.hasNext()) {
				SelectionKey key = keys.next();
				keys.remove();

				if (key.isAcceptable()) {
					ServerSocketChannel channel = (ServerSocketChannel) key.channel();
					SocketChannel       client  = channel.accept();
					client.configureBlocking(false);
					client.register(selector, SelectionKey.OP_READ | SelectionKey.OP_WRITE)
									.attach("hello ");
				} else if (key.isReadable()) {
					SocketChannel channel = (SocketChannel) key.channel();
					ByteBuffer    buf     = ByteBuffer.allocate(1024);
					channel.read(buf);
					key.channel().register(selector, key.interestOps() & (~SelectionKey.OP_READ));
				} else if (key.isWritable()) {
					SocketChannel channel    = (SocketChannel) key.channel();
					Object        attachment = key.attachment();
					channel.write(ByteBuffer.wrap(attachment.toString().getBytes()));

					channel.register(selector, key.interestOps() & (~SelectionKey.OP_WRITE));
				}

			}


		}


	}

}
