package net.tonick.xplaneudp.domain;

import net.tonick.xplaneudp.communications.RawDataGroup;

public class TransponderStatus extends AbstractDataItem {
    private final int mode;
    private final int setting;
    private final int id;
    private final float interval;

    public int getMode() {
        return mode;
    }

    public int getSetting() {
        return setting;
    }

    public int getId() {
        return id;
    }

    public float getInterval() {
        return interval;
    }

    public TransponderStatus(RawDataGroup rawDataGroup) {
        super(rawDataGroup);
        mode = rawDataGroup.getIntValue(0);
        setting = rawDataGroup.getIntValue(1);
        id = rawDataGroup.getIntValue(2);
        interval = rawDataGroup.getFloatValue(3);
    }

    @Override
    public String toString() {
        return "TransponderStatus{" +
                "mode=" + mode +
                ", setting=" + setting +
                ", id=" + id +
                ", interval=" + interval +
                '}';
    }
}
