package br.com.dio;

import br.com.dio.Modelo.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static br.com.dio.util.BoardTemplate.BOARD_TEMPLATE;
import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

public class Main{

    private final static Scanner sc = new Scanner(System.in);

    private static Board board;

    private final static int BOARD_LIMIT =9;

    public static void main(String[] args) {
        final var positions = Stream.of(args)
                .collect(Collectors.toMap(k-> k.split(";")[0],
                        o-> o.split(";")[1]));

        int option = -1;
        while(true){
            System.out.println("Selecione uma das opções a seguir");
            System.out.println("1 - Iniciar um novo Jogo");
            System.out.println("2 - Colocar um novo numero");
            System.out.println("3 - Remover um numero");
            System.out.println("4 - Visualiar status do jogo");
            System.out.println("5 - Verificar status do jogo");
            System.out.println("6 - Limpar jogo");
            System.out.println("7 - Finalizar Jogo");
            System.out.println("8 - Sair");

            option = sc.nextInt();

            switch (option){
                case 1 -> startGame(positions);
                case 2 -> inputNumber();
                case 3 -> removeNumber();
                case 4 -> showCurrentGame();
                case 5 -> showgameStatus();
                case 6 -> clearGame();
                case 7 -> finishGame();
                case 8 -> System.exit(0);
                default -> System.out.println("Opção invalida, selecione uma das opções do menu");


            }
        }

    }

    private static void startGame(Map<String, String> positions) {
        if(nonNull(board)){
            System.out.println("Jogo iniciado com sucesso!");
            return;
        }

        List<List<Space>> sp = new ArrayList<>();
        for(int i = 0; i <= BOARD_LIMIT; i++){
            sp.add(new ArrayList<>());
            for(int j =0; j <BOARD_LIMIT; j++){
                String positionConfig = positions.get("%s,%s".formatted(i,j));

                if(positionConfig ==null){
                    sp.get(i).add(new Space(0,false));
                    continue;
                }

                int expected = Integer.parseInt(positionConfig.split(";")[0]);

                boolean fixed = Boolean.parseBoolean(positionConfig.split(";")[1]);

                var currentSpace = new Space(expected, fixed);
                sp.get(i).add(currentSpace);
            }
        }

        board = new Board(sp);
        System.out.println("O jogo esta pronto para começar");
    }

    private static void inputNumber() {
        if(isNull(board)){
            System.out.println("O jogo ainda não foi iniciado!");
            return;
        }

        System.out.println("Informe a coluna que em que o numero sera inserida");
        int col = runUntilGetValidNumber(0,8);

        System.out.println("Informe a linha que em que o numero sera inserida");
        int row = runUntilGetValidNumber(0,8);

        System.out.printf("Informe o numero que vai entrar na posição [%s,%s]\n",col,row);
        int valor = runUntilGetValidNumber(1,9);

        if(!board.changeValue(col,row,valor)){
            System.out.printf("A ppsição [%s,%s] tem um valor fixo\n",col,row);
        }
    }


    private static void removeNumber() {
        if(isNull(board)){
            System.out.println("O jogo ainda não foi iniciado!");
            return;
        }

        System.out.println("Informe a coluna que em que o numero sera inserida");
        int col = runUntilGetValidNumber(0,8);

        System.out.println("Informe a linha que em que o numero sera inserida");
        int row = runUntilGetValidNumber(0,8);

        if(!board.clearValue(col,row)){
            System.out.printf("A posição [%s,%s] tem um valor fixo\n",col,row);
        }
    }

    private static void showCurrentGame() {
        if(isNull(board)){
            System.out.println("O jogo ainda não foi iniciado!");
            return;
        }

        var args = new Object[81];
        var argPositions = 0;
        var colsize = BOARD_LIMIT;

        for(int i = 0; i < BOARD_LIMIT; i++){
            for(var col : board.getSpaces()){
                args[argPositions ++] = " " + ((isNull(col.get(i).getActual())) ? " " : col.get(i).getActual());
            }
        }
        System.out.println("Seu jogo se encontra de seguinte forma");
        System.out.printf((BOARD_TEMPLATE) + "\n",args);
    }

    private static void showgameStatus() {
        if(isNull(board)){
            System.out.println("O jogo ainda não foi iniciado!");
            return;
        }
        System.out.printf("O jogo atualmente se encontra no status %s\n",board.getStatus().getLabel());
        if(board.hasError()){
            System.out.println("O jogo contem erros");

        } else{
            System.out.println("O jogo não contem erros");
        }
    }

    private static void clearGame() {
        if(isNull(board)){
            System.out.println("O jogo ainda não foi iniciado!");
            return;
        }
        System.out.println("Tem certeza que deseja limpar seu jogo e perder todo seu progresso? ");

        sc.nextLine();
        String confirm = sc.nextLine();

        while(!confirm.equalsIgnoreCase("Sim") && !confirm.equalsIgnoreCase("Não")){

            System.out.println("Informe 'Sim' ou 'Não'");
            confirm = sc.nextLine();
        }

        if(confirm.equalsIgnoreCase("Sim")){
            board.reset();
        }
    }

    private static void finishGame() {
        if(isNull(board)){
            System.out.println("O jogo ainda não foi iniciado!");
            return;
        }
        if(board.gameIsFinished()){
            System.out.println("Parabens voce concluiu o jogo");
            showCurrentGame();
            board = null;

        } else if (board.hasError()){
            System.out.println("Seu Jogo conte, erros, verifique se board e ajuste-o");

        } else {
            System.out.println("voce ainda precisa preencher o espaço");
        }
    }

    private static int runUntilGetValidNumber(final int min,final int max) {
        int current = sc.nextInt();
        while(current < min|| current > max){
            System.out.printf("Informe um numero entre %s e %s",min,max);
            current = sc.nextInt();
        }
        return current;

    }
}