package Teste;

import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class Operacao {

	List<Double> lista = new ArrayList<Double>();

	public double media() {
		getLista();
		double j = 0;
		for (int k = 0; k < lista.size(); k++) {
			j = (double) lista.get(k) + j;
		}

		return j / lista.size();
	}

	public double moda() {
		getLista();
		double n = 0;
		double m = 0;
		double i = 0;
		for (int k = 0; k < lista.size(); k++) {
			for (int j = 0; j < lista.size(); j++) {
				if (lista.get(j).equals(lista.get(k))) {
					n = n + 1;
				}
				if (n > m) {
					m = n;
					i = lista.get(k);
				}
				n = 0;
			}
		}
		return i;
	}

	public double mediana() {
		getLista();
		if (lista.size() % 2 != 0) {
			return lista.get((lista.size() / 2));
		} else {
			return (lista.get((lista.size() / 2) - 1) + lista.get(lista.size() / 2)) / 2;
		}

	}

	public double variancia() {

		getLista();
		double m = media();
		double n = 0;

		for (int k = 0; k < lista.size(); k++) {
			n = n + (lista.get(k) - m) * (lista.get(k) - m);

		}
		return n / lista.size();

	}

	public double desvio() {

		return Math.sqrt(variancia());

	}

	public List<Double> getLista() {
		if (lista != null) {
			try {
				BufferedReader bufferedReader = new BufferedReader(new FileReader("Jsons/Numeros.json"));
				Type listType = new TypeToken<ArrayList<Double>>() {
				}.getType();
				this.lista = new Gson().fromJson(bufferedReader, listType);
			} catch (java.io.FileNotFoundException e) {

			}
		}
		return lista;
	}

}
