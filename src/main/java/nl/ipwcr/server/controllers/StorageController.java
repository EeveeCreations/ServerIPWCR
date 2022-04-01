package nl.ipwcr.server.controllers;

import nl.ipwcr.server.daos.StorageDAO;
import nl.ipwcr.server.models.Storage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = {"http://localhost:4200"
        ,"https://eeveecreations.github.io",
        "https://one-piece-shop-ipwcr-jpwbr.ondigitalocean.app/"})

@RequestMapping("/storage")
@RestController
public class StorageController {
    @Autowired
    public final StorageDAO storageDAO;

    public StorageController(StorageDAO storageDAO) {
        this.storageDAO = storageDAO;
    }

    @GetMapping(value = "/all")
    public List<Storage> getAllCategories() {
        return storageDAO.getAll();
    }

    @GetMapping(value = "/{id}")
    public Storage getStorage(@PathVariable final Long id) {
        return storageDAO.getById(id);
    }

    @PutMapping(value = "/{id}")
    public Storage editStorage(@RequestBody Storage editStorage, @PathVariable Long id) throws Exception {

        return storageDAO.getByIdOptional(id)
                .map(storage -> {
                    storage.setAmount(editStorage.getAmount());
//                    storage.setProduct(editStorage.getProduct());
                    storage.setSoldOut(editStorage.isSoldOut());

                    return storageDAO.addStorage(storage);
                })
                .orElseThrow(() -> new Exception(
                        "No storage found with id " + id + "\""));
    }

    @PostMapping(value = "new")
    public Storage addStorage(@RequestBody Storage newStorage) {
        return storageDAO.addStorage(newStorage);
    }

    @DeleteMapping("/{id}")
    public void deleteStorage(@PathVariable Long id) {
        storageDAO.deleteByStorageId(id);
    }

}
