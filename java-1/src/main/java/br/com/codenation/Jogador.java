package br.com.codenation;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Jogador {

    private final Long id;

    private Long idTime;

    private Boolean isCapitao;

    private final String nome;

    private final LocalDate dataNascimento;

    private Integer nivelHabilidade;

    private BigDecimal salario;

    public Jogador(Long id, Long idTime, Boolean isCapitao, String nome, LocalDate dataNascimento, Integer nivelHabilidade, BigDecimal salario) {
        this.id = id;
        this.idTime = idTime;
        this.isCapitao = isCapitao;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.nivelHabilidade = nivelHabilidade;
        this.salario = salario;
    }

    public Long getId() { return id; }

    public Long getIdTime() { return idTime; }

    public Boolean getIsCapitao() {
        return isCapitao;
    }

    public String getNome() { return nome; }

    public LocalDate getDataNascimento() { return dataNascimento; }

    public Integer getNivelHabilidade() { return nivelHabilidade; }

    public BigDecimal getSalario() { return salario; }

    public void setIdTime(Long idTime) {
        this.idTime = idTime;
    }

    public void setCapitao(Boolean capitao) {
        isCapitao = capitao;
    }

    public void setNivelHabilidade(Integer nivelHabilidade) {
        this.nivelHabilidade = nivelHabilidade;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public static JogadorBuilder builder() {
        return new JogadorBuilder();
    }

    public static class JogadorBuilder {

        private Long id;

        private Long idTime;

        private Boolean isCapitao;

        private String nome;

        private LocalDate dataNascimento;

        private Integer nivelHabilidade;

        private BigDecimal salario;

        public JogadorBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public JogadorBuilder withIdTime(Long idTime) {
            this.idTime = idTime;
            return this;
        }

        public JogadorBuilder withIsCapitao(Boolean isCapitao) {
            this.isCapitao = isCapitao;
            return this;
        }

        public JogadorBuilder withNome(String nome) {
            this.nome = nome;
            return this;
        }

        public JogadorBuilder withDataNascimento(LocalDate dataNascimento) {
            this.dataNascimento = dataNascimento;
            return this;
        }

        public JogadorBuilder withNivelHabilidade(Integer nivelHabilidade) {
            this.nivelHabilidade = nivelHabilidade;
            return this;
        }

        public JogadorBuilder withSalario(BigDecimal salario) {
            this.salario = salario;
            return this;
        }

        public Jogador build() {
            return new Jogador(id, idTime, isCapitao, nome, dataNascimento, nivelHabilidade, salario);
        }
    }
}
