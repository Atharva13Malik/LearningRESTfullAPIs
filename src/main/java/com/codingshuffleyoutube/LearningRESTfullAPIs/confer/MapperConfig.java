package com.codingshuffleyoutube.LearningRESTfullAPIs.confer;


import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration annotation ye btata h ki ye jo class h isme hmm different type ke bean bnare honge



@Configuration
public class MapperConfig {

    //The method annotated with @Bean tells Spring:
    //“Hey, create an object of this type and register it in the Spring Application Context so it can be injected wherever needed.”


//    This creates a single instance (singleton) of ModelMapper.
//
//    That instance gets stored in Spring’s IoC container.
//
//    You can then autowire it anywhere in your project like this:
//
//    @Autowired
//    private ModelMapper modelMapper;

    @Bean
    public ModelMapper modelMapper(){

        return new ModelMapper();
    }

}
