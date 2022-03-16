package br.com.taimber.arquivos;

import br.com.taimber.configuracoes.PropriedadesLib;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GerarPdf {

    private final String destino;
    private final Document documento;
    private final List linhas;
    private final Font fonteDoTitulo = new Font(Font.FontFamily.COURIER, 14, Font.BOLD);
    private final Font fonteLinha = new Font(Font.FontFamily.COURIER, 8, Font.NORMAL);

    /**
     * Construtor
     *
     * @param destino Destino do arquivo
     */
    public GerarPdf(String destino) {

        /* seta propriedades */
        this.destino = destino;
        this.linhas = new ArrayList();

        /* novo documento */
        this.documento = new Document();

    }

    /**
     * Add linha
     *
     * @param conteudo Conteúdo da linha
     */
    public void addLinha(String conteudo) {

        this.linhas.add(conteudo);

    }

    /**
     * Adiciona o topo
     *
     * @param titulo Título
     */
    private void addTopo(String titulo) {

        /* excessão */
        try {

            /* add título */
            this.documento.add(new Paragraph(titulo, fonteDoTitulo));
            this.documento.add(new Paragraph("________________________________________________________________"));
            this.documento.add(new Paragraph("\n"));

        } catch (DocumentException ex) {

        }

    }

    /**
     * Carrega as linhas
     */
    private void carregaLinhas() {

        /* itera */
        for (Object linha : this.linhas) {

            /* excessão */
            try {

                /* add paragrafo */
                this.documento.add(new Paragraph((String) linha, this.fonteLinha));

            } catch (DocumentException ex) {

            }

        }

    }

    /**
     * Adiciona informações do sistema
     */
    private void addInformacaoSistema() {

        /* excessão */
        try {

            /* conteudo */
            String conteudo = ""
                    + "\n"
                    + "*****************************************************************************************"
                    + "\n"
                    + "Gerado por " + PropriedadesLib.NOME_SISTEMA
                    + "\n"
                    + "*****************************************************************************************"
                    + "\n"
                    + "";

            /* add linha */
            this.documento.add(new Paragraph((String) conteudo, this.fonteLinha));

        } catch (DocumentException ex) {

        }

    }

    /**
     * Gera o documento PDF
     *
     * @param titulo Título do PDF
     */
    public void gerar(String titulo) {

        /* excessão */
        try {

            /* saída */
            PdfWriter.getInstance(documento, new FileOutputStream(destino + ".pdf"));
            documento.open();

            /* adiciona informações do sistema */
            this.addInformacaoSistema();

            /* adiciona o topo */
            this.addTopo(titulo);

            /* adiciona as linhas */
            this.carregaLinhas();

        } catch (DocumentException | IOException de) {

        }

        /* fecha o documento */
        documento.close();

    }

}
