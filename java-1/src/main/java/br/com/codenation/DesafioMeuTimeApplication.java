package br.com.codenation;

import br.com.codenation.exceptions.CapitaoNaoInformadoException;
import br.com.codenation.exceptions.IdentificadorUtilizadoException;
import br.com.codenation.exceptions.JogadorNaoEncontradoException;
import br.com.codenation.exceptions.TimeNaoEncontradoException;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class DesafioMeuTimeApplication implements MeuTimeInterface {
	private final List<Time> times = new ArrayList<>();
	private final List<Jogador> jogadores = new ArrayList<>();

	private void verificaSeNaoExisteTimeComId(Long idTime) {
		if (this.buscarTimes().contains(idTime)) {
			throw new IdentificadorUtilizadoException();
		}
	}

	private void verificaSeNaoExisteJogadorComId(Long idJogador) {
		if (this.jogadorIds().contains(idJogador)) {
			throw new IdentificadorUtilizadoException();
		}
	}

	private void verificaSeExisteTimeComId(Long idTime) {
		if (!this.buscarTimes().contains(idTime)) {
			throw new TimeNaoEncontradoException();
		}
	}

	private void verificaSeExisteJogadorComId(Long idJogador) {
		if (!this.jogadorIds().contains(idJogador)) {
			throw new JogadorNaoEncontradoException();
		}
	}

	private List<Long> jogadorIds() {
		return this.jogadores.stream()
				.map(Jogador::getId)
				.collect(Collectors.toList());
	}

	private Jogador jogadorComId(Long idJogador) {
		this.verificaSeExisteJogadorComId(idJogador);
		return this.jogadores.stream()
				.filter(jogador -> idJogador.equals(jogador.getId()))
				.findFirst()
				.get();
	}

	private List<Jogador> jogadoresDoTime(Long idTime) {
		this.verificaSeExisteTimeComId(idTime);
		return this.jogadores.stream()
				.filter(jogador -> idTime.equals(jogador.getIdTime()))
				.collect(Collectors.toList());
	}

	public void incluirTime(Long id, String nome, LocalDate dataCriacao, String corUniformePrincipal, String corUniformeSecundario) {
		this.verificaSeNaoExisteTimeComId(id);
		this.times.add(Time.builder()
				.withId(id)
				.withNome(nome)
				.withDataCriacao(dataCriacao)
				.withCorUniformePrincipal(corUniformePrincipal)
				.withCorUniformeSecundario(corUniformeSecundario)
				.build());
	}

	public void incluirJogador(Long id, Long idTime, String nome, LocalDate dataNascimento, Integer nivelHabilidade, BigDecimal salario) {
		this.verificaSeNaoExisteJogadorComId(id);
		this.verificaSeExisteTimeComId(idTime);
		this.jogadores.add(Jogador.builder()
				.withId(id)
				.withIdTime(idTime)
				.withIsCapitao(false)
				.withNome(nome)
				.withDataNascimento(dataNascimento)
				.withNivelHabilidade(nivelHabilidade)
				.withSalario(salario)
				.build());
	}

	public void definirCapitao(Long idJogador) {
		this.verificaSeExisteJogadorComId(idJogador);
		this.jogadorComId(idJogador).setCapitao(true);
	}

	public Long buscarCapitaoDoTime(Long idTime) {
		verificaSeExisteTimeComId(idTime);
		List<Jogador> capitao = this.jogadoresDoTime(idTime)
				.stream()
				.filter(Jogador::getIsCapitao)
				.collect(Collectors.toList());
		if (capitao.size() == 0) {
			throw new CapitaoNaoInformadoException();
		}
		return capitao.get(0).getId();
	}

	public String buscarNomeJogador(Long idJogador) {
		return this.jogadorComId(idJogador).getNome();
	}

	public String buscarNomeTime(Long idTime) {
		verificaSeExisteTimeComId(idTime);
		return this.times.stream()
				.filter(time -> idTime.equals(time.getId()))
				.findFirst()
				.get().getNome();
	}

	public List<Long> buscarJogadoresDoTime(Long idTime) {
		return this.jogadoresDoTime(idTime)
				.stream()
				.map(Jogador::getId)
				.collect(Collectors.toList());
	}

	public Long buscarMelhorJogadorDoTime(Long idTime) {
		return this.jogadoresDoTime(idTime)
				.stream()
				.max(Comparator.comparing(Jogador::getNivelHabilidade)
						.thenComparing(Jogador::getId))
				.get().getId();
	}

	public Long buscarJogadorMaisVelho(Long idTime) {
		return this.jogadoresDoTime(idTime)
				.stream()
				.min(Comparator.comparing(Jogador::getDataNascimento))
				.get()
				.getId();
	}

	public List<Long> buscarTimes() {
		return this.times.stream()
				.map(Time::getId)
				.collect(Collectors.toList());
	}

	public Long buscarJogadorMaiorSalario(Long idTime) {
		return this.jogadoresDoTime(idTime)
				.stream()
				.max(Comparator.comparing(Jogador::getSalario))
				.get()
				.getId();
	}

	public BigDecimal buscarSalarioDoJogador(Long idJogador) {
		return this.jogadorComId(idJogador)
				.getSalario();
	}

	public List<Long> buscarTopJogadores(Integer top) {
		if (jogadores.size() == 0) {
			return new ArrayList<>();
		}
		return this.jogadores.stream()
				.sorted(Comparator.comparing(Jogador::getNivelHabilidade).thenComparing(Jogador::getId).reversed())
				.map(Jogador::getId)
				.collect(Collectors.toList())
				.subList(0, top);
	}
}
