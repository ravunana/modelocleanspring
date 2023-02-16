package com.ravunana.modelo.estoque.produto;

import com.ravunana.modelo.shared.exceptions.AppError;
import jakarta.annotation.PostConstruct;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.*;

@Service
public class ProdutoServiceImpl implements IProdutoService, CommandLineRunner {
    private final ProdutoRepository produtoRepository;

    public ProdutoServiceImpl(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @Override
    public void createProduto(ProdutoDto produtoDto) {
        var existsEmail = produtoRepository.existsByNome(produtoDto.nome);
        if (existsEmail){ throw new AppError("Exists nome"); }



        var produtoMapper = new ProdutoMapper();

        var savedProduto = produtoExpirado(produtoMapper.toEntity(produtoDto));

        produtoRepository.save(savedProduto);
    }

    @Override
    public List<Produto> findAllProdutos() {
        return produtoRepository.findAllProdutos();
    }

    @Override
    public Optional<Produto> showProduto(Integer id) {
        return Optional.ofNullable(produtoRepository.findById(id).orElseThrow( () -> new AppError("Produto nao encontrado!") ));
    }

    @Override
    public void updateProduto(Integer id) {
        var findedProduto = produtoRepository.findById(id);

        produtoRepository.save(findedProduto.get());
    }

    @Override
    public void deleteProduto(Integer id) {

        var findedProduto = produtoRepository.findById(id);

        produtoRepository.delete(findedProduto.get());

    }

    @Override
    public Produto produtoExpirado(Produto produto) {
        if (LocalDate.now().isEqual(produto.getDataExpiracao()) || LocalDate.now().isAfter(produto.getDataExpiracao()) ){
            produto.setPreco(0.0);
            return produto;
        }


        return produto;
    }
//
//    @PostConstruct
//    public void updateDateCiacao(){
//
//
//    }

    public String exportReport(String reportFormat) throws FileNotFoundException, JRException {
        var path = "C:\\Users\\Edmar_Zungo\\Desktop";
        List<Produto> produtoList = produtoRepository.findAllProdutos();
        // Carregando e compilando o arquivo produtos.jrxml
        File file = ResourceUtils.getFile("classpath:produtos.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource collectionDataSource = new JRBeanCollectionDataSource(produtoList);
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("created by", "Edmar Zungo");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, collectionDataSource);
        if (reportFormat.equalsIgnoreCase("html")){
            JasperExportManager.exportReportToHtmlFile(jasperPrint, path+"\\produtos.html");
        }
        if (reportFormat.equalsIgnoreCase("pdf")){
            JasperExportManager.exportReportToPdfFile(jasperPrint, path+"\\produtos.pdf");
        }

        return "arquivo gerado em :" + path;
    }

    @Override
    public void run(String... args) throws Exception {
        List<Produto> list = produtoRepository.findAllProdutos();
        var produtoMapper = new ProdutoMapper();

        for (var produto: list){

           if (produto.getDataCriacao() == null){
               produto.setDataCriacao(LocalDate.now());
           }

           updateProduto(produto.getId());
        }
    }
}
