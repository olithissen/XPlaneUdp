package net.tonick.xplaneudp;

import net.tonick.xplaneudp.communications.XplaneUdpReceiver;

import java.io.IOException;

public class Main {
    public static void main(String... args) throws IOException {
        XplaneUdpReceiver server = new XplaneUdpReceiver();
        server.run();
    }
}
