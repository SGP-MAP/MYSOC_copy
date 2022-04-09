package com.example.mysoc.service;

import com.example.mysoc.entity.MaintainenceDB;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public interface MaintainenceService {
    public MaintainenceDB saveDetails(MaintainenceDB mdb);
    public List<MaintainenceDB> getList();
    public Optional<MaintainenceDB> getById(Long id);
    public boolean statusUpdate(MaintainenceDB obj);
    public List<MaintainenceDB> getRemaining();
    public long generateSequence(String seqName);
}
