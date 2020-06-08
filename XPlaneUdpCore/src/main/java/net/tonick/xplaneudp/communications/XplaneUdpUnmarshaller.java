package net.tonick.xplaneudp.communications;

import net.tonick.xplaneudp.domain.IDataItem;
import net.tonick.xplaneudp.domain.factory.DataItemFactory;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class XplaneUdpUnmarshaller {
    /**
     * Takes a UDP datagram and extracts all containing DataItems
     * <p>
     * A Datagram is structured as follows:
     * <p>
     * <pre>
     * 44 41 54 41 2A // String "DATA*" (irrelevant)
     * 08             // Data group index 0x08 (JoystickAileronElevatorRudder)
     * 00 00 00       // 3 dead bytes
     * A9 26 6B 2F    // Data item 1
     * ...            // Data item ...
     * 00 C0 79 C4    // Data item 8
     * 68             // Data group index 0x68 (TransponderStatus)
     * 00 00 00       // ...
     * ...            // ...
     * </pre>
     *
     * @param data The received datagram as byte array
     * @return A list of {@link IDataItem}s extracted from the datagram
     */
    public List<IDataItem> unmarshal(byte[] data) {
        ByteBuffer buffer = ByteBuffer.wrap(data);
        discard(buffer, 5); // Discard "DATA*"

        List<IDataItem> dataItems = new ArrayList<>();
        while (buffer.hasRemaining()) {
            int dataGroupIndex = buffer.get();
            if (dataGroupIndex == 0) {
                break;
            }

            discard(buffer, 3);

            byte[] elementBuffer = new byte[4];
            List<byte[]> values = IntStream.range(0, 8).mapToObj(i -> {
                buffer.get(elementBuffer);
                return elementBuffer;
            }).collect(Collectors.toList());

            IDataItem dataItem = DataItemFactory.create(dataGroupIndex, values);
            dataItems.add(dataItem);
        }

        return dataItems;
    }

    /**
     * Discards a number of bytes from a {@link ByteBuffer}
     *
     * @param byteBuffer The {@link ByteBuffer to discard the bytes from}
     * @param length     The number of bytes to be discarded
     */
    public void discard(ByteBuffer byteBuffer, int length) {
        byte[] tempBuffer = new byte[length];
        byteBuffer.get(tempBuffer);
    }
}
