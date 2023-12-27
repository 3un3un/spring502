package com.choongang.repositories;

import com.choongang.entities.Address;
import com.choongang.entities.BoardData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface AddressRepository extends JpaRepository<Address, Long>,
                                                        QuerydslPredicateExecutor<BoardData> {

}
