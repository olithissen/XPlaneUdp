package net.tonick.xplaneudp.domain;

import net.tonick.xplaneudp.communications.RawDataGroup;

public class AbstractDataItem implements IDataItem {
    protected RawDataGroup rawDataGroup;
    public final int index;

    public AbstractDataItem(RawDataGroup rawDataGroup) {
        this.rawDataGroup = rawDataGroup;
        this.index = rawDataGroup.getIndex();
    }
}
