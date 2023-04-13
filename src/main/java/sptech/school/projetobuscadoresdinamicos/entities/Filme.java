package sptech.school.projetobuscadoresdinamicos.entities;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Filme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Schema(description = "Representa o nome do filme", example = "Homem-Aranha")
    private String nome;

    @ManyToOne
    @JoinColumn(name = "diretor_id")
    private Diretor diretor;

    private LocalDate dataLancamento;
    private double custoProducao;
    private boolean indicacaoOscar;

    public Diretor getDiretor() {
        return diretor;
    }

    public void setDiretor(Diretor diretor) {
        this.diretor = diretor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(LocalDate dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public double getCustoProducao() {
        return custoProducao;
    }

    public void setCustoProducao(double custoProducao) {
        this.custoProducao = custoProducao;
    }

    public boolean isIndicacaoOscar() {
        return indicacaoOscar;
    }

    public void setIndicacaoOscar(boolean indicacaoOscar) {
        this.indicacaoOscar = indicacaoOscar;
    }
}
