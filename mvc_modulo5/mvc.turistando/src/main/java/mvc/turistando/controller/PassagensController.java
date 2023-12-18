//TURISTANDO

package mvc.turistando.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.ResponseBody;


import mvc.turistando.model.Passagens;
import mvc.turistando.repository.PassagensRepository;

@Controller
@RequestMapping("/novocurso")
public class PassagensController {

    @Autowired
    private PassagensRepository passagensRepository;

    @GetMapping("/novocurso")
    public ModelAndView novocurso() {
        ModelAndView page = new ModelAndView("novocurso/novocurso");
        page.addObject("passagens", new Passagens());
        return page;
    }
    

    @PostMapping({"/salvarcurso", "/{id}/editar"})
    public ModelAndView salvarPassagens(@ModelAttribute Passagens passagens, @RequestParam("imagem") MultipartFile imagem) {
        try {
            passagens.setImagem(imagem);
            // Lógica para salvar no banco de dados
            Passagens passagensSalvo = passagensRepository.save(passagens);

            // Você pode adicionar lógica adicional aqui, se necessário

            // Redirecionar para a página de sucesso ou outra página desejada
            ModelAndView page = new ModelAndView("redirect:/novocurso/listarcurso");
            return page;
        } catch (IOException e) {
            // Lidar com a exceção, por exemplo, redirecionar para uma página de erro
            ModelAndView errorPage = new ModelAndView("error");
            errorPage.addObject("error", "Erro ao processar a imagem.");
            return errorPage;
        }
    }
    
    @GetMapping("/{id}")
	public ModelAndView detalhar(@PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView("novocurso/detalhescurso.html");
 
		Passagens passagens = passagensRepository.getReferenceById(id);
		modelAndView.addObject("passagens", passagens);
 
		return modelAndView;
	}
    
    
    @GetMapping("/listarcurso")
    public ModelAndView listarPassagens() {
         //Buscar todos os cursos do banco de dados
        List<Passagens> passagens = passagensRepository.findAll();

         //Retornar uma página que exibe a lista de cursos
        ModelAndView page = new ModelAndView("novocurso/listarcurso");
       page.addObject("passagens", passagens);
       return page;    
    }

    
    @GetMapping(value = "/imagem/{id}", produces = MediaType.IMAGE_JPEG_VALUE)
    @ResponseBody
    public byte[] exibirImagem(@PathVariable("id") Long id) {
        Passagens passagens = this.passagensRepository.getById(id);
        return passagens.getImagemBytes();
    }
    
    @GetMapping("/{id}/editar")
    public ModelAndView editar(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("novocurso/editarcurso");
    
        Passagens passagens = passagensRepository.getReferenceById(id);
        modelAndView.addObject("passagens", passagens);
    
        return modelAndView;
    } 
   
    @GetMapping("/{id}/excluir")
    public ModelAndView excluir(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("redirect:/novocurso/listarcurso");

        passagensRepository.deleteById(id);

        return modelAndView;
        
        
     
    }
}

