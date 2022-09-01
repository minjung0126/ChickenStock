package com.chicken.project.release.model.service;

import com.chicken.project.release.model.dao.ReleaseMapper;
import com.chicken.project.release.model.dto.ReleaseDTO;
import com.chicken.project.release.model.dto.ReleaseOrderDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ReleaseServiceImpl implements ReleaseService{

    private final ReleaseMapper releaseMapper;

    @Autowired
    public ReleaseServiceImpl(ReleaseMapper releaseMapper){

        this.releaseMapper = releaseMapper;
    }
    @Override
    public List<ReleaseOrderDTO> releaseOrderSelectN() {

        List<ReleaseOrderDTO> orderDTO = releaseMapper.releaseOrderSelectN();

        return orderDTO;
    }

    @Override
    public List<ReleaseOrderDTO> releaseOrderSelectY() {

        List<ReleaseOrderDTO> orderDTO = releaseMapper.releaseOrderSelectY();

        return orderDTO;
    }

    @Override
    public List<ReleaseDTO> releaseDtoOrderSelect() {

        List<ReleaseDTO> releaseDTO = releaseMapper.releaseDtoOrderSelect();

        return releaseDTO;
    }

    @Override
    @Transactional
    public int releaseItemUpdateY(ReleaseOrderDTO storeOrderDTO) {

        int result = releaseMapper.releaseItemUpdateY(storeOrderDTO);

        return result;
    }

    @Override
    @Transactional
    public int releaseItemInsert(ReleaseOrderDTO storeOrderDTO, int relCode) {

        int result = releaseMapper.releaseItemInsert(storeOrderDTO, relCode);

        return result;
    }

    @Override
    @Transactional
    public int releaseItemUpdateN(ReleaseOrderDTO storeOrderDTO) {

        int result = releaseMapper.releaseItemUpdateN(storeOrderDTO);

        return result;
    }

    @Override
    @Transactional
    public int releaseItemDelete(ReleaseOrderDTO storeOrderDTO, int relCode) {

        int result = releaseMapper.releaseItemDelete(storeOrderDTO, relCode);

        return result;
    }
}
