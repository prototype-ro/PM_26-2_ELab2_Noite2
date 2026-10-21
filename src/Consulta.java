import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/** 
 * MIT License
 *
 * Copyright(c) 2026 João Caram <caram@pucminas.br>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 * 
 * @author João Caram @joaocaram (caram@pucminas.br)
 * Uso do @Copilot para gerar a base da documentação (revisada manualmente)
 */


/**
 * Classe abstrata para representar uma consulta médica.
 * <p>
 * Uma consulta possui paciente, horário e especialidade, além de definir
 * o contrato para cálculo de seu valor por meio de {@link #valorConsulta()}.
 * </p>
 */
public abstract class Consulta {

	/** Nome do paciente associado à consulta. */
	protected  String nomePaciente;

	/** Data e horário da consulta. */
	protected  LocalDateTime horario;

	/** Especialidade médica da consulta. */
	protected  EEspecialidade especialidade;

	/**
	 * Cria uma consulta com paciente, horário e especialidade.
	 *Se {@code hora} estiver no passado, ajusta para agora + 1 minuto.
	 *Se {@code espec} for {@code null}, usa {@code EEspecialidade.ALERGOLOGIA}.
	 *
	 * @param paciente nome do paciente
	 * @param hora data e horário desejados para a consulta
	 * @param espec especialidade médica da consulta
	 */
	public Consulta(String paciente, LocalDateTime hora, EEspecialidade espec) {
		if(paciente.length() == 0)
			paciente = "Anônimo";
		if(hora.isBefore(LocalDateTime.now()))
			hora = LocalDateTime.now().plusMinutes(1);
		if(espec == null)
			espec = EEspecialidade.ALERGOLOGIA;

		nomePaciente = paciente;
		horario = hora;
		especialidade = espec;
	}

	/**
	 * Calcula o valor da consulta.
	 *
	 * @return valor monetário da consulta
	 */
	public abstract double valorConsulta();

	/**
	 * Retorna uma representação textual da consulta.
	 * <p>
	 * O formato de data/hora utilizado é {@code dd/MM/uu HH:mm}.
	 * </p>
	 *
	 * @return texto com especialidade, paciente, horário e valor da consulta
	 */
	public String toString() {
		DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/uu HH:mm");
		return String.format("Consulta de %s para %s, marcada para %s: R$ %.2f", 
							especialidade.name().toLowerCase(), 
							nomePaciente, 
							formatador.format(horario), 
							valorConsulta()
		);		
	}

	/**
	 * Verifica se a consulta está agendada para a data informada.
	 * 
	 * @param data data a ser verificada
	 * @return {@code true} se a consulta ocorrer na data informada;
	 */
	public boolean estahNoDia(LocalDate data) {
		return LocalDate.from(horario) == data;
	}

}