package com.example.serveripwcr.repositorys;

import com.example.serveripwcr.models.Present;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PresentRepository extends CrudRepository<Present, Long> {
}
