package com.foodorderbe.foodorderbe_artifact.repositories.repository_interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.foodorderbe.foodorderbe_artifact.entities.Menu;

public interface MenuRepository extends JpaRepository<Menu,Long>, JpaSpecificationExecutor<Menu>{
    
}
