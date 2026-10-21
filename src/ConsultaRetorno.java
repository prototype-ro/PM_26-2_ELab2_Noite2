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
 * Representa uma consulta de retorno, vinculada a uma consulta anterior.
 * @see Consulta
 */
public class ConsultaRetorno extends Consulta {

	/** Intervalo máximo, em dias, entre a consulta original e o retorno. */
	private static final int INTERVALO_MAXIMO = 31;

	/** Consulta original à qual este retorno está associado. */
	private Consulta consultaAnterior;

	/** Criar variavel double de desconto */
	private double valorDesconto;
	/**
	 * Cria uma consulta de retorno.
	 * 
	 * @param hora data e horário desejados para o retorno
	 * @param original consulta original da qual este é o retorno
	 */
	public ConsultaRetorno(LocalDateTime hora, Consulta original) {
		/** determinar data e horario da consulta retorno */
		consultaAnterior = original;
		LocalDate data = LocalDate.from(hora);
		LocalDate dataOriginal = LocalDate.from(consultaAnterior.horario);
		long dias = dataOriginal.until(data, ChronoUnit.DAYS);

		if(dias < INTERVALO_MAXIMO)
			/** dizer que o retorno vai ter o desconto */;
		 	valorDesconto = original.especialidade.valor(); 
		/** conferir a diferenca em dias entre a consulta original e retorno */

		super(null, null, null);
	}

	/**
	 * Calcula o valor da consulta de retorno.
	 * @return valor da consulta de retorno (atualmente, {@code 0})
	 */
	public double valorConsulta() {
		return especialidade.valor() - valorDesconto;	
	}

}