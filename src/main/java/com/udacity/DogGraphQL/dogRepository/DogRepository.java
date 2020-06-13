package com.udacity.DogGraphQL.dogRepository;

import com.udacity.DogGraphQL.entity.DogBreed;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;


public interface DogRepository extends CrudRepository<DogBreed,Long> {

//    @Query("select d.breed,d.name from DogBreed d where id = :id")
//    String findAllBreedId(Long id);

}
