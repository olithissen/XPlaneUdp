package net.tonick.xplaneudp.communications;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RawDataGroup {
    private final int index;
    private final List<byte[]> values;

    public RawDataGroup(int index, List<byte[]> values) {
        this.index = index;
        this.values = values;
    }

    public int getIndex() {
        return index;
    }

    public List<byte[]> getValues() {
        return values;
    }

    public byte[] getValue(int index) {
        return values.get(index);
    }

    public List<Float> getFloatValues() {
        return IntStream.range(0, 8).mapToObj(this::getFloatValue).collect(Collectors.toList());
    }

    public float getFloatValue(int index) {
        return ByteBuffer.wrap(values.get(index)).order(ByteOrder.LITTLE_ENDIAN).getFloat();
    }

    public int getIntValue(int index) {
        return (int) getFloatValue(index);
    }

    public boolean getBooleanValue(int index) {
        return getFloatValue(index) >= 1;
    }

    @Override
    public String toString() {
        return "DataItem{" +
                "index=" + index +
                ", values=" + values +
                '}';
    }
}
