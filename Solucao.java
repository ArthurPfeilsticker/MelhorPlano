//Solucao para o problema proposto no teste tecnico (Melhor Plano)

import java.io.*;
import java.util.*;

public class Solucao{//inicio classe Solucao

	public static void main(String[]args) throws Exception{//inicio main()

		String str;
		char[][]c;
		int n;

		try{//inicio try

			str = readEncoding("encode-2.in");
			n = str.length();
			c = setaMatriz(str);
			writeEncoding(c, n, str, "encode-2.out");

			str = readEncoding("encode-3.in");
			n = str.length();
			c = setaMatriz(str);
			writeEncoding(c, n, str, "encode-3.out");

			str = readEncoding("encode-4.in");
			n = str.length();
			c = setaMatriz(str);
			writeEncoding(c, n, str, "encode-4.out");
		
		}catch(Exception exception){//inicio tratamento dce esceptions

			System.out.println(exception);

		}//fim catch

	}//fim main()
	
	public static char[][] setaMatriz(String str){//inicio encoding()

		char[][] c = new char[str.length()][str.length()];
		char[] tmp = new char[str.length()];

		String temp = str;

		for(int i = 0; i < str.length(); i++){//inicio for

			tmp = encoding(temp);
			temp = setaString(tmp, str.length());

			for(int n = 0; n < str.length(); n++){//inicio for

				c[i][n] = tmp[n];

			}//fim for

		}//fim for

				String teste = "";


		c = ordena(c, str);

		return c;

	}//fim encoding

	public static char[] encoding(String str){//inicio encoding()

		int tam = str.length();
		char[] deslocado = new char[tam+1];
		char[] dSemUltimo = new char[tam];

		for(int i = tam; i > 0; i--){//inicio for

			if(i == tam)
				deslocado = setaVetor(deslocado, str);
			
			deslocado[i] = deslocado[i-1];

		}//fim for
		
		deslocado[0] = deslocado[tam];

		for(int j = 0; j < tam; j++){//inicio for

			dSemUltimo[j] = deslocado[j];

		}//fim for

		return dSemUltimo;

	}//fim encoding()

	public static String setaString(char[] c, int tam){//inicio setaString()

		String s = "";

		for(int i = 0; i < tam; i++){//inicio for

			s += c[i];

		}//fim for

		return s;

	}//fim setaString()

	public static char[] setaVetor(char[] deslocado, String str){//inicio setaVetor()
		int i;
		for(i = 0; i < str.length(); i++){//inicio for

			deslocado[i] = str.charAt(i);

			if(i == str.length()-1)
				deslocado[i+1] = str.charAt(0);

		}//fim for
	

		return deslocado;

	}//fim setaVetor()

	public static char[][] ordena(char c[][], String palavra){//inicio ordena()

		char[][] matriz = new char[palavra.length()][palavra.length()];
		String[] str = new String[palavra.length()];
		int posicao;


		for(int i = 0; i < palavra.length(); i++){//inicio for

			str[i] = "";

		}//fim for

		for(int i = 0; i < palavra.length(); i++){//inicio for
			for(int j = 0; j < palavra.length(); j++){//inicio for
				
				str[i] += c[i][j];

			}//fim for
		}//fim for

		for (int i = 1; i < str.length; i++) {
			String s = str[i];
			for (int j = i - 1; j >= 0 && str[j].compareToIgnoreCase(s) > 0; j--){
				str[j + 1] = str[j];
				str[j] = s;
			}//fim for
		}//fim for

		for(int i = 0; i < palavra.length(); i++){//inicio for
			for(int j = 0; j < palavra.length(); j++){//inicio for

				matriz[i][j] = str[i].charAt(j);  

              		}//fim for
		}//fim for

		return matriz;

	}//fim ordena()

	public static String readEncoding(String arq) throws Exception{//inicio readEncoding()
		BufferedReader br = new BufferedReader(new FileReader(arq));
		String str = br.readLine();

		br.close();

		return str;

	}//fim readEncoding()

	public static int achaCerta(char[][] c, int tam, String str){//inicio achaCerta()

		int posCerta = 0;
		String[] array = new String[tam];

		for(int i = 0; i < str.length(); i++){//inicio for

                        array[i] = "";

                }//fim for

		for(int i = 0;i < tam; i++){//inicio for
			for(int j = 0; j < tam; j++){//inicio for

				array[i] += c[i][j];

			}//fim for
		}//fim for

		for(int i = 0; i < tam; i++){//inicio for

			if(str.equals(array[i]))
				posCerta = i;

		}//fim for

		return posCerta;

	}//fim achaCerta()

	public static void writeEncoding(char[][] c, int tam, String str, String arquivo)throws Exception{//inicio writeEncoding()

		int posCerta = achaCerta(c, tam, str);
		String ultimas = "";

		for(int i = 0; i < tam; i++){//inicio for

			ultimas += c[i][tam-1];

		}//fim for

		BufferedWriter bw = new BufferedWriter(new FileWriter(arquivo));
		bw.write("['"+ultimas+"',"+posCerta+"]\n");

		bw.close();

	}//fim writeEncoding()

}//fim classe Solucao
