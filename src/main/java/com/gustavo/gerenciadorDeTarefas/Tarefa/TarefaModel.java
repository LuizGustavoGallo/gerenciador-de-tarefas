package com.gustavo.gerenciadorDeTarefas.Tarefa;

import com.gustavo.gerenciadorDeTarefas.Funcionario.FuncionarioModel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Locale;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "tb_tarefas")
public class TarefaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String descricao;

    private LocalDate data;

    @Enumerated(EnumType.STRING)
    @Column(name = "Status_Tarefa")
    private StatusTarefa statusTarefa;

    @Enumerated(EnumType.STRING)
    @Column(name = "Prioridade_Tarefa")
    private PrioridadeTarefa prioridadeTarefa;

    @ManyToOne
    @JoinColumn(name = "funcionario_id")
    private FuncionarioModel funcionario;

    public TarefaModel(String nome, String descricao, LocalDate data, PrioridadeTarefa prioridadeTarefa, FuncionarioModel funcionario){
        this.nome = nome;
        this.descricao = descricao;
        this.data = data;
        this.prioridadeTarefa = prioridadeTarefa;
        this.funcionario = funcionario;
        this.statusTarefa = StatusTarefa.PENDENTE;
    }
}