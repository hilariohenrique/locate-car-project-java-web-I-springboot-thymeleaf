package br.com.ada.locatecarprojectjavawebI.controller;

import br.com.ada.locatecarprojectjavawebI.model.Aluguel;
import br.com.ada.locatecarprojectjavawebI.service.AluguelService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class AluguelController {

    @Autowired
    private AluguelService aluguelService;

}
