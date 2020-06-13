package com.udacity.DogGraphQL.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.udacity.DogGraphQL.dogRepository.DogRepository;
import com.udacity.DogGraphQL.entity.DogBreed;
import com.udacity.DogGraphQL.exception.DogNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class Query implements GraphQLQueryResolver {

    private DogRepository dogRepository;

    public Query(DogRepository dogRepository){
        this.dogRepository=dogRepository;
    }

    public Iterable<DogBreed> findDogBreed(){
        return dogRepository.findAll();
    }

    public DogBreed findDogBreedById(Long id){
        Optional<DogBreed> optionalDogBreed = dogRepository.findById(id);
        if(optionalDogBreed.isPresent())
             return optionalDogBreed.get();
        else{
            throw new DogNotFoundException("Dog Not Found",id);
        }
    }

//    public DogBreed findAllDogNames(String breed){
//        Optional<DogBreed> optionalDog = dogRepository.findAllBreed(breed);
//        if(optionalDog.isPresent())
//            return optionalDog.get();
//        else{
//            throw new DogNotFoundException("Dog Not Found",breed);
//        }
//   //     return dogRepository.findAllBreed(name);
//    }
}
