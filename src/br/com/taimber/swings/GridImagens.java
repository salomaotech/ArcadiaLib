package br.com.taimber.swings;

import br.com.taimber.arquivos.ExecutaProgramaExterno;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.Arrays;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 * Exibe imagens do disco local a partir de um endereço
 *
 * @author www.taimber.com
 * @version 1.0
 */
public class GridImagens {

    private int largura;
    private int altura;

    /**
     * Construtor
     */
    public GridImagens() {

        this.largura = 350;
        this.altura = 350;

    }

    /**
     * Seta largura
     *
     * @param largura largura
     */
    public void setLargura(int largura) {

        this.largura = largura;

    }

    /**
     * Seta altura
     *
     * @param altura altura
     */
    public void setAltura(int altura) {

        this.altura = altura;

    }

    /**
     * Exibe os dados na grid
     *
     * @param pastaDestino Pasta de destino
     * @param jPrincipal Painel de destino
     * @param view View
     */
    public void exibir(String pastaDestino, JPanel jPrincipal, JFrame view) {

        /* remove elementos antigos do painel */
        jPrincipal.removeAll();

        /* painel de elementos */
        JPanel jPelementos = new JPanel();

        /* scroll */
        JScrollPane scroll = new JScrollPane(jPelementos);

        /* adiciona o scroll ao painel principal */
        jPrincipal.add(scroll);

        /* seta o tamanho das do painel das imagens e do scroll */
        scroll.setSize(jPrincipal.getSize());

        /* grid */
        GridLayout grid = new GridLayout(0, 2, 5, 15);
        jPelementos.setLayout(grid);

        /* excessão */
        try {

            /* arquivos */
            File arquivos = new File(pastaDestino);

            /* lista de arquivos */
            File[] listaDeArquivos = arquivos.listFiles();

            /* ordena */
            Arrays.sort(listaDeArquivos);

            /* itera */
            for (File arquivo : listaDeArquivos) {

                /* label que representa o arquivo */
                JLabel imagem = new JLabel();
                imagem.setIcon(new ImageIcon(new ImageIcon(arquivo.getAbsolutePath()).getImage().getScaledInstance(this.largura, this.altura, Image.SCALE_DEFAULT)));
                jPelementos.add(imagem);

                /* evento do mouse */
                imagem.addMouseListener(new MouseAdapter() {

                    /* clique */
                    @Override
                    public void mouseClicked(MouseEvent e) {

                        /* dois cliques */
                        if (e.getClickCount() == 2 && !e.isConsumed()) {

                            /* executa o programa */
                            ExecutaProgramaExterno.executarModoDesktop(arquivo.getAbsolutePath());

                        }

                    }

                });

            }

            /* repinta a view */
            view.repaint();

        } catch (java.lang.NullPointerException | ArrayIndexOutOfBoundsException ex) {

        }

    }

    /**
     * Exibe os dados na grid
     *
     * @param pastaDestino Pasta de destino
     * @param jPrincipal Painel de destino
     * @param index Index da imagem
     * @param view View
     */
    public void exibir(String pastaDestino, JPanel jPrincipal, int index, JFrame view) {

        /* remove elementos antigos do painel */
        jPrincipal.removeAll();

        /* painel de elementos */
        JPanel jPelementos = new JPanel();

        /* scroll */
        JScrollPane scroll = new JScrollPane(jPelementos);

        /* adiciona o scroll ao painel principal */
        jPrincipal.add(scroll);

        /* seta o tamanho das do painel das imagens e do scroll */
        scroll.setSize(jPrincipal.getSize());

        /* grid */
        GridLayout grid = new GridLayout(1, 1, 5, 15);
        jPelementos.setLayout(grid);

        /* excessão */
        try {

            /* arquivos */
            File arquivos = new File(pastaDestino);

            /* lista de arquivos */
            File[] listaDeArquivos = arquivos.listFiles();

            /* ordena */
            Arrays.sort(listaDeArquivos);

            /* pega o arquivo pelo index */
            File arquivo = listaDeArquivos[index];

            /* label que representa o arquivo */
            JLabel elemento = new JLabel();
            elemento.setIcon(new ImageIcon(new ImageIcon(arquivo.getAbsolutePath()).getImage().getScaledInstance(this.largura, this.altura, Image.SCALE_DEFAULT)));

            /* adiciona o elemento ao painel de elementos */
            jPelementos.add(elemento);

            /* evento do mouse */
            elemento.addMouseListener(new MouseAdapter() {

                /* add evento do mouse */
                @Override
                public void mouseClicked(MouseEvent e) {

                    /* clique */
                    if (e.getClickCount() == 2 && !e.isConsumed()) {

                        /* executa o programa */
                        ExecutaProgramaExterno.executarModoDesktop(arquivo.getAbsolutePath());

                    }
                }

            });

            /* repinta a view */
            view.repaint();

        } catch (java.lang.NullPointerException | ArrayIndexOutOfBoundsException ex) {

        }

    }

}
