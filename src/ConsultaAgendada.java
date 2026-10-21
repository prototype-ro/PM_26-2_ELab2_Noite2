import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

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
 * Representa uma consulta agendada com antecedência.
 * @see Consulta
 * @see EEspecialidade
 */
public class ConsultaAgendada extends Consulta {

	/** Antecedência mínima, em dias, para agendar a consulta. */
	private static final int ANTECEDENCIA_MINIMA = 2;

	/** Antecedência, em dias, a partir da qual o desconto se aplica. */
	private static final int ANTECEDENCIA_DESCONTO = 21;

	/** Percentual de desconto aplicável (0.30 = 30%). */
	private static final double PCT_DESCONTO = 0.30;

	/** Valor do desconto a ser abatido do preço da consulta. */
	private double valorDesconto;

	/**
	 * Cria uma consulta agendada.
	 * <p>
	 * Se a data informada tiver antecedência inferior a
	 * {@code ANTECEDENCIA_MINIMA} dias, o horário é ajustado para esta antecedência.
	 * 
	 *
	 * @param paciente nome do paciente
	 * @param hora data e horário desejados para a consulta
	 * @param espec especialidade médica da consulta
	 */
	public ConsultaAgendada(String paciente, LocalDateTime hora, EEspecialidade espec) {
		LocalDate data = LocalDate.from(hora);
		long dias = LocalDate.now().until(data, ChronoUnit.DAYS);
		if(dias < ANTECEDENCIA_MINIMA)
			hora = LocalDateTime.now().plusDays(ANTECEDENCIA_MINIMA);
		super(paciente, hora, espec);
		
		//TODO: calcular desconto, se for o caso.
		if (dias < ANTECEDENCIA_DESCONTO);


	}

	/**
	 * Calcula o valor da consulta.
	 * <p>
	 * O valor é o preço da especialidade ({@code especialidade.valor()})
	 * subtraído do desconto ({@code valorDesconto}).
	 * </p>
	 *
	 * @return valor final da consulta, já descontado
	 */
	public double valorConsulta() {
		return especialidade.valor() - valorDesconto;	
	}
}