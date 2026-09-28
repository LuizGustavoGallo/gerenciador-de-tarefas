package com.gustavo.gerenciadorDeTarefas.Tarefa;

import com.gustavo.gerenciadorDeTarefas.Funcionario.FuncionarioModel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "tb_tarefas")
public class TarefaModel {

    @ManyToOne
    @JoinColumn(name = "funcionario_Id")
    private FuncionarioModel funcionario;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String descricao;

    private LocalDate data;

    public TarefaModel(String nome, String descricao, LocalDate data, FuncionarioModel funcionario){
        this.nome = nome;
        this.descricao = descricao;
        this.data = data;
        this.funcionario = funcionario;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "Status_Tarefa")
    private StatusTarefa statusTarefa;

    @Enumerated(EnumType.STRING)
    @Column(name = "Prioridade_Tarefa")
    private PrioridadeTarefa prioridadeTarefa;

    public TarefaModel(String nome, String descricao, LocalDate data, StatusTarefa statusTarefa, FuncionarioModel funcionario, PrioridadeTarefa prioridadeTarefa) {
        this(nome, descricao, data, funcionario);
        this.statusTarefa = StatusTarefa.PENDENTE;
        this.prioridadeTarefa = prioridadeTarefa;
    }
}
