package cat.itacademy.barcelonactiva.manzanomontero.miguel.s05.t01.n01.model.services;

import cat.itacademy.barcelonactiva.manzanomontero.miguel.s05.t01.n01.model.domain.Branch;
import cat.itacademy.barcelonactiva.manzanomontero.miguel.s05.t01.n01.model.dto.BranchDTO;
import cat.itacademy.barcelonactiva.manzanomontero.miguel.s05.t01.n01.model.repository.IBranchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BranchService implements IBranchService {
    @Autowired
    private IBranchRepository repository;

    @Override
    @Transactional
    public BranchDTO save(BranchDTO branchDTO) {
        Branch branch = convertToBranch(branchDTO);
        return convertToDTO(this.repository.save(branch));
    }

    @Override
    @Transactional
    public void delete(int id) {
        this.repository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<BranchDTO> findOne(BranchDTO branchDTO) {
        Optional<Branch> branch = repository.findById(branchDTO.getPk_branchID());
        return branch.map(this::convertToDTO);
    }

    @Override
    @Transactional(readOnly = true)
    public List<BranchDTO> findAll() {
        List<Branch> branches = repository.findAll();

        List<BranchDTO> branchDTOs = branches.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());

        return branchDTOs;
    }


    private BranchDTO convertToDTO(Branch branch) {
        BranchDTO branchDTO = new BranchDTO();
        branchDTO.setPk_branchID(branch.getPk_branchID());
        branchDTO.setName(branch.getName());
        branchDTO.setCountry(branch.getCountry());

        return branchDTO;
    }

    private Branch convertToBranch(BranchDTO branchDTO) {
        Branch branch = new Branch();
        branch.setPk_branchID(branchDTO.getPk_branchID());
        branch.setName(branchDTO.getName());
        branch.setCountry(branchDTO.getCountry());

        return branch;
    }



}
