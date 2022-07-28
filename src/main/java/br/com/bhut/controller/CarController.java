package br.com.bhut.controller;

import br.com.bhut.model.Car;
import br.com.bhut.model.LogCar;
import br.com.bhut.service.CarService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
@AllArgsConstructor
public class CarController {

    private CarService carService;

    /**
     *
     * @return Retorna um ResponseEntity com a lista de carros presentes na API externa, endpoint: http://localhost:8080/api/listCars.
     */
    @GetMapping("/listCars")
    public ResponseEntity<List<Car>> listCars(){

        return new ResponseEntity<>(carService.findAllCars(), HttpStatus.OK);
    }

    /**
     *
     * @param newCar O carro será passado através do body da aplicação para ser persistido na API externa.
     * @return Retorna um ResponseEntity com o carro que foi criado no body, endpoint: http://localhost:8080/api/createCar.
     */
    @PostMapping("/createCar")
    public ResponseEntity<Car> createCar(@RequestBody Car newCar){

        return new ResponseEntity<>(carService.createCar(newCar), HttpStatus.CREATED);
    }

    /**
     *
     * @return Retorna um ResponseEntity com a lista dos logs no body, endpoint: http://localhost:8080/api/logs.
     */
    @GetMapping("/logs")
    public ResponseEntity<List<LogCar>> listLogs(){

        return new ResponseEntity<>(carService.findAllLogs(), HttpStatus.OK);
    }
}
