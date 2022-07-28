package br.com.bhut.service;

import br.com.bhut.message.LogCarSendMessage;
import br.com.bhut.model.Car;
import br.com.bhut.model.LogCar;
import br.com.bhut.repository.LogCarRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class CarService {

    private WebClient webClient;
    private LogCarRepository carRepository;
    private LogCarSendMessage carSendMessage;


    /**
     *
     * @return Retorna uma lista com todos os carros da API externa
     */
    public List<Car> findAllCars(){

        List<Car> listCar = this.webClient
                .get()
                .uri("/api/cars")
                .retrieve()
                .toEntityList(Car.class)
                .block()
                .getBody();

        return  listCar;
    }


    /**
     *
     * @param newCar O carro que vai ser persistido na API externa.
     * @return vai retornar o carro salvo.
     */
    public Car createCar(Car newCar) {

        Car savedCar = this.webClient
                .post()
                .uri("/api/cars")
                .body(BodyInserters.fromValue(newCar))
                .retrieve()
                .bodyToMono(Car.class)
                .block();

        insertLog(savedCar);



        return savedCar;
    }


    /**
     *
     * @return Retorna uma lista com todos os logs.
     */
    public List<LogCar> findAllLogs(){

        return carRepository.findAll();
    }


    /**
     *
     * @param logCar O log deste carro será salvo.
     */
    private void insertLog(Car logCar){

        LogCar newLogCar = LogCar.builder()
                .car_id(logCar.get_id())
                .data_hora(LocalDateTime.now())
                .build();

        carRepository.save(newLogCar);
        carSendMessage.sendMessage(newLogCar);
    }

}
