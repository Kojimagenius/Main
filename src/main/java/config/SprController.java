package config;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SprController {
    @GetMapping("/sample")
    public String showForm()
    {
        return "sample";
    }
}
