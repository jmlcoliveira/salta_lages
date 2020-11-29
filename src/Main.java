import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        int comprimento = inp.nextInt();
        int nLages = inp.nextInt();
        inp.nextLine();
        int count = 0;
        int[] lages = new int[nLages];
        while (count < nLages) {
            lages[count] = inp.nextInt();
            inp.nextLine();
            count++;
        }
        escrever(lages, comprimento);
    }

    private static void escrever(int[] lages, int comprimentoSalto) {
        int resultado = 0;
        int count = 0;
        for (int i = 0; i < lages.length; i++) {
            if (count % 2 == 0) {
                int valor_max = -1;
                int indice_valor_max = i;
                for (int j = i; j < getCompMax(i, comprimentoSalto, lages); j++) {
                    if (valor_max < lages[j]) {
                        valor_max = lages[j];
                        indice_valor_max = j;
                    }
                }
                i = indice_valor_max;
                resultado += valor_max;
            } else if (count % 2 != 0 && i + comprimentoSalto <= lages.length) {
                int valor_min = Integer.MAX_VALUE;
                int indice_valor_min = i;
                for (int j = i; j < getCompMax(i, comprimentoSalto, lages); j++) {
                    if (valor_min > lages[j]) {
                        valor_min = lages[j];
                        indice_valor_min = j;
                    }
                }
                i = indice_valor_min;
                resultado -= valor_min;
            } else {
                i = lages.length;
            } ;
            count++;
        }
        System.out.println(resultado);
    }

    private static int getCompMax(int index, int comprimentoSalto, int[] lages) {
        if (index + comprimentoSalto >= lages.length) return lages.length;
        return index + comprimentoSalto;
    }
}
