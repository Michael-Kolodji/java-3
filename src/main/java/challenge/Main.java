package challenge;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import challenge.models.Jogador;

public class Main {

	private List<Jogador> fifaList = readArchive();

	// Quantas nacionalidades (coluna `nationality`) diferentes existem no arquivo?
	public int q1() {
		List<String> nationalities = new ArrayList<>();
		
		fifaList.forEach(jogador -> {
			if(!nationalities.contains(jogador.getNationality())) {
				nationalities.add(jogador.getNationality());
			}
		});
		
		return nationalities.size();
	}

	// Quantos clubes (coluna `club`) diferentes existem no arquivo?
	// Obs: Existem jogadores sem clube.
	public int q2() {
		List<String> clubs = new ArrayList<String>();
		
		fifaList.forEach(jogador -> {
			if(!clubs.contains(jogador.getClub()) && !jogador.getClub().equals(null)) {
				clubs.add(jogador.getClub());
			}
		});
		
		return clubs.size();
	}

	// Liste o primeiro nome (coluna `full_name`) dos 20 primeiros jogadores.
	public List<String> q3() {
		List<String> names = new ArrayList<>();
		
		names = fifaList.stream()
							.limit(20)
							.map(jogador -> jogador.getFullName().substring(0, jogador.getFullName().indexOf(" ")))
							.collect(Collectors.toList());
		return names;
	}

	// Quem são os top 10 jogadores que possuem as maiores cláusulas de rescisão?
	// (utilize as colunas `full_name` e `eur_release_clause`)
	public List<String> q4() {
		
		return null;
	}

	// Quem são os 10 jogadores mais velhos (use como critério de desempate o
	// campo `eur_wage`)?
	// (utilize as colunas `full_name` e `birth_date`)
	public List<String> q5() {
		return null;
	}

	// Conte quantos jogadores existem por idade. Para isso, construa um mapa onde
	// as chaves são as idades e os valores a contagem.
	// (utilize a coluna `age`)
	public Map<Integer, Integer> q6() {
		return null;
	}

	public List<Jogador> readArchive() {

		String csvFile = "src/main/resources/data.csv";
		String line = "";
		String cvsSplitBy = ",";
		List<Jogador> list = new ArrayList<>();

		try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

			while ((line = br.readLine()) != null) {

				String[] register = line.split(cvsSplitBy);
				if (!register[0].contains("ID")) {

					BigDecimal eurReleaseClause = register[18].equals("") ? BigDecimal.ZERO
							: new BigDecimal(register[18]);

					Jogador jogador = new Jogador(new Long(register[0]), register[1], register[2], register[3], new Integer(register[6]), 
													LocalDate.parse(register[8]), register[14], new BigDecimal(register[17]), eurReleaseClause);
					list.add(jogador);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	public static void main(String[] args) {
//		System.out.println(new Main().q2());
		new Main().q3().forEach(System.out::println);
	}

}
