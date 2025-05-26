
package com.senac.hotel.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Entity
@Table(name="Cliente")
@Component
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String cliente;
    private String email;
    private int cpf;
    
    @OneToMany(mappedBy="cliente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Analise> analises = new ArrayList<>();
    
    public void adicionarAnalise(Analise analise){
        analise.setCliente(this);
        this.analises.add(analise);
    }
    
    
    
}
