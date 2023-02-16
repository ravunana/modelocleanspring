package com.ravunana.modelo.estoque.produto;

import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.util.List;

@RestController
@RequestMapping("api/produtos")
@Validated
public class ProdutoController {

    @Autowired
    private final IProdutoService iProdutoService;

    public ProdutoController(IProdutoService iProdutoService) {
        this.iProdutoService = iProdutoService;
    }

    @GetMapping
    public List<ProdutoDto> produtoDtoList(){
        var produtoMapper = new ProdutoMapper();
        var produtosList = iProdutoService.findAllProdutos();

        return produtoMapper.toProdutoDtoList(produtosList);
    }

    @GetMapping("/file/{format}")
    public String relatorio(@PathVariable String format) throws JRException, FileNotFoundException {
        return iProdutoService.exportReport(format);
    }

    @PostMapping
    public void createNewProduto(@RequestBody ProdutoDto produtoDto){

        iProdutoService.createProduto(produtoDto);
    }
}
