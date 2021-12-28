package com.example.serveripwcr.controllers;

import com.example.serveripwcr.daos.StorageDAO;
import com.example.serveripwcr.models.Storage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StorageController {
    @Autowired
    public final StorageDAO storageDAO;

    public StorageController(StorageDAO storageDAO) {
        this.storageDAO = storageDAO;
    }

    @GetMapping(value = "/storage/all")
    public List<Storage> getAllCategories() {
        return storageDAO.getAll();
    }

    @GetMapping(value = "/storage/{id}")
    public Storage getStorage(@PathVariable final Long id) {
        return storageDAO.getById(id);
    }

    @PutMapping(value = "/storage/{id}")
    public Storage editStorage(@RequestBody Storage editStorage, @PathVariable Long id) throws Exception {

        return storageDAO.getByIdOptional(id)
                .map(storage -> {
                    storage.setAmount(editStorage.getAmount());
                    storage.setProduct(editStorage.getProduct());
                    storage.setSoldOut(editStorage.isSoldOut());

                    return storageDAO.addStorage(storage);
                })
                .orElseThrow(() -> new Exception(
                        "No storage found with id " + id + "\""));
    }

    @PutMapping(value = "/storage")
    public Storage addStorage(@RequestBody Storage newStorage) {
        return storageDAO.addStorage(newStorage);
    }

    @DeleteMapping("/storage/{id}")
    public void deleteStorage(@PathVariable Long id) {
        storageDAO.deleteByStorageId(id);
    }

}
