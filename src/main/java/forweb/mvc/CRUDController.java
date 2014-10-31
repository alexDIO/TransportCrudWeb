package forweb.mvc;

import forweb.TimeManager;
import forweb.TransportMapHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import transport.storages.ManufacturerStorage;

import javax.annotation.Resource;

/**
 * Created by olomakovskyi on 10/28/2014.
 */

@Controller
@Scope("session")
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

    @RequestMapping(value = "/login")
    public String login(ModelMap model){
        return "login_page";
    }

    @RequestMapping(value="/loginError")
    public String loginError(ModelMap model) {
        model.addAttribute("error", "true");
        return "login_page";

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
