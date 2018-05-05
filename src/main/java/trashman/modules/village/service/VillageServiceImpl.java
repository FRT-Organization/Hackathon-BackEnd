package trashman.modules.village.service;

import trashman.modules.village.domain.entity.Village;
import trashman.modules.village.domain.repo.VillageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VillageServiceImpl implements VillageService {

    @Autowired
    VillageRepo villageRepo;

    @Override
    public List<Village> getAllVillages() {
        return villageRepo.findAll();
    }
}
