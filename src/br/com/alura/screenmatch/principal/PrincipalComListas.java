package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.modelos.Filme;
import br.com.alura.screenmatch.modelos.Serie;
import br.com.alura.screenmatch.modelos.Titulo;

import java.util.ArrayList;
import java.util.Collections;

public class PrincipalComListas {
    public static void main(String[] args){
        Filme meuFilme = new Filme("O poderoso chefão", 1970);
        meuFilme.avalia(9);
        Filme outroFilme = new Filme("Avatar", 2009);
        outroFilme.avalia(7);
        Serie lost = new Serie("Lost", 2000);
        var filmeDoRicardo = new Filme("Oppenheimer", 2023);
        filmeDoRicardo.avalia(9);

        ArrayList<Titulo> listaDeAssistidos = new ArrayList<>();
        listaDeAssistidos.add(meuFilme);
        listaDeAssistidos.add(outroFilme);
        listaDeAssistidos.add(filmeDoRicardo);
        listaDeAssistidos.add(lost);

        for (Titulo item: listaDeAssistidos) {
            System.out.println(item.getNome());
            if (item instanceof Filme filme){ //verifica se o titulo instaciado é um filme
                System.out.println("classificação "+ filme.getClassificacao());
            }
        }

        ArrayList<String> buscaArtista = new ArrayList<>();
        buscaArtista.add("Emma Stone");
        buscaArtista.add("Emma Watson");
        buscaArtista.add("Emma Myers");
        System.out.println(buscaArtista);

        Collections.sort(buscaArtista);
        System.out.println(buscaArtista);

        System.out.println(listaDeAssistidos);
        Collections.sort(listaDeAssistidos);
        System.out.println(listaDeAssistidos);
    }
}
