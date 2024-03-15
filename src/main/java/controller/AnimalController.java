package controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import models.Animal;
import services.AnimalService;

import java.util.ArrayList;
import java.util.List;

@Path("/animal")
public class AnimalController {

    @Inject
    AnimalService animalService;

    @GET
    @Path("/list")
    public List<Animal> findAll() {
        return animalService.findAll();
    }

    @GET
    @Path("/findById/{id}")
    public String findById(@PathParam("id") int id) {
        Animal animal = animalService.findById(id);
        return animal!=null?animal.toString():"Animal not found";
    }

    @DELETE
    @Path("/delete/{id}")
    public Animal delete(@PathParam("id") int id) {
        return animalService.delete(id);
    }

    @POST
    @Path("/add")
    public Animal add(Animal animal) {
        return animalService.add(animal);
    }

    @PUT
    @Path("/update/{id}")
    public void update(@PathParam("id") int id, Animal animal) {
        Animal existingAnimal = animalService.findById(id);
        if (existingAnimal != null) {
            existingAnimal.setType(animal.getType());
            existingAnimal.setPoids(animal.getPoids());
            existingAnimal.setBruit(animal.getBruit());
            animalService.update(existingAnimal);
        } else {
            System.out.println("Animal not found");
        }
    }
}
