package forweb.mvc;

import forweb.TimeManager;
import forweb.TransportMapHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import transport.storages.ManufacturerStorage;

import javax.annotation.Resource;

/**
 * Created by olomakovskyi on 10/28/2014.
 */

@Controller
public class CRUDController {
    @Autowired
    private TransportMapHolder holder;
    @Autowired
    ManufacturerStorage manufacturers;

    @Resource(name = "timeManagerSession")
    TimeManager timeManagerSession;

    @Resource(name = "timeManagerSingleton")
    TimeManager timeManagerSingleton;

    @RequestMapping("/crud")
    public String processRequest(ModelMap model){
        model.addAttribute("holder", holder);
        model.addAttribute("manufacturers", manufacturers);
        model.addAttribute("timeManagerSession", timeManagerSession);
        model.addAttribute("timeManagerSingleton", timeManagerSingleton);
        return "MVCTransportCRUD";
    }

    public TransportMapHolder getHolder() {
        return holder;
    }

    public void setHolder(TransportMapHolder holder) {
        this.holder = holder;
    }

    public ManufacturerStorage getManufacturers() {
        return manufacturers;
    }

    public void setManufacturers(ManufacturerStorage manufacturers) {
        this.manufacturers = manufacturers;
    }
}
