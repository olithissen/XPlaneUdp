package net.tonick.xplaneudp.domain;

import net.tonick.xplaneudp.communications.RawDataGroup;

public class JoystickAileronElevatorRudder extends AbstractDataItem {
    private final float elevator;
    private final float aileron;
    private final float rudder;

    public float getElevator() {
        return elevator;
    }

    public float getAileron() {
        return aileron;
    }

    public float getRudder() {
        return rudder;
    }

    public JoystickAileronElevatorRudder(RawDataGroup rawDataGroup) {
        super(rawDataGroup);

        elevator = rawDataGroup.getFloatValue(0);
        aileron = rawDataGroup.getFloatValue(1);
        rudder = rawDataGroup.getFloatValue(2);
    }

    @Override
    public String toString() {
        return "JoystickAileronElevatorRudder{" +
                "elevator=" + elevator +
                ", aileron=" + aileron +
                ", rudder=" + rudder +
                '}';
    }
}
