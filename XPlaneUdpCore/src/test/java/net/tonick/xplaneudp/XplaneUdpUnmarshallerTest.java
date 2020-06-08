package net.tonick.xplaneudp;

import net.tonick.xplaneudp.communications.XplaneUdpUnmarshaller;
import net.tonick.xplaneudp.domain.IDataItem;
import net.tonick.xplaneudp.util.TestDataSlicer;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class XplaneUdpUnmarshallerTest {

    @Test
    void unmarshal() throws IOException {
        List<byte[]> datagrams = TestDataSlicer.slice("datagrams.txt");
        XplaneUdpUnmarshaller unmarshaller = new XplaneUdpUnmarshaller();

        List<IDataItem> dataItems = new ArrayList<>();
        for (byte[] datagram : datagrams) {
            List<IDataItem> unmarshal = unmarshaller.unmarshal(datagram);
            dataItems.addAll(unmarshal);
        }

        assertEquals(1176, dataItems.size());
    }
}