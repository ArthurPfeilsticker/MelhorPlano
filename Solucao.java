//Solucao para o problema proposto no teste tecnico (Melhor Plano)

public class Solucao{//inicio classe Solucao

	public static void main(String[]args){//inicio main()

		String str = MyIO.readLine();
		int n = str.length();
		char[][] c;

		c = setaMatriz(str);
		mostrar(c, n);

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

	public static char[][] ordena(char c[][]){//inicio ordena()

		

	}//fim ordena()

	public static void mostrar(char[][] c, int tam){//inicio mostrar()

		String ultimas = "";
		
		for(int i = 0;i < tam; i++){//inicio for

			ultimas += c[i][tam-1];

		}//fim for

		MyIO.println(ultimas);

	}//fim mostrar()

}//fim classe Solucao
