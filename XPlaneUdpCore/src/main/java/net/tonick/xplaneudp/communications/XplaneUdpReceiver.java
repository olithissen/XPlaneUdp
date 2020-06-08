package net.tonick.xplaneudp.communications;

import net.tonick.xplaneudp.domain.IDataItem;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.List;

public class XplaneUdpReceiver {
    private DatagramSocket socket;
    private InetAddress address;
    private boolean running;

    private byte[] buf = new byte[7700];

    private XplaneUdpUnmarshaller unmarshaller = new XplaneUdpUnmarshaller();

    public XplaneUdpReceiver() throws SocketException {
        socket = new DatagramSocket(49000);
    }

    public void run() throws IOException {
        running = true;

        while (running) {
            DatagramPacket packet = new DatagramPacket(buf, buf.length);
            socket.receive(packet);
            List<IDataItem> dataItems = unmarshaller.unmarshal(buf);
            dataItems.forEach(System.out::println);
        }
    }
}