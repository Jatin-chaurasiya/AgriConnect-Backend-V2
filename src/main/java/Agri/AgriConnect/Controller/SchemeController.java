package Agri.AgriConnect.Controller;

import Agri.AgriConnect.Entity.Scheme;
import Agri.AgriConnect.Enum.Category;
import Agri.AgriConnect.Enum.SchemeType;
import Agri.AgriConnect.Enum.State;
import Agri.AgriConnect.Service.SchemeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/schemes")
@RequiredArgsConstructor
public class SchemeController {

    private final SchemeService schemeService;

    @GetMapping
    public List<Scheme> getSchemes(
            @RequestParam(required = false) SchemeType type,
            @RequestParam(required = false) State state,
            @RequestParam(required = false) Category category
    ) {
        return schemeService.getSchemes(type, state, category);
    }

    @GetMapping("/{id}")
    public Scheme getSchemeById(@PathVariable Long id) {
        return schemeService.getSchemeById(id);
    }
}