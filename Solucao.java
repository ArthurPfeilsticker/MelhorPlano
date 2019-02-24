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

			str = readDecoding1("decode-5.in");
                        n = str.length();
                        c = insereMatriz(str);
                        writeDecoding(c, str, "decode-5.out", "decode-5.in");

                        str = readDecoding2("decode-6.in");
                        n = str.length();
                        c = insereMatriz(str);
                        writeDecoding(c, str, "decode-6.out", "decode-6.in");

                        str = readDecoding1("decode-7.in");
                        n = str.length();
                        c = insereMatriz(str);
                        writeDecoding(c, str, "decode-7.out", "decode-7.in");

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

		for(int i = 0; i < palavra.length(); i++){//inicio for1
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

	public static String readDecoding1(String arq)throws Exception{//inicio readDecodng1()

                RandomAccessFile raf = new RandomAccessFile(arq, "r");
                raf.seek(2);

                String str = "";
               	long tamanho = (long)raf.length()-8;
                for(int i = 0; i < tamanho; i++){//inicio for
                        str += (char)raf.read();
                }//fim for
                raf.close();

                return str;

        }//fim readDecoding1()

        public static String readDecoding2(String arq)throws Exception{//inicio readDecodng2()

                RandomAccessFile raf = new RandomAccessFile(arq, "r");
                raf.seek(2);

                String str = "";
                long tamanho = (long)raf.length()-7;
                for(int i = 0; i < tamanho; i++){//inicio for
                        str += (char)raf.read();
                }//fim for
                raf.close();

                return str;

        }//fim readDecoding2()

	public static int readPosicao(String arq) throws Exception{//inicio readPosicao()

		RandomAccessFile raf = new RandomAccessFile(arq, "r");
                int pos = (int)raf.length()-3;
		raf.seek(pos);
		String str = "";
		int posCerta;
		str += (char)raf.read();
		posCerta = Integer.parseInt(str);
                raf.close();

                return posCerta;

	}//fim readPosicao()

	public static char[][] insereMatriz(String str){//inicio insereMatriz()

		char [][] matriz = new char[str.length()][str.length()];
		int cont = 0;

		for(int i = 0; i < str.length(); i++){//inicio for
			for(int j = 0; j < str.length(); j++){//inicio for
				matriz[i][j] = '-';
			}//fim for
		}//fim for

		for(int i = str.length()-1; i >= 0; i--){//inicio for
			for(int j = 0; j < str.length(); j++){//inicio for
				matriz[j][i] = str.charAt(j);
			}//fim for
			matriz = ordena(matriz, str);
		}//fim for

		for(int i = 0; i < str.length(); i++){
			for(int j = 0; j < str.length(); j++){
				System.out.print(matriz[i][j]);
			}
			System.out.println();
		}

		return matriz;

	}//fim insereMatriz()

	public static void writeDecoding(char[][] c, String str, String arquivo, String arquivo_2)throws Exception{//inicio writeEncoding()

		File arq = new File(arquivo);
                arq.createNewFile();

		String certa = "";
		int posicao = readPosicao(arquivo_2);

                for(int i = 0; i < str.length(); i++){//inicio for
                        certa += c[posicao][i];
                }//fim for

		System.out.println(certa);

                BufferedWriter bw = new BufferedWriter(new FileWriter(arq));
                bw.write(certa);
                bw.close();

        }//fim writeEncoding()

}//fim classe Solucao
