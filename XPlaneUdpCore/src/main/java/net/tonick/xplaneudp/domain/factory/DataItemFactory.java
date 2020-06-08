package net.tonick.xplaneudp.domain.factory;

import net.tonick.xplaneudp.communications.RawDataGroup;
import net.tonick.xplaneudp.domain.GenericDataItem;
import net.tonick.xplaneudp.domain.IDataItem;
import net.tonick.xplaneudp.domain.JoystickAileronElevatorRudder;
import net.tonick.xplaneudp.domain.TransponderStatus;

import java.util.List;

public class DataItemFactory {
    public static IDataItem create(int index, List<byte[]> values) {
        RawDataGroup di = new RawDataGroup(index, values);

        switch (index) {
            case 8:
                return new JoystickAileronElevatorRudder(di);
            case 104:
                return new TransponderStatus(di);
            default:
                return new GenericDataItem(di);
        }
    }
}
