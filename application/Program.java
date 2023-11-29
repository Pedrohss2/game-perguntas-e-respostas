package application;

import entities.Person;

import java.io.BufferedWriter;

import java.io.FileWriter;
import java.util.*;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Person> list = new ArrayList<>();

        int hits = 0;
        int erros = 0;
        String name;
        String email;

        try {
            String[] dadosMensage = new String[]{
                    "Qual o resultado de 32 x 8?",
                    "Qual o valor sastifaz essa conta 8 x ? =  72",
                    "Realizar a conta sem o auxílio da calculadore: 925 - 413?",
            };

            int[] respostaCerta = new int[] {
                    256, 9, 413
            };

            System.out.println("========== challenge NerdSchool ==========");

            System.out.println("Digite seu nome para começar");
            name = sc.nextLine();

            System.out.println("Digite seu email: EX(....@gmail.com)");
            email = sc.nextLine();


            list.add(new Person(name, email));

            for (int i = 0; i < dadosMensage.length;i++){
                System.out.println(dadosMensage[i]);
                int resposta = sc.nextInt();

                if(resposta != respostaCerta[i]){
                    System.out.println("Errou, valor certo: " + respostaCerta[i]);
                    erros++;
                }
                else {
                    System.out.println("Acertou");
                    hits++;
                }
            }
            for (Person li : list){
                System.out.println(li + " Total de questões acertadas: " + hits);
                System.out.println(li + " Total de questões Erradas: " + erros);
            }

        }
        catch (RuntimeException e) {
            System.out.println("Error: " + e.getMessage());
        }

        String path = "C:\\Temp\\Pessoa.csv";
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))){

            for (Person lis : list) {
                bw.write(" Name: " + lis.getName() + ", " + " Email: " + lis.getEmail() + ", " + " Total de acertos: " + hits + "\r\n");
            }
        }
        catch (Exception e){
            System.out.println("Error " + e.getMessage());
        }
        sc.close();
    }
}
