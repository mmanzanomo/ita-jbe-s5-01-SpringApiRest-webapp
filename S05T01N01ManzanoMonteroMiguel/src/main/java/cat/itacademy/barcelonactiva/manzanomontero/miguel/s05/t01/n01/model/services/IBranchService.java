package cat.itacademy.barcelonactiva.manzanomontero.miguel.s05.t01.n01.model.services;

import cat.itacademy.barcelonactiva.manzanomontero.miguel.s05.t01.n01.model.domain.Branch;
import cat.itacademy.barcelonactiva.manzanomontero.miguel.s05.t01.n01.model.dto.BranchDTO;

import java.util.List;
import java.util.Optional;

public interface IBranchService {
    BranchDTO save(BranchDTO branchDTO);
    void delete(int id);
    Optional<BranchDTO> findOne(BranchDTO branchDTO);
    List<BranchDTO> findAll();
}
