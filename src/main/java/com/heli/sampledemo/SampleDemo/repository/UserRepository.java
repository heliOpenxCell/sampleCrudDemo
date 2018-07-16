package com.heli.sampledemo.SampleDemo.repository;

import com.heli.sampledemo.SampleDemo.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

// https://www.journaldev.com/17379/jpa-entitymanager-hibernate -> Reference link if want more details

@Repository
public interface UserRepository extends CrudRepository<User,String> {
}
