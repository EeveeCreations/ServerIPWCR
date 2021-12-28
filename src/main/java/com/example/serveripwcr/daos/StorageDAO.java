package com.example.serveripwcr.daos;

import com.example.serveripwcr.models.Storage;
import com.example.serveripwcr.repositorys.StorageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Component
public class StorageDAO {

    @Autowired
    private StorageRepository storageRepository;

    public StorageDAO(StorageRepository storageRepository) {
        this.storageRepository = storageRepository;
    }

    public List<Storage> getAll() {
        ArrayList<Storage> storages = (ArrayList<Storage>) this.storageRepository.findAll();
        storages.sort(Comparator.comparingLong(Storage::getId));
        return storages;
    }

    public Storage getById(long id) {
        Optional<Storage> optionalStorage = storageRepository.findById(id);
        if (optionalStorage.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "This storage id: " + id + "has not found");
        }
        return optionalStorage.get();
    }

    public Optional<Storage> getByIdOptional(long id) {
        return storageRepository.findById(id);
    }

    public void deleteByStorageId(long storageId) {
        storageRepository.deleteById(storageId);
    }

    public Storage addStorage(Storage newStorage) {
        return storageRepository.save(newStorage);
    }
}
