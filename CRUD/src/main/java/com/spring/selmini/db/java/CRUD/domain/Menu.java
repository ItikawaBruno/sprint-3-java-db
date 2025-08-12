package com.spring.selmini.db.java.CRUD.domain;

import com.spring.selmini.db.java.CRUD.repository.ColaboradorRepository;
import com.spring.selmini.db.java.CRUD.repository.GestorRepository;
import com.spring.selmini.db.java.CRUD.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@Service
public class Menu {

    Scanner e = new Scanner(System.in);

    @Autowired
    private ColaboradorRepository colaboradorRepository;

    @Autowired
    private GestorRepository gestorRepository;

    @Autowired
    private TarefaRepository tarefaRepository;

    public void menu(){
        String menu = """
                1. Criar gestor
                2. Criar colaborador
                3. Criar tarefas
                4. Listar tarefas do colaborador
                5. Remover colaborador pelo email
                6. Remover gestor pelo email
                7. Remover tarefas
                8. Listar dados gestor
                9. Listar dados colaborador
                10. Sair
                """;
        int opcao = 0;

        do{
            System.out.println(menu);
            opcao =e.nextInt();

            switch (opcao){
                case 1 -> criarGestor();
                case 2 -> System.out.println(criarColaborador());
                case 3 -> System.out.print(criarTarefas());
                case 4 -> listarTarefasColaborador();
                case 5 -> removerColaborador();
                case 6 -> removerGestor();
                case 7 -> removerTarefas();
                case 8 -> System.out.println(listarDadosGestor());
                case 9 -> System.out.println(listarDadosColaborador());
                case 10 -> System.out.println("saindo...");
                default -> System.out.println("opção inálida!");
            }

        }while(opcao != 10);

    }

    private String listarDadosGestor() {
        System.out.print("Digite o email do gestor: ");
        String email = e.next();
        Optional<Gestor> gestor = gestorRepository.findByEmail(email);
        if (gestor.isEmpty()){
            return "Gestor não encontrado";
        }
        Gestor g = gestor.get();
        return g.toString();
    }


    private String listarDadosColaborador(){
        System.out.print("Digite o email do colaborador: ");
        String email = e.next();
        Optional<Colaborador> colaborador = colaboradorRepository.findByEmail(email);
        if (colaborador.isEmpty()){
            return "Gestor não encontrado";
        }
        Colaborador c = colaborador.get();
        return c.toString();
    }

    private void removerTarefas() {
        System.out.print("Digite o titulo da tarefa: ");
        String titulo = e.next();
        Tarefa tarefa = tarefaRepository.findByTitulo(titulo);
        tarefa.removeTarefa();
        tarefaRepository.save(tarefa);
    }

    private void removerGestor() {
        System.out.print("Digite o nome do gestor: ");
        String nome = e.next();
        Optional<Gestor> gestor = gestorRepository.findByNome(nome);
        if (gestor.isPresent()){
            Gestor g = gestor.get();
            g.removeGestor();
            gestorRepository.save(g);
            System.out.print("gestor foi salvo");
        }else {
            System.out.println("não foi possivel salvar");
        }

    }

    private void removerColaborador() {
        System.out.print("Digite o nome do colaborador: ");
        String nome = e.next();
        Optional<Colaborador> colaborador = colaboradorRepository.findByNome(nome);
        if (colaborador.isPresent()){
            Colaborador c = colaborador.get();
            c.removeGestor();
            colaboradorRepository.save(c);
            System.out.print("colaborador foi salvo");
        }else {
            System.out.println("não foi possivel salvar");
        }
    }

    private void listarTarefasColaborador() {
        System.out.print("Digite o email do colaborador: ");
        String email = e.next();
        e.nextLine();
        Optional<Colaborador> colaborador = colaboradorRepository.findByEmail(email);
        if (colaborador.isPresent()){
            Colaborador c = colaborador.get();
            List<Tarefa> tarefas = tarefaRepository.findByIdColaborador(c.getId());
            tarefas.stream().filter(t -> t.isAtivo()).toList();
            tarefas.stream().forEach(System.out::println);
        }else {
            System.out.println("tarefas não encontradas");
        }
    }

    private void criarGestor() {
        System.out.print("Digite o nome do gestor: ");
        String nome = e.next();
        System.out.print("Digite o email do gestor: ");
        String email = e.next();
        Gestor gestor = new Gestor(nome, email);
        gestorRepository.save(gestor);
        System.out.println("gestor foi salvo");
    }

    private String criarColaborador() {
        System.out.print("Digite o nome do colaborador: ");
        String nome = e.next();
        System.out.print("Digite o email do colaborador: ");
        String email = e.next();
        System.out.println("Digite o email do Gestor para esse colaborador");
        String emailGestor = e.next();
        Optional<Gestor> gestor = gestorRepository.findByEmail(emailGestor);
        if (gestor.isEmpty()){
            return "Gestor não encontrado";
        }
        Gestor g = gestor.get();
        Colaborador colaborador = new Colaborador(nome, email, g);
        colaboradorRepository.save(colaborador);
        return "Colaborador foi salvo";
    }

    private String criarTarefas() {
        System.out.print("Digite o seu email: ");
        String emailGestor = e.next();
        Optional<Gestor> gestor = gestorRepository.findByEmail(emailGestor);
        if(gestor.isEmpty()){
            return "Gestor não encontrado";
        }
        Gestor g = gestor.get();

        System.out.print("Digite o título da tarefa: ");
        String titulo = e.next();

        System.out.print("Digite a descrição: ");
        String descricao = e.next();

        e.nextLine();
        System.out.print("Digite a data de início: ");
        String dataInicio = e.next();

        System.out.print("Digite a data de término: ");
        String dataTermino = e.next();

        System.out.print("Digite o ID do colaborador: ");
        Long idColaborador = e.nextLong();

        e.nextLine();

        Tarefa tarefa = new Tarefa(titulo, descricao, dataInicio, dataTermino, g, idColaborador);
        tarefaRepository.save(tarefa);
        System.out.println("tarefa foi salva");
        return "Tarefa foi salva";
    }

}
