package com.vehicleandcar.manuelvehicleandcar.Service.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Moto {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
private String modelo;
private String marca;
private int    usuarioId; 
}
