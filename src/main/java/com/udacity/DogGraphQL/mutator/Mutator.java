package com.udacity.DogGraphQL.mutator;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.udacity.DogGraphQL.dogRepository.DogRepository;
import com.udacity.DogGraphQL.entity.DogBreed;
import com.udacity.DogGraphQL.exception.DogNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class Mutator implements GraphQLMutationResolver {

    private DogRepository dogRepository;

    public Mutator(DogRepository dogRepository) {this.dogRepository=dogRepository;};

    public DogBreed newDogBreed(String breed,String name){
        DogBreed dogBreed = new DogBreed(breed,name);
        dogRepository.save(dogBreed);
        return dogBreed;
    }

    public boolean deleteDogBreed(Long id){
//        boolean deleted = false;
//        Iterable<DogBreed> allDogs = dogRepository.findAll();
//        for(DogBreed d : allDogs){
//            if(d.getBreed().equals(name)){
//
//                dogRepository.delete(d);
//                deleted = true;
//            }
//        }
//        if(!deleted){
//            throw new DogNotFoundException("DogNotFound",id);
//        }
//         return deleted;
        dogRepository.deleteById(id);
        return true;
    }
    public DogBreed updateDogName(String name,Long id){
        Optional<DogBreed> optionalDogBreed = dogRepository.findById(id);
        if(optionalDogBreed.isPresent()){
            DogBreed DogBreed = optionalDogBreed.get();
            DogBreed.setName(name);
            dogRepository.save(DogBreed);
            return DogBreed;
        }else {
            throw new DogNotFoundException("DogBreed Not Found", id);
        }
    }
}
