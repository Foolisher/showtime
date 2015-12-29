package net.nio;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;

/**
 * Desc:
 * Created by wanggen on 2015-12-11 上午12:03.
 */
@Data
@AllArgsConstructor
public class Attachment {

    private ServerSocketChannel serverSocketChannel;

    private ByteBuffer buffer;

}
