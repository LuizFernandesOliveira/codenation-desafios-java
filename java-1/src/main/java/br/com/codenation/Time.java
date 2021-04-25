package br.com.codenation;

import java.time.LocalDate;

public class Time {
    private final Long id;

    private final String nome;

    private final LocalDate dataCriacao;

    private final String corUniformePrincipal;

    private final String corUniformeSecundario;

    public Time(Long id, String nome, LocalDate dataCriacao, String corUniformePrincipal, String corUniformeSecundario) {
        this.id = id;
        this.nome = nome;
        this.dataCriacao = dataCriacao;
        this.corUniformePrincipal = corUniformePrincipal;
        this.corUniformeSecundario = corUniformeSecundario;
    }

    public Long getId() { return id; }

    public String getNome() { return nome; }

    public LocalDate getDataCriacao() { return dataCriacao; }

    public String getCorUniformePrincipal() { return corUniformePrincipal; }

    public String getCorUniformeSecundario() { return corUniformeSecundario; }

    public static TimeBuilder builder() {
        return new TimeBuilder();
    }

    public static class TimeBuilder {

        private Long id;

        private String nome;

        private LocalDate dataCriacao;

        private String corUniformePrincipal;

        private String corUniformeSecundario;

        public TimeBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public TimeBuilder withNome(String nome) {
            this.nome = nome;
            return this;
        }

        public TimeBuilder withDataCriacao(LocalDate dataCriacao) {
            this.dataCriacao = dataCriacao;
            return this;
        }

        public TimeBuilder withCorUniformePrincipal(String corUniformePrincipal) {
            this.corUniformePrincipal = corUniformePrincipal;
            return this;
        }

        public TimeBuilder withCorUniformeSecundario(String corUniformeSecundario) {
            this.corUniformeSecundario = corUniformeSecundario;
            return this;
        }

        public Time build() {
            return new Time(id, nome, dataCriacao, corUniformePrincipal, corUniformeSecundario);
        }
    }
}
