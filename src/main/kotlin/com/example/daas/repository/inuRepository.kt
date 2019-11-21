package com.example.daas.repository

import com.example.daas.domin.Inu
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface InuRepository:JpaRepository<Inu,Long>