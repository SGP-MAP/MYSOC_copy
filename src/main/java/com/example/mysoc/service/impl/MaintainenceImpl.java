package com.example.mysoc.service.impl;

import com.example.mysoc.entity.MaintainenceDB;
import com.example.mysoc.entity.MaintenenceSequencer;
import com.example.mysoc.repository.MaintainenceRepo;
import com.example.mysoc.service.MaintainenceService;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;

@Service
public class MaintainenceImpl implements MaintainenceService {
    @Autowired
    private MaintainenceRepo maintainenceRepo;


    @Override
    public MaintainenceDB saveDetails(MaintainenceDB mdb) {
        return  maintainenceRepo.save(mdb);
    }

    @Override
    public List<MaintainenceDB> getList() {
        return maintainenceRepo.findAll();
    }

    @Override
    public List<MaintainenceDB> getById(Long id) {
        List<MaintainenceDB> all=maintainenceRepo.findAll();
        List<MaintainenceDB> ans=new ArrayList<>();
        for(MaintainenceDB x:all)
        {
            if(x.getId()==id)
            {
                ans.add(x);
            }
        }
        return ans;
    }

    @Override
    public boolean statusUpdate(MaintainenceDB obj) {
        Optional<MaintainenceDB> oldobj=maintainenceRepo.findById(obj.getId());
        if(oldobj!=null)
        {
            maintainenceRepo.save(obj);
            return true;
        }
        return false;
    }

    @Override
    public List<MaintainenceDB> getRemaining() {
        List<MaintainenceDB> all=maintainenceRepo.findAll();
        List<MaintainenceDB> ans = new ArrayList<>();
        for(MaintainenceDB obj:all)
        {
            if(obj.isStatus()==false) {
                ans.add(obj);
            }
        }
        return ans;
    }
    @Autowired
    private MongoOperations mongoOperations;
    @Override
    public long generateSequence(String seqName) {
        MaintenenceSequencer counter=mongoOperations.findAndModify(Query.query(where("_id").is(seqName)),new
                Update().inc("seq",1),options().returnNew(true).upsert(true),MaintenenceSequencer.class);
        return !Objects.isNull(counter) ? counter.getSeq():1;
    }
}
