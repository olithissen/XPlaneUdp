package net.tonick.xplaneudp.domain;

import net.tonick.xplaneudp.communications.RawDataGroup;

import java.util.ArrayList;
import java.util.List;

public class GenericDataItem extends AbstractDataItem {
    private final List<Float> fvalues;

    public GenericDataItem(RawDataGroup di) {
        super(di);
        fvalues = new ArrayList<>();
        fvalues.addAll(di.getFloatValues());
    }

    @Override
    public String toString() {
        return "GenericDataItem{" +
                "index=" + index +
                ", fvalues=" + fvalues +
                '}';
    }
}
