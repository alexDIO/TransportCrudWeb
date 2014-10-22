package forweb;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;


/**
 * Created by olomakovskyi on 10/9/2014.
 */
public class MapManagerTag extends TagSupport {
    private String action;
    private TransportMapHolder holder;

    private int id;
    private String transportType;
    private String mark;
    private String color;
    private int manufactureYear;
    private int passengersCount;
    private String energySource;
    private String transmission;
    private int load;

    public void setAction(String action) {
        this.action = action;
    }

    public void setHolder(TransportMapHolder holder) {
        this.holder = holder;
    }

    public void setIdd(Integer id) {
        this.id = id;
    }

    public void setTransportType(String transportType) {
        this.transportType = transportType;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setManufactureYear(int manufactureYear) {
        this.manufactureYear = manufactureYear;
    }

    public void setPassengersCount(int passengersCount) {
        this.passengersCount = passengersCount;
    }

    public void setEnergySource(String energySource) {
        this.energySource = energySource;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public void setLoad(int load) {
        this.load = load;
    }

    @Override
    public int doStartTag() throws JspException {

        switch (action){
            case "delete":
                holder.deleteTransport(id);
                break;
            case "add":
                holder.addTransport(-1, transportType, mark, color, manufactureYear, passengersCount, energySource, transmission, load);
                break;
            case "update":
                holder.deleteTransport(id);
                holder.addTransport(id, transportType, mark, color, manufactureYear, passengersCount, energySource, transmission, load);
                break;
        }

        return SKIP_BODY;
    }
}
