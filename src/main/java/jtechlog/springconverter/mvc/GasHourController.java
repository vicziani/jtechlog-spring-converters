package jtechlog.springconverter.mvc;

import jtechlog.springconverter.GasHour;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class GasHourController {

    @RequestMapping("/gashour")
    @ResponseBody
    public String getGasHour(@RequestParam(name = "gasHour") GasHour gasHour) {
        return gasHour.toString();
    }

}
