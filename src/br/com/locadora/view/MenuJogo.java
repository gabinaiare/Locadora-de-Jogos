package br.com.locadora.view;

import br.com.locadora.model.*;
import br.com.locadora.service.JogoService;
import br.com.locadora.service.ClienteService;
import br.com.locadora.service.LocadoraService;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;


public class MenuJogo {
     private Scanner input;
     private JogoService jogoService;
     private ClienteService clienteService;
     private LocadoraService locadoraService;

    public MenuJogo(JogoService jogoService, ClienteService clienteService, LocadoraService locadoraService) {
        this.input = new Scanner(System.in);
        this.jogoService = jogoService;
        this.clienteService = clienteService;
        this.locadoraService = locadoraService;
    }

    
}