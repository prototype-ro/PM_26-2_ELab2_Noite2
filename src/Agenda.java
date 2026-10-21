import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

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
 * Representa a agenda de consultas da clínica.
 * <p>
 * Mantém uma coleção de {@link Consulta} e oferece operações para
 * adicionar consultas e consultar a agenda de um determinado dia.
 * </p>
 *
 * @see Consulta
 */
public class Agenda {

	/** Lista de consultas agendadas. */
	private List<Consulta> agenda;

	/**
	 * Cria uma agenda vazia.
	 */
	public Agenda() {
		agenda = new LinkedList<>();
	}

	/**
	 * Adiciona uma consulta à agenda.
	 * <p>
	 * Se a consulta informada for {@code null}, ela é ignorada e a agenda
	 * permanece inalterada.
	 * </p>
	 *
	 * @param consulta a consulta a ser adicionada; pode ser {@code null}
	 *                 (neste caso, nada é adicionado)
	 * @return a quantidade total de consultas na agenda após a operação
	 */
	public int addConsulta(Consulta consulta) {
		if(consulta != null)
			agenda.add(consulta);
		return  agenda.size();
	}

	/**
	 * Gera a descrição da agenda de um dia específico.
	 *
	 * @param dia o dia para o qual se deseja obter a agenda
	 * @return uma {@code String} com as consultas do dia 
	 */

	private String resultado;
	private LocalDate diaAtual;

	public String agendaDoDia(LocalDate dia) {
		resultado = "";	
		diaAtual = LocalDate.now();
		for (Consulta consulta : agenda) {
			if (diaAtual == dia) {
				resultado += consulta.toString();
			}

		}
		return resultado;
	}

}