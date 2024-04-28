package jogodaForca;
import java.util.Scanner;
public class JogoDaForca {
	
private static final String[] PALAVRAS = {"java", "programacao", "computador", "desenvolvimento", "openai"};
private static final int MAX_TENTATIVAS = 6;

public static void main(String[] args) {
try(Scanner scanner = new Scanner(System.in)){;
String palavraSecreta = selecionarPalavraSecreta();

char[] palavraEscondida = new char[palavraSecreta.length()];
boolean[] letrasUtilizadas = new boolean[26];
int tentativasRestantes = MAX_TENTATIVAS;

while (tentativasRestantes > 0 && !palavraRevelada(palavraEscondida)) {
System.out.println("Palavra: " + obterPalavraEscondida(palavraEscondida));
System.out.println("Tentativas restantes: " + tentativasRestantes);
System.out.print("Digite uma letra: ");
char letra = scanner.next().charAt(0);
if (letrasUtilizadas[letra - 'a']) {
System.out.println("Você já tentou essa letra. Tente outra.");
continue;

}

letrasUtilizadas[letra - 'a'] = true;
if (!palavraSecreta.contains(String.valueOf(letra))) {
System.out.println("Letra não encontrada na palavra secreta.");
tentativasRestantes--;
	} 
else 
{
System.out.println("Letra encontrada na palavra secreta!");
atualizarPalavraEscondida(palavraSecreta, palavraEscondida, letra);
	}
}

if (palavraRevelada(palavraEscondida)) {
System.out.println("Parabéns! Você ganhou! A palavra secreta era: " + palavraSecreta);
} 
else 

System.out.println("Você perdeu! A palavra secreta era: " + palavraSecreta);
	}
}

private static String selecionarPalavraSecreta() {
return PALAVRAS[(int) (Math.random() * PALAVRAS.length)];
}

private static boolean palavraRevelada(char[] palavraEscondida) {
for (char c : palavraEscondida) {
if (c == 0) {
return false;
		}
	}
return true;
}

private static String obterPalavraEscondida(char[] palavraEscondida) {
StringBuilder sb = new StringBuilder();
for (char c : palavraEscondida) {
if (c == 0) 
{
sb.append("_ ");
	} 
else 
{
sb.append(c).append(" ");
	}

}

return sb.toString();

}

private static void atualizarPalavraEscondida(String palavraSecreta, char[] palavraEscondida, char letra) {
for (int i = 0; i < palavraSecreta.length(); i++) {
if (palavraSecreta.charAt(i) == letra) {
palavraEscondida[i] = letra;
			}
		}
	}
}



