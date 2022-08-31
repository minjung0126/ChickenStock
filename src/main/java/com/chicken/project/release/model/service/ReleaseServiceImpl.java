package com.chicken.project.release.model.service;

import com.chicken.project.release.model.dao.ReleaseMapper;
import com.chicken.project.release.model.dto.ReleaseOrderDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReleaseServiceImpl implements ReleaseService{

    private final ReleaseMapper releaseMapper;

    @Autowired
    public ReleaseServiceImpl(ReleaseMapper releaseMapper){

        this.releaseMapper = releaseMapper;
    }
    @Override
    public List<ReleaseOrderDTO> releaseOrderSelect() {

        List<ReleaseOrderDTO> orderDTO = releaseMapper.releaseOrderSelect();

        return orderDTO;
    }
}
