package com.example.serveripwcr.repositorys;

import com.example.serveripwcr.models.Storage;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StorageRepository extends CrudRepository<Storage, Long> {
}
