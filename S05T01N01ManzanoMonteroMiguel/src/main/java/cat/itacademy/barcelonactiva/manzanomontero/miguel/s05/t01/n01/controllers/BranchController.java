package cat.itacademy.barcelonactiva.manzanomontero.miguel.s05.t01.n01.controllers;


import cat.itacademy.barcelonactiva.manzanomontero.miguel.s05.t01.n01.model.dto.BranchDTO;
import cat.itacademy.barcelonactiva.manzanomontero.miguel.s05.t01.n01.model.services.IBranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/branch")
public class BranchController {
    @Autowired
    private IBranchService branchService;


    @GetMapping("/")
    public String init(Model model) {
        List<BranchDTO> branchDTOs = branchService.findAll();
        model.addAttribute("branchDTOs", branchDTOs);
        return "home";
    }

    @GetMapping("/add")
    public String addBranch(BranchDTO branchDTO) {
        return "modify";
    }

    @PostMapping("/add")
    public String save(BranchDTO branchDTO) {
        branchService.save(branchDTO);
        return "redirect:/branch/";
    }

    @GetMapping("/update/{pk_branchID}")
    public String updateBranch(BranchDTO branchDTO, Model model) {
        branchDTO = branchService.findOne(branchDTO).orElse(null);
        model.addAttribute("branchDTO", branchDTO);
        return "modify";
    }

    @GetMapping("/getOne/{pk_branchID}")
    public String getOneBranch(BranchDTO branchDTO, Model model) {
        branchDTO = branchService.findOne(branchDTO).orElse(null);

        List<BranchDTO> branchDTOs = new ArrayList<BranchDTO>();
        branchDTOs.add(branchDTO);
        model.addAttribute("branchDTOs", branchDTOs);
        return "home";
    }

    @GetMapping("/delete/{pk_branchID}")
    public String deleteBranch(BranchDTO branchDTO) {
        branchService.delete(branchDTO.getPk_branchID());
        return "redirect:/branch/";
    }


}
