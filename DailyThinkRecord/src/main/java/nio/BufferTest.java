package nio;

import java.io.RandomAccessFile;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author Akmd Nannf
 * @version v1.0
 * @Description
 * @date 2021/7/26 20:29
 */
public class BufferTest {

    public static void main(String[] args) throws Exception{
        RandomAccessFile accessFile = new RandomAccessFile("E:\\github\\ZiMu\\关于未来\\恐惧与挣扎.md","rw");
        FileChannel fileChannel = accessFile.getChannel();
        // capacity = 460
        ByteBuffer byteBuffer = ByteBuffer.allocate(460);
        int byteRead = fileChannel.read(byteBuffer);

        while (byteRead != -1) {
            byteBuffer.flip();
            while (byteBuffer.hasRemaining()) {
                System.out.println((char) byteBuffer.get());
            }
            byteBuffer.clear();
            byteRead = fileChannel.read(byteBuffer);
        }
        accessFile.close();
    }
}
