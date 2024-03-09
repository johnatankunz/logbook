package com.prologg.logbook.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.prologg.logbook.entity.MarcacaoVinculoInicioFim;

public interface MarcacaoVinculoInicioFimRepository extends JpaRepository<MarcacaoVinculoInicioFim, String> {
	

	@Query(
			  value = "SELECT MVIF.* "
			  
			  		+ " FROM marcacao_vinculo_inicio_fim MVIF "
			  		+ " LEFT JOIN marcacao MI ON (MI.codigo = MVIF.cod_marcacao_inicio) "
			  		+ " LEFT JOIN marcacao MF ON (MF.codigo = MVIF.cod_marcacao_fim) "
			  		+ " JOIN colaborador C ON (C.cpf = MI.cpf_colaborador) "
			  		
			  		+ " WHERE C.cpf = '00187832013' "
			  		
			  		+ " AND (DATE(mi.data_hora_marcacao) >= DATE('2019-03-01') "
			  		+ " AND DATE(mi.data_hora_marcacao) <= DATE('2019-03-10')) "
			  		
			  		+ " AND (DATE(mf.data_hora_marcacao) >= DATE('2019-03-01') "
			  		+ " AND DATE(mf.data_hora_marcacao) <= DATE('2019-03-10')) ", 
			  nativeQuery = true)
	List<MarcacaoVinculoInicioFim> findLogbook();

}
