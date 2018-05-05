package trashman.modules.village.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import trashman.modules.village.domain.entity.Village;
import trashman.modules.village.service.VillageService;

import java.util.List;

@RestController
@RequestMapping("/village")
public class VillageController {
    @Autowired
    VillageService villageService;

    // Get All places
    @GetMapping("/findall")
    public List<Village> getAll() {
        return villageService.getAllVillages();
    }


}
